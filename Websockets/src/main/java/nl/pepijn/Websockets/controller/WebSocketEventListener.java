package nl.pepijn.Websockets.controller;

import nl.pepijn.Websockets.model.Message;
import nl.pepijn.Websockets.model.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;


@Component
public class WebSocketEventListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebSocketEventListener.class);
    private final SimpMessageSendingOperations sendingOperations;

    @Autowired
    private WebSocketEventListener(SimpMessageSendingOperations sendingOperations) {
        this.sendingOperations = sendingOperations;
    }

    @EventListener
    public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
        LOGGER.info("New device connected!");
    }

    @EventListener
    public void handleWebSocketsDiscconectListener(final SessionDisconnectEvent event) {
        final StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        final String deviceName = headerAccessor.getSessionAttributes().get("deviceName").toString();
        final Message message = new Message(MessageType.DISCONNECT, null, deviceName, null);

        LOGGER.info(deviceName + " disconnected!");
        sendingOperations.convertAndSend("/topic/test", message);
    }
}
