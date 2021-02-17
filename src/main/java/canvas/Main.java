package canvas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import constants.SystemConstants;
import entity.Canvas;
import entity.Coordinate;
import entity.Line;
import entity.Rectangle;
import service.CanvasService;
import service.LineService;
import service.PaintService;
import service.PrintService;
import service.RectangleService;
import util.CanvasValidation;
import util.LineValidation;
import util.RectangleValidation;

public class Main {

    public static void main ( String[] arg ) throws IOException {

        String command = null;
        Canvas c = null;

        BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );

        while ( null == command || !command.toUpperCase().matches( SystemConstants.COMMAND_EXIT_REGEX ) ) {

        	System.out.print( "enter your command: " );
        	command = br.readLine();

            if ( command.toUpperCase().matches( SystemConstants.COMMAND_EXIT_REGEX ) ) {
                break;
            }

            if ( command.matches( SystemConstants.COMMAND_CREATE_CANVAS_REGEX ) ) {
                String[] createCanvasArray = new String[ 3 ];
                createCanvasArray = command.split( "\\s" );

                Integer canvasWidth = Integer.parseInt( createCanvasArray[ 1 ] );
                Integer canvasHeight = Integer.parseInt( createCanvasArray[ 2 ] );

                if ( CanvasValidation.isValid( canvasWidth, canvasHeight ) ) {
                    c = CanvasService.createCanvas( canvasWidth, canvasHeight );
                }

            } else if ( command.matches( SystemConstants.COMMAND_CREATE_LINE ) ) {

                if ( !CanvasValidation.isCreated( c ) ) {
                    continue;
                }

                Line l = null;

                String[] createLineArray = new String[ 5 ];
                createLineArray = command.split( "\\s" );

                Integer lineX1 = Integer.parseInt( createLineArray[ 1 ] );
                Integer lineY1 = Integer.parseInt( createLineArray[ 2 ] );
                Integer lineX2 = Integer.parseInt( createLineArray[ 3 ] );
                Integer lineY2 = Integer.parseInt( createLineArray[ 4 ] );

                if ( CanvasValidation.isInCanvas( c, lineX1, lineY1, lineX2, lineY2 ) ) {
                    l = LineService.createLine( lineX1, lineY1, lineX2, lineY2 );
                    if ( LineValidation.isCreated( l ) ) {
                        CanvasService.drawLineToBoard( c, l );
                    }
                }

            } else if ( command.matches( SystemConstants.COMMAND_CREATE_RECTANGLE ) ) {

                if ( !CanvasValidation.isCreated( c ) ) {
                    continue;
                }

                Rectangle r = null;

                String[] createRectangleArray = new String[ 5 ];
                createRectangleArray = command.split( "\\s" );

                Integer rectangleX1 = Integer.parseInt( createRectangleArray[ 1 ] );
                Integer rectangleY1 = Integer.parseInt( createRectangleArray[ 2 ] );
                Integer rectangleX2 = Integer.parseInt( createRectangleArray[ 3 ] );
                Integer rectangleY2 = Integer.parseInt( createRectangleArray[ 4 ] );

                if ( CanvasValidation.isInCanvas( c, rectangleX1, rectangleY1, rectangleX2, rectangleY2 ) ) {
                    r = RectangleService.createRectangle( rectangleX1, rectangleY1, rectangleX2, rectangleY2 );
                    if ( RectangleValidation.isCreated( r ) ) {
                        for ( Line l : r.getLineList() ) {
                            CanvasService.drawLineToBoard( c, l );
                        }
                    }
                }

            } else if ( command.matches( SystemConstants.COMMAND_PAINT ) ) {

                if ( !CanvasValidation.isCreated( c ) ) {
                    continue;
                }

                String[] paintArray = new String[ 4 ];
                paintArray = command.split( "\\s" );

                Integer paintX = Integer.parseInt( paintArray[ 1 ] );
                Integer paintY = Integer.parseInt( paintArray[ 2 ] );

                Coordinate coordinate = new Coordinate();
                coordinate.setX( paintX );
                coordinate.setY( paintY );

                String color;
                
                if ( paintArray.length == 4 ) {
                    color = paintArray[ 3 ];
                } else {
                    color = " ";
                }

                if ( CanvasValidation.isInCanvas( c, paintX, paintY ) ) {
                    PaintService.paint( c, coordinate, color );
                }

            } else if ( command.matches( SystemConstants.COMMAND_HELP ) ) {
                
                System.out.println( "C w h           Create a new canvas of width w and height h." );
                System.out.println( "L x1 y1 x2 y2   Create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character." );
                System.out.println( "R x1 y1 x2 y2   Create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character." );
                System.out.println( "B x y c         Fill the entire area connected to (x,y) with \"colour\" c. The behavior of this is the same as that of the \"bucket fill\" tool in paint programs." );
                System.out.println( "Q               Quit the program." );

            } else {

                System.out.println( "Please type [help] to get the instructions. " );

            }

            if ( null != c ) {

                PrintService.printCanvas( c );

            }

        }

    }

}