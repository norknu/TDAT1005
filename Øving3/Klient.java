import static javax.swing.JOptionPane.*;

class Klient{
	public static void main(String[] args){
		boolean start = true;
		int[] storrelse = {4, 4, 5, 4, 6, 2, 3, 5};

		Konferansesenter klient = new Konferansesenter();
		for (int i = 0; i < storrelse.length; i++) {
			klient.registrerRom(storrelse[i]);
		}

		//Combobox
		String RESERVER = "Legg inn reservasjon";
		String OVERSIKT = "Vis oversikt over konferansesenter";
		String FINNINDEKS = "Finn rom (indeks)";
		String FINNNUMMER = "Finn rom (nummer)";
		String NYTTROM = "Opprett nytt rom";
		String[] combo = {RESERVER, OVERSIKT, FINNINDEKS, FINNNUMMER, NYTTROM};
		String valg;
		int valgInt = -1;

		//Reservering
		String navn;
		String tlfnr;
		int antPers;
		long fraTidLest;
		long tilTidLest;

		//finn indeks, nummer og storrelse
		int indeks;
		int nummer;
		int romStorrelse;



		while (start) {
			valg = (String) showInputDialog(null, "Velg fra listen", "Konferansesenter Spektrum", DEFAULT_OPTION, null, combo, combo[0]);

			for (int i = 0; i < combo.length; i++) {
				if (combo[i].equals(valg)) {
					valgInt = i;
				}
				else if (valg == null) {
					start = false;
				}
			}

			switch (valgInt) {
				case 0:
					navn = showInputDialog("Navn?");
					tlfnr = showInputDialog("Telefonnummer?");
					antPers = Integer.parseInt(showInputDialog("Hvor mange personer?"));
					fraTidLest = Long.parseLong(showInputDialog("Nar er reservasjonen? (aaaammddttmm)"));
					tilTidLest = Long.parseLong(showInputDialog("Nar avsluttes reservasjonen? (aaaammddttmm)"));

					Tidspunkt fraTid = new Tidspunkt(fraTidLest);
					Tidspunkt tilTid = new Tidspunkt(tilTidLest);
					Kunde kundeKlient = new Kunde(navn, tlfnr);
					if (klient.reserverRom(fraTid, tilTid, kundeKlient, antPers)) {
						showMessageDialog(null, "Reservasjon vellykket!");
					}
					else showMessageDialog(null, "Misslykket");
					break;

				case 1:
					showMessageDialog(null, klient.toString());
					break;

				case 2:
					indeks = Integer.parseInt(showInputDialog("Hvilken indeks vil du se?"));
					showMessageDialog(null, klient.finnRomIndeks(indeks));
					break;

				case 3:
					nummer = Integer.parseInt(showInputDialog("Hviket romnummer vil du se?"));
					showMessageDialog(null, klient.finnRomNummer(nummer));
					break;

				case 4:
					romStorrelse = Integer.parseInt(showInputDialog("Hvor stor er rommet?"));
					klient.registrerRom(romStorrelse);
					showMessageDialog(null, "Registrert rom med " + romStorrelse + " rom.");
					break;

				default:
					showMessageDialog(null, "Program avsluttes");
					start = false;
					break;
			}

		}
	}
}