// LISTA DE DADOS DO TIPO OBJETO - GLICEMIA
import java.util.ArrayList;
import java.util.Scanner;

public class Principal{
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ArrayList<Glicemia> lista = new ArrayList<>();

        //alternativa 1
        Glicemia obj = new Glicemia(191, "11/03/2026", "08:00");
        lista.add(obj);

        //alternativa 2
        lista.add(new Glicemia(90, "11/03/2026", "11:00"));

        //alternativa 3
        int valor;
        String data, hora;
        for (int i = 0; i < 3; i++) {
            System.out.println("Digite o valor da glicemia:");
            valor = teclado.nextInt();
            teclado.nextLine(); // Limpar o buffer do teclado
            System.out.println("Digite a data da glicemia:");
            data = teclado.next();
            System.out.println("Digite a hora da glicemia:");
            hora = teclado.next();
            System.out.println("-----------------------------");
            
            lista.add(new Glicemia(valor, data, hora));
        }

        //exibir lista - Alternativa 1
        // for (int i = 0; i < lista.size(); i++) {
        //     System.out.println(lista.get(i).valor + " - " + lista.get(i).data + " - " + lista.get(i).hora);
        // }

        //exibir lista - Alternativa 2
        for (Glicemia item : lista) {
            System.out.println(item.valor + " - " + item.data + " - " + item.hora);
        }
        teclado.close();
    }
}