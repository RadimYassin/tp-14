package ma.projet.soapservice.entity;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Entité Compte bancaire
 */
@Entity
@Table(name = "comptes")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Double solde;
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TypeCompte type;

    public Compte() {
        this.dateCreation = new Date();
    }

    public Compte(Double solde, TypeCompte type) {
        this.solde = solde;
        this.type = type;
        this.dateCreation = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Compte{id=" + id + ", solde=" + solde + ", type=" + type + "}";
    }
}
