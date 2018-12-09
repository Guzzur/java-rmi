package io.github.guzzur.sharedclasses;

import java.io.Serializable;

public class Message implements Serializable {
    private User user;
    private String content;

    public Message(String content, User user) {
        this.user = user;
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.user.getName() + ": " + this.content;
    }
}
