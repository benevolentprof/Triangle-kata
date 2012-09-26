
public class Side {
	Point p1, p2;
	
	public Side(Point a, Point b) {
		p1 = a;
		p2 = b;
	}
	
	public Side(double x1, double y1, double x2, double y2) {
		p1 = new Point(x1, y1);
		p2 = new Point(x2, y2);
	}

	public double length() {
		
		double length;
		
		length = Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
		
		return length;
	}

	public Point[] getPoints() {
		
		Point[] myEndpoints = {p1, p2};
		return myEndpoints;
	}
	
	public boolean equals(Side s){
		boolean isSame = false;
		
		Point[] endPoints = s.getPoints();
		
		if (endPoints[0].equals(p1) && endPoints[1].equals(p2)){
			isSame = true;
		} else if (endPoints[0].equals(p2) && endPoints[1].equals(p1)){
			isSame = true;
		} 		
		return isSame;
	}

}
