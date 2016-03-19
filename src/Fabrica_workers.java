import java.util.ArrayList;
import java.util.List;

public class Fabrica_workers
{
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
			Random_number my_random = new Random_number();

			switch(my_random.random(0, 4))
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
}
