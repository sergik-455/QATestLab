//Singleton
public final class Random_number
{
	private static Random_number _instance = null;
	static int number;

	Random_number()
	{
		number=0;
	}

	public static synchronized Random_number getInstance(int number_min,int number_max)
	{
		if (_instance == null)
			_instance = new Random_number();
		number = number_min + (int)(Math.random() * ((number_max - number_min) + 1));
		return _instance;
	}
}