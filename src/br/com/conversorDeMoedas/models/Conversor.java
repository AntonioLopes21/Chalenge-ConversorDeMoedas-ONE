package br.com.conversorDeMoedas.models;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

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
        System.out.println();
    }
}
