package ar.com.fiera.linktracker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.fiera.linktracker.entities.Link;

@Repository
public interface LinkRepository extends JpaRepository<Link, Integer> {
    
}
