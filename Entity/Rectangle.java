package Entity;

import java.util.*;

public class Rectangle extends Line {

	private List<Line> lineList;

	private String color;

	public Rectangle () {
		this.lineList = new ArrayList<Line>();
		this.color = "x";
	}

	public void addLine ( Line l ) {
		this.lineList.add( l );
	}

	public List<Line> getLineList () {
		return this.lineList;
	}

	public void setColor ( String color ) {
		this.color = color;
	}

	public String getColor () {
		return this.color;
	}
	
}
