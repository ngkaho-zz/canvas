/**
 * Class:	LineService
 * Purpose:	Contains all the methods controlling the Line
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

package service;

import entity.Line;
import entity.Coordinate;

import util.LineValidation;

public class LineService {

    public static Line createLine ( Integer x1, Integer y1, Integer x2, Integer y2 ) {

        Line l = null;

        if ( LineValidation.isValid( x1, y1, x2, y2 ) ) {

            Coordinate coordinate1 = new Coordinate();
            Coordinate coordinate2 = new Coordinate();
            
            l = new Line();

            if ( x1 < x2 || y1 < y2 ) {

            	coordinate1 = CoordinateService.createCoordinate( x1, y1 );
            	coordinate2 = CoordinateService.createCoordinate( x2, y2 );

            } else {

            	coordinate1 = CoordinateService.createCoordinate( x2, y2 );
            	coordinate2 = CoordinateService.createCoordinate( x1, y1 );

            }
            
            l.setCoordinate1( coordinate1 );
            l.setCoordinate2( coordinate2 );

        }

        return l;

    }
    
}
