import java.util.ArrayList;

public class Splittar {
    public static void main(String[] args) {
        ArrayList<Glicemia> lista = new ArrayList<>();
        String linha = "159,23/02/2026,13:15";

        String vetorLinha[] = linha.split(",");

        Glicemia obj = new Glicemia(Integer.parseInt(vetorLinha[0]), vetorLinha[1], vetorLinha[2]);
        
        if(!lista.contains(obj)){
            lista.add(obj);
        }

        //exibir lista
        for (Glicemia item : lista) {
            System.out.println(item.valor + " - " + item.data + " - " + item.hora);
        }
    }
}