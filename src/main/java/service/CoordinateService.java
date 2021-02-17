/**
 * Class:	CoordinateService
 * Purpose:	Contains all the methods controlling the Coordinate
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

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
