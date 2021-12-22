package ar.com.fiera.linktracker.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fiera.linktracker.entities.Link;
import ar.com.fiera.linktracker.entities.Url;
import ar.com.fiera.linktracker.entities.Link.EstadoLinkEnum;
import ar.com.fiera.linktracker.repositories.LinkRepository;

@Service
public class LinkService {

    @Autowired
    public LinkRepository repo;

    public void crear(Link linkNuevo){
        repo.save(linkNuevo);
    }

    public Link crearLink(Integer id, String urlEnmascarado, Url urlId, int estadoLink) {
        
        Link link = new Link();
        link.setId(id);
        link.setUrlEnmascarado(urlEnmascarado);
        link.setUrl(urlId);
        link.setEstadoLink(EstadoLinkEnum.VALIDO);
      
        repo.save(link);
        return link;
    }

    public Optional<Link> buscarPorId(Integer id){
        return repo.findById(id);
    }

    /*public Link findById(Integer id) {
        return repo.findbyId(id);
    }*/

    public void actualizar(Link link) {
        repo.save(link);
    }
    
}
