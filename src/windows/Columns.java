package windows;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Composant.Transformation;
import structure.ParseHeaders;
import structure.ParseHeadersCSV;

public class Columns extends JPanel implements DragSourceListener, DragGestureListener {

	private DragSource ds;
	private StringSelection transferable;

	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList<String> columnsList = new JList<>(model);
	private Transformation tr;
	ParseHeaders ps;

	public Columns() {
		// TODO Auto-generated constructor stub
		setBounds(0, 100, 400, 800);
		setBackground(Color.red);
		setLayout(null);
		ds = new DragSource();
	    DragGestureRecognizer dgr = ds.createDefaultDragGestureRecognizer(columnsList,
	        DnDConstants.ACTION_COPY, this);

	}

	public Transformation getTr() {
		return tr;
	}

	public void setTr(Transformation tr) {
		this.tr = tr;
	}

	void chargerColumns() {
		ps = new ParseHeadersCSV();
		String headers[] = ps.parseheader(tr.getPrecedant().getChemin());

		for (String string : headers) {
			System.out.println(string);
			model.addElement(string);
		}
		columnsList.setSize(new Dimension(600, 60));
		JScrollPane columns = new JScrollPane(columnsList);
		columns.setSize(new Dimension(400, 800));
		add(columns);
		revalidate();
		repaint();
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent arg0) {
		// TODO Auto-generated method stub
		transferable = new StringSelection(columnsList.getSelectedValue().toString());
	    ds.startDrag(arg0, DragSource.DefaultCopyDrop, transferable, this);

	}

	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragExit(DragSourceEvent dse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		// TODO Auto-generated method stub

	}

	public JList<String> getColumnsList() {
		return columnsList;
	}

	public void setColumnsList(JList<String> columnsList) {
		this.columnsList = columnsList;
	}
	
	
}
