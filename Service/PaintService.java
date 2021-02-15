package Service;

import Entity.Canvas;

public class PaintService {

    public static void paint ( Canvas c, Integer x, Integer y, String toColor ) {

        CanvasService canvasService = new CanvasService();

        String fromColor = c.getCurrentCoordinateColor( c, x, y );
        System.out.println( "Current coordinate's color: " + fromColor );

        if ( fromColor.equals( toColor ) ) {
            return;
        } else {
            canvasService.paintOnBoard( c, x, y, toColor );
            if ( c.getUpperCoordinateColor( x, y ).equals( fromColor ) ) {
                paint( c, x, y - 1, toColor );
            }
            if ( c.getLefterCoordinateColor( x, y ).equals( fromColor ) ) {
                paint( c, x - 1, y, toColor );
            }
            if ( c.getLowerCoordinateColor( x, y ).equals( fromColor ) ) {
                paint( c, x, y + 1, toColor );
            }
            if ( c.getRighterCoordinateColor( x, y ).equals( fromColor ) ) {
                paint( c, x + 1, y, toColor );
            }
        }
        
    }
    
}
