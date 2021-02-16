package Util;

import Entity.Line;

public class LineValidation {

    public static Boolean isValid ( Integer x1, Integer y1, Integer x2, Integer y2 ) {

        Boolean isValid = false;

        System.out.println( "X1: " + x1 );
        System.out.println( "Y1: " + y1 );
        System.out.println( "X2: " + x2 );
        System.out.println( "Y2: " + y2 );
        
        if ( x1.equals( x2 ) || y1.equals( y2 ) ) {
            isValid = true;
            System.out.println( "Valid Line. " );
        } else {
            System.out.println( "Invalid Line. " );
        }

        return isValid;

    }

    public static Boolean isCreated ( Line l ) {

        Boolean isCreated = false;

        if ( null != l ) {
			System.out.println( "Line is created. " );
            isCreated = true;
        } else {
			System.out.println( "Line is not created. " );
        }

        return isCreated;

    }
    
}
