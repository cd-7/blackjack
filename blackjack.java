package com.blackjack;

import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        boolean run = true;
        int playerChips = 20000;
        System.out.println("Type Q to quit");
        System.out.println("Type Y to hit");
        System.out.println("Type N to stay");
        System.out.println("Type DD to double down");
        System.out.println();
        System.out.println("Your Chips: " + playerChips);
        Scanner scanner = new Scanner(System.in);

        while(true) {
            label172:
            while(run) {
                double dealerCardOne = (double)(Math.round(Math.random() * 9.0D) + 2L);
                double dealerCardTwo = (double)(Math.round(Math.random() * 9.0D) + 1L);
                double dealerCards = dealerCardOne + dealerCardTwo;
                boolean var10 = false;

                while(true) {
                    while(playerChips < 10) {
                        int buyInAmount = false;
                        System.out.println("Not enough chips.");
                        System.out.print("Buy More? (y, n): ");
                        String buyInAnswer = scanner.next();
                        if (!buyInAnswer.equals("y")) {
                            System.exit(0);
                        } else {
                            while(true) {
                                System.out.print("Amount (10 - 20000): ");
                                int buyInAmount = scanner.nextInt();
                                if (buyInAmount >= 10 && buyInAmount <= 20000) {
                                    playerChips += buyInAmount;
                                    System.out.println("+" + buyInAmount + " Chips");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                    break;
                                }

                                System.out.println("Please enter a buy-in amount between 10 - 20000.");
                            }
                        }
                    }

                    while(true) {
                        System.out.print("Your Bet (10 - 10000): ");
                        int bettingAmount = scanner.nextInt();
                        if (bettingAmount >= 10 && bettingAmount <= 15000) {
                            if (playerChips > bettingAmount) {
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
                                    String playerMove = "y";

                                    label161:
                                    while(true) {
                                        label159:
                                        while(true) {
                                            if (!playerMove.equals("y") || !(playerCards < 21.0D)) {
                                                break label161;
                                            }

                                            while(true) {
                                                while(true) {
                                                    System.out.print("Hit? (y, n, dd): ");
                                                    playerMove = scanner.next().toLowerCase();
                                                    if (!playerMove.equals("y") && !playerMove.equals("n") && !playerMove.equals("dd")) {
                                                        System.out.println("Please enter y, n, or dd.");
                                                    } else {
                                                        if (playerMove.equals("dd") && playerChips >= bettingAmount * 2 || playerMove.equals("y") || playerMove.equals("n")) {
                                                            if (playerMove.equals("y") && playerCards < 21.0D) {
                                                                playerCards = playerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                                                System.out.println("You: " + (int)playerCards);
                                                                if (playerCards == 21.0D) {
                                                                    while(true) {
                                                                        if (!(dealerCards < 17.0D)) {
                                                                            break label161;
                                                                        }

                                                                        dealerCards = dealerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                                                    }
                                                                }
                                                                continue label159;
                                                            }

                                                            if (playerMove.equals("dd") && playerCards < 21.0D && playerChips >= bettingAmount * 2) {
                                                                bettingAmount *= 2;
                                                                playerCards = playerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                                                System.out.println("You: " + (int)playerCards);

                                                                while(true) {
                                                                    if (!(dealerCards < 17.0D)) {
                                                                        break label161;
                                                                    }

                                                                    dealerCards = dealerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                                                }
                                                            }

                                                            if (playerMove.equals("n")) {
                                                                System.out.println("You: " + (int)playerCards);

                                                                while(true) {
                                                                    if (!(dealerCards < 17.0D)) {
                                                                        break label161;
                                                                    }

                                                                    dealerCards = dealerCards + (double)Math.round(Math.random() * 8.0D) + 2.0D;
                                                                }
                                                            }

                                                            if (playerMove.equals("q")) {
                                                                System.exit(0);
                                                            }
                                                            continue label159;
                                                        }

                                                        System.out.println("Not enough chips to double down.");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }

                                if (playerCards > 21.0D) {
                                    playerChips -= bettingAmount;
                                    System.out.println("Bust. You Lose.");
                                    System.out.println("-" + bettingAmount + " Chips");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                    continue label172;
                                }

                                if (dealerCards > 21.0D) {
                                    playerChips += bettingAmount;
                                    System.out.println("Dealer: " + (int)dealerCards);
                                    System.out.println("Dealer Busts. You Win!");
                                    System.out.println("+" + bettingAmount + " Chips");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                } else if (playerCards > dealerCards && playerCards <= 21.0D) {
                                    playerChips += bettingAmount;
                                    System.out.println("Dealer: " + (int)dealerCards);
                                    System.out.println("You Win!");
                                    System.out.println("+" + bettingAmount + " Chips");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                } else if (playerCards < dealerCards) {
                                    playerChips -= bettingAmount;
                                    System.out.println("Dealer: " + (int)dealerCards);
                                    System.out.println("You Lose.");
                                    System.out.println("-" + bettingAmount + " Chips");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                } else {
                                    System.out.println("Dealer: " + (int)dealerCards);
                                    System.out.println("Tie!");
                                    System.out.println();
                                    System.out.println("Your Chips: " + playerChips);
                                }
                                continue label172;
                            }

                            System.out.println("Not enough chips.");
                            break;
                        }

                        System.out.println("Please enter a bet between 10 and 10000.");
                    }
                }
            }

            return;
        }
    }
}
