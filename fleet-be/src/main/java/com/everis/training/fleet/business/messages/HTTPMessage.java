package com.everis.training.fleet.business.messages;

import java.util.LinkedList;
import java.util.List;

public class HTTPMessage {
    private int status;
    private String code;
    private String target;
    private List<ErrorDetails> details = new LinkedList<ErrorDetails>();

    public void setupMessage(int status, String code, String target){
        this.status = status;
        this.code = code;
        this.target = target;
    }

    public void addDetails(String code, String target, String message){
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setup(code, target, message);
        this.details.add(errorDetails);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public List<ErrorDetails> getDetails() {
        return details;
    }

    public void setDetails(List<ErrorDetails> details) {
        this.details = details;
    }
}
