package Class;

import javafx.scene.paint.Color;

import static Common.CommInstance.mainScene;

public class Line extends javafx.scene.shape.Line {

    public String start;
    public String end;

    public Line() {
        super();
        this.setStroke(Color.RED);
        this.setStrokeWidth(4);
        mainScene.getChildren().add(this);
    }


    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
