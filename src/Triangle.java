
public class Triangle {

	double x1, y1, x2, y2, x3, y3;
	
	public Triangle(double i, double j, double k, double l, double m, double n) {
		// Assign points
		
		x1 = i;
		y1 = j;
		x2 = k;
		y2 = l;
		x3 = m;
		y3 = n;
	}

	public Point[] getPoints() {
		Point p0, p1, p2;
		
		// Create points
		p0 = new Point(x1, y1);
		p1 = new Point(x2, y2);
		p2 = new Point(x3, y3);
		
		Point[] trianglePoints = {p0, p1, p2};

		return trianglePoints;
	}

	public Side[] getSides() {
		// Create sides
		Side s0, s1, s2;
		
		s0 = new Side(x1, y1, x2, y2);
		s1 = new Side(x2, y2, x3, y3);
		s2 = new Side(x3, y3, x1, y1);

		Side[] triangleSides = new Side[]{s0, s1, s2};

		return triangleSides;
	}

	public double getPerimeter() {
		double perimeter = 0;
		
		for (Side s : getSides()){
			perimeter += s.length();
		}
		return perimeter;
	}

	public Side[] touchingSides(Point point) {
		Side s0, s1;
		Side[] touchingSides;
		Point[] myPoints = getPoints();
		
		if (myPoints[0].equals(point)){
			s0 = new Side(myPoints[0], myPoints[1]);
			s1 = new Side(myPoints[0], myPoints[2]);
			touchingSides = new Side[]{s0, s1};
		} else if (myPoints[1].equals(point)){
			s0 = new Side(myPoints[1], myPoints[0]);
			s1 = new Side(myPoints[1], myPoints[2]);
			touchingSides = new Side[]{s0, s1};
		} else if (myPoints[2].equals(point)){
			s0 = new Side(myPoints[2], myPoints[0]);
			s1 = new Side(myPoints[2], myPoints[1]);		
			touchingSides = new Side[]{s0, s1};
		} else {
			touchingSides = null;
		}
		
		return touchingSides;
	}

	public Side oppositeSide(Point point) {
		Point[] myPoints = getPoints();
		Side s0 = null;

		if (myPoints[0].equals(point)){
			s0 = new Side(myPoints[1], myPoints[2]);
		} else if (myPoints[1].equals(point)){
			s0 = new Side(myPoints[0], myPoints[2]);
		} else if (myPoints[2].equals(point)){
			s0 = new Side(myPoints[0], myPoints[1]);
		} 
		
		return s0;
	}

	public double angleAt(Point point) {
		double angle = Double.NaN;
		Side[] angleSides = touchingSides(point);
		
		angle = dotProduct(angleSides[0], angleSides[1]);

		return angle;
	}
	
	private double dotProduct(Side s1, Side s2){
		double dx1, dy1, dx2, dy2;
		double dot, lengthSquared, angle;
		Point[] s1Points, s2Points;
		
		s1Points = s1.getPoints();
		s2Points = s2.getPoints();
		
		
		dx1 = s1Points[1].x - s1Points[0].x;
		dy1 = s1Points[1].y - s1Points[0].y;
		dx2 = s2Points[1].x - s2Points[0].x;
		dy2 = s2Points[1].y - s2Points[0].y;
		
		dot = dx1*dx2 + dy1*dy2;   // dot product of the 2 vectors
		lengthSquared = (dx1*dx1+dy1*dy1)*(dx2*dx2+dy2*dy2); // product of the squared lengths

		angle = Math.acos(dot/Math.sqrt(lengthSquared));
		
		return angle;
	}

	public double[] getAllAngles() {
		double a0, a1, a2;
		double[] allAngles = null;
		Point[] myPoints = getPoints();
		
		a0 = angleAt(myPoints[0]);
		a1 = angleAt(myPoints[1]);
		a2 = angleAt(myPoints[2]);
		
		allAngles = new double[] {a0, a1, a2};
		
		return allAngles;
	}

	public boolean isRight() {
		boolean isRight = false;
		
		for (double a : getAllAngles()){
			if (a == Math.PI/2){
				isRight = true;
				break;
			}
		}	
		return isRight;
	}
	
}
