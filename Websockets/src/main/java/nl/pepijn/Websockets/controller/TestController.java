package nl.pepijn.Websockets.controller;

import nl.pepijn.Websockets.model.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {

    @MessageMapping("/view.send")
    @SendTo("/topic/test")
    public Message sendMessage(@Payload final Message message) {
        return message;
    }

    @MessageMapping("/view.newDevice")
    @SendTo("/topic/test")
    public Message newDevice(@Payload final Message message, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("deviceName", message.getSender());
        return message;
    }
}
