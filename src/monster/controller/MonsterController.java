package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;

public class MonsterController
{
	private MonsterDisplay popup;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();		//MonsterDisplay() is owned by the MonsterCOntroller() construct
	}
	
	
	public void start()
	{
		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		popup.displayText(basic.toString());		//calls the toString method we've been using from MarhmallowMonster
		MarshmallowMonster kothan = new MarshmallowMonster("Kothan ", 8, 6, 2, false);
//		System.out.println(kothan);
		popup.displayText(kothan.toString());
//		System.out.println("I am feeling hungry, I am going to eat one of Kothan's arms" );
		popup.displayText("I am feeling hungery, I am going to eat one of Kothan's arms");
		kothan.setArmCount(kothan.getArmCount() - 1);
//		System.out.println(kothan);
		popup.displayText(kothan.toString());
		
		interactWithMonster(kothan);
				
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner= new Scanner(System.in);
//		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat. Please type in how many you want to eat. ");
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know haw many eyes you want to eat. Please type in how many you want to eat. ");	//have to use getResponse rather than displayText to get user input
		
		if(isValidInteger(response))
		{
			consumed = Integer.parseInt(response);
		}
		
		
//		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
//		System.out.println(currentMonster);
		popup.displayText(currentMonster.toString());
		
		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();		can do it this way
		int armEat = myScanner.nextInt();		//or use a new value if you want to record the value for another time else just reuse
		
		if(armEat == 0)			//== operator can only compare ints or booleans in Java
		{
//			System.out.println("Not hungry? oh so sad...");
			popup.displayText("Not hungry? oh so sad...");
		}
		else if(armEat < 0)
		{
//			System.out.println("Math/Reality is hard for you. It's impossible to eat a negative amount.");
			popup.displayText("Math/Reality is hard for you. It's impossible to eat a negative amount.");
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
//			System.out.println("You are not allowed to eat more arms than exist on him :( ");
			popup.displayText("You are not allowed to eat more arms than exist on him :( ");
		}
		else 
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
//			System.out.println("OK, now I have " + currentMonster.getArmCount());
			popup.displayText("OK, now I have" + currentMonster.getArmCount() );
		}
		
//		System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		popup.getResponse("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		
		
		double food = 0.0;
		String tentacleResponse = popup.getResponse("");
		if(isValidDouble(tentacleResponse))
		{
			food = Double.parseDouble(tentacleResponse);
		}
		
		if(food == currentMonster.getTentacleAmount()) 
		{
//			System.out.println("You ate all of his tentacles!!!");
			popup.displayText("You ate all of his tentacles!!!");
		}
		else
		{
//			System.out.println("More likely");
			popup.displayText("More likely");
		}
		
		//Uses many if/else if/else statements to make sure that 
		System.out.println("what color would you like to paint the whtie monster? 1 for red, 2 Green, 3 for Blue, 4 White, 5 Black ");
		int userColor = myScanner.nextInt();
		
		if(userColor == 1 )
		{
			System.out.println("You throw red sugary color on it. It looks bright red! But then the body absorbs the sugar... ");
		}
		else if(userColor == 2 )
		{
			System.out.println("You throw green sugary color on it. It looks bright green! But then the body absorbs the sugar... ");
		}
		else if(userColor == 3 )
		{
			System.out.println("You throw blue sugary color on it. It looks bright blue! But then the body absorbs the sugar... ");
		}
		else if(userColor == 4 )
		{
			System.out.println("You throw white sugary color on it. It's already white but it seems to appreciate it... before eating it. ");
		}
		else if(userColor == 5 )
		{
			System.out.println("You throw black sugary color on it. It rises and puffs up trying to look scary. But he just looks sweet as the sugar is absorbed into him... ");
		}
		//more else if/else statements to prevent errors
		if(userColor != 1)
		{
			System.out.println("You did not choose a color number");
		}
		else if(userColor != 2)
		{
			System.out.println("You did not choose a color number");
		}
		
		else if(userColor != 3)
		{
			System.out.println("You did not choose a color number");
		}
		else if(userColor != 4)
		{
			System.out.println("You did not choose a color number");
		}
		else if(userColor != 5)
		{
			System.out.println("You did not choose a color number");
		}
		else
		{
			System.out.println("ERROR! Something has gone wrong with your selection. ");
		}
		
		popup.displayText("Hi there! Ready to play???");
		String response2 = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(response2);
		
		
		myScanner.close(); //closes scanner to prevent memory leaks
	}
	
	//Helper methods
	private boolean isValidInteger(String sample)		//checks to see if user's entry is a valid integer
	{
		boolean valid = false;
		
		try 
		{
			Integer.parseInt(sample);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to input an int " + sample + " is not valid.");
		}
		
		return valid;
	}
	
	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;
		
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch(NumberFormatException error) 
		{
			popup.displayText("You need to typ a double - " + sampleDouble + "is not a valid answer.");
		}
		
		return valid;
	}
}
