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
import FourRowSolitaire.CardStack;
import FourRowSolitaire.Column;
import FourRowSolitaire.Deck;
import FourRowSolitaire.SingleCell;
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
		assertEquals(deckCards.get(39), heartAcePile.push(deckCards.get(39)));
		
		// check if we can add the 2 of hearts
		assertTrue(heartAcePile.isValidMove(deckCards.get(40)));
		
		// check if we can't move the 3 of hearts
		assertFalse(heartAcePile.isValidMove(deckCards.get(41)));
		
		// add the 2 of hearts then check if we can add 3 of hearts
		assertEquals(deckCards.get(40), heartAcePile.push(deckCards.get(40)));
		assertTrue(heartAcePile.isValidMove(deckCards.get(41)));
		
		// check if we can add 3 of spades
		assertFalse(heartAcePile.isValidMove(deckCards.get(3)));
	}
	
	@Test
	public void testSingleCell() {
		
		// create a single cell 
		SingleCell testSingle = new SingleCell();
		
		// can we add a card?
		assertTrue(testSingle.isValidMove(deckCards.get(1)));
		
		// add a card
		assertEquals(deckCards.get(1), testSingle.push(deckCards.get(1)));
		
		// we shouldn't be able to add any cards now
		assertFalse(testSingle.isValidMove(deckCards.get(2)));
	}
	
	// card stacks are stacks the assembled stacks inside the columns
	// we will need to check 
	@Test
	public void testCardStack() {
		
		// create a card stack
		CardStack testStack = new CardStack();
		
		// test if we can place a non-king card onto the empty stack
		assertFalse(testStack.isValidMove(deckCards.get(1)));
		
		// test if we can place a king onto an empty stack
		// remember testStack starts at 0 not 1, so kings are at position 12
		assertTrue(testStack.isValidMove(deckCards.get(12)));
		
		// add the king to the stack
		assertEquals(deckCards.get(12), testStack.push(deckCards.get(12)));
		
		// now test can we add the same suit queen
		assertFalse(testStack.isValidMove(deckCards.get(12)));
		
		// now test if can add an off-suit different color queen
		assertTrue(testStack.isValidMove(deckCards.get(37)));
		
		// place the card to the stack
		assertEquals(deckCards.get(37), testStack.push(deckCards.get(37)));
		
		// add a card to the stack via add method as if being dealt
		testStack.addCard(deckCards.get(40));
		
		// now check if that changes what will be accepted
		assertFalse(testStack.isValidMove(deckCards.get(41)));
	}
	
	@Test
	public void testColumn() {
		
		// create a new column
		Column testColumn = new Column();
		
		// test if we can place a non-king card onto the empty stack
		assertFalse(testColumn.isValidMove(deckCards.get(1)));
		
		// test if we can place a king onto an empty stack
		// remember testStack starts at 0 not 1, so kings are at position 12
		assertTrue(testColumn.isValidMove(deckCards.get(12)));
		
		// add the king to the stack
		assertEquals(deckCards.get(12), testColumn.push(deckCards.get(12)));
		
		// now test can we add the same suit queen
		assertFalse(testColumn.isValidMove(deckCards.get(12)));
		
		// now test if can add an off-suit different color queen
		assertTrue(testColumn.isValidMove(deckCards.get(37)));
		
		// place the card to the stack
		assertEquals(deckCards.get(37), testColumn.push(deckCards.get(37)));
		
		// add a card to the stack via add method as if being dealt
		testColumn.addCard(deckCards.get(40));
		
		// now check if that changes what will be accepted
		assertFalse(testColumn.isValidMove(deckCards.get(41)));
	}
}
