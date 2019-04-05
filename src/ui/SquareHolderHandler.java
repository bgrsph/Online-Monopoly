package ui;

import java.util.ArrayList;

import domain.Board;
import domain.MonopolyGameController;
import domain.squares.Square;

public class SquareHolderHandler {

	private ArrayList<SquareHolder> squareHolderList;
	private ArrayList<SquareHolder> dummySquaresWithActualCoordinates;

	public SquareHolderHandler() {
		this.squareHolderList = new ArrayList<SquareHolder>();
		dummySquaresWithActualCoordinates = new ArrayList<SquareHolder>();
	}

	public void initSquareHolderList() {

		MonopolyGameController.getInstance();
		Board board = MonopolyGameController.getBoard();

		int i = 0;
		for (Square square : board.getSquareList()) {
			
			//System.out.println("Adding square: (" + square.getX() + "," + square.getY() + ") " + square.getName() + "---> " + i++);
			
			
			
			
			
			squareHolderList.add(new SquareHolder(square.getName(), square.getX(), square.getY()));

		}
	}

	public SquareHolder getSquareHolderByName(String name) {
		for(SquareHolder squareHolder: this.squareHolderList) {
			if(squareHolder.getSquareName().equals(name)) {
				
				return squareHolder;
			}
		}
		
		return null;
		 
	}
	public ArrayList<SquareHolder> getSquareHolderList() {

		return this.squareHolderList;

	}

	public void boardDivider(BoardPanel bp) {

		// bp.setSize(680, 680);

		int counter = 0;
		int counter2 = 0;
		int counter3 = 0;
		int counter4 = 0;

		// 1.Panel
		for (double j = (bp.getWidth() - 7 * (bp.getWidth() / 34)); j >= (7
				* (bp.getWidth() / 34)); j -= (bp.getHeight() / 17)) {
			SquareHolder ortaAlt = new SquareHolder("ortaAlt", 0, 0);
			ortaAlt.setX(j);
			ortaAlt.setY(bp.getHeight() - (7 * (bp.getHeight() / 34)));
			dummySquaresWithActualCoordinates.add(ortaAlt);

			if (j == (7 * (bp.getWidth() / 34))) {
//2.Panel
				for (double z = (bp.getHeight() - (9 * (bp.getHeight() / 34))); z > (6
						* (bp.getWidth() / 34)); z -= (bp.getHeight() / 17)) {
					SquareHolder ortaSol = new SquareHolder("ortaSol", 0, 0);
					ortaSol.setX(7 * (bp.getWidth() / 34));
					ortaSol.setY(z);
					dummySquaresWithActualCoordinates.add(ortaSol);

					if (z == (7 * (bp.getHeight() / 34))) {
//3. Panel
						for (double a = (9 * (bp.getWidth() / 34)); a <= (bp.getWidth()
								- 7 * (bp.getWidth() / 34)); a += (bp.getWidth() / 17)) {
							SquareHolder ortaUst = new SquareHolder("ortaUst", 0, 0);
							ortaUst.setX(a);
							ortaUst.setY(7 * (bp.getWidth() / 34));
							dummySquaresWithActualCoordinates.add(ortaUst);

							if (a == (bp.getWidth() - (7 * (bp.getWidth() / 34)))) {
//4. Panel
								for (double i = (9 * (bp.getHeight() / 34)); i <= (bp.getHeight()
										- 9 * (bp.getHeight() / 34)); i += (bp.getHeight() / 17)) {
									SquareHolder ortaSag = new SquareHolder("ortaSag", 0, 0);
									ortaSag.setX(bp.getWidth() - (7 * (bp.getWidth() / 34)));
									ortaSag.setY(i);
									dummySquaresWithActualCoordinates.add(ortaSag);

								}
							}
						}
					}
				}
			}
		}

		// 5.Panel
		for (double j = (bp.getWidth() - (11 * (bp.getWidth() / 34))); j >= (11
				* (bp.getWidth() / 34)); j -= (bp.getHeight() / 17)) {
			SquareHolder icAlt = new SquareHolder("icAlt", 0, 0);
			icAlt.setX(j);
			icAlt.setY(bp.getHeight() - (11 * (bp.getHeight() / 34)));
			dummySquaresWithActualCoordinates.add(icAlt);

			if (j == (11 * (bp.getWidth() / 34))) {
				// 6.Panel
				for (double z = (bp.getWidth() - (13 * (bp.getHeight() / 34))); z >= (11
						* (bp.getWidth() / 34)); z -= (bp.getHeight() / 17)) {
					SquareHolder icSol = new SquareHolder("icSol", 0, 0);
					icSol.setX(11 * (bp.getWidth() / 34));
					icSol.setY(z);
					dummySquaresWithActualCoordinates.add(icSol);

					if (z == (11 * (bp.getHeight() / 34))) {
						// 7. Panel
						for (double a = (13 * (bp.getWidth() / 34)); a <= (bp.getWidth()
								- (11 * (bp.getWidth() / 34))); a += (bp.getWidth() / 17)) {
							SquareHolder icUst = new SquareHolder("icUst", 0, 0);
							icUst.setX(a);
							icUst.setY(11 * (bp.getHeight() / 34));
							dummySquaresWithActualCoordinates.add(icUst);

							if (a == (bp.getWidth() - (11 * (bp.getWidth() / 34)))) {
								// 8. Panel
								for (double i = (13 * (bp.getHeight() / 34)); i <= (bp.getHeight()
										- (13 * (bp.getHeight() / 34))); i += (bp.getHeight() / 17)) {
									SquareHolder icSag = new SquareHolder("icSag", 0, 0);
									icSag.setX(bp.getWidth() - (11 * (bp.getWidth() / 34)));
									icSag.setY(i);
									dummySquaresWithActualCoordinates.add(icSag);

								}
							}
						}
					}
				}
			}
		}

		// 9.Panel
		for (double j = (bp.getWidth() - 3 * (bp.getWidth() / 34)); j >= 3
				* (bp.getWidth() / 34); j -= (bp.getHeight() / 17)) {
			SquareHolder enDisAlt = new SquareHolder("EnDisAlt", 0, 0);
			enDisAlt.setX(j);
			enDisAlt.setY(bp.getHeight() - (3 * (bp.getHeight() / 34)));
			dummySquaresWithActualCoordinates.add(enDisAlt);
			counter2++;

			if (j == (3 * (bp.getWidth() / 34))) {
				// 10.Panel
				for (double z = (bp.getHeight() - (5 * (bp.getHeight() / 34))); z >= 3
						* (bp.getHeight() / 34); z -= (bp.getHeight() / 17)) {
					SquareHolder enDisSol = new SquareHolder("EnDisSol", 0, 0);
					enDisSol.setX((3 * (bp.getWidth() / 34)));
					enDisSol.setY(z);
					dummySquaresWithActualCoordinates.add(enDisSol);
					counter++;

					if (z == (3 * (bp.getHeight() / 34))) {
						// 11. Panel
						for (double a = (5 * (bp.getWidth() / 34.0)); a <= (bp.getWidth()
								- (3 * (bp.getWidth() / 34))); a += (bp.getWidth() / 17)) {
							SquareHolder enDisUst = new SquareHolder("EnDisUst", 0, 0);
							enDisUst.setX(a);
							enDisUst.setY(3 * (bp.getWidth() / 34));
							dummySquaresWithActualCoordinates.add(enDisUst);
							counter3++;
							if (a == (bp.getWidth() - (3 * (bp.getWidth() / 34)))) {
								// 12. Panel
								for (double i = (5 * (bp.getHeight() / 34)); i < (bp.getHeight()
										- (3 * (bp.getHeight() / 34))); i += (bp.getHeight() / 17)) {
									SquareHolder sq = new SquareHolder("EnDisSag", 0, 0);
									sq.setX(bp.getWidth() - (3 * (bp.getWidth() / 34)));
									sq.setY(i);
									dummySquaresWithActualCoordinates.add(sq);
									counter4++;
								}
							}
						}
					}
				}
			}
		}

		int counter1 = 0;
		for (int i = 0; i < dummySquaresWithActualCoordinates.size(); i++) {
			System.out.println(dummySquaresWithActualCoordinates.get(i).getX() + " , "
					+ dummySquaresWithActualCoordinates.get(i).getY() + " , "
					+ dummySquaresWithActualCoordinates.get(i).getSquareName());
			counter1++;
		}
		System.out.println(counter2 + "ortaAlt");
		System.out.println(counter + "ortaSol");
		System.out.println(counter3 + "ortaUst");
		System.out.println(counter4 + "ortaSag");

		System.out.println(counter1);

	}

	public void squareHolderListAndCoordinateListMatcher() {

		System.out
				.println("squareHolderListAndCoordinateListMatcher squareHoldersSize:" + getSquareHolderList().size());
		System.out.println(
				"squareHolderListAndCoordinateListMatcher liste size:" + dummySquaresWithActualCoordinates.size());

		for (int i = 0; i < squareHolderList.size(); i++) {

			getSquareHolderList().get(i).setX(dummySquaresWithActualCoordinates.get(i).getX());
			// SquareHolderList.setX(liste.get(i).getX());
			getSquareHolderList().get(i).setY(dummySquaresWithActualCoordinates.get(i).getY());
			// SquareHolderList.setY(liste.get(i).getY());
		}
	}

	public void printAllSquares() {
		System.out.println("PRINTING ALL SQUARES");

		int i = 0;
		for (SquareHolder square : this.squareHolderList) {
			
			System.out.println("Adding square: (" + square.getX() + "," + square.getY() + ") " + square.getSquareName() + "---> " + i++);
			


		}
	}

}
