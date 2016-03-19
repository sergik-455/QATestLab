
abstract class Worker 
{
	int hours_week;
	 String name;
	String profesion;
	int hours;
	int salary_for_hour;
	int worked_hours;
	 int fixed_salary;

	Worker() 
	{
		name = "Worker";
		hours = 160;
		salary_for_hour = 1;
		worked_hours = 0;
		hours_week = 40;
		fixed_salary = 0;
	}
	int working_hours()
	{
		return 160 - hours;
	}
	int worker_salary()
	{
		return worked_hours * salary_for_hour + fixed_salary;
	}
	void working()
	{
		//программист сам решает сколько он будет выполнять задание (2 или 1 час)
		//		Random_number rn = new Random_number();
		//		hours = rn.random(1, 2);
		//		hours_week -= hours;
		//		worked_hours += hours;
	}
	//когда заканчиваются рабочие часы то сотрудник становится недоступный
	boolean available()
	{
		boolean result = true;
		if (0 == hours_week) {
			result = false;
		}
		return result;
	}
}
