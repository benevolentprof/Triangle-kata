
public class Point {
	double x, y;
	
	public Point(double x1, double y1) {
		x = x1;
		y = y1;
	}
	
	public boolean equals(Point pt){
		if ((x == pt.x) && (y == pt.y)) {
			return true;
		}
		return false;
	}

}
