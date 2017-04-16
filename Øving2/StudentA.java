
class StudentA {
	private final String navn;
	private int antOppg;

	public StudentA(String navn){
		this.navn = navn;
		antOppg = 0;
	}

	public String getNavn() {
		return navn;
	}

	public int getAntOppg() {
		return antOppg;
	}

	public void setAntOppg(int antOppg) {
		if(antOppg < 0) {
			throw new IllegalArgumentException("Ugyldig antall oppg");
		} else{
			this.antOppg = antOppg;
		}
	}

	public String toString() {
		return "Eleven: " + navn + ", har levert " + antOppg + " oppgaver.";
	}
}



