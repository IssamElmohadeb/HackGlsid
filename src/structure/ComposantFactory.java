package structure;
import Composant.Combine;
import Composant.ComposantDraggable;
import Composant.DataSet;
import Composant.Select;

public class ComposantFactory {
	
	public ComposantDraggable getComposant(String ComposantType) {
		ComposantDraggable cd=null;
		if(ComposantType.toUpperCase().equals("SELECT")) {
			cd=new Select(ComposantType);
		}
		else if(ComposantType.toUpperCase().equals("COMBINE")) {
			cd=new Combine(ComposantType);
		}
		else {
			cd=new DataSet(ComposantType);
		}
		
		 return cd;
	}

}
