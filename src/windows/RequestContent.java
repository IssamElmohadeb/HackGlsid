package windows;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

public class RequestContent extends JPanel implements DropTargetListener {

	List<String> requestComposant=new ArrayList<>();
	
	public RequestContent() {
		setBounds(400, 100, 400, 800);
		//setLayout(null);
		new DropTarget(this, this);
	}

	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DropTargetEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drop(DropTargetDropEvent evt) {
		// TODO Auto-generated method stub
		try {

			Transferable transferable = evt.getTransferable();

			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

				evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

				String dragContents = (String) transferable.getTransferData(DataFlavor.stringFlavor);
				
				evt.getDropTargetContext().dropComplete(true);
				
				add(new JButton(dragContents));
				System.out.println("added"+dragContents);
				requestComposant.add(dragContents);
				this.validate();
				this.repaint();
				}}
			catch(Exception e){
					e.printStackTrace();
					}
				
		
	}

	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
		// TODO Auto-generated method stub

	}

	public List<String> getRequestComposant() {
		return requestComposant;
	}

	public void setRequestComposant(List<String> requestComposant) {
		this.requestComposant = requestComposant;
	}

}
