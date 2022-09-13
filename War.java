import java.util.ArrayList;
   import java.util.ListIterator;

   public class War{
	   public static void main(String args[]){

		   //Make decks
		   DeckOfCards warDeck = new DeckOfCards(true);
		   DeckOfCards player1, computer;
		   player1 = new DeckOfCards();
		   computer = new DeckOfCards();

		   //shuffle the deck
		   for(int i = 0; i < 10; i++){
		     warDeck.shuffleDeck();
   		  }

   		  //deal the cards
		    for(int i = 0; i < 26; i++){
		    player1.add((PlayingCard)warDeck.getTopCard());
		    computer.add((PlayingCard)warDeck.getTopCard());
   		}
   			int roundsPlayed = 0;
   			int roundsWon = 0;
   			int roundsTied = 0;
   			int roundsLost = 0;
   			String ctnPlay = "Y";
   			do{
			System.out.println("LETS PLAY WAR!!!");
   			System.out.println();
   			System.out.println();
			System.out.println("Player 1:" + "(" + player1.deck.size() + ")");
			player1.printDeck();
			System.out.println();
			System.out.println();
   			System.out.println("Computer:" + "(" + computer.deck.size() + ")");
   			computer.printDeck();
   			System.out.println();
   			System.out.println();

			roundsPlayed++;
   			//Gameplay

   			PlayingCard playTemp;
			PlayingCard compTemp;


				System.out.println("Your Card:");
   				playTemp = (PlayingCard)player1.getTopCard();
   				System.out.println(playTemp);

   				System.out.println("\nComputers Card:");
				compTemp = (PlayingCard)computer.getTopCard();
				System.out.println(compTemp);

				//compare the cards
				boolean win = false;
				boolean tie = false;
	if(playTemp.getFaceValue() > compTemp.getFaceValue()){
		System.out.println("You win!!!");
				win = true;
				tie = false;
			}else if(playTemp.getFaceValue() < compTemp.getFaceValue()){
				System.out.println("Computer wins!!");
				win = false;
				tie = false;
			}else{
				System.out.println("Tie!!");
				win = false;
				tie = true;
			}
			if(win){
				System.out.println();
				System.out.println("Round Result: " + playTemp + " > " + compTemp + " , you win, you get both cards!!");
				player1.add(playTemp);
				player1.add(compTemp);
				roundsWon++;
			}else if(!win && !tie){
				System.out.println();
				System.out.println("Round Result: " + compTemp + " > " +  playTemp + " , you lose, computer gets both cards!!");
				computer.add(playTemp);
				computer.add(compTemp);
				roundsLost++;
			}else{
				System.out.println();
				System.out.println("Round Result: " + playTemp + " = " + compTemp + " , you tie, you both get your cards back!!");
				player1.add(playTemp);
				computer.add(compTemp);
				roundsTied++;
			}
			ctnPlay = MyMethods.getString("Play again? Y or N: ");
					do{
						if(!ctnPlay.equalsIgnoreCase("Y") && !ctnPlay.equalsIgnoreCase("N")){
							System.out.println("Wrong Input");
							ctnPlay = MyMethods.getString("Play again? Y or N: ");
						}
				}while(!ctnPlay.equalsIgnoreCase("Y") && !ctnPlay.equalsIgnoreCase("N"));

				}while(ctnPlay.equalsIgnoreCase("Y"));

				System.out.println("\nGame Summary");
				System.out.println("Your Rounds Played: " + roundsPlayed);
				System.out.println("Your Rounds Won: " + roundsWon);
				System.out.println("Your Rounds Lost: " + roundsLost);
				System.out.println("YOur Rounds Tied: " + roundsTied);
				System.out.println("\nYour Card Count: " + player1.deck.size());
				System.out.println("Computer Card Count: " + computer.deck.size());




				if(player1.deck.size() > computer.deck.size()){
					System.out.println("Player wins since " + player1.deck.size() + " > " + computer.deck.size());
				}else if(player1.deck.size() == computer.deck.size()){
					System.out.println("Its a TIE since " + player1.deck.size() + " = " + computer.deck.size());

				}else{
					System.out.println("Computer wins since " +  computer.deck.size() + " < " +player1.deck.size());
				}








   		}
}