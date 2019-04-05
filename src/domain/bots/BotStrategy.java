package domain.bots;

import domain.squares.Square;

public interface BotStrategy {

	void buy(Bot B);

	void buildBuilding(Bot B);
	
	void mortgage(Bot B);
	
	void useCard(Bot B);

}
