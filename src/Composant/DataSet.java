package Composant;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import windows.Content;


public class DataSet extends JButton implements ComposantDraggable,Cloneable{
	private String chemin;
	private String type;
	private Content content;
	private DragSource dragSource;
	
	
	public DataSet(DataSet ds) {
		// TODO Auto-generated constructor stub
		this.chemin = ds.chemin;
	}
	public DataSet(String chemin) {
		super(chemin);
		
		this.chemin = chemin;
		dragSource = new DragSource();
		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		// TODO Auto-generated method stub
		Transferable transferable = new StringSelection(getText());

		dragSource.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);

		
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

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setC(Content content) {
		// TODO Auto-generated method stub
		this.content=content;
	}

@Override
protected Object clone() throws CloneNotSupportedException {
	
	return super.clone();
}
	
	
}
