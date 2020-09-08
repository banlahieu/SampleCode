package Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import Class.Point;
import Class.Triangle;

import static Common.Constant.*;
import static Common.CommInstance.*;
import static Common.CommMethod.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {

    @FXML private Text x1;
    @FXML private Text x2;
    @FXML private Text x3;
    @FXML private Text x4;
    @FXML private Text x5;
    @FXML private Text x6;
    @FXML private Text x7;
    @FXML private Text x8;
    @FXML private Text x9;
    @FXML private Text x10;

    @FXML private Text y1;
    @FXML private Text y2;
    @FXML private Text y3;
    @FXML private Text y4;
    @FXML private Text y5;
    @FXML private Text y6;
    @FXML private Text y7;
    @FXML private Text y8;
    @FXML private Text y9;
    @FXML private Text y10;

    @FXML private AnchorPane scene;

    private Point pointA = new Point(POINT_A_X,POINT_A_Y);
    private Point pointB = new Point(POINT_B_X,POINT_B_Y);
    private Point pointC = new Point(POINT_C_X,POINT_C_Y);

    private Triangle triangle;

    private int maxValue = 5;

    public Logger log = Logger.getLogger(MainController.class.getName());
    Handler fileHandler  = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        try {
            //Initialize log
            logInitialize();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            mainScene = this.scene;
            triangle = new Triangle(pointA,pointB,pointC);
            loadForm();
        } catch (Exception e) {
            //write error log
            log.info(e.toString());
            // set alert type
            alert.setAlertType(Alert.AlertType.ERROR);
            // show the dialog
            alert.show();
        }

    }

    private void loadForm() {
        setDimension(maxValue);
    }

    @FXML
    private void handleOnKeyReleased(KeyEvent event)
    {
        try {
            //Button execute
            switch (event.getCode()) {
                case UP:
                    triangle.moveUp();
                    break;
                case DOWN:
                    triangle.moveDown();
                    break;
                case LEFT:
                    triangle.moveLeft();
                    break;
                case RIGHT:
                    triangle.moveRight();
                    break;
                case F1:
                    triangle.rotateCounterClockwise();
                    break;
                case F2:
                    triangle.rotateClockwise();
                    break;
                case F3:
                    triangle.expand();
                    break;
                case F4:
                    triangle.reduce();
                    break;
                case F5:
                    throw new Exception();
            }
        } catch (Exception e) {
            //write error log
            log.info("Input:" + event.getCode() + "--- Message:" + e);
            messageBox("Unknown error occurs. Please contact manager");
        }

    }

    private void setDimension(double maxValue) {

        this.x1.setText(String.valueOf((Double)((maxValue*5)/5)));
        this.x2.setText(String.valueOf((Double)((maxValue*4)/5)));
        this.x3.setText(String.valueOf((Double)((maxValue*3)/5)));
        this.x4.setText(String.valueOf((Double)((maxValue*2)/5)));
        this.x5.setText(String.valueOf((Double)((maxValue*1)/5)));

        this.x6.setText(String.valueOf((Double)((-maxValue*1)/5)));
        this.x7.setText(String.valueOf((Double)((-maxValue*2)/5)));
        this.x8.setText(String.valueOf((Double)((-maxValue*3)/5)));
        this.x9.setText(String.valueOf((Double)((-maxValue*4)/5)));
        this.x10.setText(String.valueOf((Double)((-maxValue*5)/5)));

        this.y1.setText(String.valueOf((Double)((maxValue*5)/5)));
        this.y2.setText(String.valueOf((Double)((maxValue*4)/5)));
        this.y3.setText(String.valueOf((Double)((maxValue*3)/5)));
        this.y4.setText(String.valueOf((Double)((maxValue*2)/5)));
        this.y5.setText(String.valueOf((Double)((maxValue*1)/5)));

        this.y6.setText(String.valueOf((Double)((-maxValue*1)/5)));
        this.y7.setText(String.valueOf((Double)((-maxValue*2)/5)));
        this.y8.setText(String.valueOf((Double)((-maxValue*3)/5)));
        this.y9.setText(String.valueOf((Double)((-maxValue*4)/5)));
        this.y10.setText(String.valueOf((Double)((-maxValue*5)/5)));
    }

    private void logInitialize() throws IOException {
        LocalDateTime now = java.time.LocalDateTime.now();

        String logFolderName = "./log/";
        String logFileName =  logFolderName + now.getYear() + "_" + now.getMonthValue() + "_" + now.getDayOfMonth() + "_" + "GMLaboLog.log";

        File file = new File(logFolderName);
        if (!file.exists()) {
            file.mkdir();
        }

        //Creating consoleHandler and fileHandler
        fileHandler  = new  FileHandler("./log/" + now.getYear() + "_" + now.getMonthValue() + "_" + now.getDayOfMonth() + "_" + "GMLaboLog.log", true);

        //Assigning handlers to LOGGER object
        log.addHandler(fileHandler);

        //Setting levels to handlers and LOGGER
        fileHandler.setLevel(Level.ALL);
        log.setLevel(Level.ALL);

        log.config("Software's running");
    }
}
