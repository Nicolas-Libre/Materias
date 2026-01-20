import csv
from datetime import datetime

def obtener_asistencias(file_path, orden=None):
    asistencias = []
    with open(file_path, 'r', encoding='utf-8') as file:
        csv_reader = csv.DictReader(file)
        for row in csv_reader:
            if (row['Contexto del evento'] == 'Asistencia: Asistencia a clases de teoría' and 
                row['Nombre evento'] == 'Asistencia confirmada por el alumno'):
                fecha = datetime.strptime(row['Hora'], "%d/%m/%y, %H:%M:%S")
                asistencias.append({
                    'usuario': row['Usuario afectado'],
                    'nombre_completo': row['Nombre completo del usuario afectado'],
                    'fecha': fecha
                })

    if orden == "A":
        asistencias.sort(key=lambda x: x['fecha'])
    elif orden == "D":
        asistencias.sort(key=lambda x: x['fecha'], reverse=True)
    return asistencias

def menu_asistencias(file_path):
    while True:
        print("\nOpciones de orden:")
        print("1. Ascendente por fecha")
        print("2. Descendente por fecha")
        print("3. Sin orden")
        print("4. Salir")

        opcion = input("Seleccioná una opción: ")
        if opcion == "4":
            break
        elif opcion == "1":
            orden = "A"
        elif opcion == "2":
            orden = "D"
        elif opcion == "3":
            orden = None
        else:
            print("Opción no válida.")
            continue

        asistencias = obtener_asistencias(file_path, orden)
        for registro in asistencias:
            if registro['nombre_completo'].startswith('P'):
                print(f"{registro['nombre_completo']} - {registro['fecha'].strftime('%d/%m/%Y %H:%M:%S')}")


menu_asistencias('logs_Python_2024.csv')
# Ejecutar en Terminal






