import java.util.Random;

public class Director extends Worker 
{
	Director()
	{
		salary_for_hour = 5;
		profesion = "Director";
		worked_hours = 160;
		name = "Main Boss 0";
	}
	
	// ���������� �������
	public int generate_task()
	{
		//������� ��������� ����� ����� �� 10 �� 40 � � ����������� �� ����� ���������� ��������� ���������
		Random rand = new Random();
		int hours_task = rand.nextInt(31)+10;
		return hours_task;
	}
	
	// �������� ������������
	int worker_salary()
	{
		return worked_hours * salary_for_hour;
	}
}
