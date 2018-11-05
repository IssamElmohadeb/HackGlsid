package windows;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicBorders.ToggleButtonBorder;

import org.omg.CORBA.SystemException;

import Composant.Combine;
import Composant.ComposantDraggable;
import Composant.DataSet;
import Composant.Select;
import Composant.Transformation;
import structure.ComposantFactory;

public class Content extends JPanel implements DropTargetListener {

	private List<Transformation> trans = new ArrayList<Transformation>();
	private List<DataSet> dataSets = new ArrayList<>();
	private ComposantFactory cf = new ComposantFactory();
	private DataSet datasetTemp = null;
	private Select select1=null;
	private Select select2=null;

	public Content() {

		new DropTarget(this, this);
		
	}

	public void dragEnter(DropTargetDragEvent evt) {

	}

	public void dragOver(DropTargetDragEvent evt) {

	}

	public void dragExit(DropTargetEvent evt) {

	}

	public void dropActionChanged(DropTargetDragEvent evt) {

	}

	public void drop(DropTargetDropEvent evt) {

		try {

			Transferable transferable = evt.getTransferable();

			if (transferable.isDataFlavorSupported(DataFlavor.stringFlavor)) {

				evt.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);

				String dragContents = (String) transferable.getTransferData(DataFlavor.stringFlavor);

				evt.getDropTargetContext().dropComplete(true);

				ComposantDraggable cd = cf.getComposant(dragContents);

				if (cd instanceof Transformation) {
					
					Transformation t = (Transformation) cd;
					t.setBackground(new Color(104, 109, 224));
					t.setBounds(evt.getLocation().x, evt.getLocation().y, 200, 50);
					if (t instanceof Select) {
						t.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent e) {
								if (datasetTemp != null) {
									t.setPrecedant(datasetTemp);
									System.out.println("relation bien effectuée");
									datasetTemp=null;
									repaint();
								}
								else {
									if(select1==null) {
									select1=(Select) t;
									System.out.println("choisir un combine");}
									else {
									select2=(Select) t;
									System.out.println("choisir un combine");
									}
								}
								if(e.getClickCount()==2) {
									new ConfigurationSelectWindow(t);
								}
							}
						});
					}

					else if (t instanceof Combine) {
						Combine combine=(Combine) t;
						combine.addMouseListener(new MouseAdapter() {

							
							@Override
							public void mouseClicked(MouseEvent e) {
								if(select1!=null) {
									combine.setSelect1(select1);;
									System.out.println("relation effectuée");
									repaint();
								}
								if(select2!=null) {
									combine.setSelect2(select2);
									System.out.println("relation effectuée");
									select1=null;
									select2=null;
									repaint();
								}
							}
						});
					}

					trans.add(t);
					this.add(t);
					t.setC(this);
				} else {
					DataSet t = (DataSet) cd;
					t.setBounds(evt.getLocation().x, evt.getLocation().y, 70, 50);
					t.setBackground(new Color(249, 202, 36));
					t.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							datasetTemp = t;
							System.out.println("choisir une transaction !");

						}
					});
					this.add(t);
					dataSets.add(t);
					t.setC(this);

				}

				this.repaint();

			} else {

				evt.rejectDrop();

			}

		}  catch (Exception e) {

			evt.rejectDrop();

		}
	}

	public List<DataSet> getDataSets() {
		return dataSets;
	}

	public void setDataSets(List<DataSet> dataSets) {
		this.dataSets = dataSets;
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);

		g.setColor(Color.black);
		
		for (Transformation transformation : trans) {

			if (transformation.getPrecedant() != null) {
				g.drawLine(transformation.getPrecedant().getX()+transformation.getPrecedant().getWidth(), transformation.getPrecedant().getY(),
						transformation.getX(), transformation.getY());}
			if (transformation instanceof Combine){
				
				Combine c=(Combine) transformation;
				if(c.getSelect1()!=null) {
					System.out.println("relation avec Combine");
					g.drawLine(c.getSelect1().getX()+c.getWidth(), c.getSelect1().getY(),
							transformation.getX(), transformation.getY());
				}
				if(c.getSelect2()!=null) {
					System.out.println("relation avec Combine");
					g.drawLine(c.getSelect2().getX()+c.getWidth(), c.getSelect2().getY(),
							transformation.getX(), transformation.getY());
				}
			}
		}

	}

	

}
