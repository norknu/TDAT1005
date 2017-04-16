/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ekstraøving;

import java.util.ArrayList;

/**
 *
 * @author Kleiva
 */
public class Test {
        
    ArrayList<Svar> svar = new ArrayList<Svar>();
    ArrayList<Oppgave> oppg = new ArrayList<Oppgave>();
    
    public Test(){    
    }
        
     
    
        
    
    public void regNyOppg(Oppgave nyOppg){ //legg til ny oppgave
        this.oppg.add(nyOppg);          
    }
    
    public int finnAntOppg(){ //finner antall oppgaver
        return oppg.size();
    }
    
    public Oppgave finnOppg(int indeks){ //finner oppgave gitt indeks
        if(indeks >= 0 && indeks < oppg.size()){
            return oppg.get(indeks);
        }
        return null;
        
    }
    
    public int finnAntRiktigSvar(ArrayList<Svar> svar){ // finner antall riktige svar
        int teller = 0;
        
        for(int i = 0; i< oppg.size(); i++){
            if(svar.get(i) !=null){
                if(oppg.get(i).getFasit().equals(svar.get(i))){
                    teller++;
                }
            }
        }
        return teller;
    }

    
    public static void main(String[] args){
        
        
        Oppgave oppg1 = new JaNeiOppgave("Er Sydney hovedstaden i Australia?",
                new JaNeiSvar(false));  
        
        String[][] byerOgLand = {{"Berlin", "New York", "Trondheim", "Umeå", "Luxor"},
                                {"USA", "Sverige", "Egypt", "Norge", "Tyskland"}}; 
        Oppgave oppg2 = new FlervalgOppgave(                
                "Hvilken av følgende byer er en hovedstad?",                  
                new FlervalgSvar("Berlin"), byerOgLand[0]); 
        
        String[] svar3 = {"Tyskland", "USA", "Norge", "Sverige", "Egypt"}; 
        
        Oppgave oppg3 = new ParOppgave("Knytt sammen by og land",                                  
                new ParSvar(svar3), byerOgLand);
        
        Oppgave oppg4 = new JaNeiOppgave(
				"Er Trondheim hovedstaden i Norge?", new JaNeiSvar(false));

        
        Oppgave[] oppg = { oppg1, oppg2, oppg3, oppg4, };
        
        ArrayList<Svar> svar1 = new ArrayList<Svar>();
        ArrayList<Oppgave> oppgaver = new ArrayList<Oppgave>();
        String[] tmp = {"Norge","Norge","Norge","Norge","Norge","Norge","Norge","Norge","Norge","Norge"};
		
		svar1.add(new JaNeiSvar(false));
		svar1.add(new FlervalgSvar("Berlin"));
		svar1.add(new ParSvar(tmp)); 
		svar1.add(new JaNeiSvar(true));
		

		Test test = new Test();
		for (int i = 0; i < 4; i++) {
			test.regNyOppg(oppg[i]);
		}
		System.out.println("Antall Oppgaver: " + test.finnAntOppg());
                System.out.println("Antall riktige svar: " + test.finnAntRiktigSvar(svar1));
                System.out.println(test.finnOppg(0));
		System.out.println(test.finnOppg(1));
                System.out.println(test.finnOppg(2));
                System.out.println(test.finnOppg(3));
	}
        
    }
    

