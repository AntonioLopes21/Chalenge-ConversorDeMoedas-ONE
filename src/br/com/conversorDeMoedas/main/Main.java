package br.com.conversorDeMoedas.main;

import br.com.conversorDeMoedas.models.DadosColetados;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        String chaveApi = "e37e255ffe5b060d354da314";
        Gson gson = new Gson();
        HttpClient client = HttpClient.newHttpClient();

        // Menu
        while (true) {
            System.out.println("*******************************************");
            System.out.println("Seja bem-vindo/a ao Conversor de Moeda <3");
            System.out.println("1 - Dólar >> Peso Argentino");
            System.out.println("2 - Peso Argentino >> Dólar");
            System.out.println("3 - Real Brasileiro >> Dólar");
            System.out.println("4 - Dólar >> YEN");
            System.out.println("5 - YEN >> Dólar");
            System.out.println("6 - Real Brasileiro >> YEN");
            System.out.println("7 - Sair");
            System.out.println("*******************************************");
            System.out.print("Escolha uma opção: ");

            int opcao = scan.nextInt();
            scan.nextLine(); // Limpar o buffer

            if (opcao == 7) {
                System.out.println("Saindo...");
                break;
            }

            String moedaBase = "";
            String moedaDestino = "";
            String url = "";

            switch (opcao) {
                case 1:
                    moedaBase = "USD";
                    moedaDestino = "ARS";
                    break;
                case 2:
                    moedaBase = "ARS";
                    moedaDestino = "USD";
                    break;
                case 3:
                    moedaBase = "BRL";
                    moedaDestino = "USD";
                    break;
                case 4:
                    moedaBase = "USD";
                    moedaDestino = "JPY";
                    break;
                case 5:
                    moedaBase = "JPY";
                    moedaDestino = "USD";
                    break;
                case 6:
                    moedaBase = "BRL";
                    moedaDestino = "JPY";
                    break;
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            url = "https://v6.exchangerate-api.com/v6/" + chaveApi + "/latest/" + moedaBase;

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                System.out.println("Erro na requisição: " + response.statusCode());
                break;
            }

            DadosColetados dados = gson.fromJson(response.body(), DadosColetados.class);
            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            double taxaDeConversao = conversionRates.get(moedaDestino).getAsDouble();

            System.out.println("Digite o valor a ser convertido: ");
            double valorParaConverter = scan.nextDouble();
            scan.nextLine();

            double valorConvertido = valorParaConverter * taxaDeConversao;

            System.out.println(valorParaConverter + " " + moedaBase + " equivale a " +
                    valorConvertido + " " + moedaDestino);

            try (FileWriter file = new FileWriter("MoedasRequisitadas.txt", true)) {
                file.write(response.body() + "\n");
            }
        }

        scan.close();
    }
}
