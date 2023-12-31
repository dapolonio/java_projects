package edu.nyu.cs.dla9511;


/**
 * Q1: A variation of the game of Blackjack (20 pts).
 * 
 * Complete this program according to the instructions below.
 * 
 * In addition, replace NetID in edu.nyu.cs.NetID on the first line with your own NetID,
 * and rename the folder containing this piece of code with your NetID.
 * 

## Instructions
Complete this project, such that it allows a user to play a simplified version of the game of Blackjack against a virtual dealer.
In our simplified version of Blackjack, the play unfolds in order as follows:

1)  Two cards are dealt and displayed to the user.

2)  Two cards are dealt to the dealer, but these are secret and not displayed to the user.

3)  The user is prompted whether they would like an additional card (a "hit"). 
    - This question is repeated and the user may accept as many additional cards as they would like, 
      until they respond with the words "stand", "stop", or "pass". 
    - If the value of the cards exceeds 21 at any point during this process of accepting cards, 
      the user has "busted" and lost, and the game ends.

4)  Assuming the user has not busted, once the user stops accepting new cards, 
    the robotic dealer decides whether to accept as many additional cards as it wants. 

    You can have the robot dealer do this at random if you like, or you can develop an artificial intelligence algorithm of your choosing. 
    If the robot dealer's cards exceed 21 points during this process, the dealer has busted and lost, and the user wins.

5)  Assuming neither the user or dealer busted, then if the user's cards are higher in total value than the dealer's cards, the user wins. 
    Otherwise, the dealer wins.

6) Regardless of how the game ends, whether by a bust or by a win, the program MUST show the user what cards 
   they had and what cards the dealer had at the end of the game and announce the result of the game 
   (either there is a winner, a tie, or one of the players has bust.)


## Activity diagram
The following diagram located in ./images/blackjack_activity_diagram.png shows an overview of the flow of the game.


## Additional notes:
-   Do not worry about drawing the same card twice. Draw cards at random.
-   All "cards" are simply integer values from 2 through 10.
-   These rules are different from how Blackjack is played in casinos. Follow our version's rules.


## Sample output
The following are sample outputs from running the program with various outcomes. User responses are indicated 
on the same line as the program output for ease-of-reading only. In all cases, user input will actually appear on a separate line.

Your program's output should match these patterns.

#### Sample output: user stands, dealer stands
Welcome to Blackjack!
Your cards are: 2 and 4
Would you like to hit or stand? stand
The dealer stands.
The dealer's cards are: 8, 7
Dealer wins!


#### Sample output: dealer wins:
Welcome to Blackjack!
Your cards are: 3 and 7
Would you like to hit or stand? hit
Your cards are: 3, 7, and 4
Would you like to hit or stand? hit
Your cards are: 3, 7, 4, and 2
Would you like to hit or stand? stand
The dealer hits.
The dealer hits.
The dealer hits.
Your cards are: 3, 7, 4, and 2
The dealer's cards are: 8, 3, 4, 3, 3
Dealer wins!


#### Sample output: user wins:
Welcome to Blackjack!
Your cards are: 8 and 2
Would you like to hit or stand? hit
Your cards are: 8, 2, and 8
Would you like to hit or stand? stand
The dealer hits.
The dealer stands.
Your cards are: 8, 2, and 8
The dealer's cards are: 3, 3, and 7
You win!


#### Sample output: tie:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? stand
The dealer hits.
The dealer hits.
The dealer stands.
Your cards are: 5, 6, and 3
The dealer's cards are: 2, 6, 2, and 4
Tie!


#### Sample output: dealer busts:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? stand
The dealer hits.
The dealer stands.
Your cards are: 5, 6, and 3
The dealer's cards are: 8, 8, and 10
The dealer has bust!
You win!


#### Sample output: user busts:
Welcome to Blackjack!
Your cards are: 5 and 6
Would you like to hit or stand? hit
Your cards are: 5, 6, and 3
Would you like to hit or stand? hit
Your cards are: 5, 6, 3, and 10
You have bust!
The dealer's cards are: 5 and 7
Dealer wins!

 * 
 */


 import java.util.Scanner;
 import java.util.Random;
 
 public class Blackjack {
   public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     Random random = new Random();
     System.out.println("Welcome to Blackjack!");
 
     // create player and dealer hands
     int[] playerHand = new int[10]; // max hand size=10
     int[] dealerHand = new int[10];
     int playerHandSize = 0;
     int dealerHandSize = 0;
 
    // deal two cards to each player
     playerHand[playerHandSize++] = getRandomCard(random);
     playerHand[playerHandSize++] = getRandomCard(random);
 
     // deal two  cards to the dealer (one face up, one face down)
     dealerHand[dealerHandSize++] = getRandomCard(random);
     dealerHand[dealerHandSize++] = getRandomCard(random);
     int dealerFaceDownCard = getRandomCard(random);
 
     // display the players hand to them
     System.out.println("Your cards are: " + getHandAsString(playerHand, playerHandSize));
 
     // keep the game going until the player opts to stand 
     while (true) {
       System.out.print("Would you like to hit or stand? ");
       String userChoice = scanner.nextLine();
 
       if (userChoice.equalsIgnoreCase("hit")) {
         int newCard = getRandomCard(random);
         playerHand[playerHandSize++] = newCard;
         System.out.println("Your cards are: " + getHandAsString(playerHand, playerHandSize));
         
         // Check if the player busts
         if (getHandValue(playerHand, playerHandSize) > 21) {
           System.out.println("You have bust!");
          //  System.out.println("The dealer's face-down card was: " + dealerFaceDownCard);
           // to reveal the dealer's cards
           dealerHand[1] = dealerFaceDownCard;
           System.out.println("The dealer's cards are: " + getHandAsString(dealerHand, dealerHandSize));
           


           System.out.println("Dealer wins!");
           scanner.close();
           return;
         }
       } else if (userChoice.equalsIgnoreCase("stand")) {
         break;

       } else if (userChoice.equalsIgnoreCase("pass")) {
          // Handle passing (user skips their turn)
          break;

       } else {
         System.out.println("Invalid input. Please enter 'hit' or 'stand'.");
       }
     }
 
      // dealer's turn
      while (getHandValue(dealerHand, dealerHandSize) < 17) {
        
      
        Random randomGenerator = new Random();
        int decision = randomGenerator.nextInt(2) + 1; // Generates a random number 1 or 2


        if (decision == 1) {
            
            // dealerHand[dealerHandSize++] = newCard;
            // System.out.println("The dealer's cards are: " + getHandAsString(dealerHand, dealerHandSize));
            int newCard = getRandomCard(randomGenerator); // generate a new random card
            dealerHand[dealerHandSize++] = newCard; // add the new card to the dealer's hand
            // System.out.println("The dealer has hit with card: " + newCard);
            System.out.println("The dealer has hit.");
        } else {
            System.out.println("The dealer stands.");
            break; // Dealer stands if the decision is 2
        }
  }
      
      // Dealer stands if their hand value is 17 or higher
      if (getHandValue(dealerHand, dealerHandSize) >= 17) {
          System.out.println("The dealer stands.");
      }
 
     // reveal dealer's face-down card
     dealerHand[1] = dealerFaceDownCard;
     System.out.println("The dealer's cards are: " + getHandAsString(dealerHand, dealerHandSize));

     // determine the winner by comparing total value of both hands
     int playerValue = getHandValue(playerHand, playerHandSize);
     int dealerValue = getHandValue(dealerHand, dealerHandSize);
     
//CHANGE to 1 to test output
     if (dealerValue > 21) {
      // System.out.println("this is a test of dealer hand" +  getHandAsString(dealerHand, dealerHandSize));
       System.out.println("The dealer has bust!");
       System.out.println("You win!");
     } else if (playerValue > dealerValue) {
       System.out.println("You win!");
     } else if (playerValue < dealerValue) {
       System.out.println("Dealer wins!");
     } else {
       System.out.println("Tie!");
     }
 
    
     scanner.close();
   }

   // method to get a random card (2-10)
   private static int getRandomCard(Random random) {
     return random.nextInt(9) + 2;
   }
 
   // method to calculate the value of a hand
   private static int getHandValue(int[] hand, int size) {
     int value = 0;
     int numAces = 0;
 
     for (int i = 0; i < size; i++) {
       int card = hand[i];
       if (card == 11 || card == 12 || card == 13) {
         // face cards (J, Q, K) are worth 10 points
         value += 10;
       } else if (card == 14) {
         // ace is worth 11 points, unless it causes a bust
         value += 11;
         numAces++;
       } else {
         value += card;
       }
     }
 
     // for aces
     while (value > 21 && numAces > 0) {
       value -= 10;
       numAces--;
     }
 
     return value;
   }
 
   // method to convert a hand to a readable string
   private static String getHandAsString(int[] hand, int size) {
    String result = "";
    for (int i = 0; i < size; i++) {
        result += hand[i];
        if (i < size - 1) {
            result += ", ";
        }
    }
    return result;
  }

 }
 
