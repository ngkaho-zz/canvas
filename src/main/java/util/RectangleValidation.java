package util;

import entity.Rectangle;

public class RectangleValidation {

    public static Boolean isCreated ( Rectangle r ) {

        Boolean isCreated = false;

        if ( null != r ) {
            isCreated = true;
        } else {
			System.out.println( "Rectangle is not created. " );
        }

        return isCreated;

    }

}
