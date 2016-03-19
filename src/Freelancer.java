public class Freelancer extends Worker
{
	Freelancer()
	{
		salary_for_hour = 3;
		profesion = "Freelancer";
	}
	
	@Override
	public void working()
	{
		System.out.println("Freelancing");
	}	
}
