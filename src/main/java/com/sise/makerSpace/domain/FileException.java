package com.sise.makerSpace.domain;

import lombok.Data;
import org.springframework.stereotype.Repository;

@Data
@Repository
public class FileException extends RuntimeException{
    public FileException(){

    }

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}