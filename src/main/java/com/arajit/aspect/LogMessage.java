package com.arajit.aspect;

public class LogMessage {

  private String eventType;
  private String message;

  public LogMessage(String eventType, String message) {
    this.eventType = eventType;
    this.message = message;
  }

  public String getEventType() {
    return eventType;
  }

  public String getMessage() {
    return message;
  }
}
