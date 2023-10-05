package fr.cnalps.projetPiscine.controller;

public class FileResponse {
    private final String fileName;
    private final String message;

    public FileResponse(String fileName, String message){
        this.fileName = fileName;
        this.message = message;
    }
}
