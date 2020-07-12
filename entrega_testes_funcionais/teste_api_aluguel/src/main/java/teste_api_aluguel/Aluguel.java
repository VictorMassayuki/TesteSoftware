package teste_api_aluguel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.*;
import org.json.simple.parser.JSONParser;
import java.util.Scanner;


public class Aluguel {
	private double valor;
	private int dia;
	private double valor_calculado;
	
    public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public double getValor_calculado() {
		return valor_calculado;
	}
	public void setValor_calculado(double valor_calculado) {
		this.valor_calculado = valor_calculado;
	}
	
	public static void main(String args[]) throws IOException{

		System.out.println("Programa feito pelo Victor Massayuki Umehara");
		System.out.println("Este programa consome a API aluguebug");

		Scanner ler = new Scanner(System.in);

		System.out.println("Valor Nominal: ");
		double valorAluguel = ler.nextDouble(); 
		ler.nextLine();
		
		System.out.println("Dia: ");
		int dia = ler.nextInt();
		ler.nextLine();

        requisitarSite(valorAluguel, dia);
		
	}
	
	public static Double requisitarSite(double valorAluguel, int dia){
		JSONObject JSONreq = new JSONObject();
        JSONreq.put("valor_nominal", valorAluguel);
		JSONreq.put("dia", dia);

		String url;

        url = "https://aluguebug.herokuapp.com/calc?dados=" + JSONreq;
        
        try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();


			String JSONstr = "{" + response.toString().split("\\{")[1]+ response.toString().split("\\}")[0] + "}";
			JSONObject jobj = new JSONObject (JSONstr.replace("\\\"", ""));
			Double valor_calculado = (Double) jobj.get("valor_calculado");
            Aluguel aluguel = new Aluguel();
            aluguel.setValor(valorAluguel);
            aluguel.setDia(dia);
            aluguel.setValor_calculado(valor_calculado);
            return valor_calculado;
		} catch (Exception e) {
            return null;
            
		}
		
	}

}