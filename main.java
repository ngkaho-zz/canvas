import java.io.Console;

import Entity.Canvas;
import Service.PrintService;
import Util.CanvasValidation;

public class main {

    private static final String COMMAND_CREATE_CANVAS_REGEX = "[C]\s[0-9]+\s[0-9]+";
    private static final String COMMAND_CREATE_LINE = "[L]\s[0-9]+\s[0-9]+\s[0-9]+\s[0-9]+";
    private static final String COMMAND_CREATE_RECTANGLE = "[R]\s[0-9]+\s[0-9]+\s[0-9]+\s[0-9]+";

    public static void main ( String[] arg ) {

        String command = null;
        Canvas c = null;

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

                c = new Canvas();

                Integer canvasWidth = Integer.parseInt( createCanvasArray[ 1 ] );
                Integer canvasHeight = Integer.parseInt( createCanvasArray[ 2 ] );

                c.setWidth( canvasWidth );
                c.setHeight( canvasHeight );
                c.setBoard( canvasHeight, canvasWidth );

            } else if ( command.matches( COMMAND_CREATE_LINE ) ) {

                if ( null == c ) {
                    System.out.println( "Canvas is not created. " );
                    continue;
                }

                String[] createLineArray = new String[ 5 ];
                createLineArray = command.split( "\s" );

                Integer lineX1 = Integer.parseInt( createLineArray[ 1 ] );
                Integer lineX2 = Integer.parseInt( createLineArray[ 2 ] );
                Integer lineY1 = Integer.parseInt( createLineArray[ 3 ] );
                Integer lineY2 = Integer.parseInt( createLineArray[ 4 ] );

                if ( CanvasValidation.isInCanvas( c, lineX1, lineX2, lineY1, lineY2 ) ) {

                } else {
                    System.out.println( "Out of range. " );
                }

            }

            if ( null != c ) {
                ps.printCanvas( c );
            }

        }

    }

}