/*
Student Name: Samuel Pimentel 
Student ID:00334334
Course: CIS 252
NOTES: This is tree Structure
 */

import datastructure.LBList;
import datastructure.LinkedStack;

import java.io.Serializable;
import java.util.Scanner;


public class QuestionTree implements Serializable {

    public final QuestionNode root;
    private final LinkedStack<QuestionNode> stack;
    public QuestionNode currNode;// Keeps reference
    public LBList<String> listOfTopics;

    public QuestionTree(Question question) {

        root = new QuestionNode(question);
        stack = new LinkedStack<QuestionNode>();
        currNode = root;
        listOfTopics = new LBList<>();
        resetCurrentPosition();

    }

    public void resetCurrentPosition()
    {
        currNode = root;
    }

    public void backTrack()
    {
        if(!stack.isEmpty())
        {
            stack.pop();
            currNode = (QuestionNode) stack.top();
        }else{
            System.out.println("Cannot Go back, Stack empty");
        }
    }

    public void clearStack()
    {
        while(!stack.isEmpty())
        {
            stack.pop();
        }
    }

    public void processQuestion(String userInput)
    {
        if (userInput.equals("back") || userInput.equals("Back")) {
            backTrack();

        } else if (userInput.equals("yes") || userInput.equals("Yes")) {
            stack.push(currNode);
            currNode = currNode.getYes();

        } else if (userInput.equals("no") || userInput.equals("No")) {
            stack.push(currNode);
            currNode = currNode.getNo();
        }
    }

    public void CollectLeafTopics()
    {
        listOfTopics = new LBList<>();
        helper_CollectLeafTopics(root);
    }

    private QuestionNode helper_CollectLeafTopics(QuestionNode current)
    {
       /*
       Method has to be recursive
        */

        if(current == null)
        {
            //Base case
            return null;
        }else if(current.isEnd())
        {
            if(!listOfTopics.contains(current.getQuestion().getTopic()))
            {
                listOfTopics.add(current.getQuestion().getTopic());

            }
            return current;
        }
        else {
            helper_CollectLeafTopics(current.getYes());
            helper_CollectLeafTopics(current.getNo());
            return current;
        }
    }

    public void enrichTree(QuestionNode node, Scanner input)
    {

        String getUserQuestion;
        String getUserTopic;
        String differentated_Question;
        String Yes_orNo;


        String userInput = input.next();
        input.nextLine();

        switch (userInput)
        {
            case "no","No":
                //Method: If no teach tree by prompting user for a topic

                System.out.println("Reached the last question." +
                        "Please answer the following questions so I can learn from you\n" +
                        "Tell me what you were thinking of in terms of a question\n");
                //Get user question
                getUserQuestion = input.nextLine();

                System.out.println("Question -> " + getUserQuestion);


                System.out.println("My final guess was ->" + currNode.getQuestion().getText());
                System.out.println("and topic was ->" + currNode.getQuestion().getTopic());

                //User Topic
                System.out.println("Please enter the topic name of your question");
                getUserTopic = input.next();
                input.nextLine();

                System.out.println("Topic ->" + getUserTopic);

                System.out.println("Please provide a yes or no question that would differentiate the two guesses");
                differentated_Question = input.nextLine();

                stack.push(new QuestionNode(new Question(differentated_Question)));

                System.out.println("If your differentiated question was asked, where would your topic you input in fall?");
                Yes_orNo = input.next();
                input.nextLine();

                switch (Yes_orNo)
                {
                    case "no" , "No":

                        System.out.println("You picked no");
                        Question question_No = new Question(getUserQuestion);
                        question_No.setTopic(getUserTopic);

                        Question question_Yes = node.getQuestion();



                        node.setNo(new QuestionNode(question_No));
                        node.setYes(new QuestionNode(question_Yes));

                        Question temp = new Question(differentated_Question);
                        node.setQuestion(temp);

                        break;

                        case "yes" , "Yes":
                            System.out.println("You picked yes");
                            question_Yes = new Question(getUserQuestion);
                            question_Yes.setTopic(getUserTopic);

                            question_No = node.getQuestion();
                            node.setNo(new QuestionNode(question_No));
                            node.setYes(new QuestionNode(question_Yes));
                            temp = new Question(differentated_Question);
                            node.setQuestion(temp);

                            break;
                    }
                    break;

                case "yes","Yes":
                    System.out.println(node.getQuestion().getText());
                    System.out.println("Win");
                    break;

            case "back", "Back":
                backTrack();

                break;
            }

        input.reset();

        }


}
