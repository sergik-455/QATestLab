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
	public List<Worker> create_new_task()
	{
		// Create tasks per 1 hours (min 20, max 40)
		int number_tasks = 0;
		Random_number rn = new Random_number();	
		number_tasks = rn.random(50, 100);

		//Generate type of tasks	
		List<Worker> list_tasks = new ArrayList<Worker>();
		Fabrica_tasks ft = new Fabrica_tasks();
		list_tasks = ft.create_list_workers(number_tasks);
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
