package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan = new Scanner(System.in); 
		
	System.out.println("How much money are you starting with?");
	double startAmount = scan.nextDouble();
	System.out.println("What is the win percentage of the game you will be playing?");
	double winChance = scan.nextDouble()/100.0;	
	System.out.println("What is your win limit for the day?");
	double winLimit = scan.nextDouble();
	System.out.println("How many days would you like to simulate?");
	double totalSimulations = scan.nextDouble();
	
	
	double currentMoney;
	int numWins = 0;
	int numLosses = 0;
	for (int i = 0; i < totalSimulations; i++)
	{
	currentMoney = startAmount ; 
	int plays =0; 
	while(currentMoney > 0 && currentMoney<winLimit)
	{ 
	double coinFlip = Math.random();
		if(coinFlip<winChance)
		{ currentMoney++ ;
		}
		else
		{currentMoney--;}
		plays++; 
	}
	if(currentMoney==0)
	{numLosses++;
	System.out.println("Day " + (i+1) + ": " + plays + " LOSE");
	}
	else
	{numWins++;
	System.out.println("Day " + (i+1) + ": " + plays + " WIN");
	}
	}
	System.out.println("Losses: "+ numLosses + "; Days: " + totalSimulations);
	double expRuin;
	if (winChance==0.5)
	{expRuin = 1.0-(startAmount/winLimit);
	}
	else
	{double alpha = (1.0-winChance)/winChance;
	expRuin = (Math.pow(alpha,startAmount)-Math.pow(alpha, winLimit))/(1.0-Math.pow(alpha, winLimit));
	}
	System.out.println("Ruin Rate from Simulation: " + (numLosses/(double)totalSimulations) + " Expected Ruin Rate: " + expRuin);
	}
}
