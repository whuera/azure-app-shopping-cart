package com.app.mobilpymes.shoppingcart.controllers;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ErrorMessage {
    private String code;
    private List<Map<String, String>> messages;

    public ErrorMessage() { }

    public ErrorMessage(String code, List<Map<String, String>> messages) {
        this.code = code;
        this.messages = messages;
    }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public List<Map<String, String>> getMessages() { return messages; }
    public void setMessages(List<Map<String, String>> messages) { this.messages = messages; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String code;
        private List<Map<String, String>> messages;

        public Builder code(String code) { this.code = code; return this; }
        public Builder messages(List<Map<String, String>> messages) { this.messages = messages; return this; }

        public ErrorMessage build() { return new ErrorMessage(code, messages); }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(code, that.code) && Objects.equals(messages, that.messages);
    }

    @Override
    public int hashCode() { return Objects.hash(code, messages); }

    @Override
    public String toString() {
        return "ErrorMessage{code='" + code + "', messages=" + messages + "}";
    }
}