import java.io.Console;

public class main {

    private static final String COMMAND_CREATE_CANVAS_REGEX = "[C]\s[0-9]+\s[0-9]+";
    private static final String COMMAND_CREATE_LINE = "L ";
    private static final String COMMAND_CREATE_RECTANGLE = "R ";

    public static void main ( String[] arg ) {

        String command = null;
        Canvas c = null;

        PrintService ps = new PrintService();

        Console console = System.console();

        if ( console == null ) {
            System.err.println( "No console." );
            System.exit(1);
        }
        
        while ( null == command || ! command.toLowerCase().equals( "q" ) ) {

            command = console.readLine("enter your command: ");

            // Create Canvas
            if ( command.matches( COMMAND_CREATE_CANVAS_REGEX ) ) {
                String[] createCanvasArray = new String[ 3 ];
                createCanvasArray = command.split( "\s" );
                for ( Integer i = 0; i < createCanvasArray.length; i ++ ) {
                    System.out.println( createCanvasArray[ i ] );
                }

                c = new Canvas();

                Integer canvasWidth = Integer.parseInt( createCanvasArray[ 1 ] );
                Integer canvasHeight = Integer.parseInt( createCanvasArray[ 2 ] );

                c.setWidth( canvasWidth );
                c.setHeight( canvasHeight );
                c.setBoard( canvasHeight, canvasWidth );

            }

            if ( null != c ) {
                ps.printCanvas( c );
            }

        }

    }

}