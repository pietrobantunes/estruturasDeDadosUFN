from Glicemia import Glicemia

# começo com uma lista vazia de registros
lista = []

# exemplo de linha de texto a ser dividida
linha = "167,23/02/2026,13:15"

# dividir e criar objeto
vetor_linha = linha.split(",")
obj = Glicemia(int(vetor_linha[0]), vetor_linha[1], vetor_linha[2])

# só adiciona se ainda não estiver presente na lista
if obj not in lista:
    lista.append(obj)

# exibir conteúdo da lista
for item in lista:
    print(item.valor, item.data, item.hora)

