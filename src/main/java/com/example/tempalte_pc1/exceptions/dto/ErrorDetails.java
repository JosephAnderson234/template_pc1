package com.example.tempalte_pc1.exceptions.dto;

import java.time.LocalDateTime;

public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String details;

    public ErrorDetails(LocalDateTime timestamp, String message, String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    // getters y setters
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getMessage() { return message; }
    public String getDetails() { return details; }
    public void setTimestamp(LocalDateTime t) { this.timestamp = t; }
    public void setMessage(String m) { this.message = m; }
    public void setDetails(String d) { this.details = d; }
}