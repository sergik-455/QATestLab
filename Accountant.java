import java.util.Random;

public class Accountant extends Worker 
{
	Accountant()
	{
		salary_for_hour = 4;
		profesion = "Accountant";
	}

	@Override
	public void working(){
		//программист сам решает сколько он будет выполнять задание
		Random rand = new Random();
		//Случайное целое число от 1 до 2
		int time_task = rand.nextInt(2)+1;
		hours -= time_task;
		worked_hours += time_task;
		System.out.println("COUNTING");
	}
}
