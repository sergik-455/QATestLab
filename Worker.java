
abstract class Worker 
{
	String name;
	String profesion;
	int hours;
	int salary_for_hour;
	int worked_hours;
	Worker() 
	{
		name = "Worker";
		hours = 160;
		salary_for_hour = 1;
		worked_hours = 0;
	}
	int working_hours()
	{
		return 160 - hours;
	}
	int worker_salary()
	{
		return worked_hours * salary_for_hour;
	}
	void working()
	{
	}
}
