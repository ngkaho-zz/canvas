import java.util.Arrays;

public class PrintService {
    
    public void printCanvas ( Canvas c ) {

        String[][] canvasArray = c.getBoard();

        for ( Integer i = 0; i <= c.getHeight() + 1; i ++ ) {
            for ( Integer j = 0; j <= c.getWidth() + 1; j ++ ) {
                System.out.print( canvasArray[ i ][ j ] );
            }
            System.out.println();
        }
        
            
    }

}