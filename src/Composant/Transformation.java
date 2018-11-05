package Composant;


import java.awt.Panel;
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

import javax.swing.JButton;
import javax.swing.JFrame;

import windows.Content;



public abstract class Transformation extends JButton implements ComposantDraggable ,MouseListener{

	DragSource dragSource;
	DataSet precedant;
	Content c;
	String request="";

	public Transformation(String text) {
		setText(text);

		dragSource = new DragSource();

		dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);

	}

	
	
	public DragSource getDragSource() {
		return dragSource;
	}



	public void setDragSource(DragSource dragSource) {
		this.dragSource = dragSource;
	}



	public Content getC() {
		return c;
	}



	public void setC(Content c) {
		this.c = c;
	}



	@Override
	public void dragGestureRecognized(DragGestureEvent event) {
		// TODO Auto-generated method stub
		Transferable transferable = new StringSelection(getText());

		dragSource.startDrag(event, DragSource.DefaultCopyDrop, transferable, this);

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

	public DataSet getPrecedant() {
		return precedant;
	}

	public void setPrecedant(DataSet precedant) {
		this.precedant = precedant;
	}
	
@Override
public void mouseClicked(MouseEvent e) {
	boolean b=false;
	
	if(e.getClickCount()==1) {
		if(this.getPrecedant()==null) {
			System.out.println("choisir un data set");
		}
		
	}
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}



public String getRequest() {
	return request;
}



public void setRequest(String request) {
	this.request = request;
}

}
