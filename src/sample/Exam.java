package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;



public class Exam {
    public Label x;

    public void bouttIn(MouseEvent event) {
        x.setOpacity(0.3);
    }

    public void bouttOut(MouseEvent event) {
        x.setOpacity(1);
    }

    public void bouttonExt(MouseEvent event) {
        Platform.exit();
    }
}