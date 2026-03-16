from Glicemia import Glicemia

def popular_lista_arquivo(linha, nome_base):
    #ler o arquivo e popular a lista com dados splitados
    leitor = open(nome_base, "r", encoding="utf8")

    for linha in leitor:
        vetor_linha = linha.split(",")
        obj = Glicemia(int(vetor_linha[0]), vetor_linha[1], vetor_linha[2])

        if obj not in linha:
            linha.append(obj)

    leitor.close()

def exibir_lista(lista):
    for item in lista:
        print(f"Glicemia: {item.valor} Data: {item.data} Hora: {item.hora}")

    ("Total de registros:", len(lista))

def calcular_media(lista):
    soma = 0
    for item in lista:
        soma += item.valor

    media = soma / len(lista)
    return media

def calcular_mediana(lista):
    valores = [item.valor for item in lista]
    valores.sort()

    n = len(valores)
    if n % 2 == 0:
        mediana = (valores[n//2 - 1] + valores[n//2]) / 2
    else:
        mediana = valores[n//2]

    return mediana