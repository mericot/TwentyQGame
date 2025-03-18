/*
Student Name: Samuel Pimentel 
Student ID:00334334
Course: CIS 252
NOTES:Category Topics maps
 */

import datastructure.HMap;
import datastructure.LBList;

import java.io.Serializable;



public class CategoryTopicMap implements Serializable  {

    HMap<CategoryTopics, QuestionTree> Category_Map ;


    public CategoryTopicMap()
    {
        Category_Map = new HMap<>();
        for(CategoryTopics categoryTopics : CategoryTopics.values())
        {
            Category_Map.put(categoryTopics,new QuestionTree(categoryTopics.question()));
        }
    }


    public void getTopics(CategoryTopics topics)
    {
        if(!Category_Map.contains(topics)) {
            throw new IllegalArgumentException("Category is not found");
        }

        QuestionTree tree = Category_Map.get(topics);
        LBList<String> stringLBList = new LBList<>();

        tree.CollectLeafTopics();

        for (String word : tree.listOfTopics)
        {
            System.out.print( word + ", ");
        }
    }

}
