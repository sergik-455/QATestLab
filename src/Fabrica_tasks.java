import java.util.ArrayList;
import java.util.List;

public class Fabrica_tasks
{
	public List<Worker> create_list_workers(int number_workers)
	{
		ArrayList<Worker> list_workers = new ArrayList<Worker>();// лист сотрудников
		
		for (int i = 0; i < number_workers; i++)
		{
			Random_number my_random = new Random_number();
			
			//Генерим случайное целое число от 0 до 4 и в зависимости от числа сотруднику назначаем профессию
			switch(my_random.random(0, 4))
			{
			case 0: list_workers.add(new Programmer());
			list_workers.get(i).name = "Worker " + i;// указываем имя в виде числа
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
