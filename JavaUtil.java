package commonUtils;

import java.util.Random;

public class JavaUtil
{
	public int getRandomNumber()
	{
		Random r=new Random();
		int ran = r.nextInt(800);
		return ran;
	}
}
