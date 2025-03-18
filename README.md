# TwentyQGame_Console
This project is a console-based Twenty Questions game, developed as a class assignment. The game utilizes a tree structure, a HashMap, and a list to store and retrieve questions and possible answers efficiently.

How It Works:
	1.	The game starts by asking the user to think of an object.
	2.	It navigates through a binary tree structure, asking yes/no questions to narrow down the possibilities.
	3.	If the program reaches a final guess and is wrong, the user can add a new object along with a distinguishing question, allowing the game to “learn” over time.
	4.	The HashMap is used to store previously guessed objects for quick retrieval.
	5.	A list helps manage dynamically growing questions and answers.
