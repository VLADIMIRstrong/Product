package org.example.mavenProduct.services;
public class NotFoundException extends RuntimeException {
    public NotFoundException(int id){
        super("Element with id: " + id + " not found ");
    }
}
