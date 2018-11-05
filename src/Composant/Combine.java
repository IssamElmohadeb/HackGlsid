package Composant;


public class Combine extends Transformation {
	
	private Transformation select1;
	private Transformation select2;
	
	public Combine(String text) {
		super(text);
		
	}

	public Transformation getSelect1() {
		return select1;
	}

	public void setSelect1(Transformation select1) {
		this.select1 = select1;
	}

	public Transformation getSelect2() {
		return select2;
	}

	public void setSelect2(Transformation select2) {
		this.select2 = select2;
	}
	
	
	
}
