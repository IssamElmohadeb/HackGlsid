package windows;
import javax.swing.JButton;
import javax.swing.JPanel;

public class header extends JPanel{
	private JButton run=new JButton("run");
	private JButton preview=new JButton("preview");
	public header() {
		// TODO Auto-generated constructor stub
		run.setLocation(0, 0);
		preview.setLocation(0, this.getWidth()-preview.getWidth());
		add(run);
		add(preview);
	}
}
