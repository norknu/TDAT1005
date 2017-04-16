import java.util.ArrayList;

class OppgaveOversiktA {

	private ArrayList<StudentA> studenter = new ArrayList<StudentA>();

	/*private Student[] studenter = new Student[5];
    private int antStud = 0;*/

	/*public OppgaveOversikt(){
	}*/
	//metode for å finne antall studenter registrert:
	public int finnAntStud(){
		return studenter.size();
	}

	// metode for å finne alle navn
		public String[] finnAlleNavn() {
			String[] alleNavn = new String[studenter.size()];
			for(int i=0; i<studenter.size();i++){
				alleNavn[i] = studenter.get(i).getNavn();
			}
			return alleNavn;
	}

	//metode for å finne antall oppgaver som en bestemt student har løst:
	public int finnAntOppgaver(String navn){
		int retur = -1;
		String[] alleNavn = finnAlleNavn();
		for(int i=0; i<studenter.size(); i++) {
			if(studenter.get(i).getNavn().equals(alleNavn[i])){
				return studenter.get(i).getAntOppg();
			}
		}
		return retur;
	}

	//metode for å registrere en ny student
	public boolean regNyStudent(String navn){
		for(int i=0; i<studenter.size(); i++){
			if(studenter.get(i).getNavn().equals(navn.trim())){
				return false;
			}
		}
		/*if(studenter.length-1 == antStud){
			utvidTabell();
		}

		studenter[antStud] = new Student(navn);
		antStud++;*/
		studenter.add(new StudentA(navn));

		return true;
	}
	//metode for å øke antallet oppgaver godkjent for en student.
	public boolean økAntOppg(String navn, int okning){
		String[] alleNavn = finnAlleNavn();
		for(int i=0; i<studenter.size(); i++){
			if(studenter.get(i).getNavn().equals(navn.trim())){
				studenter.get(i).setAntOppg(okning);
				return true;
			}
		}
		return false;
	}
	/*//metode for å utvide tabell:
	public void utvidTabell(){
		Student[] nyTab = new Student[studenter.length +2];
		for(int i = 0; i<studenter.length; i++){
			nyTab[i] = studenter[i];
		}
		studenter = nyTab;
	}*/

	//toString:
	public String toString(){
		 String stringArray = "";
		 String[] alleNavn = finnAlleNavn();
		 for (int i = 0; i < studenter.size(); i++) {
		 	stringArray += "Navn: " + alleNavn[i] + ", Oppg. løst: " + studenter.get(i).getAntOppg() + "\n";
		 }
	stringArray += "antStud: " + studenter.size();
	return stringArray;
    }
		/*String retur = "";
		for(int i = 0; i<studenter.size(); i++){
			retur += "StudNR: " + (i+1) + " " + studenter[i].toString();
		}
		return retur;
	}*/

}//Class
