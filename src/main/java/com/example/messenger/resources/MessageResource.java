package com.example.messenger.resources;

import com.example.messenger.model.Message;
import com.example.messenger.resources.beans.MessageFilterBean;
import com.example.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Solbon on 2017-06-22.
 */
@Path("/messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService service = new MessageService();

    @GET
    public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) {
        if (filterBean.getYear() > 0)
            return service.getAllMessagesForYear(filterBean.getYear());
        if (filterBean.getStart() >= 0 && filterBean.getSize() > 0)
            return service.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
        return service.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
    public Message getMessage(@PathParam ("messageId") Long messageId) {
        return service.getMessage(messageId);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam ("messageId") Long id, Message message) {
        message.setId(id);
        return service.updateMessage(message);
    }

    @POST
    public Response addMessage(Message message, @Context UriInfo uriInfo) {
        Message newMessage = service.addMessage(message);
        String newId = String.valueOf(newMessage.getId());
        URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
        return Response.created(uri)
                .entity(newMessage)
                .build();
    }

    @DELETE
    @Path("/{messageId}")
    public Message removeMessage(@PathParam("messageId") Long id) {
        return service.removeMessage(id);
    }

    @Path("/{messageId}/comments")
    public CommentResource getCommentResource() {
        return new CommentResource();
    }

}
