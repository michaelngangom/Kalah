package com.kalaha.prod;

/**
 * This class represents a move in a Kalaha game.
 *
 * @author michaelngangom
 */
public class GameMove extends Move {
	int fromHoleNumber;

	public GameMove(int fromHoleNumber) {
		this.fromHoleNumber = fromHoleNumber;
	}

	public String toString() {
		return "" + fromHoleNumber;
	}
}
