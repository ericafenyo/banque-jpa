import fr.diginamic.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // Construct an entity manager for handling database transactions
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("database_config");
        EntityManager manager = factory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        transaction.begin();

        // Let's imagine a marriage couple living in Cape coast.
        Adresse adresse = new Adresse();
        adresse.setNumero(19);
        adresse.setRue("boulevard de la Victoire");
        adresse.setCodePostal(54300);
        adresse.setVille("Cape Coast");

        // There is a nearby bank called 'Cape Coast Bank'.
        Banque capeCoastBank = new Banque();
        capeCoastBank.setNom("Cape Coast Bank");
        manager.persist(capeCoastBank);

        // The wife...
        Client wife = new Client();
        wife.setNom("Pendragon");
        wife.setPrenom("Morgana");
        wife.setDateNaissance(LocalDate.parse("1997-02-20"));
        wife.setAdresse(adresse);
        manager.persist(wife);
        // ...went and created an account.
        Compte wifeAccount = new Compte();
        wifeAccount.setNumero("1358613913934");
        wifeAccount.setSolde(12_000);
        manager.persist(wifeAccount);

        wife.getBanques().add(capeCoastBank);
        wife.getComptes().add(wifeAccount);

        // Now the husband...
        Client husband = new Client();
        husband.setNom("Pendragon");
        husband.setPrenom("Arthur");
        husband.setDateNaissance(LocalDate.parse("1995-07-24"));
        husband.setAdresse(adresse);
        manager.persist(husband);
        husband.getBanques().add(capeCoastBank);

        // ...decided to have a joined account with the wife.
        Compte jointCompte = new Compte();
        jointCompte.setNumero("38913935613");
        jointCompte.setSolde(40_000);
        manager.persist(jointCompte);

        husband.getComptes().add(jointCompte);
        wife.getComptes().add(jointCompte);

        // The wife decided to subscribe for an assurance...
        AssuranceVie assurance = new AssuranceVie();
        assurance.setTaux(12.1);
        assurance.setNumero("3916193313584");
        assurance.setSolde(12_000);
        assurance.setDateFin(LocalDate.now().plusYears(1));
        manager.persist(assurance);

        // And also another side account
        LivretA livretA = new LivretA();
        livretA.setTaux(10.0);
        livretA.setNumero("4358911133934");
        livretA.setSolde(10);
        manager.persist(livretA);

        wife.getComptes().add(livretA);
        wife.getComptes().add(assurance);

        // The wife got back payments
        Virement virement = new Virement();
        virement.setBeneficiaire("Morgana Pendragon");
        virement.setMontant(800.00);
        virement.setDate(LocalDateTime.now());
        virement.setMotif("Cashback cancelled subscription");
        manager.persist(virement);
        virement.setCompte(wifeAccount);

        // The wife went for shopping
        Operation shopping = new Operation();
        shopping.setDate(LocalDateTime.now());
        shopping.setMontant(-250);
        shopping.setMotif("Monthly shopping Decah");
        manager.persist(shopping);
        shopping.setCompte(wifeAccount);

        transaction.commit();
    }
}
