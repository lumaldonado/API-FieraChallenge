package ar.com.fiera.linktracker.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    @JsonIgnore
    private List<Link> links = new ArrayList<>();

    public int getUrlId() {
        return urlId;
    }

    public void setUrlId(int urlId) {
        this.urlId = urlId;
    }

    public String getUrlEntero() {
        return urlEntero;
    }

    public void setUrlEntero(String urlEntero) {
        this.urlEntero = urlEntero;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public void agregarLink(Link link) {
        this.links.add(link);
    }
}
