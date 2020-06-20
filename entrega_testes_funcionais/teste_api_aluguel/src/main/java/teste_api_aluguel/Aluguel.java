
package teste_api_aluguel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;
import org.json.JSONException;
import java.util.Scanner;

public class Aluguel {
	public static void main(String args[]) throws IOException{

		System.out.println("Programa feito pelo Victor Massayuki Umehara");
		System.out.println("Este programa consome a API aluguebug");

		String url;

		Scanner ler = new Scanner(System.in);

		System.out.println("Valor Nominal: ");
		double valorAluguel = ler.nextDouble(); 
		ler.nextLine();
		
		System.out.println("Dia: ");
		int dia = ler.nextInt();
		ler.nextLine();

        JSONObject JSONreq = new JSONObject();
        JSONreq.put("valor_nominal", valorAluguel);
		JSONreq.put("dia", dia);

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
		System.out.println(response);
		
	}

}