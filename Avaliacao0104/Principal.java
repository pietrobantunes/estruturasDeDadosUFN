package Avaliacao0104;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

// Verificar o ano que mais choveu e o mais quente
public class Principal {

    public static void main(String[] args) {

        List<Clima> lista = new ArrayList<>();
        String arquivo = "Avaliacao0104/dadosClimaticos.csv";

        // Leitura do CSV
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(arquivo))) {

            String linha;

            leitor.readLine(); // pula cabeçalho

            while ((linha = leitor.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");

                Clima c = new Clima(
                        partes[0],
                        partes[1],
                        partes[2],
                        partes[3]
                );

                // evita duplicados
                if (!lista.contains(c)) {
                    lista.add(c);
                }
            }

            // ===== PRINT DOS DADOS =====
            System.out.println("===== DADOS CLIMATICOS =====\n");

            for (Clima c : lista) {
                System.out.println(c);
            }

            // ===== CONTAGEM POR ANO =====
            Map<String, Integer> contagemChuva = new HashMap<>();
            Map<String, Integer> contagemQuente = new HashMap<>();

            for (Clima c : lista) {

                String ano = c.getAno();

                // conta meses com "muita" chuva
                if (c.getPrecipitacao().equalsIgnoreCase("muita")) {
                    int atual = contagemChuva.getOrDefault(ano, 0);
                    contagemChuva.put(ano, atual + 1);
                }

                // conta meses "quentes"
                if (c.getTemperatura().equalsIgnoreCase("quente")) {
                    int atual = contagemQuente.getOrDefault(ano, 0);
                    contagemQuente.put(ano, atual + 1);
                }
            }

            // ===== PRINT CONTAGEM =====
            System.out.println("\n===== CONTAGEM =====\n");

            System.out.println("Chuva (muita) por ano:");
            for (String ano : contagemChuva.keySet()) {
                System.out.println("Ano " + ano + ": " + contagemChuva.get(ano));
            }

            System.out.println("\nTemperatura quente por ano:");
            for (String ano : contagemQuente.keySet()) {
                System.out.println("Ano " + ano + ": " + contagemQuente.get(ano));
            }

            // ===== MAIOR CHUVA =====
            int maiorChuva = -1;
            List<String> anosMaisChuvosos = new ArrayList<>();

            for (int qtd : contagemChuva.values()) {
                if (qtd > maiorChuva) {
                    maiorChuva = qtd;
                }
            }

            for (Map.Entry<String, Integer> entry : contagemChuva.entrySet()) {
                if (entry.getValue() == maiorChuva) {
                    anosMaisChuvosos.add(entry.getKey());
                }
            }

            // ===== MAIS QUENTE =====
            int maiorQuente = -1;
            List<String> anosMaisQuentes = new ArrayList<>();

            for (int qtd : contagemQuente.values()) {
                if (qtd > maiorQuente) {
                    maiorQuente = qtd;
                }
            }

            for (Map.Entry<String, Integer> entry : contagemQuente.entrySet()) {
                if (entry.getValue() == maiorQuente) {
                    anosMaisQuentes.add(entry.getKey());
                }
            }

            // ===== RESULTADO FINAL =====
            System.out.println("\n===== RESULTADO FINAL =====\n");

            System.out.println("Ano(s) que mais choveu : " + anosMaisChuvosos + " (" + maiorChuva + ")");
            System.out.println("Ano(s) mais quente     : " + anosMaisQuentes + " (" + maiorQuente + ")");

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}