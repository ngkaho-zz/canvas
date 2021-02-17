/**
 * Class:	CanvasValidation
 * Purpose:	Contains the validation method against Canvas
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

package util;

import entity.Canvas;

public class CanvasValidation {
		
	public static Boolean isInCanvas ( Canvas c, Integer x, Integer y ) {
		
		Boolean isIn = false;
		
		if ( x >= 1 && x <= c.getWidth()
				&& y >= 1 && y <= c.getHeight() ) {
			isIn = true;
		} else {
			System.out.println( "Input coordinates are not within canvas. " );
			System.out.println( "Canvas size: " + c.getWidth() + " x " + c.getHeight() );
			System.out.println( "Your coordinates input: ( " + x + ", " + y + " ) " );
		}
		
		return isIn;
		
	}
		
	public static Boolean isInCanvas ( Canvas c, Integer x1, Integer y1, Integer x2, Integer y2 ) {
		
		Boolean isIn = false;
		
		if ( x1 >= 1 && x1 <= c.getWidth()
				&& x2 >= 1 && x2 <= c.getWidth()
				&& y1 >= 1 && y1 <= c.getHeight() 
				&& y2 >= 1 && y2 <= c.getHeight() ) {
			isIn = true;
		} else {
			System.out.println( "Input coordinates are not within canvas. " );
			System.out.println( "Canvas size: " + c.getWidth() + " x " + c.getHeight() );
			System.out.println( "Your coordinates input: ( " + x1 + ", " + y1 + " ), ( " + x2 + ", " + y2 + " )" );
		}
		
		return isIn;
		
	}

	public static Boolean isValid ( Integer width, Integer height ) {

		Boolean isValid = false;

		if ( !height.equals( 0 ) && !width.equals( 0 ) ) {
			isValid = true;
		} else {
			System.out.println( "Invalid canvas input. Canvas width / height must be larger than 0. " );
		}

		return isValid;

	}

	public static Boolean isCreated ( Canvas c ) {

		Boolean isCreated = false;

		if ( null != c ) {
			isCreated = true;
		} else {
			System.out.println( "Canvas is not created. " );
		}

		return isCreated;

	}

}
