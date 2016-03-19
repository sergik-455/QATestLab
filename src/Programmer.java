public class Programmer extends Worker 
{
	Programmer()
	{
		salary_for_hour = 4;
		profesion = "Programer";
	}
	
	@Override
	public void working()
	{
		hours = 1; //выставляем фиксирование время (1 час) для решения 1-го задания
		if(hours_week > 0)
		{
			hours_week -= hours;
			worked_hours += hours;
		}	
		System.out.println("PROGRAMMING");
	}
}
