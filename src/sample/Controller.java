package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.*;


import java.io.IOException;

public class Controller {

    double xOffset,yOffset;
    public Label x;

    public void click(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(getClass().getResource("InterP.fxml"));
        Scene aaa=new Scene(root);
        Stage b=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        b.setScene(aaa);
        b.show();

        root.setOnMousePressed(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }

        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                b.setX(event.getScreenX()-xOffset);
                b.setY(event.getScreenY()-yOffset);
            }

        });
    }

    //ExitButtonEffect
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
