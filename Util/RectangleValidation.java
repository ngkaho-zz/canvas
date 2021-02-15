package Util;

import Entity.Rectangle;

public class RectangleValidation {
    
    public static Boolean isValid () {

        Boolean isValid = false;

        return isValid;

    }

    public static Boolean isCreated ( Rectangle r ) {

        Boolean isCreated = false;

        if ( null != r ) {
			System.out.println( "Rectangle is created. " );
            isCreated = true;
        } else {
			System.out.println( "Rectangle is not created. " );
        }

        return isCreated;

    }

}
