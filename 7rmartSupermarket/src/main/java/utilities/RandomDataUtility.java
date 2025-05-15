package utilities;

import com.github.javafaker.Faker;

public class RandomDataUtility {
	Faker faker=new Faker();
	public String  createrandomusername()
	{
		return faker.name().username();
	}
	public String createrandompassword()
	{
		return faker.internet().password();
	}
	public String createrandomfullname()
	{
		return faker.name().fullName();
	}
	
	public String createrandomemail()
	{
		return faker.internet().emailAddress();
	}
	public String createrandomfulladdress()
	{
		return faker.address().fullAddress();
	}
	 public String createRandomProductCategory() {
			return faker.commerce().department();
	    	
	    }

}
