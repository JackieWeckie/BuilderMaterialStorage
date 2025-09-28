package com.buildingmaterialstorage.Exceptions;

import lombok.experimental.StandardException;

@StandardException
public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String message) {
        super(message);
    }
}
