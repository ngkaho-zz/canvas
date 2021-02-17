/**
 * Class:	Rectangle
 * Purpose:	To store the Rectangle object attributes, extends the Line object
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

package entity;

import java.util.*;

import constants.SystemConstants;

public class Rectangle extends Line {

	private List<Line> lineList;

	private String color;

	public Rectangle () {
		this.lineList = new ArrayList<Line>();
		this.color = SystemConstants.RECTANGLE_DEFAULT_COLOR;
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
