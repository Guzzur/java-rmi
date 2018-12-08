package io.github.guzzur.sharedclasses;

public class State {
    private User user;
    private Color color;

    public State(User user, Color color) {
        this.user = user;
        this.color = color;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
