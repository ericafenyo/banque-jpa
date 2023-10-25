package fr.diginamic.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clients")
public class Client {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", length = 100, nullable = false)
    private String nom;

    @Column(name = "prenom", length = 100, nullable = false)
    private String prenom;

    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @Embedded()
    private Adresse adresse;

    @ManyToMany()
    @JoinTable(name = "client_banque",
            joinColumns = @JoinColumn(name = "clinet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "banque_id", referencedColumnName = "id")
    )
    private List<Banque> banques = new ArrayList<>();


    @ManyToMany()
    @JoinTable(name = "client_compte",
            joinColumns = @JoinColumn(name = "clinet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id", referencedColumnName = "id")
    )
    private List<Compte> comptes = new ArrayList<>();

    // Required by JPA
    public Client() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public List<Banque> getBanques() {
        return banques;
    }

    public void setBanques(List<Banque> banques) {
        this.banques = banques;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }
}
