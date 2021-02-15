package Entity;

public class Canvas {
   
    private String horizontalFrame;
    private String verticalFrame;
    private String backgroundColor;

    private Integer width;
    private Integer height;
    String[][] board;

    public Canvas () {

        this.horizontalFrame = "-";
        this.verticalFrame = "|";
        this.backgroundColor = " ";

    }

    public void setBoard ( Integer width, Integer height ) {

        this.board = new String[ height + 2 ][ width + 2 ];

        for ( Integer i = 0; i <= width + 1; i ++ ) {
            this.board[ 0 ][ i ] = this.horizontalFrame;
        }

        for ( Integer i = 0; i <= width + 1; i ++ ) {
            this.board[ height + 1 ][ i ] = this.horizontalFrame;
        }

        for ( Integer j = 1; j <= height; j ++) {
            this.board[ j ][ 0 ] = this.verticalFrame;
        }

        for ( Integer j = 1; j <= height; j ++) {
            this.board[ j ][ width + 1 ] = this.verticalFrame;
        }

        for ( Integer i = 1; i <= height; i ++ ) {
            for ( Integer j = 1; j <= width; j ++ ) {
                this.board[ i ][ j ] = this.backgroundColor;
            }
        }
        
    }

    public void setWidth ( Integer width ) {
        this.width = width;
    }

    public void setHeight ( Integer height ) {
        this.height = height;
    }

    public Integer getHeight () {
        return this.height;
    }

    public Integer getWidth () {
        return this.width;
    }

    public String[][] getBoard () {
        return this.board;
    }

    public void setHorizontalFrame ( String horizontalFrame ) {
        this.horizontalFrame = horizontalFrame;
    }

    public void setVerticalFrame ( String verticalFrame ) {
        this.verticalFrame = verticalFrame;
    }

}
