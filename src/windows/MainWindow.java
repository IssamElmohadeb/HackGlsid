package windows;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
	private JPanel test=new JPanel();
	private JPanel header=new header();
	private JPanel content;
	private JPanel transformations;
	private JPanel datasets;
	

	public MainWindow() {
		
	}

	public MainWindow(JPanel header, JPanel content, JPanel transformations, JPanel datasets) throws HeadlessException {
		
		setBounds(0, 0, 2000, 1024);
		setVisible(true);
		
		
		this.content = content;
		this.transformations = transformations;
		this.datasets = datasets;
		
		this.header.setBounds(0, 0, 1024, 40);
		
		this.content.setBounds(0, 40, 1600, 1000);
		this.content.setBackground(Color.white);
		
		this.transformations.setBackground(Color.GRAY);
		this.transformations.setBounds(1600, 40, 400, 400);

		this.datasets.setBackground(Color.green);
		this.datasets.setBounds(1600, 500, 400, 400);
		
		this.getContentPane().setLayout(null);
		this.content.setLayout(null);
		
		add(this.transformations);
		add(this.content);
		add(this.datasets);
		add(this.header);
		
		
		
	}

	public JPanel getHeader() {
		return header;
	}

	public void setHeader(JPanel header) {
		this.header = header;
	}

	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	public JPanel getTransformations() {
		return transformations;
	}

	public void setTransformations(JPanel transformations) {
		this.transformations = transformations;
	}

	public JPanel getDatasets() {
		return datasets;
	}

	public void setDatasets(JPanel datasets) {
		this.datasets = datasets;
	}
		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			
			super.paint(g);
		}
	
}
