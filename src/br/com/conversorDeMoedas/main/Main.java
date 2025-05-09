package br.com.conversorDeMoedas.main;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String resposta = "USD";
        try {
            // Setting URL
            String chaveApi = "e37e255ffe5b060d354da314";




            //início do programa
            do {
                String url_personalizada = "https://v6.exchangerate-api.com/v6/" + chaveApi + "latest/" + resposta;
                    // Making Request
                    URL url = new URL(url_personalizada);
                    HttpURLConnection request = (HttpURLConnection) url.openConnection();
                    request.connect();

                    // Convert to JSON
                    JsonParser jp = new JsonParser();
                    JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
                    JsonObject jsonobj = root.getAsJsonObject();

                    // Accessing object
                    String req_result = jsonobj.get("result").getAsString();System.out.println("Digite um código da moeda. Exemplo = ( USD para dólar)  ");
                resposta = scan.nextLine();

                FileWriter file = new FileWriter("MoedasRequisitadas.txt");
                file.write(req_result);
                file.close();

            } while (!resposta.equalsIgnoreCase("sair"));


        } catch (
                FileNotFoundException e) {
            System.out.println("Arquivo não encontrado:" + e.getMessage());

        }

    scan.close();
    }
}
