package com.app.mobilpymes.shoppingcart.utils;


import java.util.Date;
import java.util.Objects;

public class ErrorMessage {
    private String message;
    private Date timestamp;
    private Integer code;

    public ErrorMessage() { }

    public ErrorMessage(String message, Date timestamp, Integer code) {
        this.message = message;
        this.timestamp = timestamp;
        this.code = code;
    }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public Date getTimestamp() { return timestamp; }
    public void setTimestamp(Date timestamp) { this.timestamp = timestamp; }

    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private String message;
        private Date timestamp;
        private Integer code;

        public Builder message(String message) { this.message = message; return this; }
        public Builder timestamp(Date timestamp) { this.timestamp = timestamp; return this; }
        public Builder code(Integer code) { this.code = code; return this; }

        public ErrorMessage build() {
            return new ErrorMessage(message, timestamp, code);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ErrorMessage)) return false;
        ErrorMessage that = (ErrorMessage) o;
        return Objects.equals(message, that.message) &&
               Objects.equals(timestamp, that.timestamp) &&
               Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, timestamp, code);
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
               "message='" + message + '\'' +
               ", timestamp=" + timestamp +
               ", code=" + code +
               '}';
    }
}