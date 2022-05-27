package ru.itmo.lessons.lesson36.reflection;

import java.time.LocalDateTime;

public class Message implements Comparable<Message>{
    private String sender;
    private LocalDateTime sent;

    public Message(String sender) {
        this.sender = sender;
        setSent();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent() {
        this.sent = LocalDateTime.now();
    }

    @Override
    public int compareTo(Message o) {
        return sent.compareTo(o.sent);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", sent=" + sent +
                '}';
    }
}