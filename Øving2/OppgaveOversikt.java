
class OppgaveOversikt {

	private Student[] studenter = new Student[5];
    private int antStud = 0;

	public OppgaveOversikt(){
	}
	//metode for � finne antall studenter registrert:
	public int finnAntStud(){
		return antStud;
	}

	// metode for � finne alle navn
	public String[] finnAlleNavn() {
		String[] navn = new String[antStud];
		for(int i=0; i<antStud; i++){
			navn[i] = studenter[i].getNavn();
		}
		return navn;
	}

	//metode for � finne antall oppgaver som en bestemt student har l�st:
	public int finnAntOppgaver(String navn){
		int retur = -1;
		for(int i=0; i<antStud; i++) {
			if(studenter[i].getNavn().equals(navn)){
				retur = studenter[i].getAntOppg();
			}
		}
		return retur;
	}

	//metode for � registrere en ny student
	public boolean regNyStudent(String navn){
		for(int i=0; i<antStud; i++){
			if(studenter[i].getNavn().equals(navn)){
				return false;
			}
		}
		if(studenter.length-1 == antStud){
			utvidTabell();
		}

		studenter[antStud] = new Student(navn);
		antStud++;

		return true;
	}
	//metode for � �ke antallet oppgaver godkjent for en student.
	public boolean �kAntOppg(String navn, int okning){
		for(int i=0; i<antStud; i++){
			if(studenter[i].getNavn().equals(navn)){
				studenter[i].setAntOppg(okning);
				return true;
			}
		}
		return false;
	}
	//metode for � utvide tabell:
	public void utvidTabell(){
		Student[] nyTab = new Student[studenter.length +2];
		for(int i = 0; i<studenter.length; i++){
			nyTab[i] = studenter[i];
		}
		studenter = nyTab;
	}

	//toString:
	public String toString(){
		String retur = "";
		for(int i = 0; i<antStud; i++){
			retur += "StudNR: " + (i+1) + " " + studenter[i].toString();
		}
		return retur;
	}

}//Class