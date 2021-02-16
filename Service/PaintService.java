package Service;

import Entity.Canvas;
import Entity.Coordinate;

import java.util.*;

public class PaintService {

    public static List<Coordinate> unfinishedCoordinates = new ArrayList<>();

    public static Coordinate paint ( Canvas c, Coordinate coordinate, String toColor, Integer recurrsiveLoopCount ) {

        recurrsiveLoopCount++;

        CanvasService canvasService = new CanvasService();
        Coordinate nextCoordinate = new Coordinate();
        String fromColor = c.getCurrentCoordinateColor( coordinate.getX(), coordinate.getY() );

        if ( recurrsiveLoopCount >= 1000 ) {
            unfinishedCoordinates.add( coordinate );
            canvasService.paintOnBoard( c, coordinate.getX(), coordinate.getY(), toColor );
            return coordinate;
        } else {
            if ( fromColor.equals( toColor ) ) {
                return coordinate;
            } else {

                canvasService.paintOnBoard( c, coordinate.getX(), coordinate.getY(), toColor );
                if ( c.getUpperCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getY() > 1 ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() );
                    nextCoordinate.setY( coordinate.getY() - 1 );
                    nextCoordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                } 
                if ( c.getLefterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getX() > 1 ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() - 1 );
                    nextCoordinate.setY( coordinate.getY() );
                    nextCoordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                } 
                if ( c.getLowerCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getY() < c.getHeight() ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() );
                    nextCoordinate.setY( coordinate.getY() + 1 );
                    nextCoordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                } 
                if ( c.getRighterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getX() < c.getWidth() ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() + 1 );
                    nextCoordinate.setY( coordinate.getY() );
                    nextCoordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                }
            }
            return coordinate;
        }

    }

    public static Coordinate paint ( Canvas c, Coordinate coordinate, String toColor ) {

        Integer recurrsiveLoopCount = 0;
        CanvasService canvasService = new CanvasService();

        Coordinate nextCoordinate = coordinate;

        String fromColor = c.getCurrentCoordinateColor( coordinate.getX(), coordinate.getY() );

        while ( c.getUpperCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) 
                || c.getLefterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) 
                || c.getLowerCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) 
                || c.getRighterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) 
        ) {
            recurrsiveLoopCount = 0;
            if ( fromColor.equals( toColor ) ) {
                return coordinate;
            } else {
                canvasService.paintOnBoard( c, coordinate.getX(), coordinate.getY(), toColor );
                if ( c.getUpperCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getY() > 1 ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() );
                    nextCoordinate.setY( coordinate.getY() - 1 );
                    coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                    continue;
                } 
                if ( c.getLefterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getX() > 1 ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() - 1 );
                    nextCoordinate.setY( coordinate.getY() );
                    coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                    continue;
                } 
                if ( c.getLowerCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getY() < c.getHeight() ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() );
                    nextCoordinate.setY( coordinate.getY() + 1 );
                    coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                    continue;
                } 
                if ( c.getRighterCoordinateColor( coordinate.getX(), coordinate.getY() ).equals( fromColor ) && coordinate.getX() < c.getWidth() ) {
                    nextCoordinate = new Coordinate();
                    nextCoordinate.setX( coordinate.getX() + 1 );
                    nextCoordinate.setY( coordinate.getY() );
                    coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                    continue;
                }
            }

        }

        Boolean isNotFinished = unfinishedCoordinates.size() > 0;

        while ( isNotFinished ) {

            recurrsiveLoopCount = 0;
            List<Coordinate> toBeIterateCoordinateList = new ArrayList<>();
            toBeIterateCoordinateList.addAll( unfinishedCoordinates );
            unfinishedCoordinates.clear();

            for ( Coordinate unfinishedCoordinate : toBeIterateCoordinateList ) {
                if (c.getUpperCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) 
                    || c.getLefterCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) 
                    || c.getLowerCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) 
                    || c.getRighterCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) ) {
                    if ( c.getUpperCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) && unfinishedCoordinate.getY() > 1 ) {
                        nextCoordinate = new Coordinate();
                        nextCoordinate.setX( unfinishedCoordinate.getX() );
                        nextCoordinate.setY( unfinishedCoordinate.getY() - 1 );
                        coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                        continue;
                    } 
                    if ( c.getLefterCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) && unfinishedCoordinate.getX() > 1 ) {
                        nextCoordinate = new Coordinate();
                        nextCoordinate.setX( unfinishedCoordinate.getX() - 1 );
                        nextCoordinate.setY( unfinishedCoordinate.getY() );
                        coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                        continue;
                    } 
                    if ( c.getLowerCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) && unfinishedCoordinate.getY() < c.getHeight() ) {
                        nextCoordinate = new Coordinate();
                        nextCoordinate.setX( unfinishedCoordinate.getX() );
                        nextCoordinate.setY( unfinishedCoordinate.getY() + 1 );
                        coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                        continue;
                    }
                    if ( c.getRighterCoordinateColor( unfinishedCoordinate.getX(), unfinishedCoordinate.getY() ).equals( fromColor ) && unfinishedCoordinate.getX() < c.getWidth() ) {
                        nextCoordinate = new Coordinate();
                        nextCoordinate.setX( unfinishedCoordinate.getX() + 1 );
                        nextCoordinate.setY( unfinishedCoordinate.getY() );
                        coordinate = paint( c, nextCoordinate, toColor, recurrsiveLoopCount );
                        continue;
                    }
                }
            }

            if ( unfinishedCoordinates.size() == 0 ) {
                isNotFinished = false;
            }

        }

        return coordinate;

    }

}
