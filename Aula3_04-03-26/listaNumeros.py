#Importando as funções da biblioteca personalizada
from bibliotecaNumeros import lista_aleatoria, exibir_lista, copiar_lista_sem_replicados

#Declarando uma lista em Python
lista_numeros = []
quantidade_numeros = int(input("Digite a quantidade de números que deseja adicionar à lista: "))

#Definindo a faixa de números a serem adicionados
faixa_inicial = 10
faixa_final = 100

lista_aleatoria(lista_numeros, quantidade_numeros, faixa_inicial, faixa_final)

lista_resultado = []
copiar_lista_sem_replicados(lista_numeros, lista_resultado)
lista_resultado.sort() #Ordenando a lista resultado em ordem crescente
exibir_lista(lista_resultado)
