package Service;

import Entity.Coordinate;

public class CoordinateService {
    
    public Coordinate createCoordinate ( Integer x, Integer y ) {

        Coordinate c = new Coordinate();

        c.setX( x );
        c.setY( y );

        return c;

    }

}
