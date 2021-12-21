package ar.com.fiera.linktracker.entities;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "url")
public class Url {

    @Column(name = "url_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int urlId;

    @Column(name = "url_entero")
    private String urlEntero;

    @OneToMany(mappedBy = "url", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Link> links = new ArrayList<>();

    
}
