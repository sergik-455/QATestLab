
public class Company_main
{
	public static void main(String[] args) 
	{
		Company my_company = new Company();
		
		// ���������� ���������� ����������� � �������� �� 10 �� 100
		int number_workers = my_company.total_workers();
		//System.out.println(number_workers);
		
		//������� n ���������� � ������� �����������
		my_company.create_workers(number_workers);
		
		// �������� ��������� ��� ������
		my_company.do_work();
		
		//���������� ����� �� ����� � ������� � �������
		System.out.println(my_company.report());
		
		//��������� ����� �� ���� D:\\report.txt
		my_company.save_report(my_company.report());		
	}
}
