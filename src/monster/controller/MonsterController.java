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
		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat. Please type in how many you want to eat. ");
		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
		System.out.println(currentMonster);
		
		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		//consumed = myScanner.nextInt();		can do it this way
		int armEat = myScanner.nextInt();		//or use a new value if you want to record the value for another time else just reuse
		
		if(armEat == 0)			//== operator can only compare ints or booleans in Java
		{
			System.out.println("Not hungry? oh so sad...");
		}
		else if(armEat < 0)
		{
			System.out.println("Math/Reality is hard for you. It's impossible to eat a negative amount.");
		}
		else if(armEat - currentMonster.getArmCount() > 0)
		{
			System.out.println("You are not allowed to eat more arms than exist on him :( ");
		}
		else 
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			System.out.println("OK, now I have " + currentMonster.getArmCount());
		}
		
		System.out.println("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		double food = myScanner.nextDouble();
		
		if(food == currentMonster.getTentacleAmount()) 
		{
			System.out.println("You ate all of his tentacles!!!");
		}
		else
		{
			System.out.println("More likely");
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
		String answer = popup.getResponse("What is the air speed of a coconut laden swallow?");
		System.out.println(answer);
		
		
		myScanner.close(); //closes scanner to prevent memory leaks
	}
}
