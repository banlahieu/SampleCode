package Class;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.concurrent.ExecutionException;

import static Common.Constant.*;

public class Triangle{

    private String pointA = "A";
    private String pointB = "B";
    private String pointC = "C";

    private String lineAB = "AB";
    private String lineBC = "BC";
    private String lineAC = "AC";

    public LinkedHashMap<String, Point> points = new LinkedHashMap<String, Point>();
    public LinkedHashMap<String, Line> lines = new LinkedHashMap<String, Line>();

    public Triangle(Point pointA, Point pointB, Point pointC) {
        points.put(this.pointA, pointA);
        points.put(this.pointB, pointB);
        points.put(this.pointC, pointC);

        Line lineAB = new Line();
        lineAB.setStart(this.pointA);
        lineAB.setEnd(this.pointB);

        Line lineBC = new Line();
        lineBC.setStart(this.pointB);
        lineBC.setEnd(this.pointC);

        Line lineAC = new Line();
        lineAC.setStart(this.pointA);
        lineAC.setEnd(this.pointC);

        lines.put(this.lineAB, lineAB);
        lines.put(this.lineBC, lineBC);
        lines.put(this.lineAC, lineAC);
        update();
    }

    public HashMap<String, Point> getPoints() {
        return points;
    }

    public void setPoints(LinkedHashMap<String, Point> points) {
        this.points = points;
    }

    public void moveUp() {
            points.forEach( (name, point) -> {
                point.moveUp();
            });
            update();
    }

    public void moveDown(){
        points.forEach( (name, point) -> {
            point.moveDown();
        });
        update();
    }

    public void moveLeft(){
        points.forEach( (name, point) -> {
            point.moveLeft();
        });
        update();
    }

    public void moveRight(){
        points.forEach( (name, point) -> {
            point.moveRight();
        });
        update();
    }

    public void rotateClockwise() {
        String centerPointName = pointA;
        Point centerPoint = points.get(centerPointName);
        points.forEach( (name, point) -> {
            if (!name.equals(centerPointName)){
                point.rotateClockwise(centerPoint);
            }
        });
        update();
    }

    public void rotateCounterClockwise() {
        String centerPointName = pointA;
        Point centerPoint = points.get(centerPointName);
        points.forEach( (name, point) -> {
            if (!name.equals(centerPointName)){
                point.rotateCounterClockwise(centerPoint);
            }
        });
        update();
    }

    public void expand() {
        String centerPointName = pointA;
        Point centerPoint = points.get(centerPointName);
        points.forEach( (name, point) -> {
            if (!name.equals(centerPointName)){
                point.expand(centerPoint);
            }
        });
        update();
    }

    public void reduce() {
        String centerPointName = pointA;
        Point centerPoint = points.get(centerPointName);
        points.forEach( (name, point) -> {
            if (!name.equals(centerPointName)){
                point.reduce(centerPoint);
            }
        });
        update();
    }

    public void update() {
        lines.forEach( (lineName, line) -> {
            drawLine(line);
        });
    }

    private void drawLine(Line line) {
        line.setStartX(convertX(points.get(line.getStart()).getX()));
        line.setStartY(convertY(points.get(line.getStart()).getY()));
        line.setEndX(convertX(points.get(line.getEnd()).getX()));
        line.setEndY(convertY(points.get(line.getEnd()).getY()));
    }

    private double convertX (double x) {
        return DRAW_ZERO_X + x * POINT_DISTANCE;
    }

    private double convertY (double y) {
        return DRAW_ZERO_Y - y * POINT_DISTANCE;
    }
}
