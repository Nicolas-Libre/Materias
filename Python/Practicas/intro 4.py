import random
lista = []
for i in range (5):
    x = random.randrange (100)
    lista.append (x)

print (f'la lista es\n')

for i in range (5):
    print (f'{lista[i]}\n')

print (f'numeros pares:\n ')
for i in range (len(lista)):
    num = lista[i]
    if (num % 2 == 0):
        print (f'{num}\n')


    
    
