package br.com.conversorDeMoedas.models;

import java.util.Map;

public record DadosColetados(String base_code, Map<String, Double> conversion_rates){
}
