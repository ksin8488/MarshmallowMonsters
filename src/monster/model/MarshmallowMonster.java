package monster.model;

public class MarshmallowMonster
{
	//Declaration section of data members
	
	private String name;
	private int eyeCount;
	private int armCount;
	private double tentacleAmount;
	private boolean hasBloop;
	
	//Default constructor (void turns it into a method which you DON'T want here)
	public MarshmallowMonster()
	{
		
	}
	
	//initializes everything to 0, false, or null. 
	public MarshmallowMonster(String name, int eyeCount, int arms, double tentacleCount, boolean hasBloop)	//names don't have to have a match. But it's a good idea to put them in order
	{
		this.name = name;	//Assigns to the class data member this.name the value of "name" (right to left/one way road)
		this.eyeCount = eyeCount;
		this.armCount = arms;
		this.tentacleAmount = tentacleCount;
		this.hasBloop = hasBloop;
			
	}
	
	//getter's to get the data members
	public String getName()
	{
		return name;
	}
		
	public int getEyeCount()
	{
		return eyeCount;
	}
	
	public int getArmCount()
	{
		return armCount;
	}
	
	public double getTentacleAmount()
	{
		return tentacleAmount;
	}
	
	public boolean hasBloop()
	{
		return hasBloop;
	}
	
	//Setters to set the data members
	public void setName(String name)
	{
		this.name = name;
	}

	public void setEyeCount(int eyeCount)
	{
		this.eyeCount = eyeCount;
	}
	
	public void setArmCount(int armCount)
	{
		this.armCount = armCount;
	}
	
	public void setTentcleAmount(double tentacleAmount)
	{
		this.tentacleAmount = tentacleAmount;
	}
	
	public void setBloop(boolean hasBloop)
	{
		this.hasBloop = hasBloop;
	}
	
	public String toString()
	{
		String description = "I am a horifying monster to behold named " + name + "with " + eyeCount + " eyes to stare into your soul.";
		description += " My " + tentacleAmount + " tentacle's will snatch you up if you get too close and my " + armCount + " arms will";
		description += " let me skitter closer and closer! And i will hunt you down with my " + hasBloop + " bloop. Hey! i'm a lot more intimidating than this sounds! ";
		
//		example of how to use all the data members in the description of the monster
//		String description = "I am a monster, my name is " + name + ", I have " + eyeCount + " eyes and only" ;	//command / comments and uncomment code
//		description += tentacleAmount + " tentacles but I have " + armCount + " arms! " + hasBloop + " tells you"; //description += says continue onto the string and keep adding
//		description += " if I have a bloop";	
		
		return description;
	}
	
	public String toString2()
	{
		String backstory = "A long time ago in the sugar mines of the chocolate beard men, there was a great monster that lurked in the tunnels. His name was Kothan the great. \\n";
		
		
		return backstory;
	}
	
}
