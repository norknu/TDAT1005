/* Testprogram fra s.598 i boka
* om liskebokser og endringer i elementene i
* listebokser.
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import static javax.swing.JOptionPane.*;

class ListeboksVindu2 extends JFrame {
	private DefaultListModel listeinnhold = new DefaultListModel(); //"Datamodellen"
	private JList liste = new JList(listeinnhold);

	public ListeboksVindu2(String tittel){
		setTitle(tittel);
		setSize(600, 420);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new TekstPanel(), BorderLayout.NORTH);
		add(new ListePanel(), BorderLayout.CENTER);
		add(new JButton(), BorderLayout.SOUTH);
		//pack();
	}

		/* Beskriver ledetekstene øverst i vinduet*/
		private class TekstPanel extends JPanel {
			public TekstPanel() {
				setLayout(new GridLayout(4, 1, 2, 2));
				add(new JLabel("")); //for å få inn litt luft
				add(new JLabel("Velg \"nytt navn\" for å legge inn nytt navn."));
				add(new JLabel("Klikk på et navn for å fjerne det fra listen."));
				add(new JLabel("")); // for å få inn litt luft
			}
		}


/* bygger opp listen som i starten kun består av : "nytt navn". */
private class ListePanel extends JPanel {
	public ListePanel() {
		/* Det er vanskelig å styre bredden på en liste.Jukser litt....: */
		setLayout(new BorderLayout());
		add(new JButton(), BorderLayout.WEST); //for å fylle opp på venstre side
		listeinnhold.addElement("Nytt Navn"); // legger linjen inni datamodellen
		liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane rullefeltMedListe = new JScrollPane(liste); //rullefelt
		add(rullefeltMedListe, BorderLayout.CENTER);
		liste.addListSelectionListener(new ListeBoksLytter()); //lytter til listevalg
		add(new JButton(), BorderLayout.EAST); // for å fylle opp på høyre side
	}
}

/* Lytter etter valg som gjøres i listen */
private class ListeBoksLytter implements ListSelectionListener {
	public void valueChanged(ListSelectionEvent hendelse) {
		int valg = liste.getSelectedIndex();
		if (valg >= 0) {
			liste.clearSelection();
			if (valg == 0) { //"nytt navn" er valgt
				String nyttNavn = showInputDialog("Registrer nytt navn: ");
				if (nyttNavn != null) {
					listeinnhold.addElement(nyttNavn);
				}
			} else {
				String navnSomFjernes = (String) listeinnhold.get(valg);
				listeinnhold.remove(valg);
				showMessageDialog(ListeboksVindu2.this, "Nå er " + navnSomFjernes + " fjernet fra listen.");
			}
		}
	}
}
}

class TestListeboks2 {
	public static void main(String[] args) {
		ListeboksVindu2 etVindu = new ListeboksVindu2("Dynamisk navneliste");
		etVindu.setVisible(true);
	}
}

