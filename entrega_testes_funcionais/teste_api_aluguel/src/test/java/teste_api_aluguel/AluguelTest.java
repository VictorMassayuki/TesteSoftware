
package teste_api_aluguel;

import org.junit.jupiter.api.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONException;

public class AluguelTest {

	@Test
	public void testVMU() throws IOException{

		String url;

        JSONObject JSONreq = new JSONObject();
        JSONreq.put("valor_nominal", 900.00);
		JSONreq.put("dia", 1);

        url = "https://aluguebug.herokuapp.com/calc?dados=" + JSONreq;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
	}

	@Test
	public void test1VMU() throws IOException{

		String url;

        JSONObject JSONreq = new JSONObject();
        JSONreq.put("valor_nominal", 900.01);
		JSONreq.put("dia", 14);

        url = "https://aluguebug.herokuapp.com/calc?dados=" + JSONreq;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
	}

	@Test
	public void test2VMU() throws IOException{

		String url;

        JSONObject JSONreq = new JSONObject();
        JSONreq.put("valor_nominal", 899.99);
		JSONreq.put("dia", 25);

        url = "https://aluguebug.herokuapp.com/calc?dados=" + JSONreq;
		
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
	}

}