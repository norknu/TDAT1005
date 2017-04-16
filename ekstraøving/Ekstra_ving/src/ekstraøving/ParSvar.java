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

public class ParSvar extends Svar {
    private String[] svar;
    public ParSvar(String[] initSvar) {
        svar = new String[initSvar.length];
        for(int i = 0; i<svar.length; i++){
            svar[i] = initSvar[i];
        }
    }
    
    public Object finnSvar() {
        return svar;
    }
    
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof ParSvar)) return false;
        else {
            ParSvar psvar = (ParSvar) obj;
            boolean lik = true;
            int i = 0;
            while (lik && i < svar.length) {
                if (!svar[i].equalsIgnoreCase(psvar.svar[i])) lik = false;
                i++;
            }
            return (lik);
        }
      }
 }
