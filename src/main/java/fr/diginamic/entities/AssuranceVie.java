package fr.diginamic.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class AssuranceVie extends Compte {
    @Id
    private int id;

    private LocalDate dateFin;

    private double taux;

    // Required by JPA
    public AssuranceVie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
