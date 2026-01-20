import random
lista = []
par = []
impar = []
for i in range (10):
    x = random.randrange (100)
    lista.append (x)

print (f'la lista es\n')

for i in range (10):
    print (f'{lista[i]}\n')

for i in range (len(lista)):
    num = lista[i]
    if (num % 2 == 0):
        par.append (num)
    else :
        impar.append (num)

print (f'la lista par es\n')

for i in range (len(par)):
    print (f'{par[i]}\n')

print (f'la lista impar es\n')

for i in range (len(impar)):
    print (f'{impar[i]}\n')
    
    
