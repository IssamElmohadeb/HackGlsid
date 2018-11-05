package Composant;


import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import windows.Content;

public class DataSets extends JPanel{
	
	List<DataSet> dataSets=new ArrayList<DataSet>();
	JFileChooser fileChooser = new JFileChooser();
	JButton button =new JButton("Ouvrir");
	private Content content;
	
	
	public DataSets(Content content) {
		// TODO Auto-generated constructor stub
		super();
		add(button);
		
		this.content=content;
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ouvrirFichier();
				
				
			}
		});
		                            
    
	}
	
	public void ouvrirFichier() {
		int result = fileChooser.showOpenDialog(null);
		fileChooser.setMultiSelectionEnabled(true);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            String filename = fileChooser.getSelectedFile().getPath();
            DataSet d=new DataSet(filename);
            
            dataSets.add(d);
            add(d); 
            
            this.revalidate();
            this.paint(getGraphics());
            System.out.println(filename);
            
        }
       
	}
	
	
	
	
	
	public void scanner() {
		
	}

}
