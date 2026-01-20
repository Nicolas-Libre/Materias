num = int (input ('ingrese un numero para agregarlo a la lista ') )
lista = []
while num != 0:
    lista.append (num)
    num = int (input ('ingrese un numero para agregarlo a la lista ') )

print (f'lista:\n')

for i in range (len(lista)):
    if lista[i] < 0:
        print (f'ALERTA: se encontro un numero negativo.')
        break
    else:
        print (f'el numero ingresado es {lista[i]}\n')
    
    
