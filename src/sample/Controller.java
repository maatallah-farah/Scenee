package sample;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.*;


import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    double xOffset,yOffset;
    public Label x;
    public TextField m;
    public TextField p;
    ArrayList<String> L=new ArrayList<String>();

    Connection com = DB.connect();
    Statement st;

    {
        try {
            st = com.createStatement();
            //st.executeQuery();

            ResultSet resultSet=st.executeQuery("select mail from etudiant");
            while (resultSet.next()) {
                String ch = resultSet.getString("mail");
                L.add(ch);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void click(MouseEvent mouseEvent) throws IOException {
        String mail=m.getText();
        String password=p.getText();
        if((L.contains(mail) )) {
            if (password.equals("prof")) {
                Parent root = FXMLLoader.load(getClass().getResource("InterProf.fxml"));
                Scene aaa = new Scene(root);
                Stage b = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                b.setScene(aaa);
                b.show();

                root.setOnMousePressed(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }

                });
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        b.setX(event.getScreenX() - xOffset);
                        b.setY(event.getScreenY() - yOffset);
                    }

                });
            } else if(password.equals("student")){
                Parent root = FXMLLoader.load(getClass().getResource("InterP.fxml"));

                Scene aaa = new Scene(root);
                Stage b = (Stage) ((Node) mouseEvent.getSource()).getScene().getWindow();
                b.setScene(aaa);
                b.show();


                root.setOnMousePressed(new EventHandler<MouseEvent>() {

                    @Override
                    public void handle(MouseEvent event) {
                        xOffset = event.getSceneX();
                        yOffset = event.getSceneY();
                    }

                });
                root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        b.setX(event.getScreenX() - xOffset);
                        b.setY(event.getScreenY() - yOffset);
                    }

                });
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Email ou mot de passe invalide!");
            alert.showAndWait();
        }
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
