#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(){
    setlocale(LC_ALL, "Portuguese");

    char nome[100];
    int boulosAlimentar;
    int quantidadeInsulinaMaxima;
    int carboidrato;

    int quantidadeInsulina;
    int quantidadeCarboidratoMaximo;
    int restanteInsulinaDia;
    int restanteCarboidratoDia;

    printf("Nome: ");
        gets(nome);

    printf("Boulos Alimentar: ");
        scanf("%d", &boulosAlimentar);

    printf("Quantidade de Insulina Máxima: ");
        scanf("%d", &quantidadeInsulinaMaxima);

    printf("Carboidrato: ");
        scanf("%d", &carboidrato);

    quantidadeInsulina = (int)carboidrato / boulosAlimentar;
    quantidadeCarboidratoMaximo = boulosAlimentar * quantidadeInsulinaMaxima;
    restanteInsulinaDia = quantidadeInsulinaMaxima - quantidadeInsulina;
    restanteCarboidratoDia = quantidadeCarboidratoMaximo - carboidrato;

    printf("\nQuantidade de insulina para esta refeição: %d\n", quantidadeInsulina);
    printf("Quantidade máxima de carboidrato dia: %d\n", quantidadeCarboidratoMaximo);
    printf("Ainda restam %d unidades de insulina no dia\n", restanteInsulinaDia);
    printf("Ainda restam %d\g de carboidrato no dia\n", restanteCarboidratoDia);

    return 0;
}
