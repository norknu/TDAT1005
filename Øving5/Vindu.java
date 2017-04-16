import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;



class Vindu extends JFrame implements ActionListener {
	private JPanel vinduet;
	private JLabel teksten;
	private JButton btnSansSerif, btnSerif, btnMonospaced, btnDialog;


	public Vindu() {
		super("Oving5, Oppgave1:");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		vinduet = new JPanel(new FlowLayout());
		setContentPane(vinduet);
		teksten = new JLabel("Tekst skrevet med...");
		vinduet.add(teksten);

		btnSansSerif = new JButton("SansSerif");
		btnSansSerif.addActionListener(this);
		btnSansSerif.setActionCommand("SansSerif");
		vinduet.add(btnSansSerif);

		btnSerif = new JButton("Serif");
		btnSerif.addActionListener(this);
		btnSerif.setActionCommand("Serif");
		vinduet.add(btnSerif);

		btnMonospaced = new JButton("Monospaced");
		btnMonospaced.addActionListener(this);
		btnMonospaced.setActionCommand("Monospaced");
		vinduet.add(btnMonospaced);

		btnDialog = new JButton("Dialog");
		btnDialog.addActionListener(this);
		btnDialog.setActionCommand("Dialog");
		vinduet.add(btnDialog);

		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		String tekstNavn = e.getActionCommand();
		teksten.setText("Tekst skrevet med " + tekstNavn + ".");
		teksten.setFont(new Font (tekstNavn, teksten.getFont().getStyle(), teksten.getFont().getSize()));


	}

	public static void main (String[] args) {
		new Vindu();
	}


}
