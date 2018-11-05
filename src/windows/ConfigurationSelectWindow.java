package windows;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import Composant.Transformation;

public class ConfigurationSelectWindow extends JFrame {
	private OperationsPanel operations=new OperationsPanel();
	private RequestContent content=new RequestContent();
	private Columns columns=new Columns();
	private JButton saveButton;
	
	private JPanel panel=new JPanel();

	

	public ConfigurationSelectWindow(Transformation s) throws HeadlessException {
		
		setBounds(0, 0, 1060, 800);
		setVisible(true);
		
		
		
		
		this.columns.setTr(s);
		this.columns.chargerColumns();
		this.content.setBackground(Color.RED);
		
		panel.setBounds(0,0,1060,100);
		panel.setBackground(Color.WHITE);
		saveButton=new JButton("Save");
		saveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int[] selectedIx = columns.getColumnsList().getSelectedIndices();
				System.out.println(selectedIx.length);
				String requette="SELECT ";
				for (int i = 0; i < selectedIx.length; i++) {
				      String sel = columns.getColumnsList().getModel().getElementAt(selectedIx[i]);
				      if(i==(selectedIx.length-1)) {
				    	  requette+=sel+" ";
				      }
				      else {
				    	  requette+=sel+",";
				      }
				      
				}
				
				requette+="From "+s.getPrecedant().getChemin();
				for (String  composant : content.getRequestComposant()) {
					
					requette+=composant+" ";
					
					
				}
				s.setRequest(requette);
				System.out.println(requette);
				
				
			}
		});
		panel.add(saveButton);
		this.getContentPane().setLayout(null);
		
		
		add(this.columns);
		add(this.content);
		add(this.operations);
		add(this.panel);
		
		
		
	}

	
	
}