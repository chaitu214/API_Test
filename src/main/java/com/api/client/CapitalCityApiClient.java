package com.api.client;

import com.api.model.CapitalCity;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class CapitalCityApiClient {
	public String getCapitalCity(String name) {
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("https://restcountries.eu/rest/v2/name/" + name.replace(" ", "%20"));
			ClientResponse response = webResource.accept("application/json")
					.get(ClientResponse.class);
			if (response.getStatus() != 200) {
				return "";
			}
			String output = response.getEntity(String.class);
			Gson parser = new Gson();
			CapitalCity[] result = parser.fromJson(output, CapitalCity[].class);
			return result[0].getCapital();
		} catch (Exception e) {
			return "";
		}
	}
}
