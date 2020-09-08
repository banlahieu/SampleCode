package Class;
import static Common.Constant.*;

public class Point {

    double x;
    double y;

    public Point(double x, double y) {
        this.x = x ;
        this.y = y;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void moveUp() { setY(this.y + MOVE_SPEED); }

    public void moveDown() {
        setY(this.y - MOVE_SPEED);
    }

    public void moveLeft() {
        setX(this.x - MOVE_SPEED);
    }

    public void moveRight() {
        setX(this.x + MOVE_SPEED);
    }

    public void rotateClockwise(Point centerPoint){
        double degree = -ROTATE_DEGREES;
        rotate(centerPoint, degree);
    }

    public void rotateCounterClockwise(Point centerPoint){
        double degree = ROTATE_DEGREES;
        rotate(centerPoint, degree);
    }

    private void rotate(Point centerPoint, double degree) {

        double x1 = centerPoint.getX();
        double x2 = getX();
        double y1 = centerPoint.getY();
        double y2 = getY();

        setX((x2 - x1)*Math.cos(Math.toRadians(degree)) - (y2 - y1)*Math.sin(Math.toRadians(degree)) + x1);
        setY((y2 - y1)*Math.cos(Math.toRadians(degree)) + (x2 - x1)*Math.sin(Math.toRadians(degree)) + y1);
    }
    public void expand(Point centerPoint) {

        double x1 = centerPoint.getX();
        double x2 = getX();
        double y1 = centerPoint.getY();
        double y2 = getY();

        double lineLength = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

        double cos = (x2-x1)/lineLength;
        double sin = (y2-y1)/lineLength;
        double newX = (lineLength + lineLength*0.1)*cos;
        double newY = (lineLength + lineLength*0.1)*sin;

        setY(newY + y1);
        setX(newX + x1);

    }

    public void reduce(Point centerPoint) {
        double x1 = centerPoint.getX();
        double x2 = getX();
        double y1 = centerPoint.getY();
        double y2 = getY();

        double lineLength = Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));

        double cos = (x2-x1)/lineLength;
        double sin = (y2-y1)/lineLength;
        double newX = (lineLength - lineLength*0.1)*cos;
        double newY = (lineLength - lineLength*0.1)*sin;

        setY(newY + y1);
        setX(newX + x1);
    }


}
