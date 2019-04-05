package domain.squares.actionSquares;

import domain.Logger;
import domain.MonopolyGameController;
import domain.Player;
import domain.squares.Square;
import ui.Facade;

public class HollandTunnelSquare extends Square{

	public HollandTunnelSquare() {
		super("HollandTunnelSquare", 0, 0);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void landedOn() {
		// TODO Auto-generated method stub
		Player p = MonopolyGameController.getCurrentPlayer();
	if(p.getCurrentSquareIndex() == 56) {
		p.setCurrentSquareIndex(76);
		try {
			Facade.getInstance().teleport(p, "HollandTunnelSquare", "HollandTunnelSquare", 76);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(p.getCurrentSquareIndex() == 76) {
		p.setCurrentSquareIndex(56);
		try {
			Facade.getInstance().teleport(p, "HollandTunnelSquare", "HollandTunnelSquare", 56);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Logger.getInstance().notifyAll(p.getName()+" used Holland Tunnel and teleported");
	MonopolyGameController.allowCurrentPlayerToEndTurn();
}

}
