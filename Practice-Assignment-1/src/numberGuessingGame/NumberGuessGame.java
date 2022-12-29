package numberGuessingGame;

import java.util.Scanner;

public class NumberGuessGame {
	private int randoNum;
	//
	private int rangeNum;
	//
	private int numOfChance;
	//

	private Scanner lineBot = new Scanner(System.in);

	public void GuessPrompt() {
		//
		System.out.println("What is your range size?");
		System.out.println();

		//
		rangeNum = lineBot.nextInt();
		numOfChance = (int) Math.round((Math.log(rangeNum) / Math.log(2)));
		randoNum = (int) Math.round(Math.random() * rangeNum);

		//
		System.out.println("Range Selected: " + rangeNum);
		System.out.println("Number of Allowed Guesses: " + numOfChance);
		//System.out.println("Random Number Assigned: " + randoNum);

	}

	public String GuessProtocol() {
		//
		System.out.println();

		//
		int guessNum = 0;

		//
		while (numOfChance > 0) {
			//
			System.out.println("Please guess a number: ");
			guessNum = lineBot.nextInt();
			
			//
			if (guessNum == randoNum) {
				return "Congrats, you have won!";
			} 
			
			//
			else if (guessNum > randoNum) {
				System.out.println("This guess is greater than the mystery number");
			} 
			
			//
			else if (guessNum < randoNum) {
				System.out.println("This guess is less than the mystery number");
			}

			//
			numOfChance--;
			System.out.println();
		}

		// Worst case scenario plays out, number of attempts have been exhausted.
		return "Unfortunately, you're outta luck. Nothing personal kid...";
	}

	public static void main(String[] args) {
		NumberGuessGame properObjectName = new NumberGuessGame();
		properObjectName.GuessPrompt();
		String result = properObjectName.GuessProtocol();
		System.out.print(result);
	}
}