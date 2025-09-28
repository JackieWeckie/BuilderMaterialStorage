package com.buildingmaterialstorage.Exceptions;

import lombok.experimental.StandardException;

@StandardException
public class WorkerNotFound extends RuntimeException {
    public WorkerNotFound(String message) {
        super(message);
    }
}
