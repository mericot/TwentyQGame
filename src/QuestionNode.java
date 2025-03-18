/*
Student Name: Samuel Pimentel 
Student ID:00334334
Course: CIS 252
NOTES:  N/A
 */

import java.io.Serializable;

public class QuestionNode implements Serializable{

    private QuestionNode Yes;   //Left
    private QuestionNode No;    //Right
    private Question question;
    private boolean isEnd;

    public QuestionNode(Question question)
    {
        this.question = question;
        Yes = null;
        No = null;
        isEnd = false;
    }

    //Setters & Getters
    public boolean isEnd() {return Yes == null && No == null;}
    public QuestionNode getYes() {return Yes;}
    public void setYes(QuestionNode yes) {Yes = yes;}
    public QuestionNode getNo() {return No;}
    public void setNo(QuestionNode no) {No = no;}
    public Question getQuestion() {return question;}
    public void setQuestion(Question question) {this.question = question;}
}
