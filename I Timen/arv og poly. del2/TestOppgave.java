/**
 * Klassen Oppgave som gitt i oppgaveteksten
 */
import java.util.ArrayList;

abstract class Oppgave {
  public static final int FULL_DAG = 8;

  private int nr;
  private String navn;
  private int antTimer = 0;

  public Oppgave(int startNr, String startNavn, int startAntTimer) {
    nr = startNr;
    navn = startNavn;
    antTimer = startAntTimer;
  }

  public int finnNr() {
    return nr;
  }

  public String finnNavn() {
    return navn;
  }

  public int finnAntTimer() {
    return antTimer;
  }

  public String toString() {
    return nr + ": " + navn + ", " + antTimer + " timer.";
  }

  public abstract boolean skalGjoeresPaaDato(int aktuellDato);

}

class OppgaveDag extends Oppgave {
	private int dato;

	public OppgaveDag( int startNr, String startNavn, int startDag, int startAntTimer){
		super(startNr, startNavn, startAntTimer);
	}

	public int finnDato(){
		return dato;
	}

	public boolean skalGjoeresPaaDato( int aktuellDato){
		return dato == aktuellDato;
	}
}

class OppgavePeriode extends Oppgave {
	private int startDato;
	private int sluttDato;

	public OppgavePeriode( int startNr, String startNavn, int startStartDato, int startSluttDato, int startAntTimer) {
		super(startNr, startNavn, startAntTimer);
		startDato = startStartDato;
		sluttDato = startSluttDato;
	}

	public int finnStartDato(){
		return startDato;
	}

	public int finnSluttDato() {
		return sluttDato;
	}
}

class EnDagIPerioden extends OppgavePeriode {
	public EnDagIPerioden(int startNr, String startNavn, int startDato, int sluttDato, int startAntTimer){
		super(startNr, startNavn, startAntTimer, startDato, sluttDato);
	}
	public boolean skalGjoeresPaaDato( int aktuellDato) {
		return finnSluttDato() == aktuellDato;
	}
}

class HverDagIPerioden extends OppgavePeriode {
	public HverDagIPerioden(int startNr, String startNavn, int startDato, int sluttDato, int startAntTimer){
		super(startNr, startNavn, startAntTimer, startDato, sluttDato);
	}

	public boolean skalGjoeresPaaDato(int aktuellDato){
		return finnStartDato() >= aktuellDato && aktuellDato <= finnSluttDato();
	}
}

class Person {
	private String navn;
	private ArrayList<Oppgave> oppgavene = new ArrayList<Oppgave>();

	public Person(String startNavn){
		navn = startNavn;
	}

	public String finnNavn() {
		return navn;
	}

	public ArrayList<Oppgave> skalGjoeresPaaDato(int dato) {

		ArrayList<Oppgave> oppgaver = new ArrayList<Oppgave>();
		for (Oppgave enOppgave: oppgavene) {
			if(enOppgave.skalGjoeresPaaDato(dato))
				oppgaver.add(enOppgave);
		}
		return oppgaver;
	}
}

class TestOppgave {
	public static void main(String[] args) {
	}
}
