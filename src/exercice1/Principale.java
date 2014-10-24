/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercice1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Maxime
 */
public class Principale {
  
    public static void main(String[] args) {
        // On créer 10 agents
        Agent[] agents = new Agent[10];
        for(int i=0;i<agents.length;i++) {
            agents[i] = new Agent("Agent"+i);
        }
        
        // Lancement
        for (Agent agent : agents) {
            Thread t = new Thread(agent);
            t.start();
            try {
                t.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Principale.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }
   
}
