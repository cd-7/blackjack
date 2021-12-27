package com.blackjack;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        boolean run = true;
        System.out.println("Press Q to quit");
        System.out.println();

        while(true) {
            while(run) {
                double dealerCardOne = (double)(Math.round(Math.random() * 9.0D) + 2L);
                double dealerCardTwo = (double)(Math.round(Math.random() * 9.0D) + 1L);
                double dealerCards = dealerCardOne + dealerCardTwo;
                System.out.println("Dealer Cards: " + (int)dealerCardOne + ", ?");
                double playerCards = (double)(Math.round(Math.random() * 9.0D) + 2L + Math.round(Math.random() * 9.0D) + 1L);
                System.out.println("You: " + (int)playerCards);
                if (dealerCards == 21.0D && playerCards == 21.0D) {
                    System.out.println("Tie.");
                } else if (playerCards == 21.0D) {
                    System.out.println("You: " + (int)playerCards);
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("Blackjack! You Win!");
                } else if (dealerCards == 21.0D) {
                    System.out.println("You: " + (int)playerCards);
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("Blackjack... You Lose.");
                } else {
                    Scanner scanner = new Scanner(System.in);
                    String playerMove = "y";

                    label67:
                    while(true) {
                        while(true) {
                            if (!playerMove.equals("y") || !(playerCards < 21.0D)) {
                                break label67;
                            }

                            System.out.print("Hit? (y, n): ");
                            playerMove = scanner.next().toLowerCase();
                            if (playerMove.equals("y") && playerCards < 21.0D) {
                                playerCards = playerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                System.out.println("You: " + (int)playerCards);
                            } else {
                                if (playerMove.equals("n")) {
                                    System.out.println("You: " + (int)playerCards);

                                    while(true) {
                                        if (!(dealerCards < 17.0D)) {
                                            break label67;
                                        }

                                        dealerCards = dealerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                    }
                                }

                                if (playerMove.equals("q")) {
                                    System.exit(0);
                                }
                            }
                        }
                    }
                }

                if (playerCards > 21.0D) {
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("Bust. You Lose.");
                    System.out.println();
                } else if (dealerCards > 21.0D) {
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("Dealer Busts. You Win!");
                    System.out.println();
                } else if (playerCards > dealerCards && playerCards <= 21.0D) {
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("You Win!");
                    System.out.println();
                } else if (playerCards < dealerCards) {
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("You Lose.");
                    System.out.println();
                } else {
                    System.out.println("Dealer: " + (int)dealerCards);
                    System.out.println("Tie!");
                    System.out.println();
                }
            }

            return;
        }
    }
}
