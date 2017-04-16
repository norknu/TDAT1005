
class Valuta {

	private String valutaNavn;
	private double kurs;
	private int enhet; // (vanligvis 1 eller 100)

	public Valuta(String valutaNavn, double kurs, int enhet){
		this.valutaNavn = valutaNavn;
		this.kurs = kurs;
		this.enhet = enhet;
	}

	public String getValutaNavn(){
		return valutaNavn;
	}

	public double getKurs(){
		return kurs;
	}

	public int getEnhet(){
		return enhet;
	}

	public void setNavn(String nyttNavn) {
		this.valutaNavn = nyttNavn;
	}

	public void setKurs(double nyKurs) {
		this.kurs = nyKurs;
	}

	public void setEnhet(int nyEnhet) {
		this.enhet = nyEnhet;
	}

	public String toString(){
		return valutaNavn;
	}
}