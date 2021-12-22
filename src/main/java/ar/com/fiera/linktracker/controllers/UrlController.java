package ar.com.fiera.linktracker.controllers;

import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fiera.linktracker.entities.Url;
import ar.com.fiera.linktracker.models.response.GenericResponse;
import ar.com.fiera.linktracker.services.UrlService;
import org.apache.commons.validator.routines.UrlValidator;

@RestController
public class UrlController {

    @Autowired
    UrlService service;

    @PostMapping("/URL")
    public ResponseEntity<?> crearUrl(@RequestBody Url url){
        
        GenericResponse respuesta = new GenericResponse();
        String[] schemes = {"http","https"};
        UrlValidator urlValidator = new UrlValidator(schemes);

        if (urlValidator.isValid(url.getUrlEntero())) {
            service.crear(url);
            respuesta.id = url.getUrlId();
            respuesta.isOk = true;
            respuesta.message = "La URL es valida y fue creada con exito";
            return ResponseEntity.ok(respuesta);
        } else {
            respuesta.isOk = false;
            respuesta.message = "La URL es invalida";
            return ResponseEntity.badRequest().body(respuesta);
        }

        
    }
    
}
