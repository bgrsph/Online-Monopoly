package domain;

import java.io.Serializable;
import java.util.ArrayList;

import domain.squares.Square;

public class Board implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Square> squares;
	
	
	public Board() {
		squares = new ArrayList<Square>();
		initAllSquares();
	} 



		private void initAllSquares() {
			

			//orta ÅŸerit
			squares.add(SquareFactory.getInstance().createSquare("GoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MediterraneanAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BalticAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("IncomeTaxSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TransitStationSquare"));
			squares.add(SquareFactory.getInstance().createSquare("OrientalAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("VermontAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ConnecticutAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("InJailSquare"));
			squares.add(SquareFactory.getInstance().createSquare("StCharlesPlaceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ElectricCompanySquare"));
			squares.add(SquareFactory.getInstance().createSquare("StatesAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("VirginiaAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("PennysylvaniaRoadSquare"));
			squares.add(SquareFactory.getInstance().createSquare("StJamesPlaceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TenesseeAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("NewYorkAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("FreeParkingSquare"));
			squares.add(SquareFactory.getInstance().createSquare("KentuckyAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("IndianaAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("IllinoisAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TransitStationSquare"));
			squares.add(SquareFactory.getInstance().createSquare("AtlanticAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("VentnorAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("WaterWorksSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MarvinGardensSquare"));
			squares.add(SquareFactory.getInstance().createSquare("RollThreeSquare")); //Roll 3 olcak
			squares.add(SquareFactory.getInstance().createSquare("PacificAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("NorthCarolinaAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("PennsylvaniaAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ShortLineSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ParkPlaceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("LuxuryTaxSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BoardwalkSquare"));
			//iç şerit başlangıç
			squares.add(SquareFactory.getInstance().createSquare("SqueezePlaySquare"));
			squares.add(SquareFactory.getInstance().createSquare("TheEmbarcaderoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("FishermansWharfSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TelephoneCompanySquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BeaconStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BonusSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BoylstonStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("NewburryStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TransitStationSquare"));
			squares.add(SquareFactory.getInstance().createSquare("FifthAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MadisonAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("StockExchangeSquare")); // stock exchange olcak
			squares.add(SquareFactory.getInstance().createSquare("WallStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TaxRefundSquare"));
			squares.add(SquareFactory.getInstance().createSquare("GasCompanySquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("FloridaAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("HollandTunnelSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MiamiAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BiscayneAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TransitStationSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ReverseDirectionSquare"));
			squares.add(SquareFactory.getInstance().createSquare("LombardStreetSquare"));
			//dış şerit 56 adet
			
			squares.add(SquareFactory.getInstance().createSquare("SubwaySquare")); //Subway olcak
			
			
			
			
			squares.add(SquareFactory.getInstance().createSquare("LakeStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("NicolletAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("HennepinAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BusTicketSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CheckerCabCoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ReadingRailroadSquare"));
			squares.add(SquareFactory.getInstance().createSquare("EsplanadeAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CanalStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CableCompanySquare"));
			squares.add(SquareFactory.getInstance().createSquare("MagazineStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BourbonStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("HollandTunnelSquare"));
			squares.add(SquareFactory.getInstance().createSquare("AuctionSquare"));
			squares.add(SquareFactory.getInstance().createSquare("KatyFreewaySquare"));
			squares.add(SquareFactory.getInstance().createSquare("WestheimerRoadSquare"));
			squares.add(SquareFactory.getInstance().createSquare("InternetServiceProviderSquare"));
			squares.add(SquareFactory.getInstance().createSquare("KirbyDriveSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CullenBoulevardSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BlackandWhiteCabCoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("DekalbAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("AndrewYoungIntlBoulevardSquare"));
			squares.add(SquareFactory.getInstance().createSquare("DecaturStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("PeachtreeStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("PayDaySquare"));
			squares.add(SquareFactory.getInstance().createSquare("RandolphStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("LakeShoreDriveSquare"));
			squares.add(SquareFactory.getInstance().createSquare("WackerDriveSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MichiganAvenueSquare"));
			squares.add(SquareFactory.getInstance().createSquare("YellowCabCoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BORailroadSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("SouthTempleSquare"));
			squares.add(SquareFactory.getInstance().createSquare("WestTempleSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TrashCollectorSquare"));
			squares.add(SquareFactory.getInstance().createSquare("NorthTempleSquare"));
			squares.add(SquareFactory.getInstance().createSquare("TempleSquare"));
			//
			squares.add(SquareFactory.getInstance().createSquare("GoToJailSquare"));	//go to jail olcak
			//
			squares.add(SquareFactory.getInstance().createSquare("SouthStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BroadStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("WalnutStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("CommunityChestSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MarketStreetSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BusTicketSquare"));
			squares.add(SquareFactory.getInstance().createSquare("SewageSystemSquare"));
			squares.add(SquareFactory.getInstance().createSquare("UteCabCoSquare"));
			squares.add(SquareFactory.getInstance().createSquare("BirthdayGiftSquare"));
			squares.add(SquareFactory.getInstance().createSquare("MullhollandDriveSquare"));
			squares.add(SquareFactory.getInstance().createSquare("VenturaBoulevardSquare"));
			squares.add(SquareFactory.getInstance().createSquare("ChanceSquare"));
			squares.add(SquareFactory.getInstance().createSquare("RodeoDriveSquare"));
		}
		
	
	
	public Square getSquare(String squareName) {
		
		for(Square sq: squares) {
			if(sq.getName().equals(squareName)) {
				
				return sq;
			}
		}
		
		System.out.println("getSquare in Board class returns null because there is no such square in squares list");
		return null;
	}


	public ArrayList<Square> getSquareList() {
			
		return this.squares;
	}
	
	
	
	

	
	

}
