import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company
{
	private int counter_tasks = 0;

	//Generate number workers in company (min 10, max 100)
	public int generate_number_workers(int number_1, int number_2)
	{		
		int result = 0;
		Random_number random = new Random_number();
		result = random.random(number_1, number_2);	
		return result;
	}

	//Create workers
	public List<Worker> create_workers(int number_workers)
	{
		List<Worker> list_workers_company = new ArrayList<Worker>();
		Fabrica_workers fw = new Fabrica_workers();
		list_workers_company = fw.create_list_workers(number_workers);

		return list_workers_company;
	}

	// the company performs all the work
	public List<Worker> do_work(List<Worker> company_list_workers)
	{
		List<Worker> list_tasks = new ArrayList<Worker>();
		int tasks_per_hour = 0;
		Director director = new Director();
		// Cycle for 4 weeks
		for (int i = 1; i <= 4; i++) 
		{
			System.out.println("Serhii print:"  + " --------------Week---" + i + "--------");
			System.out.println("Serhii print: "  + "  List of completed tasks 1 week");
			//Every week the employee receives 40 working hours
			for (int j = 0; j < company_list_workers.size(); j++)
			{
				company_list_workers.get(j).hours_week = 40;
			}
			// Cycle for 40 hours (one week)
			for (int j = 1; j <= 40; j++) 
			{
				// Director creates new task
				list_tasks = director.create_new_task();
				tasks_per_hour = list_tasks.size();
				counter_tasks += list_tasks.size();

				//Take task and give out to employees
				for (int t = 0,clw = 0, counter = 0; t < tasks_per_hour; t++,clw++, counter ++)
				{
					//looking a free employee 
					if(list_tasks.get(t).available())
					{
						// if list_task > company_list_workers do this
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

		return company_list_workers;
	}

	/*----------Generate report per month----------*/
	public String report(List<Worker> company_list_workers) throws IOException
	{	
		String report = "" ;
		Accountant accountant = new Accountant();
		report = accountant.create_monthly_report(company_list_workers);
		report += "Number of the completed tasks " + counter_tasks + "\n";

		FileWriter writer = null;
		try
		{
			writer = new FileWriter("report.txt", false);
			String text = report;
			writer.write(text);
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
