import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company
{
	private int counter_tasks = 0;//счетчик всех заданий

	// генерируем количество сотрудников в компании от 10 до 100
	public int generate_number_workers(int number_1, int number_2)
	{		
		int result = 0;
		Random_number random = new Random_number();
		result = random.random(number_1, number_2);	
		return result;
	}

	//создаем n работников с разными профессиями
	public List<Worker> create_workers(int number_workers)
	{
		//System.out.println("Serhii: public void create_workers(int number_workers) " + number_workers);
		List<Worker> list_workers_company = new ArrayList<Worker>();
		Fabrica_workers fw = new Fabrica_workers();
		list_workers_company = fw.create_list_workers(number_workers);

		return list_workers_company;
	}

	// компания выполняет всю работу
	public List<Worker> do_work(List<Worker> company_list_workers)
	{
		List<Worker> list_tasks = new ArrayList<Worker>();// лист заданий
		int tasks_per_hour = 0;// счетчик кол-ва заданий в 1 час что генерит директор
		Director director = new Director();
		//в цикле проходим весь месяц по часам каждый раз увеличивая число проработаных часов на 1. всего 160 часов
		// цикл на 4 недели
		for (int i = 1; i <= 4; i++) 
		{
			System.out.println("Serhii print:"  + " --------------Week---" + i + "--------");
			System.out.println("Serhii print: "  + "  List of completed tasks 1 week");
			//каждую неделю начисляем сотруднику 40 рабочих часов
			for (int j = 0; j < company_list_workers.size(); j++)
			{
				company_list_workers.get(j).hours_week = 40;
			}
			// цикл на 40 часов
			for (int j = 1; j <= 40; j++) 
			{
				// директор создает новое задание
				list_tasks = director.create_new_task();
				tasks_per_hour = list_tasks.size();
				counter_tasks += list_tasks.size();

				//берем таски и раздаем их сотрудникам
				for (int t = 0,clw = 0, counter = 0; t < tasks_per_hour; t++,clw++, counter ++)
				{
					//ищем доступного сотрудника в листе, если нет то переходим до другого
					if(list_tasks.get(t).available())
					{
						//когда заданий больше чем список работников сравниваем номер последнего элемента в листе и размером массива
						// если совпадают проходимся по списку заново
						if (company_list_workers.size() == counter) 
						{
							clw = 0;
							counter = 0;
						}
						if(company_list_workers.get(clw).getClass().equals(list_tasks.get(t).getClass()))
						{
							company_list_workers.get(clw).working();
						}	
					}
				}


			}
			Accountant ac = new Accountant();
			System.out.println(ac.create_week_report(company_list_workers));
			System.out.println("________________________________________________________________");
		}
		System.out.println("counter_tasks: " + counter_tasks);

		///////////////////////////////////////////////////////////////////////
		//если нехватает работников то генерим фрилансеров и отдаем им работу
//		if(counter_tasks > list_tasks.size() * 160)
//		{
//			List<Worker> list_freelancers_company = new ArrayList<Worker>();
//			//считаем кол-во оставшихся заданий и относительного этого формируем кол-во фрилансеров
//			int number_freelancers = 0;
//			int task_for_freelancers = counter_tasks-(list_tasks.size() * 160);// кол-во заданий для фрилансера
//			if (task_for_freelancers <= 40)
//			{
//				number_freelancers = 1;
//			}
//			else 
//			{
//				// костыль
//				if(0 == ((task_for_freelancers/40) % 2))
//				{
//					number_freelancers = (task_for_freelancers/40)  + 1;
//				}
//				else
//				{
//					number_freelancers = (task_for_freelancers/40)   ;
//				}
//			}
//
//			Fabrica_freelancers ff = new Fabrica_freelancers();
//			list_freelancers_company = ff.create_list_workers(number_freelancers);
//			company_list_workers.addAll(list_freelancers_company);
//
//		}


		///////////////////////////////////////////////////////////
		return company_list_workers;
	}

	/*----------генерируем отчет за месяц----------*/
	public String report(List<Worker> company_list_workers) throws IOException
	{	
		String report = "" ;
		Accountant accountant = new Accountant();
		report = accountant.create_monthly_report(company_list_workers);
		report += "Number of the completed tasks " + counter_tasks + "\n";

		// сохраняем наш отчет в текущей папке проэкта
		FileWriter writer = null;
		try
		{
			 writer = new FileWriter("report.txt", false);
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
		finally {
			writer.close();
		}
		return report;
	}

}
