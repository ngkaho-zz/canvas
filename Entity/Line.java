package Entity;

public class Line extends Coordinate {

	private Coordinate coordinate1;
	private Coordinate coordinate2;

	private String color;

	public Line () {
		this.color = "x";
	}

	public void setColor ( String color ) {
		this.color = color;
	}

	public String getColor () {
		return this.color;
	}

	public void setCoordinate1 ( Coordinate c ) {
		this.coordinate1 = c;
	}

	public Coordinate getCoordinate1 () {
		return this.coordinate1;
	}

	public void setCoordinate2 ( Coordinate c ) {
		this.coordinate2 = c;
	}

	public Coordinate getCoordinate2 () {
		return this.coordinate2;
	}

	public Boolean isHorizontal () {

		if ( this.coordinate1.getY().equals( this.coordinate2.getY() ) ) {
			return true;
		} else {
			return false;
		}

	}
	
}
