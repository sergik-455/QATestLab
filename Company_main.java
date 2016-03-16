
public class Company_main
{
	public static void main(String[] args) 
	{
		Company my_company = new Company();
		
		// генерируем количество сотрудников в компании от 10 до 100
		int number_workers = my_company.total_workers();
		//System.out.println(number_workers);
		
		//создаем n работников с разными професси€ми
		my_company.create_workers(number_workers);
		
		// компани€ выполн€ет всю работу
		my_company.do_work();
		
		//генерируем отчет за мес€ц и выводим в консоль
		System.out.println(my_company.report());
		
		//сохран€ем отчет на диск D:\\report.txt
		my_company.save_report(my_company.report());		
	}
}
