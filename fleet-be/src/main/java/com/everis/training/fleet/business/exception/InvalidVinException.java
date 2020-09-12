package com.everis.training.fleet.business.exception;

public class InvalidVinException extends RuntimeException{
    public InvalidVinException(String errorMessage){
        super(errorMessage);
    }
}
