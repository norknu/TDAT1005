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
public class Oppgave {
    
    private String tekst;
    private Svar fasit;
    
    public Oppgave(String tekst, Svar fasit){
        this.tekst = tekst;
        this.fasit = fasit;
    }
    
    public Svar getFasit(){
        return fasit;
    }
    
    @Override
    public String toString(){
        return "Oppgave: " + tekst + ". Fasit: " + fasit.finnSvar();
    }
}

/**
 *
 * @author Kleiva
 */
class JaNeiOppgave extends Oppgave{    
    public JaNeiOppgave(String tekst, Svar fasit){
        super(tekst, fasit);       
    }
    
    
}

class ParOppgave extends Oppgave{
    
    private String[][] parOppg;
    
    public ParOppgave(String tekst, Svar fasit, String[][] parOppg){
        super(tekst, fasit);
        this.parOppg = parOppg;
    }
    
    
}

class FlervalgOppgave extends Oppgave{
    
    private String[] flerOppg;
    
    public FlervalgOppgave(String tekst, Svar fasit, String[] flerOppg){
        super(tekst, fasit);
        this.flerOppg = flerOppg;
    }
    
}