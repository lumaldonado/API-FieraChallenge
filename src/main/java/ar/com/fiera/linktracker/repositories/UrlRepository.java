package ar.com.fiera.linktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.fiera.linktracker.entities.Link;
import ar.com.fiera.linktracker.entities.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Integer> {

    Url findByUrlEntero(String urlEntero);
    
}
