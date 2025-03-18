/*
Student Name: Samuel Pimentel 
Student ID: 00334334
Course:CIS 252
NOTES:
 */

import java.io.Serializable;
public  class Question implements Serializable{

     private String text;
     private boolean response;
     private String topic;

     public Question(String text)
     {
          this.text  =text;
          topic = null;
     }

     public String getText() {
          return text;
     }

     public void setText(String text) {
          this.text = text;
     }

     public boolean getResponse() {
          return response;
     }
     public void setResponse(boolean response) {
          //False = no &  True = yes
          this.response = response;

     }
     public String getTopic() {return topic;}
     public void setTopic(String topic) {this.topic = topic;}
}
