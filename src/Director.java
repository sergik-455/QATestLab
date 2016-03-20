import java.util.ArrayList;
import java.util.List;

public class Director extends Worker 
{
	Director()
	{
		salary_for_hour = 5;
		profesion = "Director";
		worked_hours = 160;
		name = "Main Boss";
	}

	// генерируем задания
	@SuppressWarnings("static-access")
	public List<Worker> create_new_task()
	{
		// Create tasks per 1 hours (min 20, max 40)
		int number_tasks = 0;

		//Get the only object available
		Random_number object = Random_number.getInstance(50, 100);
		number_tasks = object.number;

		//Generate type of tasks	
		List<Worker> list_tasks = new ArrayList<Worker>();
		Fabrica fab__tasks = new Fabrica();
		list_tasks = fab__tasks.create_list_tasks(number_tasks);
		return list_tasks;
	}

	// fixed salary
	int worker_salary()
	{
		return worked_hours * salary_for_hour;
	}
	@Override
	public void working()
	{
		System.out.println("Director working");
	}	
}
