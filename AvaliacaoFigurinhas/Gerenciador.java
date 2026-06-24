import java.io.*;
import java.util.*;

public class Gerenciador {

    // Salvar lista no arquivo
    public static void salvar(String arquivo, List<Figura> lista) {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(arquivo));

            for (Figura f : lista) {
                pw.println(f.toCSV());
            }

            pw.close();

        } catch (Exception e) {
            System.out.println("Erro ao salvar arquivo");
        }
    }

    // Carregar lista do arquivo
    public static List<Figura> carregar(String arquivo) {

        List<Figura> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(arquivo));
            String linha;

            while ((linha = br.readLine()) != null) {
                lista.add(Figura.fromCSV(linha));
            }

            br.close();

        } catch (Exception e) {
            // Se não existir, ignora
        }

        return lista;
    }
}