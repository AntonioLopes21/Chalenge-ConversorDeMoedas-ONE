package br.com.conversorDeMoedas.models;

import java.util.*;


//utilizar no refatoramento do desafio...
public class Conversor {
    private Double moedaParaConverter;
    private Double moedaConvertida;
    private Map<String, Double> dicionario = new HashMap<>();

    public Double getMoedaParaConverter() {
        return moedaParaConverter;
    }

    public void setMoedaParaConverter(Double moedaParaConverter) {
        this.moedaParaConverter = moedaParaConverter;
    }

    public Double getMoedaConvertida() {
        return moedaConvertida;
    }

    public void setMoedaConvertida(Double moedaConvertida) {
        this.moedaConvertida = moedaConvertida;
    }

    public Map<String, Double> getDicionario() {
        return dicionario;
    }

    public Conversor(Double moedaParaConverter, Double moedaConvertida) {
        this.moedaParaConverter = moedaParaConverter;
        this.moedaConvertida = moedaConvertida;



    }

    //https://v6.exchangerate-api.com/v6/YOUR-API-KEY/pair/USD/BRL/1
    //modelo de conversão direta
    public void exibirMenu() {

        System.out.println("*******************************************");
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda <3");
        System.out.println("1 - Dólar >> Peso Argentino");
        System.out.println("2 - Peso Argentino >> Dólar");
        System.out.println("3 - Real Brasileiro >> Dólar");
        System.out.println("4 - Dólar >> YEN");
        System.out.println("5 - YEN >> Dólar");
        System.out.println("6 - Real Brasileiro >> YEN");
        System.out.println("*******************************************");

    }

    public void dolarConvertidoReal () {

    }
}
