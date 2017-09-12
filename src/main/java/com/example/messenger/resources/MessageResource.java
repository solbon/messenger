package com.example.messenger.resources;

import com.example.messenger.model.Message;
import com.example.messenger.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Solbon on 2017-06-22.
 */
@Path("/messages")
public class MessageResource {

    MessageService service = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return service.getAllMessages();
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/{messageId}")
    public Message getMessage(@PathParam ("messageId") Long messageId) {
        return service.getMessage(messageId);
    }
}
