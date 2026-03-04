import random

def lista_aleatoria(lista_numeros, quantidade_numeros, faixa_inicial, faixa_final):
    """Método que popula uma lista com números inteiros e aleatórios dentro de uma faixa.

    Args:
        lista_numeros (int): Armazenará os números inteiros e aleatórios.
        quantidade_numeros (int): Total de números a serem adicionados à lista.
        faixa_inicial (int): Número inicial da faixa.
        faixa_final (int): Número final da faixa.
    """
    for _ in range(quantidade_numeros):
        lista_numeros.append(random.randint(faixa_inicial, faixa_final))
    pass

def exibir_lista(lista_numeros):
    """Método que recebe uma lista de números inteiros e exibe seu conteúdo no console.

    Args:
        lista_numeros (int): Lista contendo os números inteiros a serem exibidos.
    """
    print("Elementos da lista: ", lista_numeros)
    print("-------------------------------")
    print("Total de elementos: ", len(lista_numeros))
    pass

def copiar_lista_sem_replicados(lista_numeros, lista_resultado):
    """Método que recebe ou copia o conteúdo da lista origem para dentro da lista destino, retirando os replicados.

    Args:
        lista_numeros (int): Lista contendo os números inteiros a serem copiados.
        lista_resultado (int): Lista que armazenará os números inteiros sem repetição.
    """
    for numero in lista_numeros:
        if numero not in lista_resultado:
            lista_resultado.append(numero)
    pass