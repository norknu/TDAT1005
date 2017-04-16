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
public class FlervalgSvar extends Svar {
    private String svar;
    public FlervalgSvar(String initSvar) {
        svar = initSvar.trim();
    }
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof FlervalgSvar)) return false;
        else {
            FlervalgSvar fsvar = (FlervalgSvar) obj;
            return (svar.equalsIgnoreCase(fsvar.svar));
        }
    }
    
    public Object finnSvar() {
        return svar;
    }
}
