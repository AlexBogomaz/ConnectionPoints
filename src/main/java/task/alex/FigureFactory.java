package task.alex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FigureFactory {

    private static ArrayList<Line> resultLines;
    private static ArrayList<Point> points;
    private static ArrayList<Point> rightPoints;
    private static ArrayList<Point> leftPoints;

    public FigureFactory(ArrayList<Point> points) {
        this.points = points;
        this.resultLines = new ArrayList<Line>(points.size());
        rightPoints = new ArrayList<Point>();
        leftPoints = new ArrayList<Point>();
    }

    public ArrayList<Line> createFigure() {
        separatePoints(findMinYPoint(points).getX());
        sortPoints(rightPoints);
        sortPoints(leftPoints);
        buildLines();
        return resultLines;
    }

    private static Point findMinYPoint(ArrayList<Point> points) {
        Point minPointByY = new Point(Double.POSITIVE_INFINITY,Double.POSITIVE_INFINITY);
        for(Point p:points){
            if (minPointByY.getY() > p.getY())
                minPointByY = p;
        }
        return minPointByY;
    }

    private static Point findMaxYPoint(ArrayList<Point> points) {
        Point maxPointByY = new Point(Double.NEGATIVE_INFINITY,Double.NEGATIVE_INFINITY);
        for(Point p:points){
            if (maxPointByY.getY() < p.getY())
                maxPointByY = p;
        }
        return maxPointByY;
    }

    private static void separatePoints(double minPoint) {
        for(Point p:points)
            if (p.getX() >= minPoint)
                rightPoints.add(p);
            else
                leftPoints.add(p);

        leftPoints.add(findMinYPoint(points));
    }


    private static void buildLines() {
        for (int i = 0; i < rightPoints.size() - 1; i++)
            resultLines.add(buildLine(i, i + 1, rightPoints));
        for (int i = 0; i < leftPoints.size() - 1; i++)
            resultLines.add(buildLine(i, i + 1, leftPoints));
        resultLines.add(new Line(findMaxYPoint(rightPoints), findMaxYPoint(leftPoints)));

    }

    private static Line buildLine(int start, int end, ArrayList<Point> points) {
        return new Line(points.get(start), points.get(end));
    }

    private static void sortPoints(ArrayList<Point> points){
        Collections.sort(points, new Comparator<Point>() {
            public int compare(Point o1, Point o2) {
                if (o1.getY() > o2.getY()) return 1;
                if (o1.getY() < o2.getY()) return -1;
                if(o1.getY() == o2.getY())
                    if(o1.getX()<o2.getX()) return 1;
                return 0;
            }
        });
    }


}
