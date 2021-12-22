package ar.com.fiera.linktracker.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.fiera.linktracker.entities.Link;
import ar.com.fiera.linktracker.entities.Url;
import ar.com.fiera.linktracker.entities.Link.EstadoLinkEnum;
import ar.com.fiera.linktracker.models.request.InfoLinkNuevo;
import ar.com.fiera.linktracker.models.response.GenericResponse;
import ar.com.fiera.linktracker.services.LinkService;

@RestController
public class LinkController {

    @Autowired
    LinkService service;

    @PostMapping("/Link")
    public ResponseEntity<?> crearLink(@RequestBody Link linkNuevo){
        
        GenericResponse respuesta = new GenericResponse();
        respuesta.isOk = true;
        respuesta.id = linkNuevo.getId();
        respuesta.message = "El link fue creado con exito";
         return ResponseEntity.ok(linkNuevo);

        
    }
    

    @PutMapping("/link/{id}")
    public ResponseEntity<GenericResponse> invalidarLink(@PathVariable Integer linkId, @RequestBody EstadoLinkEnum estadoLink ){
        GenericResponse respuesta = new GenericResponse();

        Link link = service.findById(linkId);
        link.setEstadoLink(EstadoLinkEnum.INVALIDO);
        service.actualizar(link);

        respuesta.id = link.getId();
        respuesta.isOk = true;
        respuesta.message = "El link se ha invalidado";

        return ResponseEntity.ok(respuesta);
    }
}
