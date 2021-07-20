package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Cofiguration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}	catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	
	public String getEmail()
	{
		String email=pro.getProperty("email");
		return email;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getfirefoxpath()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	public String getcountry()
	{
		String country=pro.getProperty("country");
		return country;
	}
	
	public String getname()
	{
		String name=pro.getProperty("name");
		return name;
	}
	
	public String getmobilenumber()
	{
		String mobilenumber=pro.getProperty("mobilenumber");
		return mobilenumber;
	}
	
	public String getzipcode()
	{
		String zipcode=pro.getProperty("zipcode");
		return zipcode;
	}
	
	public String getaddress()
	{
		String address=pro.getProperty("address");
		return address;
	}
	
	public String getcity()
	{
		String city=pro.getProperty("city");
		return city;
	}
	
	public String getstate()
	{
		String state=pro.getProperty("state");
		return state;
	}
	
	public String getdeliverytype()
	{
		String deliverytype=pro.getProperty("deliverytype");
		return deliverytype;
	}
	
	public String getPayment()
	{
		String Payment=pro.getProperty("Payment");
		return Payment;
	}
}
