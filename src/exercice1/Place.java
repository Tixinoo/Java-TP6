package exercice1;

/**
 *
 * @author Maxime BLAISE
 * @author Antoine NOSAL
 */
public class Place {

    /**
     * Id de la place.
     */
    private int id;

    /**
     * libre ou non?.
     */
    private boolean libre;

    /**
     * Nombre de place qui a deja ete cree.
     */
    public static int nbplace = 0;

    /**
     * Constructeur d'une place
     */
    public Place() {
        nbplace++;
        this.id = nbplace;
        this.libre = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    public synchronized boolean reserver() {
        if (this.libre) {
            this.libre = false;
            return true;
        } else {
            return false;
        }
    }

}
