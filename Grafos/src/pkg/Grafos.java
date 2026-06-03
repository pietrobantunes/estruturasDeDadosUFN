package pkg;

import java.util.ArrayList;

class Grafos {
	int matrizADJ[][];
	int qtdVertices;
	ArrayList<String> vertices;
	
	public Grafos(ArrayList<String> vertices) {
		this.vertices = new ArrayList<>();
		this.vertices.addAll(vertices);
		this.qtdVertices = vertices.size();
		this.matrizADJ = new int [this.qtdVertices][this.qtdVertices];
		
		// inicializar matrizADJ com 0
		for (int i = 0; i < qtdVertices; i++) {
			for (int j = 0; j < qtdVertices; j++) {
				this.matrizADJ[i][j] = 0;
			}
		}
	}
	void mostrarMatriz() {
		for (String v : this.vertices) {
			System.out.print("    " + v);
		}
		System.out.println();
		
		for (int i = 0; i < qtdVertices; i++) {
			System.out.print(this.vertices.get(i) + "   ");
			for (int j = 0; j < qtdVertices; j++) {
				System.out.print(matrizADJ[i][j] + "    ");
			}
			System.out.println();
		}
	}
	void mostrarGrafo() {
		for(int i = 0; i < this.qtdVertices; i++) {
			System.out.print(this.vertices.get(i) + ":  ");
			for(int j = 0; j < this.qtdVertices; j++) {
				if (this.matrizADJ[i][j] != 0) {
					System.out.print(this.vertices.get(j) + "   ");
				}
			}
			System.out.println();
		}
	}
	void inserirAresta(int origem, int destino) {
		if (this.matrizADJ[origem][destino] == 0) {
		this.matrizADJ[origem][destino] = 1;
		}
	}
	void inserirArestaSimetrica(int origem, int destino) {
		
	}
}
