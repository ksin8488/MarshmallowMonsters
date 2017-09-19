package monster.controller;

import monster.model.MarshmallowMonster;
import java.util.Scanner;

public class MonsterController
{
	public void start()
	{
//		MarshmallowMonster basic = new MarshmallowMonster();
//		System.out.println(basic);
		MarshmallowMonster kothan = new MarshmallowMonster("Kothan ", 8, 6, 2, false);
		System.out.println(kothan);
		System.out.println("I am feeling hungery, I am going to eat one of Kothan's arms" );
		kothan.setArmCount(kothan.getArmCount() - 1);
		System.out.println(kothan);
		
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
			System.out.println("You are not allowed to eat more arms than exist on me :( ");
		}
		else 
		{
			currentMonster.setArmCount(currentMonster.getArmCount() - armEat);
			System.out.println("OK, now I have " + currentMonster.getArmCount());
		}
		
		myScanner.close(); //closes scanner to prevent memory leaks
	}
}
