package Service;

import Entity.Canvas;
import Entity.Line;

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

    public void paintOnBoard ( Canvas c, Integer x, Integer y, String color ) {

        c.getBoard()[ y ][ x ] = color;
        // System.out.println( "Painted " + color + " on ( " + x + ", " + y + " ). "  );
        return;

    }

}
