import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

class Controller implements ActionListener{
	private View vindue;
	private Model modell;

	public Controller(View vindue, Model modell){
		this.vindue = vindue;
		this.vindue.getTilNok().addActionListener(this);
		this.vindue.getTilSek().addActionListener(this);
		this.modell = modell;
	}

	public void actionPerformed(ActionEvent e){
		String action = e.getActionCommand();
		String amount = vindue.getBelop();
		try {
			if(action.equals(vindue.ACTION_COMMAND_BTN_TO_NOK)){
				vindue.setSvar(amount + "SEK = " + modell.tilNok(amount) + " NOK");

			}else if (action.equals(vindue.ACTION_COMMAND_BTN_TO_SEK)){
				vindue.setSvar(amount + "NOK = " + modell.tilSek(amount) + " SEK");
			}

		} catch (NumberFormatException e1){
			vindue.setSvar("Ugyldig tall");
		} catch (IllegalArgumentException e2) {
			vindue.setSvar("IA");
		}
	}

	public static void main(String[] args) {
		new Controller(new View(), new Model(0.88, 1.22));
	}

}
