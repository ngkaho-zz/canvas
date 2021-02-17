package service;

import entity.Canvas;

public class PrintService {
    
    public static void printCanvas ( Canvas c ) {

        for ( Integer i = 0; i <= c.getHeight() + 1; i ++ ) {
            for ( Integer j = 0; j <= c.getWidth() + 1; j ++ ) {
                System.out.print( c.getBoard()[ i ][ j ] );
            }
            System.out.println();
        }
        
            
    }

}