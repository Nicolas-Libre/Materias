lista = []
num = int (input ("ingrese un numero a la lista "))
while num != 0:
    lista.append (num)
    num = int (input ("ingrese un numero a la lista "))

cadena = ""
for i in range (len(lista)):
    if lista[i] % 3 != 0:
        cadena += str(lista[i]) + "-"
print (f'{cadena}')