package Service;

import Entity.Canvas;
import Entity.Line;
import Entity.Rectangle;
import Entity.Coordinate;

public class CanvasService {
    
    public Canvas createCanvas ( Integer width, Integer height ) {

        Canvas c = new Canvas();
        c.setWidth( width );
        c.setHeight( height );
        c.setBoard( width, height );

        return c;

    }

    public void drawLineToBoard ( Canvas c, Line l ) {

        String[][] board = c.getBoard();

        if ( l.isHorizontal() ) {
            System.out.println( "Line is horizontal. " );
            for ( Integer x = l.getCoordinate1().getX(); x <= l.getCoordinate2().getX(); x ++ ) {
                board[ l.getCoordinate1().getY() ][ x ] = l.getColor();
            }
        } else {
            System.out.println( "Line is vertical. " );
            for ( Integer y = l.getCoordinate1().getY(); y <= l.getCoordinate2().getY(); y ++ ) {
                board[ y ][ l.getCoordinate1().getX() ] = l.getColor();
            }
        }
        
        System.out.println( "Drew line. " );

    }

    public void drawRectangleToBoard ( Canvas c, Rectangle r ) {

        String[][] board = c.getBoard();

        // if ( l.isHorizontal() ) {
        //     System.out.println( "Line is horizontal. " );
        //     if ( lineX1 < lineX2 ) {
        //         for ( Integer x = lineX1; x <= lineX2; x ++ ) {
        //             board[ lineY1 ][ x ] = l.getColor();
        //         }
        //     } else {
        //         for ( Integer x = lineX2; x <= lineX1; x ++ ) {
        //             board[ lineY1 ][ x ] = l.getColor();
        //         }
        //     }
        // } else {
        //     System.out.println( "Line is vertical. " );
        //     if ( lineY1 < lineY2 ) {
        //         for ( Integer y = lineY1; y <= lineY2; y ++ ) {
        //             board[ y ][ lineX1 ] = l.getColor();
        //         }
        //     } else {
        //         for ( Integer y = lineY2; y <= lineY1; y ++ ) {
        //             board[ y ][ lineX1 ] = l.getColor();
        //         }
        //     }
        // }
        
        System.out.println( "Drew line. " );

    }

}
