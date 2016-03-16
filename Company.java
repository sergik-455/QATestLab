import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Company
{
	final int total_work_hours = 160;
	int total_hours_all_workers = 0;
	int counter_task = 0;
	int salary_all_workers = 0;
	int total_workers = 0;
	int total_freelancers = 0;
	int max_hours_all_workers = 0;// максимальное время всех рабочих (кол-во рабочих * 160 часов)

	ArrayList<Worker> list_workers = new ArrayList<Worker>();// лист сотрудников

	Director director = new Director();
	Accountant main_accountant = new Accountant();
	Manager main_manager = new Manager();

	// генерируем количество сотрудников в компании от 10 до 100
	public int total_workers()
	{
		int result = (int) (Math.random()*90+10);
		total_workers = result;
		max_hours_all_workers = result;
		return result;
	}

	//создаем n работников с разными профессиями
	public void create_workers(int number_workers)
	{
		// добавляем обязательных сотрудников (Директор, Менеджер и Бухгалтер)
		list_workers.add(director);
		list_workers.add(main_accountant);
		main_accountant.name = "Main_accountant 1";
		list_workers.add(main_manager);
		main_manager.name = "Main_manager 2";

		for (int i = 3; i <= number_workers; i++)
		{
			//Генерим случайное целое число от 0 до 4 и в зависимости от числа сотруднику назначаем профессию
			Random rand = new Random();
			int n = rand.nextInt(5);
			switch(n)
			{
			case 0: list_workers.add(new Programmer());
			list_workers.get(i).name = "Worker " + i;// указываем имя
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
	}

	// компания выполняет всю работу
	public void do_work()
	{
		//в цикле проходим весь месяц по часам каждый раз увеличивая число проработаных часов на 1. всего 160 часов
		for (int i = 0; i <=total_work_hours ; i++) 
		{
			// директор создает задания (10 - 20 шт), работники сами решают сколько нужно время на выполнения каждого задания (1 час или 2 часа)
			int task_hours = director.generate_task();
			//System.out.println("task_hours = " + task_hours );
			counter_task += task_hours;// считаем кол-во распоряжений

			// пробегаем по листу наших объектов и каждому доступному сотруднику даем работу
			for (int t = 0; t < list_workers.size(); t++)
			{
				// проверяем есть ли часы в задании, если нет то выходим из цикла
				if(0 == task_hours)
				{
					break;
				}
				//проверяем имеет ли работник доступное кол-во часов
				if( list_workers.get(t).hours <= 1)
				{
					continue;
				}
				else {
					//выполняем задания директора
					list_workers.get(t).working();
					--task_hours;
				}
			}		
			// если задания не выполнены добавляем фрилансеров
			if(task_hours > 0)
			{
				Freelancer freelancer = new Freelancer();
				list_workers.add(freelancer);			
				for (int t = 0; t < list_workers.size(); t++)
				{
					// проверяем есть ли часы в задании, если нет то выходим из цикла
					if(0 == task_hours)
					{
						break;
					}
					//проверяем имеет ли работник доступное кол-во часов
					if( list_workers.get(t).hours <= 1)
					{
						continue;
					}
					else {
						//выполняем задания директора
						list_workers.get(t).working();
						--task_hours;
					}
				}				
			}//-----end freelanc	
		}
	}

	/*----------генерируем отчет за месяц----------*/
	public String report()
	{
		int i = 0;// счетчик для нумерования списка в отчете
		String result = "" ;
		for (Worker item : list_workers) {
			++i;
			result += i + ") " + "worked_hours = " + item.worked_hours + " / " + "Name: " + item.name + " / " + "Profesion: " + item.profesion + " / " + "Salary per hour = " + item.salary_for_hour + " / " + "worker_salary = " + item.worker_salary() +"\n";
			salary_all_workers += item.worker_salary();
			total_hours_all_workers += item.worked_hours;
		}	
		total_freelancers = list_workers.size()- total_workers;
		result +="-----------------------------------------------------" + "\n";
		result += "Quantity of working in the company: " + total_workers + "\n"
				+ "Quantity of freelancers in the company: " + total_freelancers + "\n"
				+ "Amount of workers and freelancers: " + list_workers.size() + "(people)" + "\n"

				+ "Number of the completed tasks = " + counter_task + "\n"
				+ "Salary all workers = " + salary_all_workers + " Dollars" + "\n"
				+ "total_hours_all_workers = " + total_hours_all_workers + "(hours)";
		return result;
	}
	/*-----------сохраняем наш отчет в файл----------*/
	public void save_report(String report){
		try(FileWriter writer = new FileWriter("D:\\report.txt", false))
		{
			// запись всей строки
			String text = report;
			writer.write(text);
			// запись по символам
			writer.append('\n');
			writer.flush();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		} 
	}

}
