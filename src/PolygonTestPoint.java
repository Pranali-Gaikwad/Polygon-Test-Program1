import java.util.Scanner;
class Point {
	double x;
	double y;

	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
};

/*
 * Algorithm: If the polygon is convex then one can consider the polygon as a
 * "path" from the first vertex. A point is on the interior of this polygons if
 * it is always on the same side of all the line segments making up the path.
 * 
 * Given a line segment between P0 (x0,y0) and P1 (x1,y1), another point P (x,y) has the following 
 * relationship to the line segment.
(y - y0) (x1 - x0) - (x - x0) (y1 - y0)
if it is less than 0 then P is to the right of the line segment,
 if greater than 0 it is to the left, if equal to 0 then it lies on the line segment.
 */
public class PolygonTestPoint {
	
	static boolean isInside(Point polygon[], int n, Point p) {
		polygon[n] = polygon[0];

		int countForleft = 0;
		int countForRight = 0;

		for (int i = 0; i < n; i++) {
			double p0X0 = polygon[i].x;
			double p0y0 = polygon[i].y;

			double p1X1 = polygon[i + 1].x;
			double p1y1 = polygon[i + 1].y;

			double x = p.x;
			double y = p.y;

			if ((y - p0y0) * (p1X1 - p0X0) - (x - p0X0) * (p1y1 - p0y0) == 0) {
				return true;
			}
			if ((y - p0y0) * (p1X1 - p0X0) - (x - p0X0) * (p1y1 - p0y0) < 0) {
				countForRight++;

			}

			if ((y - p0y0) * (p1X1 - p0X0) - (x - p0X0) * (p1y1 - p0y0) > 0) {
				countForleft++;

			}
		}
		if (countForRight == n && countForleft == 0) {

			return true;
		}
		if (countForleft == n && countForRight == 0) {

			return true;
		}

		return false;
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.print("Enter total number of vertices");

		int totalVertices = scan.nextInt();
		if (totalVertices < 3) {
			System.out.println("Enter the Vertices greater than 2");
		} else {

			Point polygonVertexArray[] = new Point[totalVertices + 1];

			System.out.print("Enter Points in X and Y Format eg. 10 20 and press enter after each Point");

			for (int i = 0; i < polygonVertexArray.length - 1; i++) {

				polygonVertexArray[i] = new Point(scan.nextDouble(), scan.nextDouble());

			}

			System.out.print("Enter Point to check whether lies inside or Not");

			Point p = new Point(scan.nextInt(), scan.nextInt());
			if (isInside(polygonVertexArray, totalVertices, p)) {
				System.out.println("True");
			} else {
				System.out.println("False");
			}
		}
	}
}
