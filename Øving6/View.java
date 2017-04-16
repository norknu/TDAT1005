import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class Valuta2 extends JFrame{

	private Valuta ny = new Valuta("Ny valuta", 1, 1);

	Valuta[] valutaliste = {
	    new Valuta("Euro", 8.10, 1), new Valuta("US Dollar", 6.23, 1),
	    new Valuta("Britiske pund", 12.27, 1), new Valuta("Svenske kroner", 88.96, 100),
	    new Valuta("Danske kroner", 108.75, 100), new Valuta("Yen", 5.14, 100),
	    new Valuta("Islandske kroner", 9.16, 100), new Valuta("Norske kroner", 100, 100)};

	private DefaultListModel listeinnhold = new DefaultListModel(); //"Datamodellen"
	private JList liste;
	private JList liste2;

	public Valuta2 (String tittel){
		setTitle(tittel);
		//setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new TekstPanel(), BorderLayout.NORTH);
		add(new ListePanel(), BorderLayout.WEST);
		add(new ListePanel2(), BorderLayout.EAST);
		add(new JButton(), BorderLayout.SOUTH); //for å få litt luft

		listeinnhold.addElement(ny);
		for (int i = 0; i < valutaliste.length; i++) {
			listeinnhold.addElement(valutaliste[i]);
		}

		pack();
	}

	private class TekstPanel extends JPanel {
		public TekstPanel() {
			setLayout(new GridLayout(2, 2, 2, 2));
			add(new JLabel("Velg valuta fra listen: "));
			add(new JLabel(""));
			setLayout(new GridLayout(2, 2, 2, 2));
			add(new JLabel("Fra valuta: "));
			add(new JLabel("Til valuta: ", SwingConstants.RIGHT));

		}
	}

private class ListePanel extends JPanel {
	public ListePanel() {
		liste = new JList(listeinnhold);
		setLayout(new BorderLayout());
		add(new JButton(), BorderLayout.WEST); //for å fylle opp på venstre side
	//	listeinnhold.addElement(ny); // legger linjen inni datamodellen
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane rullefeltMedListe = new JScrollPane(liste); //rullefelt
		add(rullefeltMedListe, BorderLayout.CENTER);
		liste.addListSelectionListener(new ListeBoksLytter()); //lytter til listevalg
		add(new JButton(), BorderLayout.EAST); // for å fylle opp på høyre side
		}

	}

private class ListePanel2 extends JPanel {
	public ListePanel2() {
		liste2 = new JList(listeinnhold);
		setLayout(new BorderLayout());
		add(new JButton(), BorderLayout.WEST); //for å fylle opp på venstre side
		liste2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane rullefeltMedListe2 = new JScrollPane(liste2); //rullefelt
		add(rullefeltMedListe2, BorderLayout.CENTER);
		liste2.addListSelectionListener(new ListeBoksLytter()); //lytter til listevalg
		add(new JButton(), BorderLayout.EAST); // for å fylle opp på høyre side
		}

	}

/* Lytter etter valg som gjøres i listen */
private class ListeBoksLytter implements ListSelectionListener {
	public void valueChanged(ListSelectionEvent hendelse) {

		Valuta fraValuta = (Valuta) liste.getSelectedValue();
		Valuta tilValuta = (Valuta) liste2.getSelectedValue();


		if( fraValuta == ny || tilValuta == ny) {
			String navn = showInputDialog("Navn på valutaen du vil registrere: ");
			double kurs = Double.parseDouble(showInputDialog("kursen: (hvor mye er den verdt i norske kroner)"));
			listeinnhold.addElement(new Valuta(navn, kurs, 1));
			liste.setModel(listeinnhold);
			liste2.setModel(listeinnhold);
		}

		if( fraValuta != null && tilValuta !=null){
			int mengde = Integer.parseInt(showInputDialog("Hvor mye vil du kalkurere?"));
			double sum = (mengde * tilValuta.getEnhet()* fraValuta.getKurs())/(fraValuta.getEnhet()* tilValuta.getKurs());

			showMessageDialog(null, mengde + " " + fraValuta.getValutaNavn() + " = " + sum + " " + tilValuta.getValutaNavn());
			liste.clearSelection();
			liste2.clearSelection();
		}
	}
}
}

class View {
	public static void main(String[] args) {
		Valuta2 etVindu = new Valuta2("Dynamisk navneliste");
		etVindu.setVisible(true);
	}
}



