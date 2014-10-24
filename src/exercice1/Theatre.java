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

    private static final Theatre instance = new Theatre(100);

    /**
     * Constructeur d'un theatre
     *
     * @param nb nombre de place
     */
    private Theatre(int nb) {
        this.nombrePlaces = nb;
        this.places = new Place[this.nombrePlaces];
        for (int i = 0; i < this.places.length; i++) {
            this.places[i] = new Place();
        }
    }

    /**
     * Creation du theatre unique.
     *
     * @return le theatre
     */
    public static Theatre recupTheatre() {
        return instance;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }

    public void setNombrePlaces(int nombrePlaces) {
        this.nombrePlaces = nombrePlaces;
    }

    public Place getPlaces(int i) {
        return places[i];
    }

    public void setPlaces(Place[] places) {
        this.places = places;
    }

}
