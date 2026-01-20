inventario = {}
cantTotal=0
exist = False
pos = 0
menu = [
        "Agregar Producto ",
        "Eliminar Producto ",
        "Mostrar Inventario Actual ",
        "Salir "
]
seguir = [
        "Si",
        "No"
]
print ('')
print ("Estas son las operaciones disponibles")
print ('')

for i, answer in enumerate (menu):
    print (f'{i+1} {menu[i]}')
print ('')
option = (input('Numero de operacion a realizar: '))
print ("Respuesta invalida "  if (option < "1" or option > "4") else f'Selecciono la opcion {option} ')
while option < "4" and option >= "1":
    if option == "1":
        print ('')
        nombre = (str(input("Ingrese el nombre del producto ")))
        print ('')

        cant = (int(input ("Ingrese la cantidad inicial del producto ")))
        if nombre in inventario:
            inventario [nombre] += cant
        else:
            inventario [nombre] = cant
    elif option == "2":
        print ('')
        if nombre in inventario:
            del inventario[nombre]
        else:
            print ('No se encuentra')
    else:
        print ('')
        for cla, val in inventario.items():
            print ('-----')
            print (f'{cla, val}')

        
    for i, answer in enumerate (menu):
        print (f'{i+1} {menu[i]}')
    option = (input('Numero de operacion a realizar: '))
    print ("Respuesta invalida " if (option < "1" or option > "4") else f'Selecciono la opcion {option} ')
print ('')
print ('Gracias')







