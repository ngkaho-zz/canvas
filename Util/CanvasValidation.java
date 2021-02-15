package Util;

import Entity.Canvas;

public class CanvasValidation {
		
	public static Boolean isInCanvas ( Canvas c, Integer x1, Integer y1, Integer x2, Integer y2 ) {
		
		Boolean isIn = false;
		
		if ( x1 >= 1 && x1 <= c.getWidth()
				&& x2 >= 1 && x2 <= c.getWidth()
				&& y1 >= 1 && y1 <= c.getHeight() 
				&& y2 >= 1 && y2 <= c.getHeight() ) {
			System.out.println( "Object is in canvas. " );
			isIn = true;
		} else {
			System.out.println( "Object is not in canvas. " );
		}
		
		return isIn;
		
	}

	public static Boolean isValidCanvas ( Integer width, Integer height ) {

		Boolean isValid = false;

		if ( !height.equals( 0 ) && !width.equals( 0 ) ) {
			System.out.println( "Valid canvas input. " );
			isValid = true;
		} else {
			System.out.println( "Invalid canvas input. " );
		}

		return isValid;

	}

	public static Boolean isCreated ( Canvas c ) {

		Boolean isCreated = false;

		if ( null != c ) {
			System.out.println( "Canvas is created. " );
			isCreated = true;
		} else {
			System.out.println( "Canvas is not created. " );
		}

		return isCreated;

	}

}
