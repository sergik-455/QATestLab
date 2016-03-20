import java.util.ArrayList;
import java.util.List;

public class Fabrica
{
	@SuppressWarnings("static-access")
	public List<Worker> create_list_workers(int number_workers)
	{
		ArrayList<Worker> list_workers = new ArrayList<Worker>();

		// create the required staff (Manager, Director and Accountant)
		Worker director = new Director();
		Worker main_manager = new Manager();
		Worker main_accountant = new Accountant();

		// add to list
		list_workers.add(director);	

		list_workers.add(main_accountant);
		main_accountant.name = "Main_accountant";
		main_accountant.fixed_salary = 400;// fixed salary

		list_workers.add(main_manager);
		main_manager.name = "Main_manager";
		main_manager.fixed_salary = 400;// fixed salary

		for (int i = 3; i < number_workers; i++)
		{
			//Get the only object available
			Random_number object = Random_number.getInstance(0, 4);

			switch(object.number)
			{
			case 0: list_workers.add(new Programmer());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 1: list_workers.add(new Tester());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 2: list_workers.add(new Designer());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 3: list_workers.add(new Manager());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 4: list_workers.add(new Accountant());
			list_workers.get(i).name = "Worker " + i;
			break;
			}		
		}	
		return list_workers;
	}
	
	
	@SuppressWarnings("static-access")
	public List<Worker> create_list_tasks(int number_workers)
	{
		ArrayList<Worker> list_workers = new ArrayList<Worker>();
		
		for (int i = 0; i < number_workers; i++)
		{
			Random_number object = Random_number.getInstance(0, 4);
			switch(object.number)
			{
			case 0: list_workers.add(new Programmer());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 1: list_workers.add(new Tester());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 2: list_workers.add(new Designer());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 3: list_workers.add(new Manager());
			list_workers.get(i).name = "Worker " + i;
			break;
			case 4: list_workers.add(new Accountant());
			list_workers.get(i).name = "Worker " + i;
			break;
			}		
		}	
		
		return list_workers;
	}
	
	public List<Worker> create_list_freelancers(int number_workers)
	{
		ArrayList<Worker> list_workers = new ArrayList<Worker>();		
		for (int i = 0; i < number_workers; i++)
		{
			list_workers.add(new Freelancer());
			list_workers.get(i).name = "Freelancer ";
		}		
		return list_workers;
	}	
	
}
