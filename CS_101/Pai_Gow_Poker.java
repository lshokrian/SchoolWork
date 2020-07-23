import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Pai_Gow_Poker extends JFrame {

	int round = 1;
	int bet = 0;
	int bank = 50;
	int state = 0;		// 0 is beginning of the round; 1 is after the 7 cards are displayed; 2 is after the user selects 1 card
	// 3 is after the user selects the second card and the winner is announced at the end of round 
	int compWins = 0;
	int userWins = 0;

	int[][] previous_cards = new int[50][2]; //int [52][2]??
	int noPC = 0;
	int [][] userHand = new int[7][2];
	private static int [][] userSelect = new int[2][2];
	int [][] newUserHand = new int[5][2];
	int noHC = 0;
	int[][] compHand = new int[7][2];
	private static int[][] compSelect = new int[2][2];
	int[][] newCompHand = new int[5][2];
	int noCC = 0;
	private static String cardSelectedone = "";
	private static String cardSelectedtwo = "";

	String winner = "";
	JPanel p1 = new JPanel();	//board
	JPanel p10 = new JPanel();
	JPanel p11 = new JPanel();
	JPanel p12 = new JPanel();
	JPanel p13 = new JPanel();
	JPanel p14 = new JPanel();
	JPanel p15 = new JPanel();
	JPanel p16 = new JPanel();
	JPanel p17 = new JPanel();
	JPanel p18 = new JPanel();
	JPanel p19 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p20 = new JPanel();
	JPanel p201 = new JPanel();
	JPanel p202 = new JPanel();
	JPanel p21 = new JPanel();
	JPanel p22 = new JPanel();
	JPanel p23 = new JPanel();
	JPanel p24 = new JPanel();
	JPanel p25 = new JPanel();
	JPanel p26 = new JPanel();
	JPanel p27 = new JPanel();
	JPanel p28 = new JPanel();
	JPanel p29 = new JPanel();
	JPanel p3 = new JPanel(); //under bottom half
	JPanel p30 = new JPanel(); //round level 
	JPanel p31 = new JPanel();	//Betting
	JPanel p311 = new JPanel();
	JPanel p312 = new JPanel();
	JPanel p32 = new JPanel();	//continue
	JPanel p33 = new JPanel();	//Result and Bank
	JPanel p331 = new JPanel();
	JPanel p332 = new JPanel();
	JPanel p333 = new JPanel();

	JLabel l100 = new JLabel("Computer");
	JLabel l200 = new JLabel("User");
	JLabel l32 = new JLabel("Action: ");
	JLabel l33 = new JLabel("Instruction: Choose bet value.");
	JLabel l30 = new JLabel("Round " + round);
	JLabel l311 = new JLabel("Bet: ");
	JLabel l312 = new JLabel("Betting: $" + bet);
	//JLabel l331 = new JLabel("Result: " + winner);
	JLabel l331 = new JLabel("Computer's wins: " + compWins);
	JLabel l332 = new JLabel("Bank: $" + bank);
	JLabel l333 = new JLabel("User's wins: " + userWins);
	
	/*buttons with images**************************
	JButton poop = new JButton(new ImageIcon(""));
	 ***
	 *
	 *********************************************/
	JButton card0 = new JButton();
	JButton card1 = new JButton();
	JButton card2 = new JButton();
	JButton card3 = new JButton();
	JButton card4 = new JButton();
	JButton card5 = new JButton();
	JButton card6 = new JButton();

	JLabel[] hand7Icons = new JLabel[7];
	JLabel[] userSelectIcon = new JLabel[2];
	JLabel[] newHandIcon= new JLabel[5];
	JLabel[] Comp7Icons = new JLabel[7];

	JButton b310 = new JButton("$1");
	JButton b311 = new JButton("$2");
	JButton b312 = new JButton("$3");
	JButton b313 = new JButton("$4");
	JButton b314 = new JButton("$5");
	JButton b32 = new JButton("Continue");	

	//constructor
	Pai_Gow_Poker(){
		//****************************************************************
		//Set up GUI, can I do super....
		this.setTitle("Spring 2014 Pai Gow Poker");	
		this.setSize(1200, 600);
		this.setVisible(true);
		this.setLayout(new GridLayout(3,1));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(p1);
		this.add(p2);
		this.add(p3);
		p1.setLayout(new GridLayout(1,10));
		p1.setBorder(new LineBorder(new Color(0, 0, 200), 2));
		p1.add(p10);
		p1.add(p11);p1.add(p12);p1.add(p13);p1.add(p14);p1.add(p15);p1.add(p16);p1.add(p17);p1.add(p18);p1.add(p19);
		p10.setBorder(new LineBorder(new Color(0, 0, 0))); p10.add(l100);
		p11.setBorder(new LineBorder(new Color(0, 0, 0)));
		p12.setBorder(new LineBorder(new Color(0, 0, 0)));
		p13.setBorder(new LineBorder(new Color(0, 0, 0)));
		p14.setBorder(new LineBorder(new Color(0, 0, 0)));
		p15.setBorder(new LineBorder(new Color(0, 0, 0)));
		p16.setBorder(new LineBorder(new Color(0, 0, 0)));
		p17.setBorder(new LineBorder(new Color(0, 0, 0)));
		p18.setBorder(new LineBorder(new Color(0, 0, 0)));
		p19.setBorder(new LineBorder(new Color(0, 0, 0)));
		p2.setLayout(new GridLayout(1,10));
		p2.setBorder(new LineBorder(new Color(200, 0, 0), 2));
		p2.add(p20);p2.add(p21);p2.add(p22);p2.add(p23);p2.add(p24);p2.add(p25);p2.add(p26);p2.add(p27);p2.add(p28);p2.add(p29);
		p20.add(l200);
		p20.setBorder(new LineBorder(new Color(0, 0, 0))); 
		p21.setBorder(new LineBorder(new Color(0, 0, 0)));
		p22.setBorder(new LineBorder(new Color(0, 0, 0)));
		p23.setBorder(new LineBorder(new Color(0, 0, 0)));
		p24.setBorder(new LineBorder(new Color(0, 0, 0)));
		p25.setBorder(new LineBorder(new Color(0, 0, 0)));
		p26.setBorder(new LineBorder(new Color(0, 0, 0)));
		p27.setBorder(new LineBorder(new Color(0, 0, 0)));
		p28.setBorder(new LineBorder(new Color(0, 0, 0)));
		p29.setBorder(new LineBorder(new Color(0, 0, 0)));
		//****add this to all panels*****//
		p10.setBackground(new Color(100,200,0));p11.setBackground(new Color(100,200,0));p12.setBackground(new Color(100,200,0));p13.setBackground(new Color(100,200,0));
		p14.setBackground(new Color(100,200,0));p15.setBackground(new Color(100,200,0));p16.setBackground(new Color(100,200,0));p17.setBackground(new Color(100,200,0));
		p18.setBackground(new Color(100,200,0));p19.setBackground(new Color(100,200,0));
		p20.setBackground(new Color(100,200,0));p21.setBackground(new Color(100,200,0));p22.setBackground(new Color(100,200,0));p23.setBackground(new Color(100,200,0));
		p24.setBackground(new Color(100,200,0));p25.setBackground(new Color(100,200,0));p26.setBackground(new Color(100,200,0));p27.setBackground(new Color(100,200,0));
		p28.setBackground(new Color(100,200,0));p29.setBackground(new Color(100,200,0));
		//////////////////////////////////
		p3.setLayout(new GridLayout(4,1));
		p3.setBorder(new LineBorder(new Color(0, 200, 0), 2));
		p31.setLayout(new GridLayout(1,2));
		p33.setLayout(new GridLayout(1,2));
		p3.add(p30);
		p30.add(l30);
		p3.add(p31);
		p311.add(l311);
		p311.add(b310);
		p311.add(b311);
		p311.add(b312);
		p311.add(b313);
		p311.add(b314);
		p31.add(p311);
		p31.add(p312.add(l312));
		p3.add(p32);
		p32.add(l32);		
		p32.add(b32);
		p32.add(l33);
		p3.add(p33);
		//p33.add(p331.add(l331));
		p33.setLayout(new GridLayout(1,3));
		p33.add(p331); p33.add(p332); p33.add(p333);
		p331.add(l331); p332.add(l332); p333.add(l333);
		
		

		//ImageIcon start = new ImageIcon("C:/Users/Limor/Documents/eclipse workspace/Final Project/src/images/Playing_card_club_K.jpg");
		//card0.setIcon(start);
		//p23.add(card0);
		repaint();
		pack();
		//**************************************************************
		//Action listeners for GUI buttons

		//button $1
		b310.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b310");
			}
		});
		//button "$2"
		b311.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b311");		//even to perform when b42 is pressed
			}
		});
		//button "$3"
		b312.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b312");
			}
		});
		//button "$4"
		b313.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b313");
			}
		});
		//button "$5"
		b314.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b314");
			}
		});
		//button "Continue"
		b32.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("b32");
			}
		});	

		card0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card0");
			}
		});

		card1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card1");
			}
		});

		card2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card2");
			}
		});

		card3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card3");
			}
		});

		card4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card4");
			}
		});

		card5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card5");
			}
		});

		card6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshDisplay("card6");
			}
		});

		//***************************************************************
		//Action program to perform poker algorithm for user and Computer hands
		Scanner cardSelect = new Scanner(System.in);

		displayInitialUserHand();


	}//end of constructor

	public static void main(String[] args){
		Pai_Gow_Poker frame = new Pai_Gow_Poker();

	}	

	public void displayInitialUserHand(){
		noHC = 0;
		noCC = 0;
		noPC = 0; 
		p21.removeAll();
		p22.removeAll();
		p23.removeAll();
		p24.removeAll();
		p25.removeAll();
		p26.removeAll();
		p27.removeAll();
		p28.removeAll();
		p29.removeAll();
		p11.removeAll();
		p12.removeAll();
		p13.removeAll();
		p14.removeAll();
		p15.removeAll();
		p16.removeAll();
		p17.removeAll();
		p18.removeAll();
		p19.removeAll();
		
		//human hand
		for (noHC = 0; noHC < 7; noHC++){
			userHand[noHC] = generate_card(previous_cards, noPC);
			previous_cards[noPC][0] = userHand[noHC][0];
			previous_cards[noPC][1] = userHand[noHC][1];
			noPC++;
		}
		
		card0.setIcon(card_to_ImageIcon(userHand[0]));
		p21.add(card0);
		card1.setIcon(card_to_ImageIcon(userHand[1]));
		p22.add(card1);
		card2.setIcon(card_to_ImageIcon(userHand[2]));
		p23.add(card2);
		card3.setIcon(card_to_ImageIcon(userHand[3]));
		p24.add(card3);
		card4.setIcon(card_to_ImageIcon(userHand[4]));
		p25.add(card4);
		card5.setIcon(card_to_ImageIcon(userHand[5]));
		p26.add(card5);
		card6.setIcon(card_to_ImageIcon(userHand[6]));
		p27.add(card6);

		repaint();
		pack();
	}

	public static int compareSecondHand(){
		//both have pairs
		if (compSelect[0][0] == compSelect[1][0]){
			if (userSelect[0][0] == userSelect[1][0]){
				if (compSelect[0][0] == userSelect[0][0]){
				return 0;
				}
				else if (compSelect[0][0] > userSelect[0][0]){
					return -2; // computer wins
				}
				else{
					return 2; //user wins
				}
			} else {
				return -2; //only computer has a pair
			}
		} else if (userSelect[0][0] == userSelect[1][0]){
			return 2;//user only has a pair
		} else if ((compSelect[1][0] > (userSelect[1][0]) ) & (compSelect[1][0] > userSelect[0][0])){
			return -2;
		} else
			return 2;
	}
	
	public static int[] generate_card(int[][] previous_cards, int noPC) {
		boolean duplicate = false;
		int[] card = new int[2]; //make new card
		do {
			duplicate = false;
			card[0] = (int) (Math.random() * 13 + 2); //number
			card[1] = (int) (Math.random() * 4 + 1); // suit
			// compare all the previous hands with the current hand
			for (int i = 0; i < noPC; i++) {
				if ((card[0] == previous_cards[i][0]) && (card[1] == previous_cards[i][1])) {
					duplicate = true;
				}
			}
		} while (duplicate);
		return card;
	}

	/*public static int[] generate_card() {
		int[] card = new int[2];
		card[0] = (int) (Math.random() * 13 + 2);
		card[1] = (int) (Math.random() * 4 + 1);
		return card;
	}*/

	public static int[][] sort_hand(int[][] hand){
		int[][] sorted = new int[hand.length][2];
		for(int i=0; i<hand.length; i++){
			sorted[i][0]=hand[i][0];
			sorted[i][1]=hand[i][1];
		}
		for(int i=0; i<hand.length; i++){
			int minIndex = i;
			int[] min = new int[2];
			min[0] = sorted[i][0];
			min[1] = sorted[i][1];
			for(int j=i; j<hand.length; j++)
				if(min[0]>sorted[j][0]){
					minIndex = j;
					min[0] = sorted[j][0];
					min[1] = sorted[j][1];
				}
			sorted[minIndex][0] = sorted[i][0];
			sorted[minIndex][1] = sorted[i][1];
			sorted[i][0] = min[0];
			sorted[i][1] = min[1];
			System.out.println("card" + i + ": " + sorted[i][0] + " " + sorted[i][1]);
		}
		return sorted;
	}
	
	//create temporary computer hand
	public void displayCompHand(){
		int[][] handComp_temp = new int[7][2];
		for (noCC = 0; noCC < 7; noCC++){
			compHand[noCC] = generate_card(previous_cards, noPC);
			previous_cards[noPC][0] = handComp_temp[noCC][0];
			previous_cards[noPC][1] = handComp_temp[noCC][1];
			noPC++;
		}

		int[][] newSortedHand = new int[7][2];
		newSortedHand = sort_hand(compHand);
		//for (int i = 0; i< newSortedHand.length; i++){
		//Comp7Icons[i] = new JLabel("", card_to_ImageIcon(compHand[i]), JLabel.CENTER);
		//}

		compSelect[0] = newSortedHand[0];
		Comp7Icons[5] = new JLabel("", card_to_ImageIcon(compSelect[0]), JLabel.CENTER);
		p18.add(Comp7Icons[5]);
		compSelect[1] = newSortedHand[1];
		Comp7Icons[6] = new JLabel("", card_to_ImageIcon(compSelect[1]), JLabel.CENTER);
		p19.add(Comp7Icons[6]);

		//System.out.println("New computer hand: ");
		System.arraycopy(newSortedHand, 2, newCompHand, 0, 5);
		for (int i = 0; i <5; i++){
			Comp7Icons[i] = new JLabel("", card_to_ImageIcon(newCompHand[i]), JLabel.CENTER);
		}

		p11.add(Comp7Icons[0]);
		p12.add(Comp7Icons[1]);
		p13.add(Comp7Icons[2]);
		p14.add(Comp7Icons[3]);
		p15.add(Comp7Icons[4]);

	}

	public String produceWinnerofHand (int result1, int result2) { 
		//int result = compare_hands(newCompHand, newUserHand);
		if ((result1 == 1) & (result2 == 2)){
			userWins++;
			bank += 2*bet;
			return "You win!";

		} else if ((result1 == -1) & (result2 == -2)){
			compWins++;
			return "Computer Wins!";
		} else
			return "Tie!";
	}

	public static int identify_hand(int[][] hand){
		// consider that the hand is already sorted


		// 1-Straight flush
		if(hand[0][1]==hand[1][1] && hand[1][1]==hand[2][1] && hand[2][1]==hand[3][1] && hand[3][1]==hand[4][1] && // compare that they have the same suit 
				hand[0][0]+1==hand[1][0] && hand[1][0]+1==hand[2][0] && hand[2][0]+1==hand[3][0] && hand[3][0]+1==hand[4][0]) // compare card numbers
			return 1;


		// 2-four of a kind
		//   the cards are ordered, so the first or the last cards can be different
		if(hand[0][0]==hand[1][0] && hand[1][0]==hand[2][0] && hand[2][0]==hand[3][0]) // compare card numbers
			return 2;
		if(hand[1][0]==hand[2][0] && hand[2][0]==hand[3][0] && hand[3][0]==hand[4][0]) // compare card numbers
			return 2;


		// 3-full house: 3 of a kind + 2 of a kind
		//   the cards are ordered, so we can have 2 kinds of full houses: 3-2 or 2-3 
		if(hand[0][0]==hand[1][0] && hand[1][0]==hand[2][0] && hand[3][0]==hand[4][0]) // 3-2
			return 3;
		if(hand[0][0]==hand[1][0] && hand[2][0]==hand[3][0] && hand[3][0]==hand[4][0]) // 2-3
			return 3;


		// 4-flush: suit of all cards are the same
		if(hand[0][1]==hand[1][1] && hand[1][1]==hand[2][1] && hand[2][1]==hand[3][1] && hand[3][1]==hand[4][1])	// compare that they have the same suit
			return 4; //4-flush

		// 5-Straight
		if((hand[0][0]+1==hand[1][0]) && (hand[1][0]+1==hand[2][0]) && (hand[2][0]+1==hand[3][0]) && (hand[3][0]+1==hand[4][0])) // compare card numbers
			return 5;		


		// 6-three of a kind
		//   the cards are ordered, so we can have: 3-1-1 or 1-3-1 or 1-1-3
		if(hand[0][0]==hand[1][0] && hand[1][0]==hand[2][0]) // 3-1-1
			return 6;
		if(hand[1][0]==hand[2][0] && hand[2][0]==hand[3][0]) // 1-3-1
			return 6;
		if(hand[2][0]==hand[3][0] && hand[3][0]==hand[4][0]) // 3-1-1
			return 6;


		// 7-two pairs
		//   the cards are ordered, so we can have: 2-2-1 or 2-1-2 or 1-2-2
		if(hand[0][0]==hand[1][0] && hand[2][0]==hand[3][0]) // 2-2-1
			return 7;
		if(hand[0][0]==hand[1][0] && hand[3][0]==hand[4][0]) // 2-1-2
			return 7;
		if(hand[1][0]==hand[2][0] && hand[3][0]==hand[4][0]) // 1-2-2
			return 7;


		// 8-one pair
		//   the cards are ordered, so we can have: 2-1-1-1 or 1-2-1-1 or 1-1-2-1 or 1-1-1-2
		if(hand[0][0]==hand[1][0]) // 2-1-1-1 
			return 8;
		if(hand[1][0]==hand[2][0]) // 1-2-1-1
			return 8;
		if(hand[2][0]==hand[3][0]) // 1-1-2-1 
			return 8;
		if(hand[3][0]==hand[4][0]) // 1-1-1-2 
			return 8;

		//high card
		// 9-nothing
		return 9;
	}

	public static int compare_hands(int[][] hand1,int[][] hand2){
		//int pair_number1, pair_number2 = 0;
		int identify_hand1 = identify_hand(hand1);
		//print_identify_hand(identify_hand1);
		int identify_hand2 = identify_hand(hand2);
		//print_identify_hand(identify_hand2);

		if(identify_hand1<identify_hand2)
			return -1; 	//comp wins
		//comp hand has lower identity value

		else if(identify_hand1>identify_hand2)
			return 1; 	//user wins
		//comp has higher identity value 

		else{ // we have the same poker hand type
			// 1-straight flush
			if(identify_hand1==1){
				// identify the higher pair in hand1
				int pair_number1, pair_number2;
				pair_number1=hand1[4][0]; //get highest card
				pair_number2=hand2[4][0]; //get highest card
				if(pair_number1<pair_number2){ //if comp card value is lower than hum card value
					return 1; //user wins
				}else if(pair_number1>pair_number2){
					return -1;//comp wins
				}else{
					return 0;//tie
				}
			} else
				// 2-4 of a kind
				if(identify_hand1==2){
					// identify the higher pair in hand1
					int pair_number1, pair_number2;
					pair_number1=hand1[2][0];
					pair_number2=hand2[2][0];
					if(pair_number1<pair_number2){ // compare the card number
						return 1;
					}else if(pair_number1>pair_number2){
						return -1;
					}else{
						return 0;
					}
				} else
					// 3-full house: 3 of a kind + of a kind 2
					if(identify_hand1==3){
						// identify the higher pair in hand1
						int pair_number1, pair_number2;
						//int two_pair_number1, two_pair_number2;
						if(hand1[0][0]==hand1[1][0] && hand1[1][0]==hand1[2][0] && hand1[3][0]==hand1[4][0]){ // 3-2
							//3 of pair on top
							pair_number1=hand1[0][0];
							//two_pair_number1=hand1[3][0];
						} else { //2-3
							pair_number1=hand1[2][0];
							//two_pair_number1=hand1[0][0];
						}
						if(hand2[0][0]==hand2[1][0] && hand2[1][0]==hand2[2][0] && hand2[3][0]==hand2[4][0]){ // 3-2
							pair_number2=hand2[0][0];
							//two_pair_number2=hand2[3][0];
						} else { //2-3
							pair_number2=hand2[2][0];
							//two_pair_number2=hand2[0][0];
						}
						if(pair_number1<pair_number2){ // compare the card number
							return 1;
						}else if(pair_number1>pair_number2){
							return -1;
						}else{
							return 0;
						}
					} else
						// 4-flush
						if(identify_hand1==4){
							// identify the higher pair in hand1
							int pair_number1, pair_number2;
							pair_number1=hand1[4][0];
							pair_number2=hand2[4][0];
							if(pair_number1<pair_number2){ // compare the card number
								return 1;
							}else if(pair_number1>pair_number2){
								return -1;
							} else if (hand1[3][0]<hand2[3][0]){
								return 1;
							} else if (hand1[3][0]>hand2[3][0]){
								return -1;
							} else if (hand1[2][0]<hand2[2][0]){
								return 1;
							} else if (hand1[2][0]>hand2[2][0]){
								return -1;
							} else if (hand1[1][0]<hand2[1][0]){
								return 1;
							} else if (hand1[1][0]>hand2[1][0]){
								return -1;
							} else if (hand1[0][0]<hand2[0][0]){
								return 1;
							} else if (hand1[0][0]>hand2[0][0]){
								return -1;
							} else {
								return 0;
							}
						} else
							// 5-Straight
							if(identify_hand1==5){
								// identify the higher pair in hand1
								int pair_number1, pair_number2;
								pair_number1=hand1[4][0];
								pair_number2=hand2[4][0];
								if(pair_number1<pair_number2){ // compare the card number
									return 1;
								}else if(pair_number1>pair_number2){
									return -1;
								}else{
									return 0;
								}
							} else
								// 6-three of a kind
								if(identify_hand1==6){
									// identify the higher pair in hand1
									int pair_number1, pair_number2;
									pair_number1=hand1[2][0];
									pair_number2=hand2[2][0];
									if(pair_number1<pair_number2){ // compare the card number
										return 1;
									}else if(pair_number1>pair_number2){
										return -1;
									}else{
										return 0;
									}
								} else
									// 7-two pairs
									if(identify_hand1==7){
										// identify the higher pair in hand1
										int pair_number1, pair_number2;
										int two_pair_number1, two_pair_number2;
										pair_number1=hand1[3][0];
										two_pair_number1=hand1[1][0];
										pair_number2=hand2[3][0];
										two_pair_number2=hand2[1][0];
										if(pair_number1<pair_number2){ // compare the card number
											return 1;
										}else if(pair_number1>pair_number2){
											return -1;
										}else if (two_pair_number1<two_pair_number2){
											return 1;
										}else if (two_pair_number1>two_pair_number2){
											return -1;
										}else {
											return 0;
										}
									} else 
										// 8-one pair
										if(identify_hand1==8){
											// identify the pair one number
											int pair_number1, pair_number2;
											int r1_1, r2_1, r3_1, r1_2, r2_2, r3_2;

											if(hand1[0][0]==hand1[1][0]){ // 2-1-1-1 
												pair_number1=hand1[0][0];
												r1_1=hand1[4][0];
												r2_1=hand1[3][0];
												r3_1=hand1[2][0];
											} else if(hand1[1][0]==hand1[2][0]){ // 1-2-1-1
												pair_number1=hand1[1][0];
												r1_1=hand1[4][0];
												r2_1=hand1[3][0];
												r3_1=hand1[0][0];
											} else if(hand1[2][0]==hand1[3][0]){ // 1-1-2-1 
												pair_number1=hand1[2][0];
												r1_1=hand1[4][0];
												r2_1=hand1[1][0];
												r3_1=hand1[0][0];
											} else {
												pair_number1=hand1[3][0];
												r1_1=hand1[2][0];
												r2_1=hand1[1][0];
												r3_1=hand1[0][0];
											}
											// identify the pair 2 number
											if(hand2[0][0]==hand2[1][0]){ // 2-1-1-1 
												pair_number2=hand2[0][0];
												r1_2=hand2[4][0];
												r2_2=hand2[3][0];
												r3_2=hand2[2][0];
											} else if(hand2[1][0]==hand2[2][0]){ // 1-2-1-1
												pair_number2=hand2[1][0];
												r1_2=hand1[4][0];
												r2_2=hand1[3][0];
												r3_2=hand1[0][0];
											} else if(hand1[1][0]==hand1[2][0]){ // 1-2-1-1
												pair_number2=hand1[1][0];
												r1_2=hand2[4][0];
												r2_2=hand2[3][0];
												r3_2=hand2[0][0];
											} else {
												pair_number2=hand2[3][0];
												r1_2=hand2[2][0];
												r2_2=hand2[1][0];
												r3_2=hand2[0][0];
											}

											if(pair_number1<pair_number2){ // compare the card number
												return 1;
											}else if(pair_number1>pair_number2){
												return -1;
											}else { 
												if (r1_1<r1_2)
													return 1;
												else if (r1_1>r1_2) 
													return -1;
												else if (r2_1<r2_2)
													return 1;
												else if (r2_1>r2_2)
													return -1;
												else if (r3_1<r3_2)
													return 1;
												else if (r3_1>r3_2)
													return -1;
												else 
													return 0;
											}
										} else 
											// 9-high card
											if(identify_hand1==9){
												if(hand1[4][0]<hand2[4][0]){ // compare the card number
													return 1;
												}else if(hand1[4][0]>hand2[4][0]){
													return -1;
												}else{ // same card number - compare suite
													if(hand1[4][1]<hand2[4][1]){ // compare suite
														return 1;
													}else if(hand1[4][1]>hand2[4][1]){
														return -1;
													} else {	
														return 0;
													}
												}
											}
		}

		return 2;
	}

	public static void print_identify_hand(int identify_hand){
		if(identify_hand==1)
			System.out.print("(straight flush)");
		else if(identify_hand==2)
			System.out.print("(four of a kind)");
		else if(identify_hand==3)
			System.out.print("(full house)");
		else if(identify_hand==3)
			System.out.print("(four of a kind)");
		else if(identify_hand==4)
			System.out.print("(flush)");
		else if(identify_hand==5)
			System.out.print("(straight)");
		else if(identify_hand==6)
			System.out.print("(three of a kind)");
		else if(identify_hand==7)
			System.out.print("(two pairs)");
		else if(identify_hand==8)
			System.out.print("(one pair)");
		else
			System.out.print("(nothing - high hand comparison)");}

	public static int[][] removeTwoCards(int[][] Hand, String cardSelectedone, String cardSelectedtwo){
		int[][] newHand = new int[5][2];
		int card1Num = 0, card2Num = 0;

		switch (cardSelectedone){
		case "card0": card1Num = 0; break;
		case "card1": card1Num = 1; break;
		case "card2": card1Num = 2; break;
		case "card3": card1Num = 3; break;
		case "card4": card1Num = 4; break;
		case "card5": card1Num = 5; break;
		case "card6": card1Num = 6; break;}

		switch (cardSelectedtwo){
		case "card0": card2Num = 0; break;
		case "card1": card2Num = 1; break;
		case "card2": card2Num = 2; break;
		case "card3": card2Num = 3; break;
		case "card4": card2Num = 4; break;
		case "card5": card2Num = 5; break;
		case "card6": card2Num = 6; break;}


		userSelect[0] = Hand[card1Num];
		userSelect[1] = Hand[card2Num];

		if (card1Num < card2Num){
			if (card1Num == 0){
				System.arraycopy(Hand, 1, newHand, 0, card2Num - 1);
				System.arraycopy(Hand, card2Num+1, newHand, card2Num-1, newHand.length+ 1-card2Num);
			}else {
				System.arraycopy(Hand, 0, newHand, 0, card1Num);
				System.arraycopy(Hand, card1Num+1, newHand, card1Num, card2Num -card1Num-1);
				System.arraycopy(Hand, card2Num+1, newHand, card2Num-1, newHand.length + 1 - card2Num);
			}
		} else {
			if (card2Num == 0){
				System.arraycopy(Hand, 1, newHand, 0, card1Num - 1);
				System.arraycopy(Hand, card1Num+1, newHand, card1Num-1, newHand.length+ 1-card1Num);
			}else {
				System.arraycopy(Hand, 0, newHand, 0, card2Num);
				System.arraycopy(Hand, card2Num+1, newHand, card2Num, card1Num -card2Num-1);
				System.arraycopy(Hand, card1Num+1, newHand, card1Num-1, newHand.length + 1 - card1Num);
			}
		}
		for (int i = 0; i < newHand.length; i++){
		System.out.println(i + "-----" + newHand[i][0] + "-----" + newHand[i][1]);
		}
		//System.arraycopy(newHand, 0, newUserHand, 0, 5);
		return newHand;

	}

	public void displayNewHand(int[][] newHand){	//user hand
		int[][] sortednewHand = new int[5][2];
		p21.removeAll();
		p22.removeAll();
		p23.removeAll();
		p24.removeAll();
		p25.removeAll();
		p26.removeAll();
		p27.removeAll();

		sortednewHand = sort_hand(newHand);
		for (int i = 0; i < 5; i++){
			newHandIcon[i] = new JLabel("", card_to_ImageIcon(sortednewHand[i]), JLabel.CENTER);
		}

		p21.add(newHandIcon[0]);
		p22.add(newHandIcon[1]);
		p23.add(newHandIcon[2]);
		p24.add(newHandIcon[3]);
		p25.add(newHandIcon[4]);
	}

	public void refreshDisplay(String option){
		System.out.println("Option: " + option); //in console

		if ((option.equals("b310") || option.equals("b311") || option.equals("b312")
				|| option.equals("b313") || option.equals("b314"))){
			switch (option){
			case "b310": bet = 1; break;
			case "b311": bet = 2; break;
			case "b312": bet = 3; break;
			case "b313": bet = 4; break;
			case "b314": bet = 5; break;
			}
			l312.setText("Betting: $" + bet);	
			//state 0 = user chooses cards
			//setting and getter for string
		} else 
			
			if (option.equals("card0") && (state == 1)){
			p28.add(card0);
			cardSelectedone = "card0";
			state = 2;
		} else 
			
			if (option.equals("card1") && (state == 1)){
			p28.add(card1);
			cardSelectedone = "card1";
			state = 2;
		} else 
			
			if (option.equals("card2") && (state == 1)){
			p28.add(card2);
			cardSelectedone = "card2";
			state = 2;
		} else 
			
			if (option.equals("card3") && (state == 1)){
			p28.add(card3);
			cardSelectedone = "card3";
			state = 2;
		} else 
			
			if (option.equals("card4") && (state == 1)){
			p28.add(card4);
			cardSelectedone = "card4";
			state = 2;
		} else 
			
			if (option.equals("card5") && (state == 1)){
			p28.add(card5);
			cardSelectedone = "card5";
			state = 2;
		} else 
			
			if (option.equals("card6") && (state == 1)){
			p28.add(card6);
			cardSelectedone = "card6";
			state = 2;
		} else 
			
			if (option.equals("card0") && (state == 3)){
			p29.add(card0);
			cardSelectedtwo = "card0";
			state = 4;
		} else 
			
			if (option.equals("card1") && (state == 3)){
			p29.add(card1);
			cardSelectedtwo = "card1";
			state = 4;
		} else 
			
			if (option.equals("card2") && (state == 3)){
			p29.add(card2);
			cardSelectedtwo = "card2";
			state = 4;
		} else 
			
			if (option.equals("card3") && (state == 3)){
			p29.add(card3);
			cardSelectedtwo = "card3";
			state = 4;
		} else 
			
			if (option.equals("card4") && (state == 3)){
			p29.add(card4);
			cardSelectedtwo = "card4";
			state = 4;
		} else 
			
			if (option.equals("card5") && (state == 3)){
			p29.add(card5);
			cardSelectedtwo = "card5";
			state = 4;
		} else 
			
			if (option.equals("card6") && (state == 3)){
			p29.add(card6);
			cardSelectedtwo = "card6";
			state = 4;
		}else 
			
			if (option.equals("b32") && (state == 0)) {
			bank -= bet;
			state = 1;
			l33.setText("Instruction: Select the first of two cards.");
		} else 
			
			if (option.equals("b32") && (state == 2)) {
			l33.setText("Instruction: Select the second of two cards.");
			state = 3;
		} else 
			
			if (option.equals("b32") && (state == 4)) {
			int[][] newHand = removeTwoCards(userHand, cardSelectedone, cardSelectedtwo);
			displayNewHand(newHand);
			newUserHand = sort_hand(newHand);
			//System.arraycopy(newHand, 0, newUserHand, 0, 5);
			l33.setText("Instruction: Deal computer's hand and selected cards.");
			state = 5;
		} else 
			
			if (option.equals("b32") && (state == 5)) {
			displayCompHand();
			l33.setText("Instruction: Computer shows selected cards.");
			state = 6;
		} else 
			
			if (option.equals("b32") && (state == 6)) {
			int resultsofrighthand = compareSecondHand();
			int resultOfcomparehand = compare_hands(newCompHand, newUserHand);
			l33.setText(produceWinnerofHand(resultOfcomparehand, resultsofrighthand));
			l331.setText("Computer's wins: " + compWins);
			l333.setText("User's wins: " + userWins);
			pack();
			repaint();
			//l33.setText(produceWinnerofHand(compareHands));
			state = 7;
			//add score to panel
		}else 
			
			if (option.equals("b32") && (state == 7)) {
			l33.setText("Continue for next round (" + (round+1) + "/10).");
			state = 8;
			
		} else 
			
			if (option.equals("b32") && (state == 8)) {
			state = 0;
			round++;
			displayInitialUserHand();
			l33.setText("Instruction: Choose Bet Value.");
			if (round == 11){
				System.out.println("Game is finished!");
				System.exit(1);
			}

		} else {
			System.out.println("Invalid option: " + option);
		}
		l30.setText("Round " + round);
		l332.setText("Bank: $" + bank);
		repaint();
	}	

	public static ImageIcon card_to_ImageIcon(int[] c) { //public static ImageIcon card_to_ImageIcon(int[] c)
		//String fileString = "C:/Users/Limor/Documents/eclipse workspace/Final Project/src/images/Playing_card_";
		String fileString = "C:/Users/lshok/Documents/Code/SchoolWork/CS_101/images/Playing_card_";
		if (c[1] == 1) {
			fileString += "heart";
		} else if (c[1] == 2) {
			fileString += "diamond";
		} else if (c[1] == 3) {
			fileString += "club";
		} else {
			fileString += "spade";
		}

		fileString += "_";

		if ((c[0] >= 2) && (c[0] <= 10)) {
			fileString += c[0];
		} else if (c[0] == 11) {
			fileString += "J";
		} else if (c[0] == 12) {
			fileString += "Q";
		} else if (c[0] == 13) {
			fileString += "K";
		} else {
			fileString += "A";
		}
		fileString += ".jpg";
		ImageIcon card_image = new ImageIcon(fileString);

		return card_image;//fileString;//
	}
	
	public static int compare_2_cards(int[] card1, int[] card2){
		//[1] is number 
		if(card1[1]<card2[1])
			return -1;
		else if(card1[1]>card2[1])
			return 1;
		else{
			// the two cards are the same suit, so compare number
			if(card1[0]<card2[0])
				return -1;
			else if(card1[0]>card2[0])
				return 1;
			else 
				return 0; // the two cards are the same
		}
	}
}
