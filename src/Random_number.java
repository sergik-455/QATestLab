public class Random_number 
{
	//Генерим случайное целое число от number_min до number_max
	int random(int number_min,int number_max)
	{
		// Min + (int)(Math.random() * ((Max - Min) + 1))
		int number = number_min + (int)(Math.random() * ((number_max - number_min) + 1));
		return number;
	}
}
