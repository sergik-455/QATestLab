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
	int max_hours_all_workers = 0;// ������������ ����� ���� ������� (���-�� ������� * 160 �����)

	ArrayList<Worker> list_workers = new ArrayList<Worker>();// ���� �����������

	Director director = new Director();
	Accountant main_accountant = new Accountant();
	Manager main_manager = new Manager();

	// ���������� ���������� ����������� � �������� �� 10 �� 100
	public int total_workers()
	{
		int result = (int) (Math.random()*90+10);
		total_workers = result;
		max_hours_all_workers = result;
		return result;
	}

	//������� n ���������� � ������� �����������
	public void create_workers(int number_workers)
	{
		// ��������� ������������ ����������� (��������, �������� � ���������)
		list_workers.add(director);
		list_workers.add(main_accountant);
		main_accountant.name = "Main_accountant 1";
		list_workers.add(main_manager);
		main_manager.name = "Main_manager 2";

		for (int i = 3; i <= number_workers; i++)
		{
			//������� ��������� ����� ����� �� 0 �� 4 � � ����������� �� ����� ���������� ��������� ���������
			Random rand = new Random();
			int n = rand.nextInt(5);
			switch(n)
			{
			case 0: list_workers.add(new Programmer());
			list_workers.get(i).name = "Worker " + i;// ��������� ���
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

	// �������� ��������� ��� ������
	public void do_work()
	{
		//� ����� �������� ���� ����� �� ����� ������ ��� ���������� ����� ������������ ����� �� 1. ����� 160 �����
		for (int i = 0; i <=total_work_hours ; i++) 
		{
			// �������� ������� ������� (10 - 20 ��), ��������� ���� ������ ������� ����� ����� �� ���������� ������� ������� (1 ��� ��� 2 ����)
			int task_hours = director.generate_task();
			//System.out.println("task_hours = " + task_hours );
			counter_task += task_hours;// ������� ���-�� ������������

			// ��������� �� ����� ����� �������� � ������� ���������� ���������� ���� ������
			for (int t = 0; t < list_workers.size(); t++)
			{
				// ��������� ���� �� ���� � �������, ���� ��� �� ������� �� �����
				if(0 == task_hours)
				{
					break;
				}
				//��������� ����� �� �������� ��������� ���-�� �����
				if( list_workers.get(t).hours <= 1)
				{
					continue;
				}
				else {
					//��������� ������� ���������
					list_workers.get(t).working();
					--task_hours;
				}
			}		
			// ���� ������� �� ��������� ��������� �����������
			if(task_hours > 0)
			{
				Freelancer freelancer = new Freelancer();
				list_workers.add(freelancer);			
				for (int t = 0; t < list_workers.size(); t++)
				{
					// ��������� ���� �� ���� � �������, ���� ��� �� ������� �� �����
					if(0 == task_hours)
					{
						break;
					}
					//��������� ����� �� �������� ��������� ���-�� �����
					if( list_workers.get(t).hours <= 1)
					{
						continue;
					}
					else {
						//��������� ������� ���������
						list_workers.get(t).working();
						--task_hours;
					}
				}				
			}//-----end freelanc	
		}
	}

	/*----------���������� ����� �� �����----------*/
	public String report()
	{
		int i = 0;// ������� ��� ����������� ������ � ������
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
	/*-----------��������� ��� ����� � ����----------*/
	public void save_report(String report){
		try(FileWriter writer = new FileWriter("D:\\report.txt", false))
		{
			// ������ ���� ������
			String text = report;
			writer.write(text);
			// ������ �� ��������
			writer.append('\n');
			writer.flush();
		}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		} 
	}

}
