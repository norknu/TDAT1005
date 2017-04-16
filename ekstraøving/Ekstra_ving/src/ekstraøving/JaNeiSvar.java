/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ekstraøving;

/**
 *
 * @author Kleiva
 */
public class JaNeiSvar extends Svar {
    private boolean ja;
    public JaNeiSvar(boolean initSvar) {
        ja = initSvar;
    }
    
    public JaNeiSvar(String svar) {
        if (svar.equalsIgnoreCase("ja")) ja = true;
        else ja = false;
    }
 public Object finnSvar() {
     return ja; //automatisk omforming til Boolean-objekt
 }
 
 public boolean equals (Object obj) {
     if (obj == this) return true;
     if(!(obj instanceof JaNeiSvar)) return false;
     else {
         JaNeiSvar svar = (JaNeiSvar) obj;
         return (svar.ja == ja);
     }
 }
}
