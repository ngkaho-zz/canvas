/**
 * Class:	PaintService
 * Purpose:	Contains the printing method
 * Author:	Kelvin Ng
 * Version:	1.0
 * Date:	17/02/2021
 */

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