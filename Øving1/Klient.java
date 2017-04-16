import static javax.swing.JOptionPane.*;

class Klient {
	public static void main(String[] args) {

		String navn = showInputDialog(null, "Hva skal restauranten hete?");

		int a = Integer.parseInt(showInputDialog(null, "Hvor mange bord er det i restauranten?"));
		Bord bord = new Bord(a);

		int etabAar = Integer.parseInt(showInputDialog(null, "Når ble restauranten etablert?"));

		Restaurant restaurant = new Restaurant(navn,etabAar, bord);

		String[] muligheter = {"Avslutt", "Reserver", "Frigi bord", "Finn reservert bord", "Alder på restauranten", "Oversikt over bordene"};

		int valg;
		do {
			valg = showOptionDialog(null, "Velg det du ønsker å gjøre!", navn, 0, PLAIN_MESSAGE, null, muligheter, muligheter[1]);

			switch(valg) {
				case 1:
				String resNavn = showInputDialog(null, "Hvem skal bordet reserveres på?");
				int antBord = Integer.parseInt(showInputDialog(null, "Hvor mange bord skal reserveres?"));
				bord.reservereBord(resNavn, antBord);
				break;

				case 2:
				int frigi = Integer.parseInt(showInputDialog(null, "Hvor mange bord ønsker du å frigi?"));
				int[] tab = new int[frigi];
				for(int i=0; i<tab.length; i++){
					tab[i] = Integer.parseInt(showInputDialog(null, "Bordnummer " + i));
				}
				bord.frigiBord(tab);
				break;

				case 3:
				String navn1 = showInputDialog(null, "Hvilken person vil du sjekke?");
				int[] reserv = bord.antBordRes(navn1);
				for(int i=0; i<reserv.length; i++){
					if(bord.antBordRes(navn1) == null){
						System.out.println("Ingen bord reservert på " + navn1 + ".");
					} else{
						System.out.println("Bordnummer " + reserv[i] + " er reservert på " + navn1);
					}
				}
				break;

				case 4:
				System.out.println("Restauranten ble etablert i " + restaurant.getAar() + ", og er " + restaurant.getAlder() + " gammel.");

				break;

				case 5:
				System.out.println("Det er " + bord.getAntLedigBord() + " ledige bord!\n" + "Det er " + bord.getAntOpptattBord() + " bord som er opptatt!\n" + "Totalt " + a + " bord!");
			}
		} while (valg !=0);
	}
}
