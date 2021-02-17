package service;

import entity.Canvas;
import entity.Line;

public class CanvasService {
    
    public static Canvas createCanvas ( Integer width, Integer height ) {

        Canvas c = new Canvas();
        c.setWidth( width );
        c.setHeight( height );
        c.setBoard( width, height );

        return c;

    }

    public static void drawLineToBoard ( Canvas c, Line l ) {

        if ( l.isHorizontal() ) {
            for ( Integer x = l.getCoordinate1().getX(); x <= l.getCoordinate2().getX(); x ++ ) {
            	paintOnBoard( c, x, l.getCoordinate1().getY(), l.getColor() );
            	// c.getBoard()[ l.getCoordinate1().getY() ][ x ] = l.getColor();
            }
        } else {
            for ( Integer y = l.getCoordinate1().getY(); y <= l.getCoordinate2().getY(); y ++ ) {
            	paintOnBoard( c, l.getCoordinate1().getX(), y, l.getColor() );
            	// c.getBoard()[ y ][ l.getCoordinate1().getX() ] = l.getColor();
            }
        }

    }

    public static void paintOnBoard ( Canvas c, Integer x, Integer y, String color ) {

        c.getBoard()[ y ][ x ] = color;
        return;

    }

}
