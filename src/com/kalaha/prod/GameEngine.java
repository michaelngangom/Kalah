package com.kalaha.prod;

import java.io.PrintWriter;

/**
 * The class which starts game.
 *
 * @author michaelngangom
 */
public class GameEngine {

	private static int SEARCH_DEPTH;

	private static final int INITIALSTONES = 6;

	public String input, level, choice;
	GamePosition currentPosition;
	PrintWriter writer;

	public static boolean isLegalMove(int[] board, int hole) {
		return hole >= 7 && hole <= 12 && board[hole] != 0;
	}

	/**
	 * The Constructor
	 */
	public GameEngine() {
		this.gamePlay();
	}

	/**
	 * Method for playing the game.
	 */
	private void gamePlay() {
		currentPosition = new GamePosition(INITIALSTONES);
		GameGUI gui = new GameGUI(this);
		gui.addTextToButtons();

		int inputLevel;
		gui.openLevelDialog();
		level = null;
		gui.jTextArea1.append("Choose the level you want to play from the buttons above !\n");
		while (level == null) { // Thread for waiting until the user press the
								// button.
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		switch ((inputLevel = Integer.parseInt(level.trim()))) {
		case 1:
			SEARCH_DEPTH = 1;
			gui.closeChoiceDialog();
			break;
		case 2:
			SEARCH_DEPTH = 3;
			gui.closeChoiceDialog();
			break;
		case 3:
			SEARCH_DEPTH = 12;
			gui.closeChoiceDialog();
			break;
		}

		gui.jTextArea1.append("Choose if you want to start: YES or NO?\n");
		gui.openChoiceDialog();
		choice = null;
		while (choice == null) { // Thread for waiting until the user press the
									// button.
			try {
				Thread.sleep(100);
			} catch (final InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		currentPosition.maxTurn = !"y".equalsIgnoreCase(choice.trim());
		gui.closeChoiceDialog();
		gui.jTextArea1.append("\n  THE GAME HAS STARTED \n");
		while (!currentPosition.gameOver()) {
			// Human Turn
			if (!currentPosition.maxTurn)

			{
				int hole = 0;
				do {
					gui.jTextArea1.append("YOUR TURN\n");
					input = null;
					while (input == null) { // Thread for waiting until the user
											// press the button.
						try {
							Thread.sleep(100);
						} catch (final InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
					hole = Integer.parseInt(input);
					if (!isLegalMove(currentPosition.gameBoard, hole))
						gui.jTextArea1.append("Illegal move:It was not your hole OR the hole is empty. Try again!\n");
				} while (!isLegalMove(currentPosition.gameBoard, hole));

				gui.jTextArea1.append("YOUR TURN!! \n");
				currentPosition.makeMove(new GameMove(hole));
			}
			// ComputerTurn
			else {
				gui.jTextArea1.append("My Turn !!! Thinking...\n");
				final double time1 = System.currentTimeMillis();
				currentPosition.makeMove(currentPosition.getBestMove(GameEngine.SEARCH_DEPTH));
				final double time2 = System.currentTimeMillis();
				System.out.println("SEARCHING TIME: " + (time2 - time1) / 1000 + " seconds");
			}
			gui.refresh();
		}
		gui.jTextArea1.append("!!!GAME OVER!!!\n");
		if (currentPosition.gameBoard[6] < currentPosition.gameBoard[13])
			gui.jTextArea1.append("You are a genius! You won! Congratulations! \n ");
		else if (currentPosition.gameBoard[6] > currentPosition.gameBoard[13])
			gui.jTextArea1.append("You lose, I thought you were a genius :P\n");
		else
			gui.jTextArea1.append("DRAW. A rematch?\n");
	}

	public void inputHoleChoice(String choice) {
		this.input = choice;
	}

	public void inputLevel(String choice) {
		this.level = choice;
	}

	public void inputStartFirstChoice(String choice) {
		this.choice = choice;
	}

	/**
	 * Main method which starts the program.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		GameEngine game = new GameEngine();
	}
}
