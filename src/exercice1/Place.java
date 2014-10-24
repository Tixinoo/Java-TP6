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
     * Nombre de place qui a deja ete cree.
     */
    public static int nbplace = 0;
    
    /**
     * Constructeur d'une place
     */
    public Place() {
        nbplace++;
        this.id = nbplace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
