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
		
		myScanner.close(); //closes scanner to prevent memory leaks
	}
}
