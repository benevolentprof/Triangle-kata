import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TriangleTest {

	double epsilon = 1e-15;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sideHasADistance(){
		// Do
		Side mySide = new Side(0, 0, 4, 0);
		
		// Verify
		assertEquals(4, mySide.length(), epsilon);		
	}
	
	@Test
	public void sideKnowsEndpoints(){
		// Do
		Side mySide = new Side(0, 0, 4, 0);
		
		//Verify
		Point[] ptArray = mySide.getPoints();
		assertTrue(ptArray[0].equals(new Point(0,0)));
		assertTrue(ptArray[1].equals(new Point(4,0)));		
	}
	
	@Test
	public void triangle345HasThreePoints(){
		//Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		Point[] ptArray = tr.getPoints();		
		assertEquals(3, ptArray.length);
	}
	
	@Test
	public void triangle345HasThreeSides(){
		//Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		Side[] sdArray = tr.getSides();	
		assertEquals(3, sdArray.length);
	}
	
	@Test
	public void triangle345HasPerimeter(){
		//Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		assertEquals(12, tr.getPerimeter(), epsilon);
	}
	
	@Test
	public void triangle345HasTwoSidesTouchingAPoint(){
		//Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		Side[] twoSides = tr.touchingSides(new Point(0.0, 0.0));
		assertEquals(2, twoSides.length);
				
		// overkill?
		assertTrue(twoSides[0].equals(new Side(0, 0, 3, 0)));
		assertTrue(twoSides[1].equals(new Side(0, 0, 0, 4)));
	}
	
	@Test
	public void triangle345HasSideNotTouchingAPoint(){
		//Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		Side notTouchingSide = tr.oppositeSide(new Point(0,0));
		assertNotNull(notTouchingSide);
		
		//overkill?
		assertTrue(notTouchingSide.equals(new Side(3, 0, 0, 4)));
	}

	@Test
	public void triangle345twoSidesTouchingHasAngle(){
		// Do
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
		
		//Verify
		double angle = tr.angleAt(new Point(0, 0));
		assertEquals(Math.PI/2, angle, epsilon);
	}

	@Test
	public void triangle345HasThreeAngles(){
		// Do 
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
	
		// Verify
		double[] allAngles = tr.getAllAngles();
		assertEquals(3, allAngles.length);
	}
	
	@Test
	public void triangle345IsARightTriangle(){
		// Do 
		Triangle tr = new Triangle(0, 0, 3, 0, 0, 4);
	
		// Verify
		assertTrue(tr.isRight());
	}

}
