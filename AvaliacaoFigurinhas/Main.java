import java.util.*;

public class Main {

    static Scanner sc = new Scanner(System.in);

    // Listas principais
    static List<Figura> repetidas = new ArrayList<>();
    static List<Figura> desejadas = new ArrayList<>();

    public static void main(String[] args) {

        // Carrega arquivos ao iniciar
        repetidas = Gerenciador.carregar("figuras_repetidas_pessoais.csv");
        desejadas = Gerenciador.carregar("figuras_desejadas_pessoais.csv");

        int op;

        do {

            // Menu
            System.out.println("\nMENU");
            System.out.println("1 - Cadastrar repetidas");
            System.out.println("2 - Listar repetidas");
            System.out.println("3 - Cadastrar desejadas");
            System.out.println("4 - Listar desejadas");
            System.out.println("5 - Ver repetidas do OUTRO");
            System.out.println("6 - Ver desejadas do OUTRO");
            System.out.println("7 - Sair");

            op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    cadastrar(repetidas, "figuras_repetidas_pessoais.csv");
                    break;

                case 2:
                    System.out.println();
                    listar(repetidas);
                    break;

                case 3:
                    cadastrar(desejadas, "figuras_desejadas_pessoais.csv");
                    break;

                case 4:
                    System.out.println();
                    listar(desejadas);
                    break;

                case 5:
                    compararRepetidasOutro();
                    break;

                case 6:
                    compararDesejadasOutro();
                    break;
            }

        } while (op != 7);

        System.out.println("Saindo...");
    }

    // Cadastrar figurinha
    public static void cadastrar(List<Figura> lista, String arquivo) {

        System.out.print("Seleção: ");
        String sel = sc.nextLine();

        System.out.print("Número: ");
        int num = sc.nextInt();
        sc.nextLine();

        System.out.print("Descrição: ");
        String desc = sc.nextLine();

        System.out.print("Quantidade: ");
        int qtd = sc.nextInt();

        System.out.print("Rara (true/false): ");
        boolean rara = sc.nextBoolean();
        sc.nextLine();

        Figura f = new Figura(sel, num, desc, qtd, rara);

        lista.add(f);

        // Salva no CSV
        Gerenciador.salvar(arquivo, lista);

        System.out.println("Figura salva!");
    }

    // Listar figuras
    public static void listar(List<Figura> lista) {

        if (lista.isEmpty()) {
            System.out.println("Lista vazia.");
            return;
        }

        for (Figura f : lista) {
            System.out.println(f);
        }
    }

    // Opção 5
    public static void compararRepetidasOutro() {

        List<Figura> outra = Gerenciador.carregar("figuras_repetidas_outro.csv");

        System.out.println("\nRepetidas do outro:");
        listar(outra);

        System.out.println("\nMATCH (ele tem o que você quer):");

        for (Figura fOutro : outra) {
            for (Figura fMinha : desejadas) {

                if (fOutro.igual(fMinha)) {
                    System.out.println(fOutro);
                }
            }
        }
    }

    // Opção 6
    public static void compararDesejadasOutro() {

        List<Figura> outra = Gerenciador.carregar("figuras_desejadas_outro.csv");

        System.out.println("\nDesejadas do outro:");
        listar(outra);

        System.out.println("\nMATCH (você tem o que ele quer):");

        for (Figura fOutro : outra) {
            for (Figura fMinha : repetidas) {

                if (fOutro.igual(fMinha)) {
                    System.out.println(fOutro);
                }
            }
        }
    }
}