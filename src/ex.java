
import java.net.URL;
import java.util.HashMap;
import okhttp3.HttpUrl;

public class ex {
	public static void main(String args[]) {
		 HashMap<String, String> whaturl = new HashMap<String, String>();
		    whaturl.put("email","anitha.payyavula97@gmail.com");
		    whaturl.put("password","Neeraj@1231");
		    String link1 = "http://www.gmail.com";
		    
		    

		    URL url = new HttpUrl.Builder()
		        .scheme("http")
		        .host("example.com")
		        .port(4567)
		        .addPathSegment("foldername/1234")
		        .addQueryParameter("abc", "xyz")
		        .build().url();
		    Utility.newRequest(link1,Utility.METHOD_POST,whaturl, new Utility.Callback() {
		        @Override
		        public void OnSuccess(String response) {
		           System.out.println("Server OnSuccess response="+response);
		        }
		        @Override
		        public void OnError(int status_code, String message) {
		              System.out.println("Server OnError status_code="+status_code+" message="+message);
		        }
		    });
	}

}
