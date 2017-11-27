package test;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import FourRowSolitaire.AcePile;
import FourRowSolitaire.Card;
import FourRowSolitaire.Deck;
/*
 * Testing validMove() methods of:
 * SingleCell.java
 * Column.java
 * AcePile.java
 * CardStack.java
 * 
 */
public class CardMoveTest {
	Deck testDeck;
	LinkedList<Card> deckCards;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		// set up an ace pile
		testDeck = new Deck(1, true);
		deckCards = testDeck.getDeck();
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAcePile() {

		// create the ace pile in the suite hearts
		AcePile heartAcePile = new AcePile("Hearts");
		
		// test if we can add the ace of spades
		assertFalse(heartAcePile.isValidMove(deckCards.get(1)));
		
		// test if we can add the two of hearts
		assertFalse(heartAcePile.isValidMove(deckCards.get(40)));
		
		// test if we can add the ace of hearts
		assertTrue(heartAcePile.isValidMove(deckCards.get(39)));
		
		
		// add the Ace of Hearts to the deck
		heartAcePile.push(deckCards.get(39));
		
		// check if we can add the 2 of hearts
		assertTrue(heartAcePile.isValidMove(deckCards.get(40)));
		
		// check if we can't move the 3 of hearts
		assertFalse(heartAcePile.isValidMove(deckCards.get(41)));
		
		// add the 2 of hearts then check if we can add 3 of hearts
		heartAcePile.push(deckCards.get(40));
		assertTrue(heartAcePile.isValidMove(deckCards.get(41)));
		
		// check if we can add 3 of spades
		assertFalse(heartAcePile.isValidMove(deckCards.get(3)));
	}

}
