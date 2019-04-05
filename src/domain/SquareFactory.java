package domain;


import domain.squares.Square;
import domain.squares.actionSquares.AuctionSquare;
import domain.squares.actionSquares.BirthdayGiftSquare;
import domain.squares.actionSquares.BonusSquare;
import domain.squares.actionSquares.BusTicketSquare;
import domain.squares.actionSquares.ChanceSquare;
import domain.squares.actionSquares.CommunityChestSquare;
import domain.squares.actionSquares.FreeParkingSquare;
import domain.squares.actionSquares.GoSquare;
import domain.squares.actionSquares.GoToJailSquare;
import domain.squares.actionSquares.HollandTunnelSquare;
import domain.squares.actionSquares.InJailSquare;
import domain.squares.actionSquares.IncomeTaxSquare;
import domain.squares.actionSquares.LuxuryTaxSquare;
import domain.squares.actionSquares.PayDaySquare;
import domain.squares.actionSquares.ReverseDirectionSquare;
import domain.squares.actionSquares.RollThreeSquare;
import domain.squares.actionSquares.SqueezePlaySquare;
import domain.squares.actionSquares.StockExchangeSquare;
import domain.squares.actionSquares.SubwaySquare;
import domain.squares.actionSquares.TaxRefundSquare;
import domain.squares.propertySquares.AndrewYoungIntlBoulevardSquare;
import domain.squares.propertySquares.AtlanticAvenueSquare;
import domain.squares.propertySquares.BalticAvenueSquare;
import domain.squares.propertySquares.BeaconStreetSquare;
import domain.squares.propertySquares.BiscayneAvenueSquare;
import domain.squares.propertySquares.BoardwalkSquare;
import domain.squares.propertySquares.BourbonStreetSquare;
import domain.squares.propertySquares.BoylstonStreetSquare;
import domain.squares.propertySquares.BroadStreetSquare;
import domain.squares.propertySquares.CanalStreetSquare;
import domain.squares.propertySquares.ConnecticutAvenue;
import domain.squares.propertySquares.CullenBoulevardSquare;
import domain.squares.propertySquares.DecaturStreetSquare;
import domain.squares.propertySquares.DekalbAvenueSquare;
import domain.squares.propertySquares.EsplanadeAvenueSquare;
import domain.squares.propertySquares.FifthAvenueSquare;
import domain.squares.propertySquares.FishermansWharfSquare;
import domain.squares.propertySquares.FloridaAveneuSquare;
import domain.squares.propertySquares.FloridaAvenueSquare;
import domain.squares.propertySquares.HennepinAvenueSquare;
import domain.squares.propertySquares.IllinoisAvenueSquare;
import domain.squares.propertySquares.IndianaAvenueSquare;
import domain.squares.propertySquares.KatyFreewaySquare;
import domain.squares.propertySquares.KentuckyAvenueSquare;
import domain.squares.propertySquares.KirbyDriveSquare;
import domain.squares.propertySquares.LakeShoreDriveSquare;
import domain.squares.propertySquares.LakeStreetSquare;
import domain.squares.propertySquares.LombardStreetSquare;
import domain.squares.propertySquares.MadisonAvenueSquare;
import domain.squares.propertySquares.MagazineStreetSquare;
import domain.squares.propertySquares.MarketStreetSquare;
import domain.squares.propertySquares.MarvinGardensSquare;
import domain.squares.propertySquares.MediterraneanAvenueSquare;
import domain.squares.propertySquares.MiamiAvenueSquare;
import domain.squares.propertySquares.MichiganAvenueSquare;
import domain.squares.propertySquares.MullhollandDriveSquare;
import domain.squares.propertySquares.NewYorkAvenueSquare;
import domain.squares.propertySquares.NewburryStreetSquare;
import domain.squares.propertySquares.NicolletAvenueSquare;
import domain.squares.propertySquares.NorthCarolinaAvenueSquare;
import domain.squares.propertySquares.NorthTempleSquare;
import domain.squares.propertySquares.OrientalAvenueSquare;
import domain.squares.propertySquares.PacificAvenueSquare;
import domain.squares.propertySquares.ParkPlaceSquare;
import domain.squares.propertySquares.PeachtreeStreetSquare;
import domain.squares.propertySquares.PennsylvaniaAvenueSquare;
import domain.squares.propertySquares.RandolphStreetSquare;
import domain.squares.propertySquares.RodeoDriveSquare;
import domain.squares.propertySquares.SouthStreetSquare;
import domain.squares.propertySquares.SouthTempleSquare;
import domain.squares.propertySquares.StCharlesPlaceSquare;
import domain.squares.propertySquares.StJamesPlaceSquare;
import domain.squares.propertySquares.StatesAvenueSquare;
import domain.squares.propertySquares.TempleSquare;
import domain.squares.propertySquares.TenesseeAvenueSquare;
import domain.squares.propertySquares.TheEmbarcaderoSquare;
import domain.squares.propertySquares.VentnorAvenueSquare;
import domain.squares.propertySquares.VenturaBoulevardSquare;
import domain.squares.propertySquares.VermontAvenueSquare;
import domain.squares.propertySquares.VirginiaAvenueSquare;
import domain.squares.propertySquares.WackerDriveSquare;
import domain.squares.propertySquares.WallStreetSquare;
import domain.squares.propertySquares.WalnutStreetSquare;
import domain.squares.propertySquares.WestTempleSquare;
import domain.squares.propertySquares.WestheimerRoadSquare;
import domain.squares.railroadSquares.BORailroadSquare;
import domain.squares.railroadSquares.PennsylvaniaRailroadSquare;
import domain.squares.railroadSquares.ReadingRailroadSquare;
import domain.squares.railroadSquares.ShortLineSquare;
import domain.squares.railroadSquares.TransitStationSquare;
import domain.squares.utilitySquares.BlackandWhiteCabCoSquare;
import domain.squares.utilitySquares.CableCompanySquare;
import domain.squares.utilitySquares.CheckerCabCoSquare;
import domain.squares.utilitySquares.ElectricCompanySquare;
import domain.squares.utilitySquares.GasCompanySquare;
import domain.squares.utilitySquares.InternetServiceProviderSquare;
import domain.squares.utilitySquares.SewageSystemSquare;
import domain.squares.utilitySquares.TelephoneCompanySquare;
import domain.squares.utilitySquares.TrashCollectorSquare;
import domain.squares.utilitySquares.UteCabCoSquare;
import domain.squares.utilitySquares.WaterWorksSquare;
import domain.squares.utilitySquares.YellowCabCoSquare;


public class SquareFactory {

	private static SquareFactory squareFactoryInstance;

	public static SquareFactory getInstance() {

		if (squareFactoryInstance == null) {
			squareFactoryInstance = new SquareFactory();
		}

		return squareFactoryInstance; 
	}
 
	public Square createSquare(String squareName) {

		if (squareName.equals("BonusSquare")) {
			return new BonusSquare();
		} 
		
		else if (squareName.equals("SubwaySquare")) {
			return new SubwaySquare();
		}
		
		else if (squareName.equals("FloridaAvenueSquare")) {
			return new FloridaAvenueSquare();
		}
		
		else if (squareName.equals("BiscayneAvenueSquare")) {
			return new BiscayneAvenueSquare();
		}
		
		else if (squareName.equals("BusTicketSquare")) {
			return new BusTicketSquare();
		}
		
		else if (squareName.equals("NewburryStreetSquare")) {
			return new NewburryStreetSquare();
		}
		
		

		
		else if (squareName.equals("ChanceSquare")) {
			return new ChanceSquare();
		}

		else if (squareName.equals("CommunityChestSquare")) {
			return new CommunityChestSquare();

		} else if (squareName.equals("HollandTunnelSquare")) {
			return new HollandTunnelSquare();

		} else if (squareName.equals("ReverseDirectionSquare")) {
			return new ReverseDirectionSquare();

		} else if (squareName.equals("SqueezePlaySquare")) {
			return new SqueezePlaySquare();

		} else if (squareName.equals("StockExchangeSquare")) {
			return new StockExchangeSquare();

		} else if (squareName.equals("TaxRefundSquare")) {
			return new TaxRefundSquare();

		} else if (squareName.equals("BeaconStreetSquare")) {
			return new BeaconStreetSquare();

		} else if (squareName.equals("BoylstonStreetSquare")) {
			return new BoylstonStreetSquare();

		} else if (squareName.equals("FifthAvenueSquare")) {
			return new FifthAvenueSquare();

		} else if (squareName.equals("FishermansWharfSquare")) {
			return new FishermansWharfSquare();

		} else if (squareName.equals("FloridaAveneuSquare")) {
			return new FloridaAveneuSquare();

		} else if (squareName.equals("LombardStreetSquare")) {
			return new LombardStreetSquare();

		} else if (squareName.equals("MadisonAvenueSquare")) {
			return new MadisonAvenueSquare();

		} else if (squareName.equals("MiamiAvenueSquare")) {
			return new MiamiAvenueSquare();

		} else if (squareName.equals("TheEmbarcaderoSquare")) {
			return new TheEmbarcaderoSquare();

		} else if (squareName.equals("WallStreetSquare")) {
			return new WallStreetSquare();

		} else if (squareName.equals("GasCompanySquare")) {
			return new GasCompanySquare();

		} else if (squareName.equals("TelephoneCompanySquare")) {
			return new TelephoneCompanySquare();

		} else if (squareName.equals("TransitStationSquare")) {
			return new TransitStationSquare();

		}
		 else if (squareName.equals("MediterraneanAvenueSquare")) {
				return new MediterraneanAvenueSquare();

			}
		
		
		
		
		//orcun
		else if(squareName.equals("GoSquare")) {
			return new GoSquare();
		}else if(squareName.equals("CommunityChestSquare")) {
			return new CommunityChestSquare();
		}else if(squareName.equals("BalticAvenueSquare")) {
			return new BalticAvenueSquare();
		}else if(squareName.equals("IncomeTaxSquare")) {
			return new IncomeTaxSquare();
		}else if(squareName.equals("OrientalAvenueSquare")) {
			return new OrientalAvenueSquare();
		}else if(squareName.equals("ChanceSquare")) {
			return new ChanceSquare();
		}else if(squareName.equals("VermontAvenueSquare")) {
			return new VermontAvenueSquare();
		}else if(squareName.equals("ConnecticutAvenueSquare")) {
			return new ConnecticutAvenue();
		}else if(squareName.equals("InJailSquare")) {
			return new InJailSquare();
		}else if(squareName.equals("StCharlesPlaceSquare")) {
			return new StCharlesPlaceSquare();
		}else if(squareName.equals("ElectricCompanySquare")) {
			return new ElectricCompanySquare();
		}else if(squareName.equals("StatesAvenueSquare")) {
			return new StatesAvenueSquare();
		}else if(squareName.equals("VirginiaAvenueSquare")) {
			return new VirginiaAvenueSquare();
		}else if(squareName.equals("PennysylvaniaRoadSquare")) {
			return new PennsylvaniaRailroadSquare();
		}else if(squareName.equals("StJamesPlaceSquare")) {
			return new StJamesPlaceSquare();
		}else if(squareName.equals("TenesseeAvenueSquare")) {
			return new TenesseeAvenueSquare();
		}else if(squareName.equals("NewYorkAvenueSquare")) {
			return new NewYorkAvenueSquare();
		}else if(squareName.equals("FreeParkingSquare")) {
			return new FreeParkingSquare();
		}

		//atisay is here
				else if (squareName.equals("RodeoDriveSquare")) {
					return new RodeoDriveSquare();
				}
				else if (squareName.equals("VenturaBoulevardSquare")) {
					return new VenturaBoulevardSquare();

				} else if (squareName.equals("MullhollandDriveSquare")) {
					return new MullhollandDriveSquare();

				} else if (squareName.equals("BirthdayGiftSquare")) {
					return new BirthdayGiftSquare();

				} else if (squareName.equals("UteCabCoSquare")) {
					return new UteCabCoSquare();

				} else if (squareName.equals("SewageSystemSquare")) {
					return new SewageSystemSquare();

				} else if (squareName.equals("MarketStreetSquare")) {
					return new MarketStreetSquare();

				} else if (squareName.equals("WalnutStreetSquare")) {
					return new WalnutStreetSquare();

				} else if (squareName.equals("BroadStreetSquare")) {
					return new BroadStreetSquare();

				} else if (squareName.equals("SouthStreetSquare")) {
					return new SouthStreetSquare();
					

				} else if (squareName.equals("LakeStreetSquare")) {
					return new LakeStreetSquare();

				} else if (squareName.equals("NicolletAvenueSquare")) {
					return new NicolletAvenueSquare();

				} else if (squareName.equals("HennepinAvenueSquare")) {
					return new HennepinAvenueSquare();

				} else if (squareName.equals("CheckerCabCoSquare")) {
					return new CheckerCabCoSquare();

				} else if (squareName.equals("ReadingRailroadSquare")) {
					return new ReadingRailroadSquare();

				} else if (squareName.equals("EsplanadeAvenueSquare")) {
					return new EsplanadeAvenueSquare();

				} else if (squareName.equals("CanalStreetSquare")) {
					return new CanalStreetSquare();

				} else if (squareName.equals("CableCompanySquare")) {
					return new CableCompanySquare();

				} else if (squareName.equals("MagazineStreetSquare")) {
					return new MagazineStreetSquare();

				} else if (squareName.equals("BourbonStreetSquare")) {
					return new BourbonStreetSquare();

				}
				else if (squareName.equals("AuctionSquare")) {
					return new AuctionSquare();

				} else if (squareName.equals("KatyFreewaySquare")) {
					return new KatyFreewaySquare();

				} else if (squareName.equals("WestheimerRoadSquare")) {
					return new WestheimerRoadSquare();

				} else if (squareName.equals("InternetServiceProviderSquare")) {
					return new InternetServiceProviderSquare();

				} else if (squareName.equals("KirbyDriveSquare")) {
					return new KirbyDriveSquare();

				} else if (squareName.equals("CullenBoulevardSquare")) {
					return new CullenBoulevardSquare();

				} else if (squareName.equals("BlackandWhiteCabCoSquare")) {
					return new BlackandWhiteCabCoSquare();

				}
				// atisay is gone
		
		//berrak
		if(squareName.equals("KentuckyAvenueSquare")) {
			return new KentuckyAvenueSquare();
			
		}
		else if(squareName.equals("IndianaAvenueSquare")) {
			return new IndianaAvenueSquare();
			
		}
		
		else if(squareName.equals("IllinoisAvenueSquare")) {
			return new IllinoisAvenueSquare(); 
			
		}
		
		else if(squareName.equals("AtlanticAvenueSquare")) {
			return new AtlanticAvenueSquare();
			
		}
		else if(squareName.equals("VentnorAvenueSquare")) {
			return new VentnorAvenueSquare();
			
		}
		
		else if(squareName.equals("MarvinGardensSquare")) {
			return new MarvinGardensSquare();
			
		}
		else if(squareName.equals("PacificAvenueSquare")) {
			return new PacificAvenueSquare();
			
		}
		else if(squareName.equals("PennsylvaniaAvenueSquare")) {
			return new PennsylvaniaAvenueSquare();
			
		}
		else if(squareName.equals("NorthCarolinaAvenueSquare")) {
			return new NorthCarolinaAvenueSquare();
			
		}
		else if(squareName.equals("ParkPlaceSquare")) {
			return new ParkPlaceSquare();
			
		}
		else if(squareName.equals("BoardwalkSquare")) {
			return new BoardwalkSquare();
			
		}
		
		else if(squareName.equals("RollThreeSquare")) {
			return new RollThreeSquare();
			
		}

		else if(squareName.equals("BoardwalkSquare")) {
			return new BoardwalkSquare();
			
		}
		
		else if(squareName.equals("WaterWorksSquare")) {
			return new WaterWorksSquare();
			
		}
		else if(squareName.equals("ShortLineSquare")) {
			return new ShortLineSquare();
			
		}
		else if(squareName.equals("LuxuryTaxSquare")) {
			return new LuxuryTaxSquare();
			
		}
		else if(squareName.equals("ShortLineSquare")) {
			return new ShortLineSquare();
			
		}
		else if(squareName.equals("PayDaySquare")) {
			return new PayDaySquare();
			
		}
		
		
		//ayca
		else if(squareName.equals("DekalbAvenueSquare")) {
			return new DekalbAvenueSquare();
		}else if(squareName.equals("AndrewYoungIntlBoulevardSquare")) {
			return new AndrewYoungIntlBoulevardSquare();
		}else if(squareName.equals("DecaturStreetSquare")) {
			return new DecaturStreetSquare();
		}else if(squareName.equals("PeachtreeStreetSquare")) {
			return new PeachtreeStreetSquare();
		}else if(squareName.equals("RandolphStreetSquare")) {
			return new RandolphStreetSquare();
		}else if(squareName.equals("LakeShoreDriveSquare")) {
			return new LakeShoreDriveSquare();
		}else if(squareName.equals("WackerDriveSquare")) {
			return new WackerDriveSquare();
		}else if(squareName.equals("MichiganAvenueSquare")) {
			return new MichiganAvenueSquare();
		}else if(squareName.equals("YellowCabCoSquare")) {
			return new YellowCabCoSquare();
		}else if(squareName.equals("BORailroadSquare")) {
			return new BORailroadSquare();
		}else if(squareName.equals("SouthTempleSquare")) {
			return new SouthTempleSquare();
		}else if(squareName.equals("WestTempleSquare")) {
			return new WestTempleSquare();
		}else if(squareName.equals("TrashCollectorSquare")) {
			return new TrashCollectorSquare();
		}else if(squareName.equals("NorthTempleSquare")) {
			return new NorthTempleSquare();
		}else if(squareName.equals("TempleSquare")) {
			return new TempleSquare();
		}else if(squareName.equals("GoToJailSquare")) {
			return new GoToJailSquare();
		}
		

		else {
			System.out.println("Either you or the developer entered wrong class name in the Square Factory: " + squareName);
		}

		return null;

	}

}