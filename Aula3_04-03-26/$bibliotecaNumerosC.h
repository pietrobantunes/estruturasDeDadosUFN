#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

/* Observe o símbolo & na frente da variável lista, isso acontece porque em C++ 
as funções recebem os parâmetros por valor, ou seja, uma cópia do valor é feita 
para a função. Se quisermos modificar a lista original passada como argumento, 
precisamos passar por referência usando o símbolo &. Isso permite que a função 
modifique diretamente a lista original, sem criar uma cópia dela.
*/

/**
 * @brief Função para popular uma lista com números aleatórios dentro de uma faixa específica.
 * 
 * @param lista A lista a ser populada com números aleatórios. 
 * @param quantidade A quantidade de números aleatórios a serem adicionados à lista. 
 * @param faixaInicial O valor mínimo da faixa para os números aleatórios. 
 * @param faixaFinal O valor máximo da faixa para os números aleatórios. 
 */
void popularListaAleatoria(vector<int> &lista, int quantidade, int faixaInicial, int faixaFinal) {

    srand(time(NULL)); 
    int numeroSorteado;

    for (int i = 0; i < quantidade; i++){
        numeroSorteado = rand() % (faixaFinal - faixaInicial + 1) + faixaInicial;
        lista.push_back(numeroSorteado);
    }                                                                                       
}

/**
 * @brief Função para exibir os elementos de uma lista de números inteiros.
 * 
 * @param lista A lista de números inteiros a ser exibida. 
 */

void exibirLista(const vector<int>& lista) {
    for (int i = 0; i < lista.size(); i++){
        cout << lista[i] << "\n";
    }

    cout << "-----------------------------\n";
    cout << "Total de elementos: " << lista.size() << "\n";
}

/**
 * @brief Método para copiar os elementos de uma lista original para uma nova lista, sem repetições.
 * 
 * @param listaOriginal A lista original de onde os elementos serão copiados.
 * @param listaResultado A nova lista onde os elementos únicos da lista original serão armazenados.
 */
void copiarListaSemRep(vector<int> &listaOriginal, vector<int> &listaResultado) {
    for (int i = 0; i < listaOriginal.size(); i++){
        bool encontrado = false;

        for (int j = 0; j < listaResultado.size(); j++){
            if (listaOriginal[i] == listaResultado[j]){
                encontrado = true;
                break;
            }
        }

        if (!encontrado){
            listaResultado.push_back(listaOriginal[i]);
        }
    }
}
