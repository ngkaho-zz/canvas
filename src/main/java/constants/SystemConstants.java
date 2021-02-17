package constants;

public class SystemConstants {

    /**
     * Commands
     */
    public static final String COMMAND_EXIT_REGEX = "[Q]";
    public static final String COMMAND_CREATE_CANVAS_REGEX = "[C]\\s[0-9]+\\s[0-9]+";
    public static final String COMMAND_CREATE_LINE = "[L]\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+";
    public static final String COMMAND_CREATE_RECTANGLE = "[R]\\s[0-9]+\\s[0-9]+\\s[0-9]+\\s[0-9]+";
    public static final String COMMAND_PAINT = "[B]\\s[0-9]+\\s[0-9]+\\s.";
    public static final String COMMAND_HELP = "[h][e][l][p]";

    /**
     * Canvas
     */
    public static final String CANVAS_DEFAULT_HORIZONTAL_FRAME = "-";
    public static final String CANVAS_DEFAULT_VERTICAL_FRAME = "|";
    public static final String CANVAS_DEFAULT_BACKGROUND_COLOR = " ";

    /**
     * Line
     */
    public static final String LINE_DEFAULT_COLOR = "x";

    /**
     * Rectangle
     */
    public static final String RECTANGLE_DEFAULT_COLOR = "x";
    

}
