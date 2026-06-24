// Classe da figurinha
public class Figura {

    String selecao;
    int numero;
    String descricao;
    int quantidade;
    boolean rara;

    // Construtor
    public Figura(String selecao, int numero, String descricao, int quantidade, boolean rara) {
        this.selecao = selecao;
        this.numero = numero;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.rara = rara;
    }

    // Converte para linha CSV
    public String toCSV() {
        return selecao + "," + numero + "," + descricao + "," + quantidade + "," + rara;
    }

    // Cria objeto a partir do CSV
    public static Figura fromCSV(String linha) {
        String[] p = linha.split(",");

        return new Figura(
            p[0],
            Integer.parseInt(p[1]),
            p[2],
            Integer.parseInt(p[3]),
            Boolean.parseBoolean(p[4])
        );
    }

    // Verifica se é a mesma figurinha
    public boolean igual(Figura f) {
        return this.numero == f.numero &&
               this.selecao.equalsIgnoreCase(f.selecao);
    }

    // Mostrar no console
    public String toString() {
        return selecao + " #" + numero + " - " + descricao + " Qtd:" + quantidade +
               (rara ? " (RARA)" : "");
    }
}