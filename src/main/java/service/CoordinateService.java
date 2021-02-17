package service;

import entity.Coordinate;

public class CoordinateService {
    
    public static Coordinate createCoordinate ( Integer x, Integer y ) {

        Coordinate c = new Coordinate();

        c.setX( x );
        c.setY( y );

        return c;

    }

}
