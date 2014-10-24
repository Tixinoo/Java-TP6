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
     * tableau des places.
     */
    private Place[] places;
    
    /**
     * Constructeur d'un theatre
     * 
     * @param nb nombre de place
     */
    private Theatre(int nb) {
        this.nombrePlaces = nb;
        this.places = new Place[this.nombrePlaces];
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

    public Place[] getPlaces() {
        return places;
    }

    public void setPlaces(Place[] places) {
        this.places = places;
    }
    
    
}
