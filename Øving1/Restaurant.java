import java.util.*;
import static java.util.Calendar.*;

class Restaurant {

	private String navn;
	private int etabAar;
	private Bord bord;

	public Restaurant (String navn, int etabAar, Bord bord){
		this.navn = navn;
		this.etabAar = etabAar;
		this.bord = bord;
	}

	public String getNavn(){
		return navn;
	}

	public void setNavn(String nyttNavn){
		this.navn = nyttNavn;
	}

	public int getAar(){
		return etabAar;
	}

	public int getAlder(){
		return finnAaret() - etabAar;
	}

	public int finnAaret(){
		GregorianCalendar dato = new GregorianCalendar();
		return dato.get(YEAR);
	}

	public int antLedigBord(){
		return bord.getAntLedigBord();
	}

	public int antOpptattBord(){
		return bord.getAntOpptattBord();
	}
}




