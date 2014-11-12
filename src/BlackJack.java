import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class BlackJack implements ActionListener {

	JFrame board = null;
	
	Card pCard1 = null;
	Card pCard2 = null;
	Card dCard1 = null;
	Card dCard2 = null;
	
	boolean firstRun;
	
	int pWins;
	int dWins;
	
	String scoreBoard = "Dealer: " + dWins + " Player: " + pWins;
	
	ArrayList<Card> playerHand = new ArrayList<Card>();
	ArrayList<Card> dealerHand = new ArrayList<Card>();
	ArrayList<JLabel> imageLabels = new ArrayList<JLabel>();
	ArrayList<JLabel> dImageLabels = new ArrayList<JLabel>();
	
	int dealerRegTotal = 0;
	int dealerTotalIfAce = 0;
	
	int regTotal = 0;
	int totalIfAce = 0;
	
	JButton hit = null;
	JButton stop = null;
	
	//add place for cards
	JLabel dImage1 = new JLabel();
	JLabel dImage2 = new JLabel();
	JLabel card1 = new JLabel();
	JLabel card2 = new JLabel();
	
	JPanel rightPanel = new JPanel( new GridLayout(2,1) );
	JPanel cardPanel = new JPanel();
	JPanel dealerPanel = new JPanel();
	
	//Total count label
	JLabel playerCount = new JLabel("Your total: ", SwingConstants.CENTER);
	
	public BlackJack(int dScore, int pScore) {
		
		dWins = dScore;
		pWins = pScore;
		
		if (dWins == 0 && pWins == 0){
			firstRun = true;
		}
		
		reset(dScore, pScore);
				
	}
	
	public String transformIntoString( ArrayList<Card> cards ){
		
		String cardString = "";
		boolean gate = false;
		
		for( Card card: cards ){
			
			if( gate == false ){
				cardString = card.getLetter();
				gate = true;
			} else {
				cardString = cardString + "----" + card.getLetter();
			}
			
		}
		
		return cardString;
	}
	
	public int numAces( ArrayList<Card> cards){
		
		int count = 0;
		
		for( Card card : cards ){
			
			if( card.getLetter() == "A" ){
				count++;
			}
			
		}
		
		return count;
	}
	
	public void setDealerTotal( ArrayList<Card> cards ){
		
		int regSum = 0;
		int aceSum = 0;
		
		if( hasAce(cards) ){
			
			if( numAces(cards) == 1 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 10;
				
			} else if( numAces(cards) == 2 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 20;
				
			} else if( numAces(cards) == 3 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 30;
				
			} else if( numAces(cards) == 4 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 40;
				
			}
			
		} else{
			
			for( Card card : cards ){
				regSum += card.getCount();
			}
			
		}
		
		dealerRegTotal = regSum;
		dealerTotalIfAce = aceSum;
		
	}
	
	public void setTotal( ArrayList<Card> cards ){
		
		int regSum = 0;
		int aceSum = 0;
		
		if( hasAce(cards) ){
			
			if( numAces(cards) == 1 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 10;
				
			} else if( numAces(cards) == 2 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 20;
				
			} else if( numAces(cards) == 3 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 30;
				
			} else if( numAces(cards) == 4 ){
				
				for( Card card : cards ){
					regSum += card.getCount();
					aceSum +=card.getCount();
				}
				
				aceSum += 40;
				
			}
			
		} else{
			
			for( Card card : cards ){
				regSum += card.getCount();
			}
			
		}
		
		regTotal = regSum;
		totalIfAce = aceSum;
		
	}
	
	public boolean hasAce( ArrayList<Card> cards ){ 
		
		//Checks if the list provided has an ace in it
		boolean listIncludesAce = false;
		
		for( Card card : cards ){
			if(card.getLetter() == "A"){
				listIncludesAce = true;
			}
		}
		
		return listIncludesAce;
		
	}
	
	public void setUpBoard(){
		
		board = null;
		
		pCard1 = null;
		pCard2 = null;
		dCard1 = null;
		dCard2 = null;
		
		scoreBoard = "Dealer: " + dWins + " Player: " + pWins;
		
		playerHand = new ArrayList<Card>();
		dealerHand = new ArrayList<Card>();
		imageLabels = new ArrayList<JLabel>();
		dImageLabels = new ArrayList<JLabel>();
		
		dealerRegTotal = 0;
		dealerTotalIfAce = 0;
		
		regTotal = 0;
		totalIfAce = 0;
		
		hit = null;
		stop = null;
		
		//add place for cards
		dImage1 = new JLabel();
		dImage2 = new JLabel();
		card1 = new JLabel();
		card2 = new JLabel();
		
		rightPanel = new JPanel( new GridLayout(2,1) );
		cardPanel = new JPanel();
		dealerPanel = new JPanel();
		
		//Total count label
		playerCount = new JLabel("Your total: ", SwingConstants.CENTER);

		board = new JFrame();
		
		//Default JFrame settings
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		board.setTitle("Blackjack"); 
		board.setSize(900, 300);
		
		// Create panel to add visuals to and make it a grid layout
		JPanel basePanel = new JPanel(new GridBagLayout());
		
		JPanel middlePanel = new JPanel();
		
		playerCount.setVerticalAlignment( SwingConstants.CENTER );
		
		//add labels to board panel
		JPanel leftPanel = new JPanel( new GridLayout(2,1) );
		leftPanel.add( new JLabel("") );
		dealerPanel.add( dImage1 );
		dealerPanel.add( dImage2 );
		leftPanel.add( dealerPanel );
		
		
		hit = new JButton( "Hit" );
		stop = new JButton( "Stop" );
		hit.addActionListener(this);
		stop.addActionListener(this);
		
		middlePanel.add(hit);
		middlePanel.add(stop);
		
		
		cardPanel.add(card1);
		cardPanel.add(card2);
		
		rightPanel.add( playerCount );
		rightPanel.add( cardPanel );
		
		basePanel.add(leftPanel);
		basePanel.add(middlePanel);
		basePanel.add(rightPanel);
		
		leftPanel.setBackground( Color.BLACK );
		middlePanel.setBackground( Color.BLACK );
		rightPanel.setBackground( Color.BLACK );
		dealerPanel.setBackground( Color.BLACK );
		cardPanel.setBackground( Color.BLACK );
		basePanel.setBackground(Color.BLACK);
		
		playerCount.setForeground( Color.WHITE );
		playerCount.setFont( playerCount.getFont().deriveFont(64.0f) );
		
		//Add panel to JFrame
		board.setContentPane( basePanel );
		
		//Make JFrame visible
		board.setVisible(true);
		
		
	}

	public void toImage( ArrayList<Card> cards ){
		
		for(int i = 0; i < cards.size(); i++){
			imageLabels.add(null);
			if( imageLabels.get(i) == null ){
				imageLabels.set(i, new JLabel());
			}
			
			cardPanel.add( imageLabels.get(i) );
			imageLabels.get(i).setIcon( cards.get(i).getIcon() );
			
		}
		
	}
	
	public void toDImage( ArrayList<Card> cards ){				
		
		for(int i = 0; i < cards.size(); i++){
			dImageLabels.add(null);
			if( dImageLabels.get(i) == null ){
				dImageLabels.set(i, new JLabel());
			}
			
			dealerPanel.add( dImageLabels.get(i) );
			dImageLabels.get(i).setIcon( cards.get(i).getIcon() );
			
		}
		
	}
	
	public static void main(String[] args) {

		new BlackJack(0, 0);
		
	}
	
	public void reset(int dScore, int pScore){
		
		if ( firstRun ){
			firstRun = false;
		} else {
			board.dispose();
		}
		
		setUpBoard();
		
		board.setTitle("Dealer: " + dScore + " Player: " + pScore);
		
		Deck.makeDeck();
		Deck.dealHand();
		
		// Initialize playerCount and playerCards labels
		pCard1 = Deck.playerCard1;
		pCard2 = Deck.playerCard2;
		dCard1 = Deck.dealerCard1;
		dCard2 = Deck.dealerCard2;
		
		playerHand.add( pCard1 );
		playerHand.add( pCard2 );
		
		dealerHand.add( dCard1 );
		dealerHand.add( dCard2 );
		
		setTotal( playerHand );
		
		if( hasAce(playerHand) ){
			playerCount.setText( "" + regTotal + " or " + totalIfAce );
		} else{
			playerCount.setText( "" + regTotal );
		}
		
		card1.setIcon( pCard1.getIcon() );
		card2.setIcon( pCard2.getIcon() );
		dImage1.setIcon( new ImageIcon(getClass().getResource( "155.png" )) );
		dImage2.setIcon( dCard2.getIcon() );
		imageLabels.add( card1 );
		imageLabels.add( card2 );
		dImageLabels.add( dImage1 );
		dImageLabels.add( dImage2 );
		
	}
	
	public boolean isBust( ArrayList<Card> cards ){
		
		boolean busted = false;
		
		if( hasAce(cards) ){
			
			if( (regTotal > 21) && (totalIfAce > 21) ){
				busted = true;
			}
			
		} else{
			if( regTotal > 21 ){
				busted = true;
			}
		}
		
		return busted;
		
	}
	
	public boolean dealerIsBust( ArrayList<Card> cards ){ 
		boolean busted = false;
		
		if( hasAce(cards) ){
			
			if( (dealerRegTotal > 21) && (dealerTotalIfAce > 21) ){
				busted = true;
			}
			
		} else{
			if( dealerRegTotal > 21 ){
				busted = true;
			}
		}
		
		return busted;
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		Object checker = event.getSource();
		
		if( checker == hit ){
			
			playerHand.add( Deck.getRandCard() );
			
			setTotal( playerHand );
			
			if( hasAce(playerHand) ){
				playerCount.setText( "" + regTotal + " or " + totalIfAce );
			} else{
				playerCount.setText( "" + regTotal );
			}
			
			toImage(playerHand);
			
			if( isBust( playerHand ) ){
				toDImage(dealerHand);
				dWins++;
				int check = JOptionPane.showConfirmDialog(board, "You went bust! Would you like to play again?", "BlackJack", JOptionPane.YES_NO_OPTION);
				if( check == 0){
					reset(dWins, pWins);
				} else{
					System.exit(0);
				}
			}
			
		} else if( checker == stop ){
			
			toDImage(dealerHand);
			setDealerTotal( dealerHand );
			
			dealerMakeDecision();
			
		}

	}
	
	public void dealerWon(){
		dWins++;
		int check = JOptionPane.showConfirmDialog(board, "The dealer won! Would you like to play again?", "BlackJack", JOptionPane.YES_NO_OPTION);
		if( check == 0){
			reset(dWins, pWins);
		} else{
			System.exit(0);
		}
	}
	
	public void hitDealer(){
		
		dealerHand.add( Deck.getRandCard() );
		setDealerTotal( dealerHand );
		toDImage(dealerHand);
		
	}
	
	public void dealerMakeDecision(){
		if( dealerIsBust( dealerHand ) != true ){
			if( hasAce(dealerHand) == true && hasAce(playerHand) == true ){
				
				if(totalIfAce > 21){
					
					if( dealerTotalIfAce > 21 ){
						
						if( dealerRegTotal >= regTotal ){
							dealerWon();
						} else{
							hitDealer(); 
							dealerMakeDecision();							
						}
						
					} else{
						
						if( dealerTotalIfAce >= regTotal ){
							dealerWon();
						} else{
							hitDealer(); 
							dealerMakeDecision();
						}
						
					}
					
				} else{
					
					if( dealerTotalIfAce > 21 ){
						
						if( dealerRegTotal >= totalIfAce ){
							dealerWon();
						} else{
							hitDealer(); 
							dealerMakeDecision();
						}
						
					} else{
						
						if( dealerTotalIfAce >= totalIfAce ){
							dealerWon();
						} else{
							hitDealer(); 
							dealerMakeDecision();
						}
						
					}
					
				}
				
			} else if( hasAce(dealerHand) == true && hasAce(playerHand) == false ){
				
				if( dealerTotalIfAce > 21 ){
					
					if( dealerRegTotal >= regTotal ){
						dealerWon();
					} else{
						hitDealer();
						dealerMakeDecision();
					}
					
				} else{
					
					if( dealerTotalIfAce >= regTotal ){
						dealerWon();
					} else{
						hitDealer(); 
						dealerMakeDecision();
					}
					
				}
				
			} else if( hasAce(dealerHand) == false && hasAce(playerHand) == true ){
				
				if( totalIfAce > 21 ){
					
					if( dealerRegTotal >= regTotal ){
						dealerWon();
					} else{
						hitDealer(); 
						dealerMakeDecision();
					}
					
				} else{
					
					if( dealerRegTotal >= totalIfAce ){
						dealerWon();
					} else{
						hitDealer(); 
						dealerMakeDecision();
					}
					
				}
				
			} else if( hasAce(dealerHand) == false && hasAce(playerHand) == false ){
				
				if( dealerRegTotal >= regTotal ){
					dealerWon();
				} else{
					hitDealer(); 
					dealerMakeDecision();
				}
				
			}
		
		} else{
			pWins++;
			int check = JOptionPane.showConfirmDialog(board, "Dealer went bust! Would you like to play again?", "BlackJack", JOptionPane.YES_NO_OPTION);
			if( check == 0){
				reset(dWins, pWins);
			} else{
				System.exit(0);
			}
			
		}
	}
	
}