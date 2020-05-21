import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class RestSample {
	public static void POSTRequest() throws IOException {
	    final String POST_PARAMS = "{\r\n" + 
	    		"\"to\": \"anitha.payyavula97@gmail.com\",\r\n" + 
	    		"\"subject\": \"Hiii\",\r\n" + 
	    		"\"body\": \"Hello....\"\r\n" + 
	    		"}";
	    System.out.println(POST_PARAMS);
	    URL obj = new URL("https://my-json-server.typicode.com/anitha-payyavula/sample/posts");
	    HttpURLConnection postConnection = (HttpURLConnection) obj.openConnection();
	    postConnection.setRequestMethod("POST");
	    postConnection.setRequestProperty("userId", "anitha-payyavula");
	    postConnection.setRequestProperty("Content-Type", "application/json");
	    postConnection.setDoOutput(true);
	    OutputStream os = postConnection.getOutputStream();
	    os.write(POST_PARAMS.getBytes());
	    os.flush();
	    os.close();
	    int responseCode = postConnection.getResponseCode();
	    System.out.println("POST Response Code :  " + responseCode);
	    System.out.println("POST Response Message : " + postConnection.getResponseMessage());
	    if (responseCode == HttpURLConnection.HTTP_CREATED) { //success
	        BufferedReader in = new BufferedReader(new InputStreamReader(
	            postConnection.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in .readLine()) != null) {
	            response.append(inputLine);
	        } in .close();
	       
	        System.out.println(response.toString());
	    } else {
	        System.out.println("POST NOT WORKED");
	    }
	}

	public static String MyGETRequest() throws IOException {
	    URL urlForGetRequest = new URL("https://my-json-server.typicode.com/anitha-payyavula/sample/posts");
	    String readLine = null;
	    HttpURLConnection conection = (HttpURLConnection) urlForGetRequest.openConnection();
	    conection.setRequestMethod("GET");
	    String response ="";
	    conection.setRequestProperty("userId", "anitha-payyavula"); 
	    int responseCode = conection.getResponseCode();
	    if (responseCode == HttpURLConnection.HTTP_OK) {
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(conection.getInputStream()));
	        
	        while ((readLine = in .readLine()) != null) {
	            response+=readLine;
	        } in .close();
	   
	       System.out.println("JSON String Result " + response.toString());
	      
	      
	        
	    } else {
	        System.out.println("GET NOT WORKED");
	    }
	    return response.toString();
	}

	public static void main(String[] args) throws IOException {
		
	}

}
