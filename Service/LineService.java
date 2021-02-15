package Service;

import Entity.Line;
import Entity.Coordinate;

import Util.LineValidation;

public class LineService {

    public Line createLine ( Integer x1, Integer y1, Integer x2, Integer y2 ) {

        Line l = new Line();

        Coordinate coordinate1 = new Coordinate();
        Coordinate coordinate2 = new Coordinate();

        if ( LineValidation.isValidLine( x1, y1, x2, y2 ) ) {

            if ( x1 < x2 || y1 < y2 ) {

                coordinate1.setX( x1 );
                coordinate1.setY( y1 );
        
                coordinate2.setX( x2 );
                coordinate2.setY( y2 );

            } else {

                coordinate1.setX( x2 );
                coordinate1.setY( y2 );
        
                coordinate2.setX( x1 );
                coordinate2.setY( y1 );

            }
            
            l.setCoordinate1( coordinate1 );
            l.setCoordinate2( coordinate2 );

        }

        return l;

    }
    
}
