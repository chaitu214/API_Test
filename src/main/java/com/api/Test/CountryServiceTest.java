package com.api.Test;

import java.util.Scanner;
import com.api.client.CapitalCityApiClient;

public class CountryServiceTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String exit = "";
		CapitalCityApiClient apiClient = new CapitalCityApiClient();
		while (!exit.equalsIgnoreCase("n")) {
			System.out.println("Enter Country Name:");
			String cityName = sc.next();
			//System.out.println("Enter expected Country name:");
			//String expectedCountryName = sc.nextLine();
			String name = apiClient.getCapitalCity(cityName);
			if (name.equalsIgnoreCase(""))
				System.out.println("Country Not Found, try to enter valid capital city name");
			else
				System.out.println("Capital City Name: " + name);
			System.out.println("Enter N to exit or any letter to proceed further");
			exit = sc.next();
		}
		sc.close();
	}
}


