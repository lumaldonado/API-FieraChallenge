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
import ar.com.fiera.linktracker.models.request.GenericResponse;
import ar.com.fiera.linktracker.models.request.InfoLinkNuevo;
import ar.com.fiera.linktracker.services.LinkService;

@RestController
public class LinkController {

    @Autowired
    LinkService service;

    @PostMapping("/Link")
    public ResponseEntity<?> crearLink(@RequestBody InfoLinkNuevo linkNuevo){
        
        GenericResponse respuesta = new GenericResponse();
        Link link = service.crearLink(linkNuevo.linkId, linkNuevo.urlEnmascarado,linkNuevo.urlId,linkNuevo.estadoLink);
        respuesta.isOk = true;
        respuesta.id = link.getLinkId();
        respuesta.message = "El link fue creado con exito";
         return ResponseEntity.ok(linkNuevo);

    
        
    }
    

    @PutMapping("/link/{id}")
    public ResponseEntity<GenericResponse> invalidarLink(@PathVariable Integer linkId, @RequestBody EstadoLink estadoLink ){
        GenericResponse respuesta = new GenericResponse();

        Link link = service.buscarPorId(linkId);
        link.setEstadoLinkId(estadoLink.estadoNuevo);
        service.actualizar(link);

        respuesta.id = link.getLinkId();
        respuesta.isOk = true;
        respuesta.message = "Estado del Link actualizado";

        return ResponseEntity.ok(respuesta);
    }
}
