package com.crm.genericUtilities;

import io.restassured.response.Response;

public class restAssuredLibrary {
	/**
	 * this method will get the json data through json path fron response body
	 * @param response
	 * @param path
	 * @return
	 */
	
		public String getJsonData(Response response, String path)	{
			String jsonpath = response.jsonPath().get(path);
			return jsonpath;
			
	}
}

