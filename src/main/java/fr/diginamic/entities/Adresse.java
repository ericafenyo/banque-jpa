package fr.diginamic.entities;

import javax.persistence.*;

@Embeddable
public class Adresse {
    @Column(name = "numero", nullable = false)
    private int numero;
    @Column(name = "rue", nullable = false)
    private String rue;

    @Column(name = "code_postal", nullable = false)
    private int codePostal;

    @Column(name = "ville", nullable = false)
    private String ville;

    // Required by JPA
    public Adresse() {}

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
