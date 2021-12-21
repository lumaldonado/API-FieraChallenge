package ar.com.fiera.linktracker.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.fiera.linktracker.entities.Url;
import ar.com.fiera.linktracker.repositories.UrlRepository;

@Service
public class UrlService {

    @Autowired
    UrlRepository repo;

    public boolean crear(Url url) {
        if(existe(url.getUrlEntero()))
           return false;

        repo.save(url);

        return true;
    }

    public boolean existe(String urlEntero) {
        Url url = repo.findByUrlEntero(urlEntero);
        return url != null;
    }
    
}
