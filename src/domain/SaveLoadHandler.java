package domain;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import domain.squares.Square;

public class SaveLoadHandler{
	
	MonopolyGameController mp;
	
	ArrayList<File> fileList;
	
	FileOutputStream f;
	ObjectOutputStream o;
	File fl;
	FileInputStream fi;
	ObjectInputStream oi;
	
	public SaveLoadHandler(){
		//fileList = new ArrayList<File>();
	}
	
	//Load Issues
	public void load(String fileName) {
		readAllObjects(fileName);
		
		
	}
	
	
	//arrayList deï¿½iï¿½ti arraylist orijinal
	
	public void readAllObjects(String chosenFileName){
		
		
		try {
		
		fi = new FileInputStream(createSaveFile(chosenFileName));
		oi = new ObjectInputStream(fi);
		
		/*MonopolyGameController.getCup() cup = (MonopolyGameController.getCup()) oi.readObject();
		
		System.out.println(mp1.getCup().getTotalFaceValue());*/

		// Read objects
	/*	Person pr1 = (Person) oi.readObject();
		Person pr2 = (Person) oi.readObject();
	*/
		Cup c = (Cup) oi.readObject();
		Deck d=(Deck) oi.readObject();
	
		Pool po=(Pool) oi.readObject();
		Board b= (Board) oi.readObject();
		ArrayList<Player> pl=(ArrayList<Player>) oi.readObject();
		
		//test cases for load results
		
		MonopolyGameController.getInstance();
		MonopolyGameController.setCup(c);
		MonopolyGameController.setDeck(d);
		MonopolyGameController.setPool(po);
		MonopolyGameController.setBoard(b);
//		MonopolyGameController.setPawns(pa);
//		MonopolyGameController.setPawnNames(pn);
		
//		MonopolyGameController.setPlayers(pl);
/*		private String name;
		private int balance;
		private boolean inJail;
		private ArrayList<Card> cards;
		private Pawn pawn;
		private int direction;
		private ArrayList<Square> properties;
		private int numberOfOwnedUtility;
		private int numberOfOwnedRailroad;
		private int currentSquareIndex;
*/
		int i=0;
		for(Player p : MonopolyGameController.getPlayersList()) {
			Square source=p.getCurrentSquare(MonopolyGameController.getBoard());
			p.setBalance(pl.get(i).getBalance());
			p.setName(pl.get(i).getName());
			p.setInJail(pl.get(i).jailRemaining());
			p.setCards(pl.get(i).getCards());
			p.setDirection(pl.get(i).getDirection());
			p.setProperties(pl.get(i).getProperties());
			p.setNumberOfOwnedRailroad(pl.get(i).getNumberOfOwnedRailroad());
			p.setNumberOfOwnedUtility(pl.get(i).getNumberOfOwnedUtility());
			p.setCurrentSquareIndex(pl.get(i).getCurrentSquareIndex());
			Square target=p.getCurrentSquare(MonopolyGameController.getBoard());
			try {
				MonopolyGameController.teleportPlayer(p, source, target, p.getCurrentSquareIndex());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			i++;
		}
		
		
//		MonopolyGameController.setCup(c);
		//MonopolyGameController.getInstance().setPawnNames(n);
		
		//System.out.println(fileList.size());	
		
		oi.close();
		fi.close();

	} catch (FileNotFoundException e) {
		System.out.println("File not found");
	} catch (IOException e) {
		System.out.println("Error initializing stream");
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	
	public Boolean validate(String fileName) {
		return false;
	}
	
	//Save Issues
	
	
	
	public File createSaveFile(String f) {
		fl = new File(f);
		MonopolyGameController.getInstance().fileList.add(fl);
		return fl;
	}
	
	public Object writeAll(ArrayList<String> pawnNames, ArrayList<Player> players, Cup cup, Deck deck, ArrayList<Pawn> pawns, Pool pool,String fileName) {
		
		
		//MonopolyGameController mp1 = MonopolyGameController.getInstance();
		//playerlarï¿½ teker teker eï¿½itlemek yerine halihazï¿½rdaki playerlara save ettiï¿½imiz playerlarï¿½n valuelarï¿½ atanacak.
		
		MonopolyGameController.getInstance();
		Cup c=MonopolyGameController.getCup();
		Deck d=MonopolyGameController.getDeck();
		Pool po=MonopolyGameController.getPool();
		Board b = MonopolyGameController.getBoard();
		ArrayList<Player> pl=MonopolyGameController.getPlayersList();

		
		try {
			 f = new FileOutputStream(createSaveFile(fileName));
			 o = new ObjectOutputStream(f);

			// Write objects to file
			o.writeObject(c);			
			o.writeObject(d);
			//o.writeObject(pn);
			o.writeObject(po);			
//			o.writeObject(po);
//			o.writeObject(pa);
			o.writeObject(b);
			o.writeObject(pl);

			
			o.close();
			f.close();


		} catch (FileNotFoundException e) {
			System.out.println("File not found");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		}

		
		
		
		return o;
	}
	
	
	
	
public void save(ArrayList<String> pawnNames, ArrayList<Player> players, Cup cup, Deck deck, ArrayList<Pawn> pawns, Pool pool, String wannaBeFileName) {
		
		MonopolyGameController.getInstance();
		MonopolyGameController.onSaveEvent(writeAll(pawnNames, players, cup, deck, pawns, pool,wannaBeFileName), fl.getName());
//		MonopolyGameController.onSaveEvent(writeAll(pawnNames, players, cup, deck, pawns, pool,"debugSaveFile"), fl.getName());

		
	}

public boolean loadValidate() {
	// TODO Auto-generated method stub
	//load baï¿½arï¿½lï¿½ mï¿½ deï¿½il mi kontrol et
	return false;
}


	
	

}