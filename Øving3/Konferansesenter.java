import java.util.ArrayList;

class Konferansesenter{
	private ArrayList <Rom>rommene = new ArrayList<Rom>();

	public Konferansesenter(){

	}

	public boolean reserverRom(Tidspunkt fraTid, Tidspunkt tilTid, Kunde kunde, int antPersoner){
		for (Rom test: rommene) {
			if (test.addReservasjon(fraTid, tilTid, kunde, antPersoner)) {
				return true;
			}
		}
		return false;
	}

	public void registrerRom(int storrelse){
		rommene.add(new Rom(storrelse));
	}

	public String finnRomIndeks(int indeks){
		String ret = "";
		for (Rom test: rommene) {
			if (test.getNummer() - 1000 == indeks) {
				ret = test.toString();
			}
		}
		return ret;
	}

	public String finnRomNummer(int nummer){
		String ret = "";
		for (Rom test: rommene) {
			if (test.getNummer() == nummer) {
				ret = test.toString();
			}
		}
		return ret;
	}

	public String toString(){
		String ret = "Spektrum, antall rom: " + Rom.getAntRom() + "\n";
		for (Rom test: rommene) {
			ret+= test.toString() + "\n";
		}
		return ret;
	}
}