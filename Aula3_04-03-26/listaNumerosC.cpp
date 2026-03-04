#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

using namespace std;

#include "bibliotecaNumerosC.h"

int main(){

    vector<int> listanumeros;
    int quantidadenumeros;
    int faixainicial = 10;
    int faixafinal = 100;
    vector<int> listaresultado;

    cout << "Digite a quantidade de números que deseja adicionar à lista: ";
    cin >> quantidadenumeros;

    popularListaAleatoria(listanumeros, quantidadenumeros, faixainicial, faixafinal);

    copiarListaSemRep(listanumeros, listaresultado);
    exibirLista(listaresultado);


    return 0;
}