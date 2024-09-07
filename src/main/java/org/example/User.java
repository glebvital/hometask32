package org.example;

public class User {
    private Long ChattID;
    private String text;

    public User(Long chattID, String text) {
        ChattID = chattID;
        this.text = text;
    }

    public Long getChattID() {
        return ChattID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChattID(Long chattID) {
        ChattID = chattID;
    }
}
