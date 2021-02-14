package Util;

import Entity.Canvas;
import Entity.Line;

public class CanvasValidation {
		
	public static Boolean isInCanvas ( Canvas c, Integer x1, Integer x2, Integer y1, Integer y2 ) {
		
		Boolean isIn = false;
		
		if ( x1 >= 0 && x1 <= c.getWidth()
				&& x2 >= 0 && x2 <= c.getWidth()
				&& y1 >= 0 && y1 <= c.getHeight() 
				&& y2 >= 0 && y2 <= c.getHeight() ) {
			isIn = true;
		}
		
		return isIn;
		
	}

}
