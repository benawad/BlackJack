import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Deck {
	
	static Card[] cardDeck = new Card[Deck.size];
	
	public static final int size = 52;
	
	public static Card playerCard1 = null;
	public static Card playerCard2 = null;
	public static Card dealerCard1 = null;
	public static Card dealerCard2 = null;
	
	public static void assignLetter( int plus ){
		
		for(int j = 0; j < 13; j++){
					
					switch (j) {
						case 0:
							cardDeck[j+plus].setLetter("A");
							break;
						case 1:
							cardDeck[j+plus].setLetter("2");
							break;
						case 2:
							cardDeck[j+plus].setLetter("3");
							break;
						case 3:
							cardDeck[j+plus].setLetter("4");
							break;
						case 4:
							cardDeck[j+plus].setLetter("5");
							break;
						case 5:
							cardDeck[j+plus].setLetter("6");
							break;
						case 6:
							cardDeck[j+plus].setLetter("7");
							break;
						case 7:
							cardDeck[j+plus].setLetter("8");
							break;
						case 8:
							cardDeck[j+plus].setLetter("9");
							break;
						case 9:
							cardDeck[j+plus].setLetter("10");
							break;
						case 10:
							cardDeck[j+plus].setLetter("J");
							break;
						case 11:
							cardDeck[j+plus].setLetter("Q");
							break;
						case 12:
							cardDeck[j+plus].setLetter("K");
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR in deck.java something wrong with assignLetter method");
					}
					
				}
	}
	
	public static void assignCount( int plus ){
		
		for(int j = 0; j < 13; j++){
					
					switch (j) {
						case 0:
							cardDeck[j+plus].setCount(1);
							break;
						case 1:
							cardDeck[j+plus].setCount(2);
							break;
						case 2:
							cardDeck[j+plus].setCount(3);
							break;
						case 3:
							cardDeck[j+plus].setCount(4);
							break;
						case 4:
							cardDeck[j+plus].setCount(5);
							break;
						case 5:
							cardDeck[j+plus].setCount(6);
							break;
						case 6:
							cardDeck[j+plus].setCount(7);
							break;
						case 7:
							cardDeck[j+plus].setCount(8);
							break;
						case 8:
							cardDeck[j+plus].setCount(9);
							break;
						case 9:
							cardDeck[j+plus].setCount(10);
							break;
						case 10:
							cardDeck[j+plus].setCount(10);
							break;
						case 11:
							cardDeck[j+plus].setCount(10);
							break;
						case 12:
							cardDeck[j+plus].setCount(10);
							break;
						default:
							JOptionPane.showMessageDialog(null, "ERROR in deck.java something wrong with assignLetter method");
					}
					
				}
	}
	
	public static void assignImage( int plus ){
		
		int[] add = new int[14];
		
		for(int t = 1; t < 14; t++){
			add[t] = t + plus + 100;
		}
		
		for(int j = 0; j < 13; j++){
			
			switch (j) {
				case 0:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 1:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 2:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 3:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 4:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 5:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 6:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 7:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 8:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 9:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 10:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 11:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				case 12:
					cardDeck[j+plus].setIcon( new ImageIcon(Deck.class.getResource(add[j+1] + ".png")) );
					break;
				default:
					JOptionPane.showMessageDialog(null, "ERROR in deck.java something wrong with assignImage method");
			}
			
		}
		
	}
	
	public static void makeDeck(){

		for(int i = 0; i < Deck.size; i++){
			
			cardDeck[i] = new Card(0, "", "");
			
			if( i < 13 ){
				cardDeck[i].setSuit("Diamonds");
			} else if (i > 12 && i < 26){
				cardDeck[i].setSuit("Clubs");
			} else if (i > 25 && i < 39){
				cardDeck[i].setSuit("Hearts");
			} else{
				cardDeck[i].setSuit("Spades");
			}
				
		}
		
		assignLetter(0);
		assignLetter(13);
		assignLetter(26);
		assignLetter(39);
		
		assignCount(0);
		assignCount(13);
		assignCount(26);
		assignCount(39);		
		
		assignImage(0);
		assignImage(13);
		assignImage(26);
		assignImage(39);
		
	}
	
	public static void dealHand(){
		
		playerCard1 = getRandCard();
		playerCard2 = getRandCard();
		dealerCard1 = getRandCard();
		dealerCard2 = getRandCard();
		
	}
	
	public static Card getRandCard(){
		
		Card cardHit = null;
		Random rand = new Random();
		
		while(cardHit == null){		
			int currentRand = rand.nextInt(51)+1;
			if( cardDeck[currentRand] != null ){
				cardHit = cardDeck[currentRand];
				cardDeck[currentRand] = null;
			}
		}
		
		return cardHit;
	}

	/* public static void main(String[] args) {
		Deck.makeDeck();
		for(int p = 0; p < 52; p++){
			System.out.println(cardDeck[p].getIcon().toString());
		}
	}*/
	
}
