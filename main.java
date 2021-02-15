import java.io.Console;

import Entity.Canvas;
import Entity.Line;
import Entity.Rectangle;
import Service.CanvasService;
import Service.LineService;
import Service.PrintService;
import Service.RectangleService;
import Util.CanvasValidation;
import Util.LineValidation;
import Util.RectangleValidation;

public class main {

    private static final String COMMAND_CREATE_CANVAS_REGEX = "[C]\s[0-9]+\s[0-9]+";
    private static final String COMMAND_CREATE_LINE = "[L]\s[0-9]+\s[0-9]+\s[0-9]+\s[0-9]+";
    private static final String COMMAND_CREATE_RECTANGLE = "[R]\s[0-9]+\s[0-9]+\s[0-9]+\s[0-9]+";

    public static void main ( String[] arg ) {

        String command = null;
        Canvas c = null;

        CanvasService canvasService = new CanvasService();
        LineService lineService = new LineService();
        RectangleService rectangleService = new RectangleService();

        PrintService ps = new PrintService();

        Console console = System.console();

        if ( console == null ) {
            System.err.println( "No console." );
            System.exit(1);
        }
        
        while ( null == command || !command.toLowerCase().equals( "q" ) ) {

            command = console.readLine("enter your command: ");
            
            if ( command.toLowerCase().equals( "q" ) ) {
                break;
            }

            // Create Canvas
            if ( command.matches( COMMAND_CREATE_CANVAS_REGEX ) ) {
                String[] createCanvasArray = new String[ 3 ];
                createCanvasArray = command.split( "\s" );

                Integer canvasWidth = Integer.parseInt( createCanvasArray[ 1 ] );
                Integer canvasHeight = Integer.parseInt( createCanvasArray[ 2 ] );

                if ( CanvasValidation.isValidCanvas( canvasWidth, canvasHeight ) ) {
                    c = canvasService.createCanvas( canvasWidth, canvasHeight );
                }

            } else if ( command.matches( COMMAND_CREATE_LINE ) ) {

                if ( !CanvasValidation.isCreated( c ) ) {
                    continue;
                }

                Line l = null;

                String[] createLineArray = new String[ 5 ];
                createLineArray = command.split( "\s" );

                Integer lineX1 = Integer.parseInt( createLineArray[ 1 ] );
                Integer lineY1 = Integer.parseInt( createLineArray[ 2 ] );
                Integer lineX2 = Integer.parseInt( createLineArray[ 3 ] );
                Integer lineY2 = Integer.parseInt( createLineArray[ 4 ] );

                if ( CanvasValidation.isInCanvas( c, lineX1, lineY1, lineX2, lineY2 ) ) {
                    l = lineService.createLine( lineX1, lineY1, lineX2, lineY2 );
                    if ( LineValidation.isCreated( l ) ) {
                        canvasService.drawLineToBoard( c, l );
                    }
                }

            } else if ( command.matches( COMMAND_CREATE_RECTANGLE ) ) {

                if ( !CanvasValidation.isCreated( c ) ) {
                    continue;
                }

                Rectangle r = null;

                String[] createRectangleArray = new String[ 5 ];
                createRectangleArray = command.split( "\s" );

                Integer rectangleX1 = Integer.parseInt( createRectangleArray[ 1 ] );
                Integer rectangleY1 = Integer.parseInt( createRectangleArray[ 2 ] );
                Integer rectangleX2 = Integer.parseInt( createRectangleArray[ 3 ] );
                Integer rectangleY2 = Integer.parseInt( createRectangleArray[ 4 ] );

                if ( CanvasValidation.isInCanvas( c, rectangleX1, rectangleY1, rectangleX2, rectangleY2 ) ) {
                    r = rectangleService.createRectangle( rectangleX1, rectangleY1, rectangleX2, rectangleY2 );
                    if ( RectangleValidation.isCreated( r ) ) {
                        for ( Line l : r.getLineList() ) {
                            canvasService.drawLineToBoard( c, l );
                        }
                    }
                }

            }

            if ( null != c ) {
                ps.printCanvas( c );
            }

        }

    }

}