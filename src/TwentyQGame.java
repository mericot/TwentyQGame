/*
Student Name: Samuel Pimentel 
Student ID:00334334
Course: CIS 252
NOTES: This is Game Structure
 */

import datastructure.LBList;

import java.io.*;
import java.util.Scanner;

public class TwentyQGame implements Serializable {

    public CategoryTopicMap categoryTopicMap;
    private Scanner scanner;

    public TwentyQGame() {

        scanner = new Scanner(System.in);

        categoryTopicMap = new CategoryTopicMap();
        try{
            System.out.println("Loading saved game...");
            this.categoryTopicMap = Load_Game();
            System.out.println("Game loaded successfully");
        }catch (FileNotFoundException e){
            System.out.println("No saved game found. Starting new game");
        }catch (IOException | ClassNotFoundException e)
        {
            throw new RuntimeException("Error Cannot load game" + e.getMessage());
        }
    }

    public void showCategories() {
        for (CategoryTopics category : CategoryTopics.values()) {
            System.out.print(category.name() + ":: ");
            categoryTopicMap.getTopics(category);
            System.out.print(" \n");
        }
    }

    public void startGame() {

        LBList<CategoryTopics> categoryTopics = new LBList<>();
        int countTopics = 0;


        for(CategoryTopics topics : CategoryTopics.values())
        {
            categoryTopics.add(topics);
            System.out.println( "["+ countTopics + "]"+ topics.name());
            countTopics++;
        }
        System.out.println("Select a Category to play");
        int userInput = scanner.nextInt();

        CategoryTopics user_Selected = categoryTopics.get(userInput);
        playCategory(user_Selected);


    }

    public void playCategory(CategoryTopics category) {

        QuestionTree tree = categoryTopicMap.Category_Map.get(category);
        System.out.println(tree);
        System.out.println("Category selected " + category.name());
        boolean running = true;

        while(running){

            if (tree.currNode.isEnd()) {
                System.out.println(tree.currNode.getQuestion().getText());
                tree.enrichTree(tree.currNode, scanner);


                    System.out.println("Would you like to continue?");
                String restart = scanner.next();
                scanner.nextLine();
                running = !restart.equalsIgnoreCase("no");
                if (running) {
                    tree.resetCurrentPosition();


                }
            } else {
                System.out.println(tree.currNode.getQuestion().getText());
                String userInput = scanner.next();
                scanner.nextLine();
                tree.processQuestion(userInput);
            }
            scanner.reset();

        }
    }

    private CategoryTopicMap Load_Game() throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("20QGame.ser"))) {
            return (CategoryTopicMap) in.readObject();
        }
    }

    public void Save_Game() {

        try {
            FileOutputStream saveFile = new FileOutputStream("20QGame.ser");
            ObjectOutputStream out = new ObjectOutputStream(saveFile);
            out.writeObject(this.categoryTopicMap);
            System.out.println("Game Saved successfully");

        }catch (IOException i){
            i.printStackTrace();
        }


    }

    public void Menu() {

        boolean running = true;

        while(running)
        {
            System.out.println("1. Play" +
                    "\n2. See Existing Topics by Category" +
                    "\n3. Quit & Save Game");
            int userInput = scanner.nextInt();
            scanner.nextLine();


            switch (userInput){

                case 1:
                    startGame();
                    break;

                case 2:
                    showCategories();
                    break;

                case 3:
                    Save_Game();
                    System.out.println("goodbye");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}
