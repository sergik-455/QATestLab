import java.util.Random;

public class Director extends Worker 
{
	Director()
	{
		salary_for_hour = 5;
		profesion = "Director";
		worked_hours = 160;
		name = "Main Boss 0";
	}
	
	// генерируем задани€
	public int generate_task()
	{
		//√енерим случайное целое число от 10 до 40 и в зависимости от числа сотруднику назначаем профессию
		Random rand = new Random();
		int hours_task = rand.nextInt(31)+10;
		return hours_task;
	}
	
	// зарплата фиксирована€
	int worker_salary()
	{
		return worked_hours * salary_for_hour;
	}
}
