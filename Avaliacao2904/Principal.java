package Avaliacao2904;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Principal {

    public static void main(String[] args) {

        ArrayList<Aluno> lista = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("Avaliacao2904/alunos.csv"));
            String linha;

            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                String nome = dados[0];
                String curso = dados[1];
                String sexo = dados[2];
                int ano = Integer.parseInt(dados[3]);

                lista.add(new Aluno(nome, curso, sexo, ano));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Erro ao ler arquivo");
        }

        ordenarPorNome(lista);
        exibir(lista);

        ordenarPorAno(lista);
        exibir(lista);

        Aluno encontrado = buscarPorNome(lista, "Ana Silva");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado);
        }

        agregacaoPorAno(lista);
    }

    public static void ordenarPorNome(ArrayList<Aluno> lista) {
        Collections.sort(lista, Comparator.comparing(Aluno::getNome));
    }

    public static void ordenarPorAno(ArrayList<Aluno> lista) {
        Collections.sort(lista, Comparator.comparingInt(Aluno::getAnoIngresso));
    }

    public static Aluno buscarPorNome(ArrayList<Aluno> lista, String nome) {
        for (Aluno a : lista) {
            if (a.getNome().equals(nome)) {
                return a;
            }
        }
        return null;
    }

    public static void exibir(ArrayList<Aluno> lista) {
        for (Aluno a : lista) {
            System.out.println(a);
        }
        System.out.println();
    }

    public static void agregacaoPorAno(ArrayList<Aluno> lista) {
        HashMap<Integer, Integer> mapa = new HashMap<>();

        for (Aluno a : lista) {
            int ano = a.getAnoIngresso();
            mapa.put(ano, mapa.getOrDefault(ano, 0) + 1);
        }

        System.out.println("Alunos por ano:");
        for (Integer ano : mapa.keySet()) {
            System.out.println(ano + ": " + mapa.get(ano));
        }
    }
}