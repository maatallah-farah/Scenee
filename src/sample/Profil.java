package sample;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;

public class Profil {

    double xOffset, yOffset;
    public Label x;

    public void sauve(MouseEvent mouseEvent) {
    }

    public void init(ContextMenuEvent contextMenuEvent) {
    }
    public void bouttIn(MouseEvent event){
        x.setOpacity(0.3);
    }
    public void bouttOut(MouseEvent event){
        x.setOpacity(1);
    }
    public void bouttonExt(MouseEvent event){
        Platform.exit();
    }


}