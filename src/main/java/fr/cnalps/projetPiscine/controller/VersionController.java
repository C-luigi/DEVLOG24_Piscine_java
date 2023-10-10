package fr.cnalps.projetPiscine.controller;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/api/version")
public class VersionController {
    @GetMapping
    public ResponseEntity<String> getVersion()
    {
        return new ResponseEntity<>("{\"version\":\"1.0\"}", HttpStatusCode.valueOf(200));
    }

}