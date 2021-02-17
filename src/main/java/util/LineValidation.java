/**
 * Class:	LineValidation
 * Purpose:	Contains the validation method against Line
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

package util;

import entity.Line;

public class LineValidation {

    public static Boolean isValid ( Integer x1, Integer y1, Integer x2, Integer y2 ) {

        Boolean isValid = false;

        if ( x1.equals( x2 ) || y1.equals( y2 ) ) {
            isValid = true;
        } else {
            System.out.println( "Line input is invalid. A line must be either horizontal or vertical. " );
            System.out.println( "Your coordinates input: ( " + x1 + ", " + y1 + " ), ( " + x2 + ", " + y2 + " )" );
        }

        return isValid;

    }

    public static Boolean isCreated ( Line l ) {

        Boolean isCreated = false;

        if ( null != l ) {
            isCreated = true;
        } else {
			System.out.println( "Line is not created. " );
        }

        return isCreated;

    }
    
}
