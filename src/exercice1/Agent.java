package exercice1;

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
     * Constructeur de l'agent, en fonction de son nom.
     * 
     * @param nom nom de l'agent.
     */
    public Agent(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public void run() {
        
    }
    
}
