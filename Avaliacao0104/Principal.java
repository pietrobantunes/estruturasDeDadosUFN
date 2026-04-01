package Avaliacao0104;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Classe principal responsável por ler os dados climáticos
 * de um arquivo CSV e analisar quais anos foram mais quentes
 * e com mais chuva.
 */
public class Principal {

    /**
     * Método principal que executa o programa.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {

        List<Clima> lista = new ArrayList<>();
        String arquivo = "Avaliacao0104/dadosClimaticos.csv";

        /**
         * Leitura do arquivo CSV contendo os dados climáticos.
         */
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(arquivo))) {

            String linha;

            leitor.readLine(); // pula cabeçalho

            while ((linha = leitor.readLine()) != null) {

                if (linha.trim().isEmpty()) continue;

                String[] partes = linha.split(",");

                /**
                 * Cria objeto Clima com os dados do CSV.
                 */
                Clima c = new Clima(
                        partes[0],
                        partes[1],
                        partes[2],
                        partes[3]
                );

                /**
                 * Evita adicionar dados duplicados na lista.
                 */
                if (!lista.contains(c)) {
                    lista.add(c);
                }
            }

            /**
             * Exibe todos os dados lidos.
             */
            System.out.println("===== DADOS CLIMATICOS =====\n");

            for (Clima c : lista) {
                System.out.println(c);
            }

            /**
             * Mapas para contar ocorrência de chuva e calor por ano.
             */
            Map<String, Integer> contagemChuva = new HashMap<>();
            Map<String, Integer> contagemQuente = new HashMap<>();

            for (Clima c : lista) {

                String ano = c.getAno();

                /**
                 * Conta meses com muita chuva.
                 */
                if (c.getPrecipitacao().equalsIgnoreCase("muita")) {
                    int atual = contagemChuva.getOrDefault(ano, 0);
                    contagemChuva.put(ano, atual + 1);
                }

                /**
                 * Conta meses quentes.
                 */
                if (c.getTemperatura().equalsIgnoreCase("quente")) {
                    int atual = contagemQuente.getOrDefault(ano, 0);
                    contagemQuente.put(ano, atual + 1);
                }
            }

            /**
             * Exibe contagem por ano.
             */
            System.out.println("\n===== CONTAGEM =====\n");

            System.out.println("Chuva (muita) por ano:");
            for (String ano : contagemChuva.keySet()) {
                System.out.println("Ano " + ano + ": " + contagemChuva.get(ano));
            }

            System.out.println("\nTemperatura quente por ano:");
            for (String ano : contagemQuente.keySet()) {
                System.out.println("Ano " + ano + ": " + contagemQuente.get(ano));
            }

            /**
             * Descobre o(s) ano(s) com mais chuva.
             */
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

            /**
             * Descobre o(s) ano(s) mais quentes.
             */
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

            /**
             * Exibe resultado final da análise.
             */
            System.out.println("\n===== RESULTADO FINAL =====\n");

            System.out.println("Ano(s) que mais choveu : " + anosMaisChuvosos + " (" + maiorChuva + ")");
            System.out.println("Ano(s) mais quente     : " + anosMaisQuentes + " (" + maiorQuente + ")");

        } catch (Exception e) {
            /**
             * Exibe erro caso o arquivo não seja lido.
             */
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }
}
