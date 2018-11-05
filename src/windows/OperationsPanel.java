package windows;
import java.awt.Color;

import javax.swing.JPanel;

import Composant.Operations;

public class OperationsPanel extends JPanel {

	public OperationsPanel() {
		// TODO Auto-generated constructor stub
		setBounds(800, 100, 400, 800);
		setBackground(Color.BLACK);
		for (String operation : Operations.operations) {
			add(new Operations(operation));
		}
		
	}
}
