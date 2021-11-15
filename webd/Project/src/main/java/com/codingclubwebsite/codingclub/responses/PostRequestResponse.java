package com.codingclubwebsite.codingclub.responses;

public class PostRequestResponse {

    private String status_message;
    private String queryId;
    private String description;


    public PostRequestResponse(String status_message, String queryId, String description) {
        this.status_message = status_message;
        this.queryId = queryId;
        this.description = description;
    }

    public String getStatus_message() {
        return status_message;
    }

    public void setStatus_message(String status_message) {
        this.status_message = status_message;
    }

    public String getSubmissionID() {
        return queryId;
    }

    public void setSubmissionID(String submissionID) {
        this.queryId = submissionID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
