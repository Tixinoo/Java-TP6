package exercice1;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class Theatre {
    
    /**
     * Capacité du theatre.
     */
    private int nombrePlaces;
    
    /**
     * Constructeur d'un theatre
     * 
     * @param nb nombre de place
     */
    private Theatre(int nb) {
        this.nombrePlaces = nb;
    }
    
    /**
     * Creation du theatre unique.
     * 
     * @param nb nombre de place du theatre
     * @return le theatre
     */
    public static Theatre creerTheatre(int nb) {
        return new Theatre(nb);
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }
    
    
}
