import javax.swing.ImageIcon;


public class Card {
	
	protected int count = 0;
	
	ImageIcon icon;
		
	protected String suit;
	
	protected String letter = "";
	
	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public ImageIcon getIcon(){
		return icon;
	}
	
	public Card(int worth, String abbrev, String suit){
		count = worth;
		letter = abbrev;
		this.suit = suit;
	}
	
	public int getCount(){
		return count;
	}
	
	public String getLetter(){
		return letter;
	}
	
	public String getSuit(){
		return suit;
	}

	public void setCount(int count) {
			this.count = count;
	}

	public void setLetter(String letter) {
		this.letter = letter;
	}
	
	public void setSuit(String suit){
		this.suit = suit;
	}

}
