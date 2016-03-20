import java.util.List;

public class Accountant extends Worker 
{
	Accountant()
	{
		salary_for_hour = 4;
		profesion = "Accountant";
	}

	@Override
	public void working()
	{
		hours = 1; 
		if(hours_week > 0)
		{
			hours_week -= hours;
			worked_hours += hours;
		}			
		System.out.println("COUNTING");
	}

	public String create_week_report(List<Worker> company_list_workers)
	{
		int i = 0;
		String result = "" ;
		for (Worker item : company_list_workers) {
			++i;
			result += i + ") " + "worked_hours = " + item.worked_hours + " / " + "Name: " + item.name 
					+ " / " + "Profesion: " + item.profesion + " / " + "Salary per hour = " 
					+ item.salary_for_hour + " / " + "worker_salary = " + item.worker_salary() 
					+ " / hours_week: " + item.hours_week +"\n";
		}	
		return result;
	}

	public String create_monthly_report(List<Worker> company_list_workers)
	{
		int i = 0;
		int salary_all_workers = 0;
		int total_hours_all_workers = 0;
		String result = "" ;
		for (Worker item : company_list_workers)
		{
			++i;
			result += i + ") " + "worked_hours = " + item.worked_hours + " / " + "Name: " 
			+ item.name + " / " + "Profesion: " + item.profesion + " / " + "Salary per hour = " 
			+ item.salary_for_hour + " / " + "worker_salary = " + item.worker_salary() +"\n";
			salary_all_workers += item.worker_salary();
			total_hours_all_workers += item.worked_hours;
		}			
		result += "salary_all_workers: " + salary_all_workers + "\n";
		result += "total_hours_all_workers: " + total_hours_all_workers + "\n";
		result += "Amount of workers and freelancers: " + company_list_workers.size() + "\n";
		return result;
	}
}
