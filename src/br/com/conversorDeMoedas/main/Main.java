package br.com.conversorDeMoedas.main;

import br.com.conversorDeMoedas.models.DadosColetados;
import com.google.gson.Gson;
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
                String url_personalizada = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + resposta;
                    // Making Request
                    URL url = new URL(url_personalizada);
                    HttpURLConnection request = (HttpURLConnection) url.openConnection();
                    request.connect();

                    // Convert to JSON
                Gson gson = new Gson();
                DadosColetados dados = gson.fromJson(new InputStreamReader(request.getInputStream()), DadosColetados.class);
                Double taxaConversao = dados.conversion_rates().get(resposta);

                // Exibindo o valor da conversão
                if (taxaConversao != null) {
                    System.out.println("1 " + dados.base_code() + " equivale a " + taxaConversao + " " + resposta);
                } else {
                    System.out.println("A moeda " + resposta + " não foi encontrada.");
                }

                String dadosConvertidos = gson.toJson(dados);

                System.out.println("Digite um código da moeda. Exemplo = ( USD para dólar)  ");
                resposta = scan.nextLine().toUpperCase();



                FileWriter file = new FileWriter("MoedasRequisitadas.txt");
                file.write(dadosConvertidos);
                file.close();

            } while (!resposta.equalsIgnoreCase("sair"));


        } catch (
                FileNotFoundException e) {
            System.out.println("Arquivo não encontrado:" + e.getMessage());

        }

    scan.close();
    }
}
