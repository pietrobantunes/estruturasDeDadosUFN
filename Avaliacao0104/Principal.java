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

        // ===== LEITURA DO ARQUIVO CSV =====
        // Lê cada linha do arquivo e cria objetos Clima
        // Pula a primeira linha (cabeçalho) e ignora linhas vazias
        try (BufferedReader leitor = new BufferedReader(
                new FileReader(arquivo))) {

            String linha;
            leitor.readLine(); // pula cabeçalho

            // Laço de leitura: processa cada linha até o final do arquivo
            while ((linha = leitor.readLine()) != null) {

                if (linha.trim().isEmpty()) continue; // ignora linhas vazias

                // Divide a linha pelos separadores (,)
                String[] partes = linha.split(",");

                // Cria um novo objeto Clima com os dados parseados
                Clima c = new Clima(partes[0], partes[1], partes[2], partes[3]);

                // Evita adicionar dados duplicados (mesmo ano e mês)
                if (!lista.contains(c)) {
                    lista.add(c);
                }
            }

            // ===== EXIBE TODOS OS DADOS LIDOS =====
            System.out.println("===== DADOS CLIMATICOS =====\n");

            for (Clima c : lista) {
                System.out.println(c);
            }

            // ===== ANÁLISE POR ANO =====
            // Conta quantos meses tiveram muita chuva e quantos foram quentes
            
            String[] anos = obterAnos(lista).toArray(new String[0]);
            
            System.out.println("\n===== CONTAGEM =====\n");
            System.out.println("Chuva (muita) por ano:");
            
            // Laço para contar chuva em cada ano
            for (String ano : anos) {
                int contagem = contarChuva(lista, ano);
                System.out.println("Ano " + ano + ": " + contagem);
            }

            System.out.println("\nTemperatura quente por ano:");
            
            // Laço para contar meses quentes em cada ano
            for (String ano : anos) {
                int contagem = contarQuente(lista, ano);
                System.out.println("Ano " + ano + ": " + contagem);
            }

            // ===== ENCONTRA O(S) ANO(S) COM MAIS CHUVA =====
            int maiorChuva = encontrarMaiorChuva(lista, anos);
            List<String> anosMaisChuvosos = encontrarAnosComChuva(lista, anos, maiorChuva);

            // ===== ENCONTRA O(S) ANO(S) MAIS QUENTE(S) =====
            int maiorQuente = encontrarMaiorQuente(lista, anos);
            List<String> anosMaisQuentes = encontrarAnosQuentes(lista, anos, maiorQuente);

            // ===== EXIBE RESULTADO FINAL =====
            System.out.println("\n===== RESULTADO FINAL =====\n");
            System.out.println("Ano(s) que mais choveu : " + anosMaisChuvosos + " (" + maiorChuva + ")");
            System.out.println("Ano(s) mais quente     : " + anosMaisQuentes + " (" + maiorQuente + ")");

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    }

    // ===== MÉTODOS AUXILIARES =====

    /**
     * Obtém uma lista com todos os anos únicos presentes nos dados.
     * 
     * @param lista Lista de dados climáticos.
     * @return Lista de anos únicos.
     */
    private static List<String> obterAnos(List<Clima> lista) {
        List<String> anos = new ArrayList<>();
        
        // Percorre todos os climas e adiciona cada ano único
        for (Clima c : lista) {
            if (!anos.contains(c.getAno())) {
                anos.add(c.getAno());
            }
        }
        return anos;
    }

    /**
     * Conta quantos meses do ano especificado tiveram muita chuva.
     * 
     * @param lista Lista de dados climáticos.
     * @param ano Ano a ser analisado.
     * @return Quantidade de meses com muita chuva.
     */
    private static int contarChuva(List<Clima> lista, String ano) {
        int contagem = 0;
        
        // Percorre todos os dados e incrementa contador para meses com muita chuva
        for (Clima c : lista) {
            if (c.getAno().equals(ano) && c.getPrecipitacao().equalsIgnoreCase("muita")) {
                contagem++;
            }
        }
        return contagem;
    }

    /**
     * Conta quantos meses do ano especificado foram quentes.
     * 
     * @param lista Lista de dados climáticos.
     * @param ano Ano a ser analisado.
     * @return Quantidade de meses quentes.
     */
    private static int contarQuente(List<Clima> lista, String ano) {
        int contagem = 0;
        
        // Percorre todos os dados e incrementa contador para meses quentes
        for (Clima c : lista) {
            if (c.getAno().equals(ano) && c.getTemperatura().equalsIgnoreCase("quente")) {
                contagem++;
            }
        }
        return contagem;
    }

    /**
     * Encontra a maior quantidade de chuva em qualquer ano.
     * 
     * @param lista Lista de dados climáticos.
     * @param anos Array de anos únicos.
     * @return Máxima quantidade de meses com muita chuva.
     */
    private static int encontrarMaiorChuva(List<Clima> lista, String[] anos) {
        int maior = 0;
        
        // Percorre cada ano e mantém o maior valor encontrado
        for (String ano : anos) {
            int contagem = contarChuva(lista, ano);
            if (contagem > maior) {
                maior = contagem;
            }
        }
        return maior;
    }

    /**
     * Encontra a maior temperatura em qualquer ano.
     * 
     * @param lista Lista de dados climáticos.
     * @param anos Array de anos únicos.
     * @return Máxima quantidade de meses quentes.
     */
    private static int encontrarMaiorQuente(List<Clima> lista, String[] anos) {
        int maior = 0;
        
        // Percorre cada ano e mantém o maior valor encontrado
        for (String ano : anos) {
            int contagem = contarQuente(lista, ano);
            if (contagem > maior) {
                maior = contagem;
            }
        }
        return maior;
    }

    /**
     * Encontra todos os anos que tiveram exatamente a maior chuva.
     * 
     * @param lista Lista de dados climáticos.
     * @param anos Array de anos únicos.
     * @param maiorChuva Valor máximo a comparar.
     * @return Lista de anos que atingiram o máximo de chuva.
     */
    private static List<String> encontrarAnosComChuva(List<Clima> lista, String[] anos, int maiorChuva) {
        List<String> resultado = new ArrayList<>();
        
        // Percorre cada ano e adiciona à lista se houver a quantidade máxima
        for (String ano : anos) {
            if (contarChuva(lista, ano) == maiorChuva) {
                resultado.add(ano);
            }
        }
        return resultado;
    }

    /**
     * Encontra todos os anos que foram mais quentes (máximo).
     * 
     * @param lista Lista de dados climáticos.
     * @param anos Array de anos únicos.
     * @param maiorQuente Valor máximo a comparar.
     * @return Lista de anos que atingiram o máximo de temperatura.
     */
    private static List<String> encontrarAnosQuentes(List<Clima> lista, String[] anos, int maiorQuente) {
        List<String> resultado = new ArrayList<>();
        
        // Percorre cada ano e adiciona à lista se houver a quantidade máxima
        for (String ano : anos) {
            if (contarQuente(lista, ano) == maiorQuente) {
                resultado.add(ano);
            }
        }
        return resultado;
    }
}
