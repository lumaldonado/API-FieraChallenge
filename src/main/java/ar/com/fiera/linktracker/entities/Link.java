package ar.com.fiera.linktracker.entities;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name = "link")
public class Link {
    
    @Column(name = "link_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int linkId;
    
    @Column(name = "fecha_expiracion")
    private Date fechaExpiracion;

    @Column(name = "url_enmascarado")
    private String urlEnmascarado;

    @ManyToOne
    @JoinColumn(name = "url_id", referencedColumnName = "url_id")
    private Url url;

    @Column(name = "estado_id")
    private EstadoLinkEnum estadoLink;


    public enum EstadoLinkEnum {
       VALIDO(1), INVALIDO(2);

        private final int value;

        private EstadoLinkEnum(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static EstadoLinkEnum parse(int id) {
            EstadoLinkEnum status = null; // Default
            for (EstadoLinkEnum item : EstadoLinkEnum.values()) {
                if (item.getValue() == id) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }

}
