package monster.controller;

import monster.model.MarshmallowMonster;

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
				
	}
}
