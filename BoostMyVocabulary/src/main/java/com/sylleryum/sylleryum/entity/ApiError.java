package com.sylleryum.sylleryum.entity;

public class ApiError {
    private String traceId;
    private String errorMessage;

    public ApiError() {
    }

    public ApiError(String traceId, String errorMessage) {
        this.traceId = traceId;
        this.errorMessage = errorMessage;
    }

    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return "LibraryApiError{" +
                "traceId='" + traceId + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                '}';
    }
}
