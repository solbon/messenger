package com.example.messenger.resources;

import com.example.messenger.model.Message;
import com.example.messenger.resources.beans.MessageFilterBean;
import com.example.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    public Message addMessage(Message message) {
        return service.addMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message removeMessage(@PathParam("messageId") Long id) {
        return service.removeMessage(id);
    }
}
