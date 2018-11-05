package windows;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import Composant.Combine;
import Composant.DataSets;
import Composant.Select;
import Composant.Transformation;

public class Main {

	
	public static void main(String ar[]) {
		Content content=new Content();
		
		JPanel transformations=new JPanel();
		JPanel datasets=new DataSets(content);
		
		transformations.setLayout(null);
		Transformation t=new Select("select");
		t.setLocation(1,20);
		t.setBounds(100, 60, 160, 80);
		transformations.add(t);
		Transformation t1=new Combine("Combine");
		t1.setBounds(100, 150,160, 80);

		
		transformations.add(t1);
		
		header header=new header();
		
		
		
		
		
		MainWindow main=new MainWindow(header, content, transformations, datasets);
		
	}

}
