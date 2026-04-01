from Glicemia import Glicemia  
from minhasFuncoes import calcular_media, exibir_lista, popular_lista_arquivo, calcular_mediana

lista = []
nome_base = "dados.csv"

popular_lista_arquivo(lista, nome_base)
exibir_lista(lista)

media = calcular_media(lista)
print("Media glicemia: ", media)

mediana = calcular_mediana(lista)
print("Mediana glicemia: ", mediana)
