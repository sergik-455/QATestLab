import java.util.Random;

public class Programmer extends Worker 
{
	Programmer()
	{
		salary_for_hour = 4;
		profesion = "Programer";
	}
	
	@Override
	public void working()
	{
		//����������� ��� ������ ������� �� ����� ��������� �������
		Random rand = new Random();
		//��������� ����� ����� �� 1 �� 2
		int time_task = rand.nextInt(2)+1;
		hours -= time_task;
		worked_hours += time_task;
		System.out.println("PROGRAMMING");
	}
}
