import java.util.ArrayList;

class Rom{
	private int nummer;
	private int storrelse;
	private ArrayList <Reservasjon>res = new ArrayList<Reservasjon>();
	private static int antRom;

	public Rom(int storrelse){
		this.nummer = Rom.getAntRom() + 1000;
		this.storrelse = storrelse;
		antRom++;
	}

	public int getNummer(){
		return nummer;
	}

	public int getStorrelse(){
		return storrelse;
	}

	public boolean addReservasjon(Tidspunkt fraTid, Tidspunkt tilTid, Kunde kunde, int antPersoner){
		if (antPersoner > storrelse) return false;
		for (Reservasjon sjekk: res) {
			if (!sjekk.overlapp(fraTid, tilTid)) {
				res.add(new Reservasjon(fraTid, tilTid, kunde));
				return true;
			}
		}
		return false;
	}

	public static int getAntRom(){
		return antRom;
	}

	public String toString(){
		String ret = "Romnummer: " + nummer + "\n";
		for (Reservasjon test: res) {
			ret += test.toString();
		}
		return ret;
	}

	public static void main(String[] args){
		Kunde kunde = new Kunde("Kjell", "99232074");
		Tidspunkt fraTid = new Tidspunkt(200302011000L);
		Tidspunkt tilTid = new Tidspunkt(200302011500L);
		Rom testKlient = new Rom(2);
		testKlient.addReservasjon(fraTid, tilTid, kunde, 2);
		System.out.println(testKlient.toString());
	}
}