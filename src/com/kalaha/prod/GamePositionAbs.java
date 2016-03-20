package com.kalaha.prod;

import java.util.List;

/**
 * A general class. An object of GamePositon type represents a game position in
 * any two-player game. Because this class includes min-max algorithm with
 * alpha beta pruning, it can be used to develop any two-player game where the
 * computer uses AI for finding the best move in the game.
 *
 */
public abstract class GamePositionAbs {

	protected abstract int value();

	protected abstract void makeMove(Move m);

	protected abstract GamePositionAbs copy();

	protected abstract List<Move> nextPossibleMoves();

	private Move bestMove;

	public Move getBestMove(int depth) {
		bestMove = null;
		searchAlphaBeta(Integer.MIN_VALUE, Integer.MAX_VALUE, depth);
		return bestMove;
	}

	public boolean maxTurn;

	public boolean unclear() {
		return false;
	}

	protected abstract boolean gameOver();

	public int searchAlphaBeta(int alpha, int beta, int depth) {
		List<Move> npmList = nextPossibleMoves();
		if ((depth <= 0 && !unclear()) || npmList == null || npmList.isEmpty()) {
			return value();
		}
		for (Move gm : npmList) {
			GamePositionAbs gp = (GamePositionAbs) copy();
			gp.makeMove(gm);
			int value = gp.searchAlphaBeta(alpha, beta, depth - 1); // Recursive
																	// calling.
			if (maxTurn && value > alpha) {
				alpha = value;
				if (alpha >= beta) {
					return alpha;
				}
				bestMove = gm;
			} else if (!maxTurn && value < beta) {
				beta = value;
				if (alpha >= beta) {
					return beta;
				}
				bestMove = gm;
			}
		}
		return maxTurn ? alpha : beta;
	}
}
