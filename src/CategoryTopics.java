

/*
Student Name: Samuel Pimentel 
Student ID:00334334
Course: CIS 252
NOTES:
 */
import java.io.Serializable;

public enum CategoryTopics implements Serializable  {
     ANIMALS {
          public Question question() {
               Question question  = new Question("Is it a dog?");
               question.setTopic("dog");

               //TESTING: System.out.println("Is it a dog?");
               return question;
          }
     },
     MUSIC_GENRE{
          public Question question()
           {
                Question question  = new Question("Is it rock?");
                question.setTopic("rock");

                //TESTING: System.out.println("Is it rock?");
                return question;
           }
      },
     COUNTRIES{
          public Question question()
          {
               Question question  = new Question("Is it in the continent America?");
               question.setTopic("america");

               //TESTING: System.out.println("Is it in the continent America?");
               return question;
          }

     },
     OCCUPATIONS{
          public Question question()
          {
               Question question  = new Question("Is it a doctor?");
               question.setTopic("doctor");

               //TESTING: System.out.println("is it a Doctor?");
               return question;
          }


     };

     public abstract Question question();




}
