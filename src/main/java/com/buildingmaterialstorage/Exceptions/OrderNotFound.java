package com.buildingmaterialstorage.Exceptions;

import lombok.experimental.StandardException;

@StandardException
public class OrderNotFound extends RuntimeException {
    public OrderNotFound(String message) {
        super(message);
    }
}
