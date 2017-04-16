import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

class View extends JFrame {
	public static final String ACTION_COMMAND_BTN_TO_NOK = "TO NOK";
	public static final String ACTION_COMMAND_BTN_TO_SEK = "TO SEK";
	private static final long serialVersionUID = 1L;
	private JPanel vindu;
	private JTextField belop;
	private JLabel svar;
	private JButton btnNok, btnSek;

	public View () {
		super("Oving5, Oppgave2:");
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		vindu = new JPanel(new FlowLayout());
		setContentPane(vindu);

		belop = new JTextField("Belop her...", 15);
		vindu.add(belop);

		svar = new JLabel("<Svar>");
		vindu.add(svar);

		btnNok = new JButton("Til NOK");
		btnNok.setActionCommand(ACTION_COMMAND_BTN_TO_NOK);
		vindu.add(btnNok);

		btnSek = new JButton("Til SEK");
		btnSek.setActionCommand(ACTION_COMMAND_BTN_TO_SEK);
		vindu.add(btnSek);

		setVisible(true);

	}

	public JButton getTilNok(){
		return btnNok;
	}

	public JButton getTilSek(){
		return btnSek;
	}

	public String getBelop(){
		return belop.getText();
	}

	public void setSvar(String svaret){
		svar.setText(svaret);
	}
}