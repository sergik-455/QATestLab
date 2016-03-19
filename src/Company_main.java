import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Company_main
{
	public static void main(String[] args) throws IOException 
	{
		Company my_company = new Company();
		
		//Generate number workers in company (min 10, max 100)
		int number_workers = my_company.generate_number_workers(10, 100);
		
		//Create workers
		List<Worker> list_workers = new ArrayList<Worker>();
		list_workers = my_company.create_workers(number_workers);
		
		//Do all the work and generate report per month
		System.out.println("Serhii print: Do all the work and generate report per month" + "\n" 
		+ my_company.report(my_company.do_work(list_workers)));		
	}
}
