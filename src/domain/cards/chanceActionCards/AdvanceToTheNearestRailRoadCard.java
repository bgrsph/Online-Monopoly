package domain.cards.chanceActionCards;

import domain.MonopolyGameController;
import domain.Player;
import domain.cards.Card;
import domain.squares.Square;

public class AdvanceToTheNearestRailRoadCard extends Card {

	public AdvanceToTheNearestRailRoadCard() {
		super("chanceAction", true);
	}

	@Override
	public void useCard() {

		MonopolyGameController.getInstance();
		Player currentPlayer = MonopolyGameController.getCurrentPlayer();
		int currentSquareIndex = currentPlayer.getCurrentSquareIndex();
		Square currentSquare = MonopolyGameController.getBoard().getSquareList().get(currentSquareIndex);
		Square targetSquare;

		if (currentPlayer.isInCenterTrack()) {

			Square railRoad1 = MonopolyGameController.getBoard().getSquareList().get(71);
			int indexTBCompared1 = 5;
			Square railRoad2 = MonopolyGameController.getBoard().getSquareList().get(15);
			int indexTBCompared2 = 15;
			Square railRoad3 = MonopolyGameController.getBoard().getSquareList().get(99);
			int indexTBCompared3 = 25;
			Square railRoad4 = MonopolyGameController.getBoard().getSquareList().get(35);
			int indexTBCompared4 = 61;

			int distance1 = Math.abs(currentSquareIndex - indexTBCompared1);
			int distance2 = Math.abs(currentSquareIndex - indexTBCompared2);
			int distance3 = Math.abs(currentSquareIndex - indexTBCompared3);
			int distance4 = Math.abs(currentSquareIndex - indexTBCompared4);

			int minimumDistance = Math.min(Math.min(distance1, distance2), Math.min(distance3, distance4));

			if (minimumDistance == distance1) {

				targetSquare = railRoad1;

			} else if (minimumDistance == distance2) {
				targetSquare = railRoad2;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else if (minimumDistance == distance3) {

				targetSquare = railRoad3;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else if (minimumDistance == distance4) {
				targetSquare = railRoad4;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else {
				System.out.println("Something is wrong in " + this.getClass().getSimpleName());
			}

		} else if (currentPlayer.isInOuterTrack()) {
			Square railRoad1 = MonopolyGameController.getBoard().getSquareList().get(71);
			int indexTBCompared1 = 71;
			Square railRoad2 = MonopolyGameController.getBoard().getSquareList().get(99);
			int indexTBCompared2 = 99;
			int distance1 = Math.abs(currentSquareIndex - indexTBCompared1);
			int distance2 = Math.abs(currentSquareIndex - indexTBCompared2);
			int minimumDistance = Math.min(distance1, distance2);

			if (minimumDistance == distance1) {

				targetSquare = railRoad1;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else if (minimumDistance == distance2) {

				targetSquare = railRoad2;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else {
				System.out.println("Something is wrong in " + this.getClass().getSimpleName());
			}

		} else { // Player is in innerTrack

			Square railRoad1 = MonopolyGameController.getBoard().getSquareList().get(15);
			int indexTBCompared1 = 49;
			Square railRoad2 = MonopolyGameController.getBoard().getSquareList().get(35);
			int indexTBCompared2 = 61;
			int distance1 = Math.abs(currentSquareIndex - indexTBCompared1);
			int distance2 = Math.abs(currentSquareIndex - indexTBCompared2);
			int minimumDistance = Math.min(distance1, distance2);

			if (minimumDistance == distance1) {

				targetSquare = railRoad1;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else if (minimumDistance == distance2) {

				targetSquare = railRoad2;
				int targetSqIndex = MonopolyGameController.getBoard().getSquareList().indexOf(targetSquare);
				MonopolyGameController.getInstance();
				try {
					MonopolyGameController.teleportPlayer(currentPlayer, currentSquare, targetSquare, targetSqIndex);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				currentPlayer.setCurrentSquareIndex(targetSqIndex);
				targetSquare.landedOn();
				return;

			} else {
				System.out.println("Something is wrong in " + this.getClass().getSimpleName());
			}

		}

	}

}
