package com.kalaha.prod;

import java.util.ArrayList;
import java.util.List;

/**
 * GamePosition defines a GamePositionAbs. This class extends the
 * GamePositionAbs abstract class. A GamePosition consists of a game-board and
 * methods to play the game
 *
 * @author michaelngangom
 */
public class GamePosition extends GamePositionAbs {
	/**
	 * The board represents the game-board. Elements 0-5 in the array are the
	 * upper holes of the board. Elements 7-12 in the array are the lower holes
	 * of the board. Elements 6 and 13 in the array are the kalaha-stores of the
	 * upper and lower player, respectively.
	 */
	protected int gameBoard[] = new int[14];

	/**
	 * Initial stones to be put in each hole at the beginning of the game.
	 */
	protected static int STARTSTONES;

	/**
	 * Constructs a GamePosition object with given initial stones in each hole
	 * (apart from the stores). The initial stones can be changed depending on
	 * the requirement
	 *
	 *
	 */
	public GamePosition(int initialStones) {
		STARTSTONES = initialStones;
		for (int i = 0; i < 6; i++) {
			gameBoard[i] = STARTSTONES;
		}
		for (int i = 7; i < 13; i++) {
			gameBoard[i] = STARTSTONES;
		}
	}

	// static int count; //For counting the nodes.
	/**
	 * Constructs a KalahaPositon object.
	 */
	public GamePosition() {
		// count++;
		// System.out.println(count);
	}

	@Override
	protected int value() {
		int currentValue = 0;
		currentValue += 10 * (gameBoard[6] - gameBoard[13]);
		return currentValue;
	}

	/**
	 * Makes a move from the given hole number.
	 */
	protected void makeMove(int holeNumber) {
		makeMove(new GameMove(holeNumber));
	}

	@Override
	protected void makeMove(Move m) {
		GameMove km = (GameMove) m;
		int fromHole = km.fromHoleNumber;
		int stones = gameBoard[fromHole];
		gameBoard[fromHole] = 0;
		int endHole = 0;
		for (int i = stones; i > 0; i--) {
			fromHole++;
			if (fromHole > 13)
				fromHole = 0;
			if (maxTurn && fromHole == 13)
				fromHole = 0;
			if (!maxTurn && fromHole == 6)
				fromHole = 7;
			endHole = fromHole;
			this.gameBoard[fromHole] += 1;
		}
		// This one checks whether the last stone lands in an empty hole owned
		// by the player, and the opposite hole contains seeds.
		// If so, both the last stone and the stones in the opposite hole are
		// captured and placed into the player's store.
		if (this.gameBoard[endHole] == 1 && endHole != 6 && endHole != 13
				&& this.gameBoard[-1 * (endHole - 6) + 6] != 0) {
			int oppositePool = -1 * (endHole - 6) + 6;
			if (maxTurn && endHole < 6) {
				this.gameBoard[6] += this.gameBoard[oppositePool] + this.gameBoard[endHole];
				this.gameBoard[oppositePool] = 0;
				this.gameBoard[endHole] = 0;
			}
			if (!maxTurn && endHole > 6 && endHole < 13) {
				this.gameBoard[13] += this.gameBoard[oppositePool] + this.gameBoard[endHole];
				this.gameBoard[oppositePool] = 0;
				this.gameBoard[endHole] = 0;
			}
		}
		// When one player no longer has stone in any of his holes, the game
		// ends.
		// The other player moves all remaining stones to his store, and the
		// player with the most stones in his store wins.
		if (gameBoard[0] + gameBoard[1] + gameBoard[2] + gameBoard[3] + gameBoard[4] + gameBoard[5] == 0) {
			for (int i = 7; i < 13; i++) {
				int addStones = gameBoard[i];
				gameBoard[i] = 0;
				if (maxTurn)
					gameBoard[13] += addStones;
				else
					gameBoard[6] += addStones;
			}
		}
		if (gameBoard[7] + gameBoard[8] + gameBoard[9] + gameBoard[10] + gameBoard[11] + gameBoard[12] == 0) {
			for (int i = 0; i < 6; i++) {
				int addStones = gameBoard[i];
				gameBoard[i] = 0;
				if (!maxTurn)
					gameBoard[6] += addStones;
				else
					gameBoard[13] += addStones;
			}
		}
		// If the last stone lands in the player's hole, the player gets an
		// additional move.
		if (endHole == 6 && maxTurn)
			this.maxTurn = !this.maxTurn;
		if (endHole == 13 && !maxTurn)
			this.maxTurn = !this.maxTurn;
		this.maxTurn = !this.maxTurn;
	}

	@Override
	protected GamePositionAbs copy() {
		GamePosition kp = new GamePosition();
		kp.maxTurn = maxTurn;
		kp.gameBoard = gameBoard.clone();
		return kp;
	}

	/**
	 * Use it for optimizing the horizon of maxTurn: if it is maxTurn, the
	 * alpha-beta search further, otherwise not.
	 *
	 * @return Returns true if it is maxTurn.
	 */
	@Override
	public boolean unclear() {
		return maxTurn;
	}

	@Override
	protected List<Move> nextPossibleMoves() {
		List<Move> nextPossibleMovesList = new ArrayList<Move>();
		if (!gameOver()) {
			if (maxTurn) {
				for (int holeNumber = 0; holeNumber <= 5; holeNumber++)
					if (gameBoard[holeNumber] != 0)
						nextPossibleMovesList.add(new GameMove(holeNumber));
			} else {
				for (int holeNumber = 7; holeNumber <= 12; holeNumber++)
					if (gameBoard[holeNumber] != 0)
						nextPossibleMovesList.add(new GameMove(holeNumber));
			}
		}
		return nextPossibleMovesList;
	}

	@Override
	/**
	 * Checks either one player's Kalaha store is more than 6 times of the
	 * initial stones OR both players have equal number of stone in each
	 * player's Kalaha, then the game is over.
	 */
	protected boolean gameOver() {
		return (gameBoard[6] > 6 * STARTSTONES || gameBoard[13] > 6 * STARTSTONES)
				|| (gameBoard[6] == 6 * STARTSTONES && gameBoard[13] == 6 * STARTSTONES);
	}

}
