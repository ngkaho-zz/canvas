package service;

import entity.Rectangle;
import entity.Line;

public class RectangleService {

    public static Rectangle createRectangle ( Integer x1, Integer y1, Integer x2, Integer y2 ) {

        Rectangle r = new Rectangle();

        Integer smallerX;
        Integer smallerY;
        Integer largerX;
        Integer largerY;

        if ( x1 <= x2 ) {
            smallerX = x1;
            largerX = x2;
        } else {
            smallerX = x2;
            largerX = x1;
        }

        if ( y1 <= y2 ) {
            smallerY = y1;
            largerY = y2;
        } else {
            smallerY = y2;
            largerY = y1;
        }

        Line line1 = LineService.createLine( smallerX, smallerY, largerX, smallerY );
        Line line2 = LineService.createLine( smallerX, smallerY, smallerX, largerY );
        Line line3 = LineService.createLine( largerX, smallerY, largerX, largerY );
        Line line4 = LineService.createLine( smallerX, largerY, largerX, largerY );

        r.addLine( line1 );
        r.addLine( line2 );
        r.addLine( line3 );
        r.addLine( line4 );

        return r;

    }
    
}
