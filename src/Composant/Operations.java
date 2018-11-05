package Composant;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Operations extends JButton implements DragSourceListener, DragGestureListener{
	DragSource ds;
	StringSelection transferable;
	public final static String[] operations= {"where","(",")",",","or","and","<",">","==","LIKE"};
	
	public Operations(String s) {
		// TODO Auto-generated constructor stub
		super(s);
		ds = new DragSource();

		ds.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

	}
	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		// TODO Auto-generated method stub
		Transferable transferable = new StringSelection(getText());

		ds.startDrag(event, DragSource.DefaultCopyDrop, transferable, this);

	}

	@Override
	public void dragDropEnd(DragSourceDropEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragEnter(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragExit(DragSourceEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dragOver(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dropActionChanged(DragSourceDragEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
