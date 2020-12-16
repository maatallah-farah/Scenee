package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DExam {
    @FXML
    public TextField mat, rep, dead, quest,et;


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


    public ArrayList<String> L= new ArrayList<String>();

    public void ajRep(MouseEvent mouseEvent) {
        L.add(rep.getText());
        rep.setText("");
    }

public ArrayList<Question> L2=new ArrayList<>();
    public void ajquest(MouseEvent mouseEvent) {
        Question q=new Question(quest.getText());
        q.setReponse(L);
        q.setEtat(parseInt(et.getText()));
        quest.setText("");
        L2.add(q);
        L.clear();
        et.setText("");
    }

    public void creer(MouseEvent mouseEvent) {
        Examen e=new Examen();
        e.setQuest(L2);
        e.afficher();
        L2.clear();
    }


    public void back(MouseEvent mouseEvent) throws IOException {
        Parent login = FXMLLoader.load(getClass().getResource("interProf.fxml"));
        Scene Slogin=new Scene(login);
        Stage log=(Stage) ( (Node) mouseEvent.getSource() ).getScene().getWindow();
        log.setScene(Slogin);
        log.show();
    }
}
