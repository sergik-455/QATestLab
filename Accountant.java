import java.util.Random;

public class Accountant extends Worker 
{
	Accountant()
	{
		salary_for_hour = 4;
		profesion = "Accountant";
	}

	@Override
	public void working(){
		//����������� ��� ������ ������� �� ����� ��������� �������
		Random rand = new Random();
		//��������� ����� ����� �� 1 �� 2
		int time_task = rand.nextInt(2)+1;
		hours -= time_task;
		worked_hours += time_task;
		System.out.println("COUNTING");
	}
}
