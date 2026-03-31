package Avaliacao0104;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Principal {

    static List<Clima> dados = new ArrayList<>();

    public static void main(String[] args) {

        String arquivo = "Avaliacao0104/dadosClimaticos.csv";

        carregarDados(arquivo);
        exibirDados();
        analisarEstacoes();
    }

    public static void carregarDados(String arquivo) {

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(arquivo), StandardCharsets.UTF_8))) {

            String linha;

            br.readLine();

            while ((linha = br.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");

                if (partes.length < 4) continue;

                int chuva = Clima.converterChuva(partes[3]);

                Clima c = new Clima(
                        partes[0],
                        partes[1],
                        partes[2],
                        chuva
                );

                if (!dados.contains(c)) {
                    dados.add(c);
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    public static void exibirDados() {

        System.out.println("===== DADOS CLIMATICOS =====\n");

        for (Clima c : dados) {
            System.out.println(c);
        }
    }

    public static void analisarEstacoes() {

        Map<String, List<Clima>> estacoes = new HashMap<>();

        estacoes.put("VERAO", new ArrayList<>());
        estacoes.put("OUTONO", new ArrayList<>());
        estacoes.put("INVERNO", new ArrayList<>());
        estacoes.put("PRIMAVERA", new ArrayList<>());

        for (Clima c : dados) {

            String mes = c.mes.toLowerCase();

            if (mes.equals("dezembro") || mes.equals("janeiro") || mes.equals("fevereiro")) {
                estacoes.get("VERAO").add(c);
            }
            else if (mes.equals("março") || mes.equals("marco") || mes.equals("abril") || mes.equals("maio")) {
                estacoes.get("OUTONO").add(c);
            }
            else if (mes.equals("junho") || mes.equals("julho") || mes.equals("agosto")) {
                estacoes.get("INVERNO").add(c);
            }
            else if (mes.equals("setembro") || mes.equals("outubro") || mes.equals("novembro")) {
                estacoes.get("PRIMAVERA").add(c);
            }
        }

        String maisChove = "";
        String menosChove = "";
        String maisQuente = "";
        String maisAmena = "";

        double maxChuva = -1;
        double minChuva = Double.MAX_VALUE;
        double maxTemp = -1;
        double minTemp = Double.MAX_VALUE;

        System.out.println("\n===== ANALISE DAS ESTACOES =====\n");

        for (String nome : estacoes.keySet()) {

            List<Clima> lista = estacoes.get(nome);

            if (lista.isEmpty()) {
                System.out.println(nome + " sem dados\n");
                continue;
            }

            int somaChuva = 0;
            int somaTemp = 0;

            for (Clima c : lista) {
                somaChuva += c.precipitacao;
                somaTemp += c.valorTemperatura();
            }

            double mediaChuva = (double) somaChuva / lista.size();
            double mediaTemp = (double) somaTemp / lista.size();

            String chuvaFormatada = String.format("%.3f", mediaChuva);
            String tempFormatada = String.format("%.3f", mediaTemp);

            System.out.println("----- " + nome + " -----");
            System.out.println("Media de chuva: " + chuvaFormatada);
            System.out.println("Media de temperatura: " + tempFormatada);
            System.out.println();

            if (mediaChuva > maxChuva) {
                maxChuva = mediaChuva;
                maisChove = nome;
            }

            if (mediaChuva < minChuva) {
                minChuva = mediaChuva;
                menosChove = nome;
            }

            if (mediaTemp > maxTemp) {
                maxTemp = mediaTemp;
                maisQuente = nome;
            }

            if (mediaTemp < minTemp) {
                minTemp = mediaTemp;
                maisAmena = nome;
            }
        }

        System.out.println("===== RESULTADO FINAL =====\n");

        System.out.println("Estacao que mais chove  : " + maisChove);
        System.out.println("Estacao que menos chove : " + menosChove);
        System.out.println("Estacao mais quente     : " + maisQuente);
        System.out.println("Estacao mais amena      : " + maisAmena);
    }
}