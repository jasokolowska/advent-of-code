package advent.of.code.day5;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private Point firstPoint;
    private Point secondPoint;
    private List<Point> line = new LinkedList<>();

    public Line(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        getPoints();
    }

    public void getPoints() {
        int xDiff = firstPoint.getX() - secondPoint.getX();
        int yDiff = firstPoint.getY() - secondPoint.getY();

        if (xDiff == 0) {
            if (yDiff < 0 ) {
                for (int i = 0; i <= Math.abs(yDiff); i++) {
                    line.add(new Point(firstPoint.getX(), firstPoint.getY() + i));
                }
            } else {
                for (int i = 0; i <= yDiff; i++) {
                    line.add(new Point(firstPoint.getX(), firstPoint.getY() - i));
                }
            }

        } else if (yDiff == 0){
            if (xDiff < 0) {
                for (int i = 0; i <= Math.abs(xDiff); i++) {
                    line.add(new Point(firstPoint.getX() + i, firstPoint.getY()));
                }
            } else {
                for (int i = 0; i <= Math.abs(xDiff); i++) {
                    line.add(new Point(firstPoint.getX() - i, firstPoint.getY()));
                }
            }
        } else if (xDiff == yDiff) {
            if (xDiff < 0) {
                for (int i = 0; i <= Math.abs(xDiff); i++) {
                    line.add(new Point(firstPoint.getX() + i, firstPoint.getY() + i));
                }
            }else {
                    for (int i = 0; i <= Math.abs(xDiff); i++) {
                        line.add(new Point(firstPoint.getX() - i, firstPoint.getY() - i));
                }
            }
        } else if (xDiff == -(yDiff)) {
            if (xDiff > 0) {
                for (int i = 0; i <= Math.abs(xDiff); i++) {
                    line.add(new Point(firstPoint.getX() - i, firstPoint.getY() + i));
                }
            }else {
                for (int i = 0; i <= Math.abs(xDiff); i++) {
                    line.add(new Point(firstPoint.getX() + i, firstPoint.getY() - i));
                }
            }
        }
    }

    public List<Point> getLine() {
        return line;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
