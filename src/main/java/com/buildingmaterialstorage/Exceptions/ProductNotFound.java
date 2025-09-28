package com.buildingmaterialstorage.Exceptions;

import lombok.experimental.StandardException;

@StandardException
public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
}
