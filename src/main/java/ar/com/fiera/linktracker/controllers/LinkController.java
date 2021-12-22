package ar.com.fiera.linktracker.controllers;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import com.google.appengine.repackaged.org.joda.time.LocalDate;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

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
        respuesta.message = "El link fue creado con exito" + linkNuevo.getUrl() + linkNuevo.getUrlEnmascarado();
         return ResponseEntity.ok(linkNuevo);

        
    }
    
    @PostMapping("/Link/temporal")
    public ResponseEntity<?> crearLinkTemporal(@RequestBody Link linkTemporal){
        
        GenericResponse respuesta = new GenericResponse();
        
       /* ZoneId z = ZoneId.of( "America/Argentina" );
        LocalDate today = LocalDate.now(z );
        DateTimeFormatter f = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate start = LocalDate.parse( "22-02-2010", f);
        LocalDate stop = LocalDate.parse( "25-12-2010", f);*/

        respuesta.isOk = true;
        respuesta.id = linkTemporal.getId();
        respuesta.message = "El link fue creado con exito" + linkTemporal.getUrl() + linkTemporal.getUrlEnmascarado();
         return ResponseEntity.ok(linkTemporal);

        
    }

    @PutMapping("/link/{id}")
    public ResponseEntity<GenericResponse> invalidarLink(@PathVariable Integer linkId, @RequestBody EstadoLinkEnum estadoLink ){
        GenericResponse respuesta = new GenericResponse();

        Link link = new Link();
        service.buscarPorId(linkId);
        link.setEstadoLink(EstadoLinkEnum.INVALIDO);
        service.actualizar(link);

        respuesta.id = link.getId();
        respuesta.isOk = true;
        respuesta.message = "El link se ha invalidado";

        return ResponseEntity.ok(respuesta);
    }
}
