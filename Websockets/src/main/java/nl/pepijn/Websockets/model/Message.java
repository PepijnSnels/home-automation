package nl.pepijn.Websockets.model;

import lombok.Builder;

@Builder
public class Message {

    private MessageType messageType;
    private String content;
    private String sender;
    private String time;

    public Message(MessageType messageType, String content, String sender, String time) {
        this.messageType = messageType;
        this.content = content;
        this.sender = sender;
        this.time = time;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageType=" + messageType +
                ", content='" + content + '\'' +
                ", sender='" + sender + '\'' +
                ", time='" + time + '\'' +
                '}';
    }


}
