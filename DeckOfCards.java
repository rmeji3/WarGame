/*	Program Name:	DeckOfCards.java
	Programmer:		Kevin Walsh
	Date:			11/30/21

	This program will define a deck of cards.  Both a FULL DECK and
	a players hand.		*/

import java.util.ArrayList;
import java.util.ListIterator;
import java.lang.*;
import java.util.*;
import java.io.*;

public class DeckOfCards{

	// Instance Data
	ArrayList deck;

	// DefaultContructor -> doesnt do anything
	public DeckOfCards(){
		deck = new ArrayList();
	}

	// Second Constructor -> Build a FULL Deck of cards
	public DeckOfCards(boolean fullDeck){
		deck = new ArrayList();
		int suit;
		// use a loop to create the 52 cards
		for(int i = 0; i < 52; i++){
			// generate the suits H, D, C, S
			if(i < 13){
				suit = 0; // heart
			}else if(i < 26){
				suit = 1; // diamond
			}else if(i < 39){
				suit = 2; // club
			}else{
				suit = 3; // spade
			}

			deck.add(new PlayingCard((i + 1) % 13, suit));
		}
	}

	// Shuffle the deck
	public void shuffleDeck(){
		// Temporary deck to hold cards while shuffling
		ArrayList tempDeck = new ArrayList();

		// random card from deck
		int randomCard;

		// while loop to process the shuffling
		while(deck.size() != 0){ // run while there are cards inthe deck
			// pick our random card
			randomCard = MyMethods.getRandomInt(deck.size());
			// add the random card tothe temp deck
			tempDeck.add((PlayingCard)deck.get(randomCard));
			// remove teh card from the deck
			deck.remove(randomCard);
		}

		// put the shuffled cards back into deck
		// use a listIterator to process tempDeck
		ListIterator deckIterator = tempDeck.listIterator();

		while(deckIterator.hasNext()){
			deck.add((PlayingCard)deckIterator.next());
		}
	}

	// get top card from the deck
	public PlayingCard getTopCard(){
		PlayingCard temp = (PlayingCard)deck.get(0);
		deck.remove(0);
		return temp;
	}

	public void add(PlayingCard incomingCard){
		deck.add((PlayingCard)incomingCard); // Start here
	}

	public void clearDeck(){
		// create the list iterator
		ListIterator deckIterator = deck.listIterator();
		while(deckIterator.hasNext()){
			deck.remove(0);
		}
	}

	// print hidden deck (Back of Cards)
	public void printHidden(){
		ListIterator deckIterator = deck.listIterator();
		int i = 1;
		while(deckIterator.hasNext()){
			System.out.print("[" + i);
			i++;
			deckIterator.next();
		}
		System.out.print("]");
	}

	// Print the deck - ListIterator
	public void printDeck(){
		// create the list iterator
		ListIterator deckIterator = deck.listIterator();

		// use a while loop with list iterators
		int count = 0;
		while(deckIterator.hasNext()){
			if(count != 0 && count % 13 == 0)
				System.out.println();

			System.out.print(deckIterator.next());
			count++;
		}
		//System.out.println();
	}
}

