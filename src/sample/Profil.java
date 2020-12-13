package sample;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Profil {
    @FXML
    TextField np,dn,tel,em,mp;

    Connection com = DB.connect();
    Statement st;

    {
        try {
            st = com.createStatement();
            //st.executeQuery();
            st.executeQuery("");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

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
    public void back(MouseEvent event) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("interP.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) event.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }
}