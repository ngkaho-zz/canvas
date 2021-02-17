package test;

import static org.junit.jupiter.api.Assertions.*;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import constants.SystemConstants;
import entity.Canvas;
import entity.Coordinate;
import entity.Line;
import entity.Rectangle;
import service.CanvasService;
import service.CoordinateService;
import service.LineService;
import service.PaintService;
import service.RectangleService;
import util.CanvasValidation;
import util.LineValidation;
import util.RectangleValidation;

public class CanvasTest {
	
	private Canvas emptyCanvas = null;
	private Canvas c;

	private Coordinate topLeftCorner;
	private Coordinate topRightCorner;
	private Coordinate bottomLeftCorner;
	private Coordinate bottomRightCorner;

	private Coordinate topLeftArea;
	private Coordinate topRightArea;
	private Coordinate bottomLeftArea;
	private Coordinate bottomRightArea;

	private Coordinate horizontalLineCoordinate1;
	private Coordinate horizontalLineCoordinate2;
	private Coordinate verticalLineCoordinate1;
	private Coordinate verticalLineCoordinate2;

	private Coordinate rectangleLine1Coordinate1;
	private Coordinate rectangleLine1Coordinate2;
	private Coordinate rectangleLine2Coordinate1;
	private Coordinate rectangleLine2Coordinate2;
	private Coordinate rectangleLine3Coordinate1;
	private Coordinate rectangleLine3Coordinate2;
	private Coordinate rectangleLine4Coordinate1;
	private Coordinate rectangleLine4Coordinate2;

	private Line rectangleLine1;
	private Line rectangleLine2;
	private Line rectangleLine3;
	private Line rectangleLine4;
	
	private Line emptyLine = null;
	private Line horizontalLine;
	private Line verticalLine;
	
	private Rectangle emptyRectangle = null;
	private Rectangle r;

	private static final Integer TEST_CANVAS_WIDTH = 100;
	private static final Integer TEST_CANVAS_HEIGHT = 100;
	private static final Integer TEST_CANVAS_INVALID_HEIGHT = 0;
	
	private static final Integer TEST_LARGE_CANVAS_WIDTH = 2000;
	private static final Integer TEST_LARGE_CANVAS_HEIGHT = 2000;

	private static final Integer TEST_HORIZONTAL_LINE_X1 = 1;
	private static final Integer TEST_HORIZONTAL_LINE_Y1 = TEST_CANVAS_HEIGHT / 2;
	private static final Integer TEST_HORIZONTAL_LINE_X2 = TEST_CANVAS_WIDTH;
	private static final Integer TEST_HORIZONTAL_LINE_Y2 = TEST_CANVAS_HEIGHT / 2;
	private static final Integer TEST_HORIZONTAL_LINE_INVALID_NON_STRAIGHT_LINE_Y2 = TEST_CANVAS_HEIGHT;
	private static final Integer TEST_HORIZONTAL_LINE_INVALID_OUTSIDE_CANVAS_X2 = TEST_CANVAS_WIDTH + 1;

	private static final Integer TEST_VERTICAL_LINE_X1 = TEST_CANVAS_WIDTH / 2;
	private static final Integer TEST_VERTICAL_LINE_Y1 = 1;
	private static final Integer TEST_VERTICAL_LINE_X2 = TEST_CANVAS_WIDTH / 2;
	private static final Integer TEST_VERTICAL_LINE_Y2 = TEST_CANVAS_HEIGHT;

	private static final Integer TEST_RECTANGLE_X1 = 2;
	private static final Integer TEST_RECTANGLE_Y1 = 2;
	private static final Integer TEST_RECTANGLE_X2 = TEST_CANVAS_WIDTH - 1;
	private static final Integer TEST_RECTANGLE_Y2 = TEST_CANVAS_HEIGHT - 1;
	private static final Integer TEST_RECTANGLE_INVALID_OUTSIDE_CANVAS_Y2 = TEST_CANVAS_HEIGHT + 1;

    @BeforeEach 
    void init () {

    	/**
    	 * Create horizontal line
    	 */
    	c = new Canvas();
    	c.setWidth( TEST_CANVAS_WIDTH );
    	c.setHeight( TEST_CANVAS_HEIGHT );
    	c.setBoard( TEST_CANVAS_WIDTH, TEST_CANVAS_HEIGHT );

    	/**
    	 * Create painting coordinates
    	 */
    	topLeftCorner = new Coordinate();
    	topRightCorner = new Coordinate();
    	bottomLeftCorner = new Coordinate();
    	bottomRightCorner = new Coordinate();

    	topLeftCorner.setX( 1 );
    	topLeftCorner.setY( 1 );

    	topRightCorner.setX( TEST_CANVAS_WIDTH );
    	topRightCorner.setY( 1 );

    	bottomLeftCorner.setX( 1 );
    	bottomLeftCorner.setY( TEST_CANVAS_HEIGHT );

    	bottomRightCorner.setX( TEST_CANVAS_WIDTH );
    	bottomRightCorner.setY( TEST_CANVAS_HEIGHT );
    	
    	topLeftArea = new Coordinate();
    	topRightArea = new Coordinate();
    	bottomLeftArea = new Coordinate();
    	bottomRightArea = new Coordinate();

    	topLeftArea.setX( 3 );
    	topLeftArea.setY( 3 );

    	topRightArea.setX( TEST_CANVAS_WIDTH - 2 );
    	topRightArea.setY( 3 );

    	bottomLeftArea.setX(3 );
    	bottomLeftArea.setY( TEST_CANVAS_HEIGHT - 2 );

    	bottomRightArea.setX( TEST_CANVAS_WIDTH - 2 );
    	bottomRightArea.setY( TEST_CANVAS_HEIGHT - 2 );
    	
    	/**
    	 * Create horizontal line
    	 */
    	horizontalLineCoordinate1 = new Coordinate();
    	horizontalLineCoordinate2 = new Coordinate();
    	
    	horizontalLineCoordinate1.setX( TEST_HORIZONTAL_LINE_X1 );
    	horizontalLineCoordinate1.setY( TEST_HORIZONTAL_LINE_Y1 );
    	horizontalLineCoordinate2.setX( TEST_HORIZONTAL_LINE_X2 );
    	horizontalLineCoordinate2.setY( TEST_HORIZONTAL_LINE_Y2 );

    	horizontalLine = new Line();
    	horizontalLine.setCoordinate1( horizontalLineCoordinate1 );
    	horizontalLine.setCoordinate2( horizontalLineCoordinate2 );

    	/**
    	 * Create vertical line
    	 */
    	verticalLineCoordinate1 = new Coordinate();
    	verticalLineCoordinate2 = new Coordinate();
    	
    	verticalLineCoordinate1.setX( TEST_VERTICAL_LINE_X1 );
    	verticalLineCoordinate1.setY( TEST_VERTICAL_LINE_Y1 );
    	verticalLineCoordinate2.setX( TEST_VERTICAL_LINE_X2 );
    	verticalLineCoordinate2.setY( TEST_VERTICAL_LINE_Y2 );

    	verticalLine = new Line();
    	verticalLine.setCoordinate1( verticalLineCoordinate1 );
    	verticalLine.setCoordinate2( verticalLineCoordinate2 );
    	
    	/**
    	 * Create rectangle
    	 */
        Integer rectangleSmallerX = TEST_RECTANGLE_X1;
        Integer rectangleSmallerY = TEST_RECTANGLE_Y1;
        Integer rectangleLargerX = TEST_RECTANGLE_X2;
        Integer rectangleLargerY = TEST_RECTANGLE_Y2;
    	
    	r = new Rectangle();

    	/**
    	 * Rectangle line 1
    	 */    	
    	rectangleLine1Coordinate1 = new Coordinate();
    	rectangleLine1Coordinate2 = new Coordinate();
    	
    	rectangleLine1Coordinate1.setX( rectangleSmallerX );
    	rectangleLine1Coordinate1.setY( rectangleSmallerY );
    	rectangleLine1Coordinate2.setX( rectangleLargerX );
    	rectangleLine1Coordinate2.setY( rectangleSmallerY );
    	
    	rectangleLine1 = new Line();
    	rectangleLine1.setCoordinate1( rectangleLine1Coordinate1 );
    	rectangleLine1.setCoordinate2( rectangleLine1Coordinate2 );

    	/**
    	 * Rectangle line 2
    	 */    	
    	rectangleLine2Coordinate1 = new Coordinate();
    	rectangleLine2Coordinate2 = new Coordinate();
    	
    	rectangleLine2Coordinate1.setX( rectangleSmallerX );
    	rectangleLine2Coordinate1.setY( rectangleSmallerY );
    	rectangleLine2Coordinate2.setX( rectangleLargerX );
    	rectangleLine2Coordinate2.setY( rectangleLargerY );
    	
    	rectangleLine2 = new Line();
    	rectangleLine2.setCoordinate1( rectangleLine2Coordinate1 );
    	rectangleLine2.setCoordinate2( rectangleLine2Coordinate2 );
    	
    	/**
    	 * Rectangle line 3
    	 */    	
    	rectangleLine3Coordinate1 = new Coordinate();
    	rectangleLine3Coordinate2 = new Coordinate();
    	
    	rectangleLine3Coordinate1.setX( rectangleLargerX );
    	rectangleLine3Coordinate1.setY( rectangleSmallerY );
    	rectangleLine3Coordinate2.setX( rectangleLargerX );
    	rectangleLine3Coordinate2.setY( rectangleLargerY );
    	
    	rectangleLine3 = new Line();
    	rectangleLine3.setCoordinate1( rectangleLine3Coordinate1 );
    	rectangleLine3.setCoordinate2( rectangleLine3Coordinate2 );
    	
    	/**
    	 * Rectangle line 4
    	 */    	
    	rectangleLine4Coordinate1 = new Coordinate();
    	rectangleLine4Coordinate2 = new Coordinate();
    	
    	rectangleLine4Coordinate1.setX( rectangleSmallerX );
    	rectangleLine4Coordinate1.setY( rectangleLargerY );
    	rectangleLine4Coordinate2.setX( rectangleLargerX );
    	rectangleLine4Coordinate2.setY( rectangleLargerY );
    	
    	rectangleLine4 = new Line();
    	rectangleLine4.setCoordinate1( rectangleLine4Coordinate1 );
    	rectangleLine4.setCoordinate2( rectangleLine4Coordinate2 );

        r.addLine( rectangleLine1 );
        r.addLine( rectangleLine2 );
        r.addLine( rectangleLine3 );
        r.addLine( rectangleLine4 );
        
    }

    @AfterEach
    void teardown () {
    	
    	c = null;
    	horizontalLineCoordinate1 = null;
    	horizontalLineCoordinate2 = null;
    	verticalLineCoordinate1 = null;
    	verticalLineCoordinate2 = null;
    	horizontalLine = null;
    	verticalLine = null;
    	r = null;
    	
    }

	@Test
    @DisplayName( "Simple create a canvas" ) 
	void successCreateCanvas () {
		
		Canvas c = CanvasService.createCanvas( TEST_CANVAS_WIDTH, TEST_CANVAS_HEIGHT );
		assertNotNull( c );
		assertEquals( c.getWidth(), TEST_CANVAS_WIDTH );
		assertEquals( c.getHeight(), TEST_CANVAS_HEIGHT );
		
	}

	@Test
    @DisplayName( "Create a large canvas" ) 
	void successCreateLargeCanvas () {
		
		Canvas c = CanvasService.createCanvas( TEST_LARGE_CANVAS_WIDTH, TEST_LARGE_CANVAS_HEIGHT );
		assertNotNull( c, "Canvas is created. Not null. " );
		assertEquals( c.getWidth(), TEST_LARGE_CANVAS_WIDTH, "Canvas width is valid. " );
		assertEquals( c.getHeight(), TEST_LARGE_CANVAS_HEIGHT, "Canvas height is valid" );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isValid - Pass" ) 
	void passCanvasValidationIsValid () {
		
		Boolean result = CanvasValidation.isValid( TEST_CANVAS_WIDTH, TEST_CANVAS_HEIGHT );
		assertEquals( result, true, "Canvas is valid. " );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isValid - Fail" ) 
	void failCanvasValidationIsValid () {
		
		Boolean result = CanvasValidation.isValid( TEST_CANVAS_WIDTH, TEST_CANVAS_INVALID_HEIGHT );
		assertEquals( result, false, "Canvas is invalid. " );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isCreated - Pass" ) 
	void passCanvasValidationIsCreated () {

		Boolean result = CanvasValidation.isCreated( c );
		assertEquals( result, true, "Canvas is created. " );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isCreated - Fail" ) 
	void failCanvasValidationIsCreated () {
		
		Boolean result = CanvasValidation.isCreated( emptyCanvas );
		assertEquals( result, false, "Canvas is not created. " );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isInCanvas - Pass" ) 
	void passCanvasValidationIsInCanvas () {

		Boolean result = CanvasValidation.isInCanvas( c, TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_Y2 );
		assertEquals( result, true, "Object is in canvas. " );
		
	}
	
	@Test
    @DisplayName( "CanvasValidation - isInCanvas - Fail" ) 
	void failCanvasValidationIsInCanvas () {

		Boolean result = CanvasValidation.isInCanvas( c, TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_INVALID_OUTSIDE_CANVAS_X2, TEST_HORIZONTAL_LINE_Y2 );
		assertEquals( result, false, "Object is outside canvas. " );
		
	}
	
	@Test
    @DisplayName( "LineValidation - isValid - Pass" ) 
	void passLineValidationIsValid () {

		Boolean result = LineValidation.isValid( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_Y2 );
		assertEquals( result, true, "Line is valid. " );
		
	}
	
	@Test
    @DisplayName( "LineValidation - isValid ( Outside canvas ) - Pass" ) 
	void passLineValidationIsValidOutsideCanvas () {

		Boolean result = LineValidation.isValid( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_INVALID_OUTSIDE_CANVAS_X2, TEST_HORIZONTAL_LINE_Y2 );
		assertEquals( result, true, "Line is valid. " );
		
	}
    	
	@Test
    @DisplayName( "LineValidation - isValid - Fail" ) 
	void failLineValidationIsValid () {

		Boolean result = LineValidation.isValid( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_INVALID_NON_STRAIGHT_LINE_Y2 );
		assertEquals( result, false, "Line is invalid. " );
		
	}
	
	@Test
    @DisplayName( "LineValidation - isCreated - Pass" ) 
	void passLineValidationIsCreated () {

		Boolean result = LineValidation.isCreated( horizontalLine );
		assertEquals( result, true, "Line is created. " );
		
	}
	
	@Test
    @DisplayName( "LineValidation - isCreated - Fail" ) 
	void failLineValidationIsCreated () {

		Boolean result = LineValidation.isCreated( emptyLine );
		assertEquals( result, false, "Line is invalid. " );
		
	}
	
	@Test
    @DisplayName( "LineService - createLine - Pass" ) 
	void passCreateLine () {

		Line l = null;
        if ( CanvasValidation.isInCanvas( c, TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_Y2 ) ) {
            l = LineService.createLine( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_Y2 );
        }
		assertNotNull( l, "Line is valid. " );
		
	}
    	
	@Test
    @DisplayName( "LineService - createLine - Fail" ) 
	void failCreateLine () {

		Line l = null;
        if ( CanvasValidation.isInCanvas( c, TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_INVALID_NON_STRAIGHT_LINE_Y2 ) ) {
            l = LineService.createLine( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1, TEST_HORIZONTAL_LINE_X2, TEST_HORIZONTAL_LINE_INVALID_NON_STRAIGHT_LINE_Y2 );
        }
		assertNull( l, "Line is invalid. " );
		
	}
	
	@Test
    @DisplayName( "CoodinateService - createCoordinate - Pass" ) 
	void passCreateCoordinate () {

		Coordinate c = null;
		c = CoordinateService.createCoordinate( TEST_HORIZONTAL_LINE_X1, TEST_HORIZONTAL_LINE_Y1 );
		assertNotNull( c, "Coordinate is created. " );
		assertEquals( c.getX(), TEST_HORIZONTAL_LINE_X1, "Coordinate X is valid. " );
		assertEquals( c.getY(), TEST_HORIZONTAL_LINE_Y1, "Coordinate Y is valid. " );
		
	}
	
	@Test
    @DisplayName( "RectangleService - createRectangle - Pass" ) 
	void passCreateRectangle () {

		Rectangle r = null;

        if ( CanvasValidation.isInCanvas( c, TEST_RECTANGLE_X1, TEST_RECTANGLE_Y1, TEST_RECTANGLE_X2, TEST_RECTANGLE_Y2 ) ) {
            r = RectangleService.createRectangle( TEST_RECTANGLE_X1, TEST_RECTANGLE_Y1, TEST_RECTANGLE_X2, TEST_RECTANGLE_Y2 );
        }
        
		assertNotNull( r, "Rectangle is valid. " );
		
	}
    	
	@Test
    @DisplayName( "RectangleService - createRectangle - Fail" ) 
	void failCreateRectangle () {

		Rectangle r = null;

        if ( CanvasValidation.isInCanvas( c, TEST_RECTANGLE_X1, TEST_RECTANGLE_Y1, TEST_RECTANGLE_X2, TEST_RECTANGLE_INVALID_OUTSIDE_CANVAS_Y2 ) ) {
            r = RectangleService.createRectangle( TEST_RECTANGLE_X1, TEST_RECTANGLE_Y1, TEST_RECTANGLE_X2, TEST_RECTANGLE_INVALID_OUTSIDE_CANVAS_Y2 );
        }
        
		assertNull( r, "Rectangle is invalid. " );
		
	}
	
	@Test
    @DisplayName( "RectangleValidation - isCreated - Pass" ) 
	void passRectangleValidationIsCreated () {

		Boolean result = RectangleValidation.isCreated( r );
		assertEquals( result, true, "Rectangle is created. " );
		
	}
	
	@Test
    @DisplayName( "RectangleValidation - isCreated - Fail" ) 
	void failRectangleValidationIsCreated () {

		Boolean result = RectangleValidation.isCreated( emptyRectangle );
		assertEquals( result, false, "Rectangle is invalid. " );
		
	}
	
	@Test
    @DisplayName( "Case - Create a line and paint on canvas" ) 
	void createOneLineAndPaintOnCanvas () {
		
		String toColor = "o";
		
        CanvasService.drawLineToBoard( c, horizontalLine );
        PaintService.paint( c, topLeftCorner, toColor );

        String upperAreaColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() - 1 ][ horizontalLine.getCoordinate1().getX() ];
        String lowerAreaColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() + 1 ][ horizontalLine.getCoordinate1().getX() ];
        String lineColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() ][ horizontalLine.getCoordinate1().getX() ];

		assertEquals( toColor, upperAreaColor, "Upper area is painted. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, lowerAreaColor, "Lower area is not painted. " );
		assertEquals( SystemConstants.LINE_DEFAULT_COLOR, lineColor, "Line area is not painted. " );
		
	}
	
	@Test
    @DisplayName( "Case - Create a line and paint on line" ) 
	void createOneLineAndPaintOnLine () {
		
		String toColor = "o";
		
        CanvasService.drawLineToBoard( c, horizontalLine );
        PaintService.paint( c, horizontalLine.getCoordinate1(), toColor );

        String upperAreaColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() - 1 ][ horizontalLine.getCoordinate1().getX() ];
        String lowerAreaColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() + 1 ][ horizontalLine.getCoordinate1().getX() ];
        String lineColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() ][ horizontalLine.getCoordinate1().getX() ];

		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, upperAreaColor, "Upper area is painted. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, lowerAreaColor, "Lower area is not painted. " );
		assertEquals( toColor, lineColor, "Line area is not painted. " );
		
	}
	
	@Test
    @DisplayName( "Case - Create a rectangle and paint on outer area" ) 
	void createOneRectangleAndPaintOnOuterArea () {
		
		String toColor = "o";
		
		for ( Line l : r.getLineList() ) {
	        CanvasService.drawLineToBoard( c, l );
		}
		
        PaintService.paint( c, topLeftCorner, toColor );

        String rectangleOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleInnerAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() + 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() ][ r.getLineList().get( 0 ).getCoordinate1().getX() ];

		assertEquals( toColor, rectangleOuterAreaColor, "Outer area is painted. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleInnerAreaColor, "Inner area is not painted. " );
		assertEquals( SystemConstants.RECTANGLE_DEFAULT_COLOR, rectangleColor, "Rectangle area is not painted. " );
		
	}
	
	@Test
    @DisplayName( "Case - Create a rectangle and paint on inner area" ) 
	void createOneRectangleAndPaintOnInnerArea () {
		
		String toColor = "o";
		
		for ( Line l : r.getLineList() ) {
	        CanvasService.drawLineToBoard( c, l );
		}
		
        PaintService.paint( c, topLeftArea, toColor );

        String rectangleOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleInnerAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() + 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() ][ r.getLineList().get( 0 ).getCoordinate1().getX() ];
        
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleOuterAreaColor, "Outer area is not painted. " );
		assertEquals( toColor, rectangleInnerAreaColor, "Inner area is painted. " );
		assertEquals( SystemConstants.RECTANGLE_DEFAULT_COLOR, rectangleColor, "Rectangle area is not painted. " );
		
	}
	
	@Test
    @DisplayName( "Case - Create a rectangle and paint on rectangle" ) 
	void createOneRectangleAndPaintOnRectangle () {
		
		String toColor = "o";
		
		for ( Line l : r.getLineList() ) {
	        CanvasService.drawLineToBoard( c, l );
		}
		
        PaintService.paint( c, r.getLineList().get( 0 ).getCoordinate1(), toColor );

        String rectangleOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleInnerAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() + 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() ][ r.getLineList().get( 0 ).getCoordinate1().getX() ];

		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleOuterAreaColor, "Outer area is not painted. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleInnerAreaColor, "Inner area is not painted. " );
		assertEquals( toColor, rectangleColor, "Rectangle area is painted. " );
		
	}
	
	
	@Test
    @DisplayName( "Case - Draw two lines and one rectangle, paint on different area" ) 
	void createLinesAndRectangleAndPaintOnDifferentArea () {

        CanvasService.drawLineToBoard( c, horizontalLine );

        PaintService.paint( c, horizontalLine.getCoordinate1(), "h" );
        
        CanvasService.drawLineToBoard( c, verticalLine );
        
		for ( Line l : r.getLineList() ) {
	        CanvasService.drawLineToBoard( c, l );
		}

        PaintService.paint( c, topLeftCorner, SystemConstants.CANVAS_DEFAULT_HORIZONTAL_FRAME );
        PaintService.paint( c, topRightCorner, SystemConstants.CANVAS_DEFAULT_VERTICAL_FRAME );
        PaintService.paint( c, bottomLeftCorner, "!" );
        PaintService.paint( c, bottomRightCorner, "@" );
        PaintService.paint( c, topLeftArea, "#" );
        PaintService.paint( c, topRightArea, "$" );
        PaintService.paint( c, bottomLeftArea, "%" );
        PaintService.paint( c, bottomRightArea, "^" );
        PaintService.paint( c, verticalLine.getCoordinate1(), "p" );
		
        String horizontalLineAreaColor = c.getBoard()[ horizontalLine.getCoordinate1().getY() ][ horizontalLine.getCoordinate1().getX() ];
        String verticalLineAreaColor = c.getBoard()[ verticalLine.getCoordinate1().getY() ][ verticalLine.getCoordinate1().getX() ];
        String rectangleAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() ][ r.getLineList().get( 0 ).getCoordinate1().getX() ];
        String rectangleTopLeftOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleTopRightOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate2().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate2().getX() - 1 ];
        String rectangleBottomLeftOuterAreaColor = c.getBoard()[ r.getLineList().get( 3 ).getCoordinate1().getY() + 1 ][ r.getLineList().get( 3 ).getCoordinate1().getX() + 1 ];
        String rectangleBottomRightOuterAreaColor = c.getBoard()[ r.getLineList().get( 3 ).getCoordinate2().getY() + 1 ][ r.getLineList().get( 3 ).getCoordinate2().getX() - 1 ];
        String rectangleTopLeftInnerAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() + 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        String rectangleTopRightInnerAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate2().getY() + 1 ][ r.getLineList().get( 0 ).getCoordinate2().getX() - 1 ];
        String rectangleBottomLeftInnerAreaColor = c.getBoard()[ r.getLineList().get( 3 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 3 ).getCoordinate1().getX() + 1 ];
        String rectangleBottomRightInnerAreaColor = c.getBoard()[ r.getLineList().get( 3 ).getCoordinate2().getY() - 1 ][ r.getLineList().get( 3 ).getCoordinate2().getX() - 1 ];

		assertEquals( "h", horizontalLineAreaColor, "Horizontal line area is painted as h. " );
		assertEquals( "p", verticalLineAreaColor, "Vertical line area is painted as p. " );
		assertEquals( "p", rectangleAreaColor, "Rectangle area is painted as p. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_HORIZONTAL_FRAME, rectangleTopLeftOuterAreaColor, "Rectangle bottom right outer area is painted as " + SystemConstants.CANVAS_DEFAULT_HORIZONTAL_FRAME + ". " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_VERTICAL_FRAME, rectangleTopRightOuterAreaColor, "Rectangle bottom right outer area is painted as " + SystemConstants.CANVAS_DEFAULT_VERTICAL_FRAME + ". " );
		assertEquals( "!", rectangleBottomLeftOuterAreaColor, "Rectangle bottom right outer area is painted as !. " );
		assertEquals( "@", rectangleBottomRightOuterAreaColor, "Rectangle bottom right inner area is painted as @. " );
		assertEquals( "#", rectangleTopLeftInnerAreaColor, "Rectangle bottom right inner area is painted as -. " );
		assertEquals( "$", rectangleTopRightInnerAreaColor, "Rectangle bottom right inner area is painted as |. " );
		assertEquals( "%", rectangleBottomLeftInnerAreaColor, "Rectangle bottom right inner area is painted as !. " );
		assertEquals( "^", rectangleBottomRightInnerAreaColor, "Rectangle bottom right inner area is painted as @. " );

        PaintService.paint( c, topLeftCorner, SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR );
        PaintService.paint( c, topRightCorner, SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR );
        
        rectangleTopLeftOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate1().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate1().getX() + 1 ];
        rectangleTopRightOuterAreaColor = c.getBoard()[ r.getLineList().get( 0 ).getCoordinate2().getY() - 1 ][ r.getLineList().get( 0 ).getCoordinate2().getX() - 1 ];
		
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleTopLeftOuterAreaColor, "Rectangle bottom right outer area is painted as background color. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_BACKGROUND_COLOR, rectangleTopRightOuterAreaColor, "Rectangle bottom right outer area is painted as background color. " );
		
        String topFrameColor = c.getBoard()[ 0 ][ 0 ];
        String rightFrameColor = c.getBoard()[ 1 ][ TEST_CANVAS_WIDTH + 1 ];
		
		assertEquals( SystemConstants.CANVAS_DEFAULT_HORIZONTAL_FRAME, topFrameColor, "Top frame is not painted as background color. " );
		assertEquals( SystemConstants.CANVAS_DEFAULT_VERTICAL_FRAME, rightFrameColor, "Right frame is not painted as background color. " );
        
	}
	
	@Test
    @DisplayName( "Create width x height number of lines" ) 
	void loadTest () {
		
		for ( Integer x = 1; x <= TEST_CANVAS_WIDTH; x ++ ) {
			for ( Integer y = 1; y <= TEST_CANVAS_HEIGHT; y ++ ) {
				
				Coordinate c1 = new Coordinate();
				Coordinate c2 = new Coordinate();
				
				c1.setX( x );
				c1.setY( y );
				c2.setX( x );
				c2.setY( y );
				
				Line l = new Line();
				l.setCoordinate1( c1 );
				l.setCoordinate2( c2 );

		        CanvasService.drawLineToBoard( c, l );
				
			}
		}
		
	}
    	
}
