package exercice2;

/**
 * Tri d'un tableau d'entiers multi-thread.
 * Utilisation de wait() et notify() au lieu de join()
 */
public class Trieur2 extends Thread {

  private int[] t; // tableau � trier
  private int debut, fin; // tranche de ce tableau qu'il faut trier
  private Trieur2 parent;  // thread Trieur2 qui a lanc� ce (this) Trieur2
  private int nbNotify = 0; // La Condition est materialisee ainsi: "nombre de notifications de terminaison=2" 
	// Initialement, la condition est fausse (nbNotify=0) 

  public Trieur2(int[] t) {
    this(null, t, 0, t.length - 1);
  }
  
  private Trieur2(Trieur2 parent, int[] t, int debut, int fin) {
    this.parent = parent;
    this.t = t;
    this.debut = debut;
    this.fin = fin;
  }

  public synchronized void notifier() {
    // Modifier la condition, et signaler le(s) thread(s) potentiellement
    // endormi(s) en attente d'une modification de cette condition.
  }

  public void run() {
    if (fin - debut < 2) {
      if (t[debut] > t[fin]) {
        echanger(debut, fin);
      }
    }
    else {
      int milieu = debut + (fin - debut) / 2;
      Trieur2 trieur1 = new Trieur2(this, t, debut, milieu);
      Trieur2 trieur2 = new Trieur2(this, t, milieu + 1, fin);
      trieur1.start();
      trieur2.start();
      // attend les 2 threads fils par le biais du test d'une condition
      // qui, si non verifiee, entraine l'utilisation de wait() sur
      // le moniteur associe implicitement a l'objet courant (cad a this)
      // jusqu'`a ce qu'elle soit verifiee
      synchronized(this) {
          System.out.println("");
        }
      }
      triFusion(debut, fin);
    }
    // indique qu'il a fini au parent (eventuel) qui l'attend
    

  /**
   * Echanger t[i] et t[j]
   */
  private void echanger(int i, int j) {
    int valeur = t[i];
    t[i] = t[j];
    t[j] = valeur;
  }

  /**
   * Fusionne 2 tranches d�j� tri�es du tableau t.
   *   - 1�re tranche : de debut � milieu = (debut + fin) / 2
   *   - 2�me tranche : de milieu + 1 � fin
   * @param debut premier indice de la 1�re tranche
   * @param fin dernier indice de la 2�me tranche
   */
  private void triFusion(int debut, int fin) {
    // tableau o� va aller la fusion
    int[] tFusion = new int[fin - debut + 1];
    int milieu = (debut + fin) / 2;
    // Indices des �l�ments � comparer
    int i1 = debut, 
        i2 = milieu + 1;
    // indice de la prochaine case du tableau tFusion � remplir
    int iFusion = 0;
    while (i1 <= milieu && i2 <= fin) {
      if (t[i1] < t[i2]) {
        tFusion[iFusion++] = t[i1++];
      }
      else {
        tFusion[iFusion++] = t[i2++]; 
      }
    }
    if (i1 > milieu) {
      // la 1�re tranche est �puis�e
      for (int i = i2; i <= fin; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    else {
      // la 2�me tranche est �puis�e
      for (int i = i1; i <= milieu; ) {
        tFusion[iFusion++] = t[i++];
      }
    }
    // Copie tFusion dans t
    for (int i = 0, j = debut; i <= fin - debut; ) {
      t[j++] = tFusion[i++];
    }
  }
  public static void main(String[] args) {
    int[] t = {5, 8, 3, 2, 7, 10, 1};
    Trieur2 trieur = new Trieur2(t);
    trieur.start();	
    try { // on continue d'utiliser un join() pour etre sur que le tri
	  // complet est termine avant d'afficher le resultat du tri
      trieur.join();
    }
    catch(InterruptedException e) {}
    for (int i = 0; i <t.length; i++) {
      System.out.print(t[i] + " ; ");
    }
    System.out.println();
  }

}

