import java.util.ArrayList;
import java.util.List;
public class Fabrica_freelancers 
{
	public List<Worker> create_list_workers(int number_workers)
	{
		ArrayList<Worker> list_workers = new ArrayList<Worker>();		
		for (int i = 0; i < number_workers; i++)
		{
			list_workers.add(new Freelancer());
			list_workers.get(i).name = "Freelancer " + i;
		}		
		return list_workers;
	}	
}
