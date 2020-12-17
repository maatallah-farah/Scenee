package sample;

import java.io.IOException;
import java.util.*;
public class Examen {

    private ArrayList<Question> quest = new ArrayList();
    //int numeroQuestionEnCours;

    //Examen(){this.total=total;}
    public void ajouterQuest(Question qst){
        quest.add(qst);
    }
   /* public boolean resteDesQuestions(){
        return numeroQuestionEnCours != quest.size()-1;
    }
    public void afficherQuestionSuivante() {
        if (numeroQuestionEnCours < quest.size() - 1) {
            numeroQuestionEnCours++;
            quest.get(numeroQuestionEnCours)
                    .afficherQuest("Question " + (numeroQuestionEnCours + 1) + ". ");
        }
    }*/

    public ArrayList<Question> getQuest() {
        return quest;
    }

    public void setQuest(ArrayList<Question> a) {
        this.quest = a;
    }

    public void afficher(){
        for (Question q :quest) {
            q.afficherQuest(); }    }



   /* public int getNumeroQuestionEnCours() {
        return numeroQuestionEnCours;
    }

    public void setNumeroQuestionEnCours(int numeroQuestionEnCours) {
        this.numeroQuestionEnCours = numeroQuestionEnCours;
    }*/

   /* public void lireReponseQuestion() throws NumberFormatException, IOException {
        boolean bonneReponse = quest.get(numeroQuestionEnCours).lireReponseAuClavier();
        if (bonneReponse) {
            total++;
        }
    }*/
   // public double geTotal(){return this.total;}
    public void calculerTotal(){}

}
