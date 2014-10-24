package exercice1;

import java.util.ArrayList;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class Agent implements Runnable {

    /**
     * Nom de l'agent.
     */
    private String nom;

    /**
     * Liste des places que l'agent a réservé.
     */
    public ArrayList<Place> listePlaces;

    /**
     * Constructeur de l'agent, en fonction de son nom.
     *
     * @param nom nom de l'agent.
     */
    public Agent(String nom) {
        this.nom = nom;
        this.listePlaces = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        // L'agent doit réserver 5 places aléatoire
        for (int i = 0; i < 5; i++) {
            Place p = Theatre.recupTheatre().getPlaces((int) (Math.random() * Theatre.recupTheatre().getNombrePlaces()));

            // On tente de réserver
            if (p.reserver()) {
                this.listePlaces.add(p);
                System.out.println(nom + " a reserve la place " + p.getId());
            } else {
                System.out.println(nom + " n'a pas reussi a reserver la place " + p.getId());
            }
        }

    }

}
