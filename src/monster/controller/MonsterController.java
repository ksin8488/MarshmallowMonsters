package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;
import monster.view.MonsterDisplay;
import java.util.List;
import java.util.ArrayList;

public class MonsterController
{
	private MonsterDisplay popup;
	private List<MarshmallowMonster> monsterList;
	
	public MonsterController()
	{
		popup = new MonsterDisplay();		//MonsterDisplay() is owned by the MonsterCOntroller() construct
		monsterList = new ArrayList<MarshmallowMonster>();
	}
	
	
	public void start()
	{	//Demo of loops TAKE SCREENSHOT
		
//		int count = 0;
		
// 		WHILE loop
//		while(count < 10)
//		{
//			popup.displayText("Isn't he the coolest??!");
//			count +=2;
//		}

//		FOR loop
//		for(int loop = 0; loop < 10; loop += 1)		//execution amount = |start - end|/increment
//		{
//			popup.displayText("This is loop # " + (loop + 1) + " of ten");
//		}	//after closing squiggle the int loop no longer is visible. Only within the brackets
		
			
		
		
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
		
		monsterList.add(basic);
		monsterList.add(kothan);
		useList();
		
		interactWithMonster(kothan);
				
	}
	
	private void useList()
	{
		for (int index = 0; index < monsterList.size(); index++)
		{
			MarshmallowMonster currentMonster = monsterList.get(index);
			popup.displayText(currentMonster.getName());
			String updateName = popup.getResponse("What should my new name be?");
			currentMonster.setName(updateName);
			popup.displayText("My new name is " + currentMonster.getName());
		}
		
		for (MarshmallowMonster current : monsterList)	//does the same work as the for loop above starts doing
		{
			popup.displayText("My name is " + current.getName());
		}
	}
	
	private void interactWithMonster(MarshmallowMonster currentMonster)
	{
		Scanner myScanner= new Scanner(System.in);
//		System.out.println(currentMonster.getName() + " wants to know how many eyes you want to eat. Please type in how many you want to eat. ");
		int consumed = 0;
		String response = popup.getResponse(currentMonster.getName() + " wants to know haw many eyes you want to eat. Please type in how many you want to eat. ");	//have to use getResponse rather than displayText to get user input
		
		while(!isValidInteger(response))		//creates a statement that only terminates once the correct answer is given
		{
			popup.displayText("grrr type in a better answer next time");
			response = popup.getResponse("Type in a integer value!");
		}
		
		
//		if(isValidInteger(response))		No longer needed thanks to the while loop (worked like an if block with a loop)
//		{
//			consumed = Integer.parseInt(response);
//		}
		
		
//		int consumed = myScanner.nextInt();
		currentMonster.setEyeCount(currentMonster.getEyeCount() - consumed);
//		System.out.println(currentMonster);
		popup.displayText(currentMonster.toString());
		
//		System.out.println("How many arms are you interested in eating? I have " + currentMonster.getArmCount());
		String armResponse = popup.getResponse("How many arms are you interested in eating? He has " + currentMonster.getArmCount());
//		response = popup.getResponse("");		//catches the response so it doesn't disappear
		//consumed = myScanner.nextInt();		can do it this way
//		int armEat = myScanner.nextInt();		//or use a new value if you want to record the value for another time else just reuse
		int armEat = 0;
		
		while(!isValidInteger(armResponse))
		{
			popup.displayText("grrr type in good answer");
			armResponse = popup.getResponse("Type in an integer!");
		}
		armEat = Integer.parseInt(armResponse);		//sets the armEat amount to the response given
		
//		if(isValidInteger(armResponse))
//		{
//			armEat = Integer.parseInt(armResponse);
//		}
		
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
		String tentacleResponse = popup.getResponse("How many tentacles do you want to eat? I have " + currentMonster.getTentacleAmount());
		
		
		double food = 0.0;
		
		while(!isValidDouble(tentacleResponse))
		{
			popup.displayText("grr type the correct response!");
			tentacleResponse = popup.getResponse("Type in a valid Double!");
		}
		food = Double.parseDouble(tentacleResponse);
		
//		if(isValidDouble(tentacleResponse))
//		{
//			food = Double.parseDouble(tentacleResponse);
//		}
		
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
//		System.out.println("what color would you like to paint the white monster? 1 for red, 2 Green, 3 for Blue, 4 White, 5 Black ");
		String colorResponse = popup.getResponse("What color would you like to paint the white monster? 1 for red, 2 Green, 3 for Blue, 4 White, 5 Black ");
		int userColor = 0;
		 
		while(!isValidInteger(colorResponse))
		{
			popup.displayText("GRRR type the correct color number!");
			colorResponse = popup.getResponse("Type in a valid integer value! 1 for red, 2 Green, 3 for Blue, 4 White, 5 Black");
		}
		userColor = Integer.parseInt(colorResponse);
		
//		if(isValidInteger(colorResponse))
//		{
//			userColor = Integer.parseInt(colorResponse);
//		}
		
		if(userColor == 1 )
		{
//			System.out.println("You throw red sugary color on it. It looks bright red! But then the body absorbs the sugar... ");
			popup.displayText("You throw red sugary color on it. It looks bright red! But then the body absorbs the sugar... ");
		}
		else if(userColor == 2 )
		{
			System.out.println("You throw green sugary color on it. It looks bright green! But then the body absorbs the sugar... ");
			popup.displayText("You throw green sugary color on it. It looks bright green! But then the body absorbs the sugar... ");
		}
		else if(userColor == 3 )
		{
//			System.out.println("You throw blue sugary color on it. It looks bright blue! But then the body absorbs the sugar... ");
			popup.displayText("You throw blue sugary color on it. It looks bright blue! But then the body absorbs the sugar... ");
		}
		else if(userColor == 4 )
		{
//			System.out.println("You throw white sugary color on it. It's already white but it seems to appreciate it... before eating it. ");
			popup.displayText("You throw white sugary color on it. It's already white but it seems to appreciate it... before eating it. ");
		}
		else if(userColor == 5 )
		{
//			System.out.println("You throw black sugary color on it. It rises and puffs up trying to look scary. But he just looks sweet as the sugar is absorbed into him... ");
			popup.displayText("You throw black sugary color on it. It rises and puffs up trying to look scary. But he just looks sweet as the sugar is absorbed into him... ");
		}
		else
			popup.displayText("You did not type the correct color value and Kothan can't be painted");
		
		//DON'T NEED DUE TO HELPER METHODS
//		//more else if/else statements to prevent errors
//		if(userColor != 1)
//		{
////			System.out.println("You did not choose a color number");
//			popup.displayText("You did not choose a color number");
//		}
//		else if(userColor != 2)
//		{
////			System.out.println("You did not choose a color number");
//			popup.displayText("You did not choose a color number");
//		}
//		
//		else if(userColor != 3)
//		{
////			System.out.println("You did not choose a color number");
//			popup.displayText("You did not choose a color number");
//		}
//		else if(userColor != 4)
//		{
////			System.out.println("You did not choose a color number");
//			popup.displayText("You did not choose a color number");
//		}
//		else if(userColor != 5)
//		{
////			System.out.println("You did not choose a color number");
//			popup.displayText("You did not choose a color number");
//		}
//		else
//		{
////			System.out.println("ERROR! Something has gone wrong with your selection. ");
//			popup.displayText("ERROR! Something has gone wrong with your selection");
//		}
		
		popup.displayText("Hi there! Ready to play???");
		String questionResponse = popup.getResponse("What is the air speed of a coconut laden swallow that isn't coconut laden?");
//		System.out.println(response2);
		boolean correctAnswer = false;
		
		while(!isValidBoolean(questionResponse))
		{
			popup.displayText("Good sir/madam/other, please type in a valid response");
			questionResponse = popup.getResponse("Type the correct guess for the air speed of a cocunut laden swallow that isn't cocunt laden?");
		}
		
		if (questionResponse.equals("24"))
		{
			correctAnswer = true;
		}
		else
			popup.displayText("Sorry! You got the wrong answer. it was 24");
		
//		if(isValidBoolean(questionResponse))
//		{
//			popup.displayText("You got the answer! Congratz! Cheater.");
//		}
	
		
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
	
	private boolean isValidDouble(String sampleDouble)	//checks to see if user's entry is a valid double
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
	
	private boolean isValidBoolean(String sampleBoolean)	//checks to see if user's entry is a valid boolean
	{
		boolean valid = false;
		
		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch(NumberFormatException error)
		{
			popup.displayText("You need to type a boole- " + sampleBoolean + "is not a valid answer.");
		}
		return valid;
	}
}
