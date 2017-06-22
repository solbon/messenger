package com.example.resources;

import com.example.model.Message;
import com.example.service.MessageService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
    @Produces(MediaType.APPLICATION_XML)
    public List<Message> getMessages() {
        return service.getAllMessages();
    }
}