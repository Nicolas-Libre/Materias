# constante
from pathlib import Path
 
PROJECT_PATH = Path(__file__).parent.parent
DATA_PATH = PROJECT_PATH / "files"
DATA_OUT_PATH = PROJECT_PATH / "data_out"
DATA_HOGAR = DATA_OUT_PATH / "usu_hogar.csv"
DATA_INDIVIDUAL = DATA_OUT_PATH / "usu_individual.csv"
PROCESSED_DATA_PATH = PROJECT_PATH / "processed_data"
PROCESSED_DATA_INDIVIDUAL = PROCESSED_DATA_PATH / "individual_procesado.csv"
PROCESSED_DATA_HOGAR = PROCESSED_DATA_PATH / "hogar_procesado.csv"




# funcionalidad
from constantes import DATA_PATH, DATA_OUT_PATH
import csv

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
def creacion_datasets (indicador):
    """Función para unificar todos los datasets de individuos y hogares que se encuentren descargados."""
    
    if not DATA_PATH.exists():
        print(f"La carpeta {DATA_PATH} no existe. Verificá la estructura del proyecto.")
        return

    if not DATA_OUT_PATH.exists():
        print(f"La carpeta {DATA_OUT_PATH} no existe. Verificá la estructura del proyecto.")
        return
    
    nombre_archivo = "usu_individual" if indicador == "I" else "usu_hogar"
    archivo_salida = DATA_OUT_PATH / f"{nombre_archivo}.csv"
    tiene_encabezado = False
    with archivo_salida.open('w') as salida:
        for patron in [f"{nombre_archivo}_*", f"{nombre_archivo.capitalize()}_*"]:
            for archivo in DATA_PATH.glob(patron):
                try:
                    with archivo.open('r', encoding='utf-8') as f:
                        encabezado = f.readline()
                        if not tiene_encabezado:
                            salida.write(encabezado)
                            tiene_encabezado = True
                        for line in f:
                            salida.write(line)
                except FileNotFoundError:
                    print(f"Un archivo {archivo} fue eliminado antes de poder leerlo. Se omite.")
                except PermissionError:
                    print(f"No se tienen permisos para leer el archivo {archivo}. Se omite.") 

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#ESTAS FUNCIONES SE USAN EN LOS SIGUIENTES INCISOS

def aglo_dict():
    """Devuelve un diccionario que mapea los códigos de aglomerado con sus respectivos nombres."""
    
    AGLOMERADOS={
        '2': 'Gran La Plata', '3': 'Bahía Blanca-Cerri', '4': 'Gran Rosario',
        '5': 'Gran Santa Fe', '6': 'Gran Paraná', '7': 'Posadas', '8': 'Gran Resistencia',
        '9': 'Comodoro Rivadavia-Rada Tilly', '10': 'Gran Mendoza', '12': 'Corrientes',
        '13': 'Gran Córdoba', '14': 'Concordia', '15': 'Formosa', '17': 'Neuquén-Plottier',
        '18': 'Santiago del Estero-La Banda', '19': 'Jujuy-Palpalá', '20': 'Río Gallegos',
        '22': 'Gran Catamarca', '23': 'Gran Salta', '25': 'La Rioja', '26': 'Gran San Luis',
        '27': 'Gran San Juan', '29': 'Gran Tucumán-Tafí Viejo', '30': 'Santa Rosa-Toay',
        '31': 'Ushuaia-Río Grande', '32': 'Ciudad Autónoma de Buenos Aires',
        '33': 'Partidos del Gran Buenos Aires', '34': 'Mar del Plata', '36': 'Río Cuarto',
        '38': 'San Nicolás-Villa Constitución', '91': 'Rawson-Trelew', '93': 'Viedma-Carmen de Patagones'}
    return AGLOMERADOS


def defaultcantidades():
    """Devuelve un diccionario con códigos de aglomerado con valores inicializados."""
    
    AGLOMERADOS=['2','3','4','5','6','7','8','9','10','12','13',
        '14','15','17','18','19','20','22','23','25','26','27','29','30','31',
        '32','33','34','36','38','91','93']
    return {x: {'cant': 0} for x in AGLOMERADOS}


def sacar_porcentaje(diccionariocontador):
    """Calcula el porcentaje par respecto al total para cada aglomerado."""
    
    resultados = []
    for aglomerado , data  in diccionariocontador.items():
        totaldatos = int(data['cant'])
        totalesp = int(data['cantesp'])
        porcentaje = (totalesp / totaldatos) * 100 if totaldatos > 0 else 0
        resultados.append((aglomerado, porcentaje))
    resultados.sort(key=lambda x: x[1], reverse=True)
    return resultados

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# FUNCIONALIDAD PARA STREAMLITS
def calcular_fechas(archivocsv,indicador='4'):
    menor_anio = float('inf')
    menor_trimestre = float('inf')
    mayor_anio = float('-inf')
    mayor_trimestre = float('-inf')

    with open(archivocsv, encoding="utf-8") as f:
        next(f)  # Saltar encabezado
        for linea in f:
            columnas = linea.strip().split(";")
            anio = int(columnas[1])
            trimestre = int(columnas[2])
            if (indicador == '4'):
                if anio < menor_anio:
                    menor_anio = anio
                    menor_trimestre = trimestre
                elif anio == menor_anio:
                    menor_trimestre = min(menor_trimestre, trimestre)

            if anio > mayor_anio:
                mayor_anio = anio
                mayor_trimestre = trimestre
            elif anio == mayor_anio:
                mayor_trimestre = max(mayor_trimestre, trimestre)
    if(indicador == '4'):
        return menor_anio, menor_trimestre,mayor_anio, mayor_trimestre
    else :
        return mayor_anio, mayor_trimestre
    
    
def calcular_fechas_comparadas(archivocsv_hogar, archivocsv_individual):
    # Llamamos a calcular_fechas para cada archivo
    #EL :2(AGARRA LOS 2 PRIMEROS RESULTADOS) Y 2:(AGARRA LOS 2 ULTIMOS RESULTADOS) 
    menor_anio_hogar, menor_trimestre_hogar = calcular_fechas(archivocsv_hogar)[:2]
    mayor_anio_hogar, mayor_trimestre_hogar = calcular_fechas(archivocsv_hogar)[2:]
    menor_anio_individual, menor_trimestre_individual = calcular_fechas(archivocsv_individual)[:2]
    mayor_anio_individual, mayor_trimestre_individual = calcular_fechas(archivocsv_individual)[2:]
    
    # Comparar los resultados para obtener el mínimo y máximo general
    # Mínimo
    menor_anio = min(menor_anio_hogar, menor_anio_individual)
    if menor_anio == menor_anio_hogar:
        menor_trimestre = min(
            menor_trimestre_hogar,
            menor_trimestre_individual if menor_anio == menor_anio_hogar else 999
        )
    else:
        menor_trimestre = min(
            menor_trimestre_individual,
            menor_trimestre_hogar if menor_anio == menor_anio_individual else 999
        )

    # Máximo
    mayor_anio = max(mayor_anio_hogar, mayor_anio_individual)
    if mayor_anio == mayor_anio_hogar:
        mayor_trimestre = max(
            mayor_trimestre_hogar,
            mayor_trimestre_individual if mayor_anio == mayor_anio_hogar else -1
        )
    else:
        mayor_trimestre = max(
            mayor_trimestre_individual,
            mayor_trimestre_hogar if mayor_anio == mayor_anio_individual else -1
        )
    
    return menor_anio, menor_trimestre, mayor_anio, mayor_trimestre

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 1 SECCION B = Imprime año tras año el porcentaje de personas +6 años alfabetizados y analfabetizados.

def porcentaje_alfabetizacion (archivo_csv):
    """Calcula e imprime el porcentaje de personas mayores a 6 anios que, saben y que no saben,  leer y escribir"""

    CH09 = 16 # Sabe leer: 1= Sí; 2= No; 3 =Menor de 2 años
    CH06 = 13 # edad
    pondera = 9 # cantidad de personas que contempla
    trimestre = 2 # trimestre del registro
    ANO4 = 1 # año del registro

    total_mayores_6 = {}
    alfabetizados = {}

    try:
        with open(archivo_csv, 'r', encoding='utf-8') as archivo:
            reader = csv.reader(archivo, delimiter=';')
            next(reader)

            for row in reader:
                if (row[trimestre] == "4"):
                    edad = int(row[CH06])
                    if edad > 6:
                        capacidad = row[CH09]
                        anio = row[ANO4]
                        cantidad = int(row[pondera])

                        if anio not in total_mayores_6:
                            total_mayores_6[anio] = 0 
                            alfabetizados[anio] = 0
                        total_mayores_6[anio] += cantidad
                        if capacidad == "1":
                            alfabetizados[anio] += cantidad

        for anio in sorted(total_mayores_6):
            total = total_mayores_6[anio]
            capaces = alfabetizados[anio]
            porcentaje_leen = (capaces / total) * 100
            porcentaje_no_leen = 100 - porcentaje_leen
            print(f"En el año {anio} El porcentaje de personas > 6 años alfabetizadas es: "
                  f"{porcentaje_leen:.2f}% / El porcentaje de analfabetizadas: {porcentaje_no_leen:.2f}%")

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 2 SECCION B= Dado un año imprime el porcentaje de inmigrantes que hayan cursado nivel universitario o superior

def porcentaje_inmigrantes_academicos(archivo_csv):
    """Imprime el porcentaje de inmigrantes que cursaron nivel universitario dado un año y trismestre especificados"""

    CH12 = 19 # ¿Cuál es el nivel más alto que cursa/ó? = 7 (universitario)
    CH15 = 22 # ¿Dónde nació? = 4 / 5 (fuera del país)  
    pondera = 9 # cantidad de personas que contempla
    trim = 2 # trimestre del registro
    year = 1 # año del registro

    trimestre = input("Ingrese un trimestre: ")
    anio = input("Ingrese un año: ")
    total_personas = 0
    inmigrantes_universitarios = 0

    try:
        with open(archivo_csv, 'r', encoding='utf-8') as archivo:
            reader = csv.reader(archivo, delimiter=';')
            next(reader)

            for row in reader:
                if row[year] == anio:
                    if row[trim] == trimestre:
                        total_personas += int(row[pondera])
                        if (row[CH12]) >= "7":
                            if row[CH15] in ["4", "5"]:
                                inmigrantes_universitarios += int(row[pondera])

        print(f"En el año {anio}, trimestre numero {trimestre} {(inmigrantes_universitarios / total_personas) * 100}%"
            " son personas no nacidas en argentina que han cursado nivel universitario o superior.")
        
    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 3 SECCION B = Informa el año con menor desocupacion.

def menor_desocupacion_anio_trim(archivo_csv):
    """Imprime el año y trimestre con menor desocupación registrada."""
    
    condicion_laboral = 179 # Campo de strings: Desocupado.
    pondera = 9 # cantidad de personas que contempla
    trim = 2 # trimestre del registro
    year = 1 # año del registro
    desocupados_por_periodo = {}

    try:
        with open(archivo_csv, 'r', encoding='utf-8') as archivo:
            reader = csv.reader(archivo, delimiter=';')
            next(reader)
            
            for row in reader:
                condicion = row[condicion_laboral].strip()
                if (condicion == "Desocupado."):
                    anio = int(row[year])
                    trimestre = int(row[trim])
                    cantidad = int(row[pondera])
                    clave = (anio,trimestre)

                    if clave not in desocupados_por_periodo:
                        desocupados_por_periodo[clave] = 0
                    desocupados_por_periodo[clave] += cantidad

        anio_min, trim_min = min(desocupados_por_periodo, key= desocupados_por_periodo.get)
        print(f"Menor desocupación: año {anio_min}, trimestre numero {trim_min}.")

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 4 SECCION B= Ranking 5 aglomerados con mas de 2 ocupantes en un hogar con estudios universitarios o superiores

def top_5_aglomerados_universitarios(archivo_csv_hogares, archivo_csv_personas):
    """
    Imprime el ranking de los 5 aglomerados con mayor porcentaje de hogares con al menos
    dos personas con estudios universitarios o superiores finalizados.
    """
    
    UNIVERSITARIO = 180 # columna generada en la seccion a, inciso 6 (1: Sí, 0: No, 2: no aplica).
    CODUSU = 0 # codigo de vivienda, apareable con personas
    NRO_HOGAR = 3 # codigo para distinguir hogares
    AGLOMERADO_HOGAR = 7 # codigo de aglomerado
    PONDERA_HOG = 8 # cantidad de personas que contempla
    trim = 2 # trimestre del registro
    year = 1 # año del registro
    anio, trimestre = calcular_fechas(archivo_csv_hogares,'2')

    AGLOMERADOS = aglo_dict()
    diccionario_contador = defaultcantidades()

    for valor in diccionario_contador.values():
        valor['cantesp'] = 0  # agregamos campo extra que contabiliza la condicion de recibidos
    try:
        # Leer archivo de personas y agrupar por hogar
        personas_por_hogar = {}
        with open(archivo_csv_personas, 'r', encoding='utf-8') as archivo_personas:
            personas_reader = csv.reader(archivo_personas, delimiter=';')
            next(personas_reader)
            for row in personas_reader:
                if int(row[year]) == anio and int(row[trim]) == trimestre:
                    if row[UNIVERSITARIO] == '1': # si cumple identifica su hogar
                        codusu = row[CODUSU].strip()
                        nro_hogar = row[NRO_HOGAR].strip()
                        hogar_id = (codusu, nro_hogar)

                        if hogar_id not in personas_por_hogar: # se agrega esa persona al hogar en el dict
                            personas_por_hogar[hogar_id] = 0 
                        # cuento individualmente que en ese hogar id, 1 persona cumplió con ser universitario
                        personas_por_hogar[hogar_id] += 1 

        # Leer archivo de hogares
        with open(archivo_csv_hogares, 'r', encoding='utf-8') as archivo_hogares:
            hogares_reader = csv.reader(archivo_hogares, delimiter=';')
            next(hogares_reader)
            for row in hogares_reader:
                if int(row[year]) == anio and int(row[trim]) == trimestre:
                    codusu = row[CODUSU].strip()
                    nro_hogar = row[NRO_HOGAR].strip()
                    aglomerado = row[AGLOMERADO_HOGAR].strip()
                    pondera_hogar = int(row[PONDERA_HOG])
                    
                    diccionario_contador[aglomerado]['cant'] += pondera_hogar
                    
                    hogar_id = (codusu, nro_hogar)
                    if personas_por_hogar.get(hogar_id, 0) >= 2:
                        diccionario_contador[aglomerado]['cantesp'] += pondera_hogar

        # Obtener y mostrar el rankin de 5 aglomerados 
        resultados = sacar_porcentaje(diccionario_contador)
        print("Top 5 aglomerados con mayor porcentaje de hogares con mas de 2 personas"
        " con estudios universitarios o superiores finalizados:")
        for codigo, porcentaje in resultados[:5]:
            nombre = AGLOMERADOS.get(codigo, f"Aglomerado {codigo}")
            print(f"{nombre}: {porcentaje:.2f}%")

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 5 SECCION B = Informar para cada aglomerado el porcentaje de viviendas ocupadas por sus propietarios.

def porcentaje_aglomerados_propietarios(archivocsv):
    """Imprime el porcentaje de viviendas ocupadas por propietarios en cada aglomerado."""
    
    AGLOMERADOS = aglo_dict()
    
    #INDEX'S
    IDX_II7 = 37
    AGLOMERADO = 7
    PONDERA = 8
    
    # Inicializa el diccionario para contar las viviendas por aglomerado
    diccionariocontador = defaultcantidades()
    
    #AÑADO NUEVO VALOR EN EL DICCIONARIO PARA CONTAR LAS CANTIDADES DE VIVIENDAS OCUPADAS POR PROPIETARIOS
    for valor in diccionariocontador.values():
        valor['cantesp'] = 0
    try:
        with open(archivocsv, 'r', encoding='utf-8') as archivo:
            lector = csv.reader(archivo, delimiter=';')
            lector.__next__()  # Salta la primera línea (encabezados)
            
            for linea in lector:
                aglomerado_act = linea[AGLOMERADO].strip()
                II7_act = linea[IDX_II7].strip()
                pondera_act = int(linea[PONDERA])
                
                diccionariocontador[aglomerado_act]['cant'] += pondera_act
                if II7_act in ('1','2'):
                    diccionariocontador[aglomerado_act]['cantesp'] += pondera_act

        print("\nPorcentajes de viviendas ocupadas por sus propietarios:")
        listaporcentajes = sacar_porcentaje(diccionariocontador)
        for aglomerado, porcentaje in listaporcentajes:
            print(f"{AGLOMERADOS[aglomerado]}: {porcentaje:.2f}%")
    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 6 SECCION B = Informar el aglomerado con mayor cantidad de viviendas con más de dos ocupantes y sin baño.

def aglo_max_viviendas(diccionariocontador):
    """Retorna el código del aglomerado con mayor cantidad de viviendas según el acumulado en el diccionario."""
    
    aglomerado_maximo = max(diccionariocontador.items(), key=lambda item: item[1]['cant'])
    return aglomerado_maximo[0], aglomerado_maximo[1]['cant']


def viviendas_esp(archivocsv):
    """Imprime el nombre del aglomerado que tiene la mayor cantidad de viviendas con más de dos ocupantes, sin baño."""
    
    AGLOMERADOS = aglo_dict()
    
    #INDEX'S 
    IX_TOT_OCUPANTES = 64
    AGLOMERADO = 7
    PONDERA = 8
    IV8_BAÑO = 19
    
    # Inicializa el diccionario para contar las viviendas por aglomerado
    diccionariocontador = defaultcantidades()
    try:
        with open(archivocsv, 'r', encoding='utf-8') as archivo:
            lector = csv.reader(archivo, delimiter=';')
            next(lector)  # Salta la primera línea (encabezados)
        
            for linea in lector:
                aglomerado_act = linea[AGLOMERADO].strip()
                pondera_act = int(linea[PONDERA])
                no_banio_act = linea[IV8_BAÑO].strip() == '2'
                total_ocupantes_act = int(linea[IX_TOT_OCUPANTES].strip())
            
                if (no_banio_act and (total_ocupantes_act > 2)):
                    diccionariocontador[aglomerado_act]['cant'] += pondera_act
        
        aglomax,cantmax = aglo_max_viviendas(diccionariocontador)  
        print(f"EL AGLOMERADO, {AGLOMERADOS[aglomax]}, TIENE LA MAYOR CANTIDAD DE VIVIENDAS CON MAS DE DOS OCUPANTES "
            f"Y SIN BAÑO CON UN TOTAL DE: {cantmax} VIVIENDAS")
    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#INCISO 7 SECCION B= Informar para cada aglomerado el porcentaje de personas que hayan cursado universitario o superior

def porc_aglo_estudios(archivocsv):
    """Imprime el porcentaje de individuos que han alcanzado al menos el nivel universitario"""
    
    AGLOMERADOS = aglo_dict()
    
    #INDEX'S
    IND_ESTUDIO = 26
    AGLOMERADO = 8
    PONDERA = 9
    
    # Inicializa el diccionario para contar las viviendas por aglomerado
    diccionariocontador = defaultcantidades()
    
    #CREO NUEVO VALOR EN EL DICCIONARIO PARA CONTAR LOS ESTUDIOS
    for valor in diccionariocontador.values():
        valor['cantesp'] = 0
    
    #ABRO ARCHIVO Y LEO
    with open(archivocsv, 'r', encoding='utf-8') as archivo:
        lector = csv.reader(archivo, delimiter=';')
        next(lector)
    
            
        for linea in lector:
            try:
                aglomerado_act = linea[AGLOMERADO].strip()
                pondera_act = int(linea[PONDERA])
                estudios_act = linea[IND_ESTUDIO].strip()
        
                diccionariocontador[aglomerado_act]['cant'] += pondera_act
            
                if  estudios_act in ('5','6'):
                    diccionariocontador[aglomerado_act]['cantesp'] += pondera_act
            except(IndexError,ValueError,KeyError) as e:
                print(f'Error procesando la linea {linea}. {e}')
    print("\nPorcentajes de personas que han cursado al menos nivel universitario o superior:")
    listaporcentaje= sacar_porcentaje(diccionariocontador)
    for aglomerado, porcentaje in listaporcentaje:
        print(f"{AGLOMERADOS[aglomerado]}: {porcentaje:.2f}%")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 8 SECCION B = Informar las regiones en orden descendente según el porcentaje de inquilinos de cada una.

def crear_acumulador_inquilinos():
    """Crea un diccionario para acumular el total de personas y la cantidad de inquilinos por región."""
    
    REGIONES = ['1', '40', '41', '42', '43', '44']
    return {i: {'total': 0, 'inquilinos': 0} for i in REGIONES}


def generar_porcentajes_inquilinos(estructura):
    """Calcula y devuelve una lista ordenada de regiones según el porcentaje de inquilinos en cada una."""
    
    porcentajes = [] 
    for region, datos in estructura.items(): # recorro la estructura
        total= datos['total'] # a total le doy total de personas en esa region
        inquilinos= datos['inquilinos'] # a inquilinos le doy el total de inquilinos en esa region
        porcentaje = (inquilinos / total * 100 ) if total > 0 else 0.0 # saco porcentaje 
        porcentajes.append ((region, round (porcentaje, 2))) # agrego la region y el porcentaje a la lista
    porcentajes_ordenados = sorted(porcentajes, key=lambda x: x[1], reverse=True) # ordeno en forma descendiente
    return porcentajes_ordenados


def imprimir_region_inquilinos(archivo_csv):
    """Imprime el porcentaje de inquilinos por región de manera ordenada."""
    
    nombres_regiones = {
        '1': 'Gran Buenos Aires',
        '40': 'Noroeste',
        '41': 'Noreste',
        '42': 'Cuyo',
        '43': 'Pampeana',
        '44': 'Patagonia'
    }
    try:
        with open (archivo_csv,encoding='utf-8') as archivo:
            reader = csv.reader(archivo,delimiter = ';')
            II7 = 37
            REGION = 5
            PONDERA = 8
            estructura = crear_acumulador_inquilinos()
            encabezado = next(reader)
            for row in reader:
                estructura[row[REGION]]['total'] += int (row[PONDERA])
                if row [II7] == '3':
                    estructura [row[REGION]]['inquilinos'] += int (row[PONDERA])
            porcentajes_ordenados= generar_porcentajes_inquilinos(estructura)
            print("\nPORCENTAJE DE INQUILINOS POR REGIÓN (Ordenado)")
            print("-----------------------------------------------")
            print("| Región               | Porcentaje         |")
            print("|----------------------|--------------------|")
            for r, p in porcentajes_ordenados:
                nombre_region = nombres_regiones.get(r)
                print(f'| {nombre_region:<20} | {p:>17}% |')

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 9 SECCION B = Pedir al usuario que seleccione un aglomerado y a partir de la información contenida
# retornar una tabla que contenga la cantidad de personas mayores de edad según su nivel de estudios alcanzados.

def imprimir_tabla_formacion(estructuraPrincipal, nombre_aglomerado):
    """
    Imprime una tabla con la cantidad de personas mayores de edad
    por nivel educativo, año y trimestre en el aglomerado seleccionado.
    """
    
    print(f"\nNombre de Aglomerado: {nombre_aglomerado}\n")
    print(f"{'Año':^10} | {'Trimestre':^10} | {'Primario incompleto':^20} | {'Primario completo':^20} | "
        f"{'Secundario Incompleto':^20} | {'Secundario Completo':^20} | {'Superior o universitario':^20}")
    print("-" * 130) # hacemos el encabezado con las 3 lineas anteriores
    for anio in sorted(estructuraPrincipal.keys()): # ordenamos los anios
        for trimestre in sorted (estructuraPrincipal[anio].keys()): # ordenamos los trimestres
            prim_inc, prim_comp, sec_inc, sec_comp, sup = estructuraPrincipal[anio][trimestre] 
            print(f"{anio:^10} | {trimestre:^10} | {prim_inc:^20} | {prim_comp:^20} "
                f"| {sec_inc:^20} | {sec_comp:^20} | {sup:^20}")


def imprimir_formacion_por_aglomerado(archivo_csv):
    """
    Solicita un aglomerado al usuario e imprime la distribución de niveles educativos
    de personas mayores de edad para ese aglomerado.
    """

    try:
        with open (archivo_csv,encoding='utf-8') as archivo:
            reader = csv.reader(archivo,delimiter = ';')
            encabezado = next(reader)
            aglomerados = aglo_dict()
            for codigo ,nombre in aglomerados.items():
                print (f"{codigo} {nombre}")
            numero_aglomerado= input (f"Ingrese el numero del aglomerado en el cual quiere obtener"
                "la informacion de nivel de estudios alcanzados de las personas que viven en el:")
            if not numero_aglomerado in aglomerados:
                print (f"Aglomerado inexistente")
            estructuraPrincipal = acumular_formacion_periodo(reader,numero_aglomerado)
            nombre_aglomerado = aglomerados[numero_aglomerado]
            imprimir_tabla_formacion(estructuraPrincipal,nombre_aglomerado)

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")


def procesar_fila_formacion(row,estructuraPrincipal,numero_aglomerado):
    """
    Procesa una fila del CSV y actualiza la estructura con datos de la formación educativa
    para personas mayores en el aglomerado indicado.
    """
    
    PONDERA = 9
    COLUM_AGLOMERADO = 8
    EDAD = 13
    ANIO = 1
    TRIMESTRE = 2
    NIVEL_ED = 26
    try:
        if (int(row[EDAD]) > 18) and (numero_aglomerado == row[COLUM_AGLOMERADO]):
            if not (row [ANIO]) in estructuraPrincipal:
                estructuraPrincipal[row [ANIO]]= {} # si es un nuevo anio, creamos el diccionario de ese anio
            if not (row [TRIMESTRE]) in estructuraPrincipal[row [ANIO]]:
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]] = [0,0,0,0,0]  # EN DEFAULT cuando es nuevo trimestre
            if row [NIVEL_ED] == '1':
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]][0] += int (row [PONDERA])
            elif row [NIVEL_ED] == '2':
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]][1] += int (row [PONDERA])
            elif row [NIVEL_ED] == '3':
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]][2] += int (row [PONDERA])
            elif row [NIVEL_ED] == '4':
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]][3] += int (row [PONDERA])
            elif row [NIVEL_ED] == '5' or row [NIVEL_ED]== '6' :
                estructuraPrincipal[row [ANIO]][row [TRIMESTRE]][4] += int (row [PONDERA])
        # vamos cargando las personas que cumplen con cada condicion       
    except (IndexError,ValueError,KeyError) as e:
        print(f'Error procesando la fila {row}. {e}')


def acumular_formacion_periodo(reader,numero_aglomerado):
    """
    Procesa todas las filas del CSV y acumula la información educativa por año y trimestre
    para un aglomerado específico.
    """
    try:
        # defino las variables para moverme en el archivo csv 
        estructuraPrincipal = {} ##creamos el diccionario principal
        for row in reader:
            procesar_fila_formacion(row,estructuraPrincipal,numero_aglomerado)
        return estructuraPrincipal  

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")      

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
# INCISO 10 SECCION B = Pedir al usuario que seleccione dos aglomerados y a partir de la información
# contenida retornar una tabla que contenga el porcentaje de personas mayores de edad con secundario incompleto.

def imprimir_comparacion_aglomerados(estructuraAglomerado1,estructuraAglomerado2,
                nombre_aglomerado_1,nombre_aglomerado_2):
    """
    Imprime una tabla comparativa del porcentaje de personas mayores de edad
    con secundario incompleto entre dos aglomerados.
    """ 
    
    print("\nCOMPARACIÓN DE PORCENTAJE DE SECUNDARIO INCOMPLETO")
    print(f"{nombre_aglomerado_1} vs {nombre_aglomerado_2}\n")
    print(f"{'Año':<6}|{'Trimestre':<10}|{nombre_aglomerado_1[:15]:<15}|{nombre_aglomerado_2[:15]}")
    print("-" * 50)
    for anio in sorted(estructuraAglomerado1.keys()):
        for trimestre in sorted(estructuraAglomerado1[anio].keys()):
            secIncTotal1, total1 = estructuraAglomerado1[anio][trimestre]
            porcentaje1 = (secIncTotal1/total1) * 100 if total1 != 0 else 0
        # a partir de aca chequeo si el anio y el trimestre que se proceso del aglomerado 1, lo tiene el aglomerado 2
            if (anio in estructuraAglomerado2) and (trimestre in estructuraAglomerado2[anio]):
                secIncTotal2,total2 = estructuraAglomerado2 [anio][trimestre]
                porcentaje2 = (secIncTotal2 / total2) * 100 if total2 != 0 else 0
                print(f"{anio:<6} {trimestre:<10} {f'{porcentaje1:.1f}%':<15} {f'{porcentaje2:.1f}%'}")
                print("-" * 50)
    print("Nota: Porcentajes de personas > 18 años con secundario incompleto\n")


def procesar_informacion_secundario_incompleto (reader,numero_aglomerado_1,numero_aglomerado_2):
    """Processes the data to calculate incomplete secondary percentages for two agglomerates"""
    
    # defino las variables para moverme en el archivo csv
    ANIO = 1
    TRIMESTRE = 2
    NIVEL_ED = 26
    PONDERA = 9
    COLUM_AGLOMERADO = 8
    EDAD = 13
    # defino las 2 estructuras principales
    estructuraAglomerado1 = {}
    estructuraAglomerado2 = {}

    for row in reader:
        # consulto por la edad y por el aglomerado
        if ((row[EDAD]) > '18') and (row[COLUM_AGLOMERADO] == numero_aglomerado_1):
            if not row[ANIO] in estructuraAglomerado1: # si ese anio no esta en la estructura, lo agregamos
                estructuraAglomerado1[row [ANIO]] = {}
            # si dentro de ese anio no esta el trimestre, lo agregamos
            if not row[TRIMESTRE] in estructuraAglomerado1[row [ANIO]]: 
                estructuraAglomerado1 [row [ANIO]][row [TRIMESTRE]] = [0,0] 
            if row[NIVEL_ED] == '3': 
                # primer valor= acumulador de secundario incompleto
                estructuraAglomerado1 [row [ANIO]][row [TRIMESTRE]][0] += int (row [PONDERA])
            # segundo valor= acumulador de personas mayores, que estan en el aglomerado 
            estructuraAglomerado1[row[ANIO]][row[TRIMESTRE]][1] += int (row [PONDERA]) 
        ## se procesesa el aglomerado 2. la misma metodologia que con el primero       
        elif (row [EDAD] > '18') and (row[COLUM_AGLOMERADO] == numero_aglomerado_2):
            if not row[ANIO] in estructuraAglomerado2:
                estructuraAglomerado2[row [ANIO]] = {}
            if not row[TRIMESTRE] in estructuraAglomerado2[row [ANIO]]:   
                estructuraAglomerado2 [row[ANIO]][row[TRIMESTRE]] = [0,0]
            if row[NIVEL_ED]== '3':
                estructuraAglomerado2 [row[ANIO]][row[TRIMESTRE]][0] += int (row[PONDERA])   
            estructuraAglomerado2[row[ANIO]][row[TRIMESTRE]][1] += int (row [PONDERA])
    return estructuraAglomerado1, estructuraAglomerado2             


def comparacion_dos_aglomerados (archivo_csv):
    """Compara el porcentaje de adultos con el secundario incompleto entre dos aglomerados."""
    try:
        with open (archivo_csv,encoding='utf-8') as archivo:
            reader = csv.reader(archivo,delimiter = ';')
            next(reader)
            aglomerados = aglo_dict()
            for codigo,nombre in aglomerados.items():
                print (f'{codigo}  {nombre}')
            ## pido los aglomerados a comparar    
            numero_aglomerado_1= input (f'INGRESE EL NUMERO DEL ALGOMERADO 1:  ')
            numero_aglomerado_2 = input (f'INGRESE EL NUMERO DEL ALGOMERADO 2:  ')
            estructuraAglomerado1, estructuraAglomerado2 = (
                procesar_informacion_secundario_incompleto (reader,numero_aglomerado_1, numero_aglomerado_2))
            ## me guardo el nombre de cada aglomerado para despues imprimirlos.
            nombre_aglomerado_1 = aglomerados[numero_aglomerado_1]
            nombre_aglomerado_2 = aglomerados[numero_aglomerado_2]
            imprimir_comparacion_aglomerados(
                estructuraAglomerado1,estructuraAglomerado2,nombre_aglomerado_1,nombre_aglomerado_2
            )

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - -  EJERCICIO 11 - - - - - - - - - - - - - - - - - - - - - - -
# Pedir al usuario que seleccione un año, y busque en el último trimestre almacenado
# del mencionado año, el aglomerado con mayor porcentaje de viviendas de “Material
# precario” y el aglomerado con menor porcentaje de viviendas de “Material precario”.

def inicializar_algo_contadores ():
    aglomerados = aglo_dict()
    estructura = {}
    for codigo, nombre in aglomerados.items():
        estructura[codigo] = {'nombre': nombre, 'personas_precario': 0, 'personas_totales': 0}
    return estructura


def imprimir_aglo_material_precario (aglo_mayor,aglo_menor,ultimo_trimestre,anio):
    print(f"\n--- Resultados para el año {anio}, Trimestre {ultimo_trimestre} ---")
    print(f"Mayor % material precario: {aglo_mayor[1]['nombre']} ({aglo_mayor[1]['porcentaje']}%)")
    print(f"Menor % Material precario: {aglo_menor[1]['nombre']} ({aglo_menor[1]['porcentaje']}%)")


def procesar_material_precario (reader,anio):
    col_anio = 1
    col_trimestre = 2
    col_material_techumbre= 89
    col_aglomerado = 7
    col_pondera = 8
    ultimo_trimestre = 0
    aglomerados = inicializar_algo_contadores()
    encabezado = next(reader)

    for row in reader:  
        if (int (row[col_anio])) == anio:
            trimestre_actual = int(row[col_trimestre])
            if ultimo_trimestre < trimestre_actual: ##Reiniciamos contadores si encontramos un trimestre mas reciente
                ultimo_trimestre = trimestre_actual
                for aglo in aglomerados.values():
                    aglo['personas_precario'] = 0
                    aglo['personas_totales'] = 0
            if ultimo_trimestre == trimestre_actual: ## Chequeamos que estemos en el ultimo trimestre hasta el momento
                aglomerados[row[col_aglomerado]]['personas_totales'] += int (row[col_pondera])
                if row[col_material_techumbre] == 'Material Precario':
                    aglomerados[row[col_aglomerado]]['personas_precario'] += int(row[col_pondera])
    
    porcentaje_aglomerados = {}
    for codigo, datos in aglomerados.items():
        if datos['personas_totales'] > 0:
            porcentaje = (datos['personas_precario'] / datos['personas_totales']) * 100
            porcentaje_aglomerados[codigo] = {
                'nombre': datos['nombre'],
                'porcentaje': round(porcentaje, 2)}

    if porcentaje_aglomerados: ##chequeo si el diccionario tiene valores
        # Convertimos el diccionario a lista de tuplas para ordenarlo
        items_ordenados = sorted(
            porcentaje_aglomerados.items(),
            key=lambda x: x[1]['porcentaje']  
        )
        aglo_menor = items_ordenados[0]
        aglo_mayor = items_ordenados[-1]
        imprimir_aglo_material_precario (aglo_mayor,aglo_menor,ultimo_trimestre,anio)


def algomerado_material_precario (archivo_csv):
    try:
        with open (archivo_csv,encoding='utf-8') as archivo:
            reader = csv.reader(archivo,delimiter = ';')
            anio = int(input(
                "ENTRE EL 2016 Y EL 2024 INGRESE EL ANIO QUE QUIERE OBTENER "
                "EL AGLOMERADO CON MAYOR Y MENOR PORCENTAJE DE MATERIAL PRECARIO: "
            ))           
            if (anio < 2016) or (anio > 2024):
                print('AÑO INCORRECTO')
            else:
                procesar_material_precario(reader, anio)

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")

# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - EJERCICIO 12 - - - - - - - - - - - - - - - - - - - - - - -
#​ A partir de la información del último trimestre almacenado en el sistema se debe
# retornar para cada aglomerado el porcentaje de jubilados que vivan en una vivienda
# con CONDICION_DE_HABITABILIDAD insuficiente.

def inicializar_estructura_jubilados():
    aglomerados = aglo_dict()
    estructura = {}

    for codigo,nombre in aglomerados.items():
        estructura[codigo] = {'nombre': nombre, 'jubilados_insuficiente': 0,'jubilados_totales': 0}
    return estructura


def jubilados_habitabilidad_insuficiente (archivo_csv_hogar,archivo_csv_individual):
    col_anio = 1 
    col_codusu = 0 
    col_trimestre =  2
    col_condi_habitabilidad = 91
    col_aglomerado = 8
    ult_anio = 0
    ult_trimestre = 0
    aglomerados = inicializar_estructura_jubilados()
    viviendas_insu = {}

    try:     
        with open (archivo_csv_hogar, encoding='utf-8') as archivo:
            reader_hogar = csv.reader(archivo,delimiter = ';')
            next (reader_hogar) 

            for row in reader_hogar:
                if (
                    int(row[col_anio]) > ult_anio or(
                        int(row[col_anio]) == ult_anio and
                        ult_trimestre < int(row[col_trimestre]))
                ):
                    ult_anio = int(row[col_anio])
                    ult_trimestre = int(row[col_trimestre])
                    viviendas_insu = {}

                if (int(row[col_anio]) == ult_anio) and  row[col_condi_habitabilidad].strip() == 'Insuficiente':
                    viviendas_insu[row[col_codusu]] = (row[col_aglomerado])

        with open (archivo_csv_individual, encoding='utf-8') as archivo:
            reader_individual = csv.reader(archivo,delimiter = ';')
            col_es_jubiliado = 29
            col_pondera = 9

            next (reader_individual)
            for row in reader_individual:
                if (
                        int(row[col_anio]) == ult_anio and
                        int(row[col_trimestre]) == ult_trimestre and
                        row[col_es_jubiliado].strip() == '1'
                    ):
                    aglomerados[(row[col_aglomerado])]['jubilados_totales'] += int(row[col_pondera])
                    if (row[col_codusu]) in viviendas_insu:
                        aglomerados[(row[col_aglomerado])]['jubilados_insuficiente'] += int(row[col_pondera])

        print("\n Porcentaje de jubilados en viviendas insuficientes por aglomerado, del ultimo trimestre :")
        print("{:<6} {:<40} {:<10}".format("Código", "Aglomerado", "Porcentaje"))
        print("-" * 45)

        for codigo, datos in aglomerados.items():
            porcentaje = (
                (datos['jubilados_insuficiente'] / datos['jubilados_totales']) * 100
                if datos['jubilados_totales'] > 0
                else 0
            )
            print("{:<6} {:<40} {:<10.2f}%".format(codigo, datos['nombre'],porcentaje))

    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")       
 
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - EJERCICIO 13 - - - - - - - - - - - - - - - - - - - - - - -

def cantidad_universitarios_en_vivienda_insuficiente_en_anio(individuos_csv, hogar_csv):
    """
    Solicita al usuario ingresar un año y retorna la cantidad de personas que hayan
    cursado el nivel universitario o superior con vivienda insuficiente.
    """
    
    ANIO = 1
    TRIM = 2
    NIVEL_ED_str = 178
    CODUSU = 0
    COND_HAB = 91
    PONDERA = 9
    
    try:
        anio_buscado = input('Ingrese el año a verificar.').strip()
    
        viviendas_insu = {} # Clave = Codusu | valor = trimestre
        with open(hogar_csv, encoding='utf-8') as hogar:
            reader = csv.reader(hogar, delimiter=";")
            next(reader)  
            
            for row in reader:
                if row[ANIO].strip() == anio_buscado and row[COND_HAB].strip() == "Insuficiente":
                    codusu = row[CODUSU].strip()
                    trimestre = row[TRIM].strip()
                    viviendas_insu[codusu] = trimestre

        conteo_trimestre = {}  # Clave = trimestre | Valor = cantidad.
        
        with open(individuos_csv,encoding='utf-8') as ind:
            reader = csv.reader(ind, delimiter=";")
            next(reader)
        
            for row in reader:
                codusu = row[CODUSU].strip()
                if row[ANIO].strip() == anio_buscado and codusu in viviendas_insu:
                    trimestre = viviendas_insu[codusu] # Me guardo el trimestre que se encuentra en el dic.
                    if row[NIVEL_ED_str].strip() == "Superior o universitario.":
                        conteo_trimestre[trimestre] = conteo_trimestre.get(trimestre,0) + int(row[PONDERA]) 
                    
        if conteo_trimestre: #Verifica si hay datos.
            ultimo_trim = max(conteo_trimestre.keys(), key=lambda x: int(x))
            cantidad = conteo_trimestre[ultimo_trim]
            print(f'En el último trimestre ({ultimo_trim} del año {anio_buscado})')
            print(f'hubo {cantidad} personas con nivel universitario o superior con viviendas insuficientes.')
        else:
            print("No se encontraron datos para el año ingresado.")
            
    except KeyError as e:
        print(f"Error: faltan columnas esperadas en los CSV. Columna faltante: {e}")
    except FileNotFoundError:
        print("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        print("Error: se esperaba un número pero se recibió otro dato.")
    except Exception as e:
        print(f"Ocurrió un error inesperado: {e}")
# - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

# procesamiento
from pathlib import Path
import csv
from constantes import DATA_OUT_PATH, PROCESSED_DATA_PATH


"""def load_files (type):
    
    data = []
    
    column = []
    
    if not (DATA_PATH.exists()): # Si no existe, no crashea.
        print(f'La carpeta {DATA_PATH} no existe. Verificá la estructura del proyecto.') 
        return data, column
        
    for archive in DATA_PATH.glob(f"*{type}*.txt"):
        
        with archive.open(encoding="utf-8") as f:
            lect = csv.DictReader(f,delimiter=";")
            
            if not column:
                column.extend(lect.fieldnames)
                
            for row in lect:
                data.append(row)
                
    return data, column"""     # La unificación de los dataset's se lleva a cabo en FUNCIONALIDAD.


def transformar_ch04_str(valor):
    """Transforma el valor numérico del género a String."""
    
    if (valor == "1"):
        return "Masculino"
    
    else:
        return "Femenino"


def transformar_nivel_ed_str(value): 
    """Transforma el valor numérico del nivel educativo a String."""
    
    match value:
        case "1":
            return "Primario incompleto."
        case "2":
            return "Primario completo."
        case "3":
            return "Secundario incompleto."
        case "4":
            return "Secundario completo."
        case "5" | "6":
            return "Superior o universitario."
        case "7" | "9":
            return ("Sin información.")


def transformar_condicion_laboral(est_valor, ocup_valor):
    """Transforma el valor numérico del estado laboral a String.."""
    try:
        if est_valor == "1":
            if ocup_valor in ("1", "2"):
                return "Ocupado Autónomo."
            if ocup_valor in ("3", "4", "9"):
                return "Ocupado dependiente."
        if est_valor == "2":
            return "Desocupado."
        if est_valor == "3":
            return "Inactivo."
        if est_valor == "4":
            return "Fuera de categoría/Sin información."
    except Exception:
        pass
    return "Sin información."
    

def clasificar_universitario (edad, nivel_ed):
    """Retorna un String clasificando si una persona mayor de edad completó los estudios universitarios o no."""
    try:
        if (int(edad) < 18):
            return "2"
        elif (nivel_ed in ("7","8")):
            return "1"
        else:
            return "0"
    except (ValueError, TypeError):
        return "0"


def clasificar_tipo_hogar (personas):
    """Clasifica el tipo de hogar dependiendo la cantidad de personas viviendo."""

    try:
        personas = int(personas)
        if personas == 1:
            return "Unipersonal."
        elif 2 <= personas <= 4:
            return "Nuclear."
        else:
            return "Extendido."
    except (ValueError, TypeError):
        return "Desconocido"


def clasificar_material_techumbre(valor):
    """Transformar el valor numérico de la columna V4(material del techo) a String."""
    
    valor = str(valor).strip()
    match valor:
        case "5" | "6" | "7":
            return "Material Precario"
        case "1" | "2" | "3" | "4":
            return "Material Durable"
        case "9":
            return "No aplica"
        case "_":
            return "N/S."


def densidad_hogar(habitaciones, personas):
    """Calcula la densidad del hogar como personas por habitación: Bajo, Medio o Alto."""
    
    try:
        personas = int(personas)
        habitaciones = int(habitaciones)

        densidad = personas / habitaciones

        if densidad < 1:
            return "Bajo"
        elif densidad <= 2:
            return "Medio"
        else:
            return "Alto"
        
    except (ValueError, ZeroDivisionError, TypeError):
        return "Desconocido"



def condicion_habitabilidad (agua, ori_agua, banio, ubi_banio, drenaje, techo):
    """Calcula la condicion de habitabilidad entre las categorias de: Insuficiente, Regular, Saludable y Buena"""
    
    try:
        if agua == '3' or techo == 'No aplica.':
            return 'Insuficiente'
        elif agua == '2':
            if banio == '2':
                return 'Insuficiente'
            if drenaje == '4' or ubi_banio == '3' or ori_agua == '4':
                return 'Insuficiente'
            elif ubi_banio == '2' or ori_agua == '3':
                return 'Regular'
            else:
                return 'Saludable'
        else:
            if techo == 'Material Durable':
                if drenaje == '4' or ubi_banio == '3' or ori_agua == '4':
                    return 'Regular'
                elif ubi_banio == '2' or ori_agua == '3':
                    return 'Saludable'
                else:
                    return 'Buena'
            else:
                return 'Regular'
    except Exception:
        return 'Desconocido'


def procesar_individuos(ind):
    """Procesa todos los individuos unificados, creando las nuevas columnas con los valores transformados."""
    
    for row in ind:
        row["CH04_str"] = transformar_ch04_str(row["CH04"])
        row["NIVEL_ED_str"] = transformar_nivel_ed_str(row["NIVEL_ED"])
        row["CONDICION_LABORAL"] = transformar_condicion_laboral(row["ESTADO"], row["CAT_OCUP"])
        row["UNIVERSITARIO"] = clasificar_universitario(row["CH06"], row["NIVEL_ED"])


def procesar_hogares(hog):
    """Procesa todos los hogares unificados, creando las nuevas columnas con los valores transformados."""
    
    for row in hog:
        row["TIPO_HOGAR"] = clasificar_tipo_hogar(row["IX_TOT"])
        row["MATERIAL_TECHUMBRE"] = clasificar_material_techumbre(row["V4"])
        row["DENSIDAD_HOGAR"] = densidad_hogar(row['IV2'], row['IX_TOT'])
        row["CONDICION_DE_HABITABILIDAD"] = condicion_habitabilidad (
            row['IV6'], row['IV7'], row['IV8'], row['IV9'], row['IV11'], row["MATERIAL_TECHUMBRE"]
        )


def procesar_data(indicator):
    """
    Esta función procesa todos los datos unificados en bruto y crea un nuevo archivo CSV 
    con las nuevas columnas en la carpeta processed_data.
    """
    
    try:
        nombre = "individual" if indicator == 'I' else 'hogar'
    
        data_in = DATA_OUT_PATH / f'usu_{nombre}.csv'
        data_out = PROCESSED_DATA_PATH / f'{nombre}_procesado.csv'
    
        if not (PROCESSED_DATA_PATH.exists()):
            print(f'La carpeta {PROCESSED_DATA_PATH} no existe. Verificá la estructura del proyecto.')
            return
    
        if not (data_in.exists()):
            print(f'El archivo no se encontró. Unifique los datasets primero.')
            return
    
        with data_in.open("r",encoding='utf-8') as d_in:
            csv_reader = csv.DictReader(d_in,delimiter=';')
            data = list(csv_reader)
            columnas = csv_reader.fieldnames.copy()
        
        if indicator == "I":
            procesar_individuos(data)
            nuevas_columnas = ["CH04_str", "NIVEL_ED_str", "CONDICION_LABORAL", "UNIVERSITARIO"]
        else:
            procesar_hogares(data)
            nuevas_columnas = ["TIPO_HOGAR","MATERIAL_TECHUMBRE","DENSIDAD_HOGAR","CONDICION_DE_HABITABILIDAD"]
    
        for col in nuevas_columnas:
            if col not in columnas:
                columnas.append(col)
        
        with data_out.open("w",newline="",encoding="utf-8") as d_out:
            csv_writer = csv.DictWriter(d_out,fieldnames=columnas,delimiter=";")
            csv_writer.writeheader()
            for row in data:
                clean_row = {col: row.get(col, "") for col in columnas}
                csv_writer.writerow(clean_row)
    except Exception as e:
        print(F'Error al procesar los datos. {e}')

# streamlit

import streamlit as st
import os
import time
from pathlib import Path
from constantes import *
from funcionalidad import creacion_datasets, calcular_fechas_comparadas
from procesamiento import procesar_data

st.set_page_config(page_title="B.D.S.E.",layout="wide",page_icon=":computer:")

# --- Sidebar ---
st.sidebar.title("Menú")
pagina = st.sidebar.radio("Navegación", ["Inicio", "Carga de datos"])

# --- Página 1: Inicio ---
if pagina == "Inicio":
    
    
    que_es_eph = '''
→ LA :red-background[*ENCUESTA PERMANENTE DE HOGARES (EPH)*] ES UN PROGRAMA NACIONAL QUE, 
A PARTIR DE RELEVAMIENTOS EN DIFERENTES AGLOMERADOS URBANOS,  
DA A CONOCER LAS TENDENCIAS Y CARACTERÍSTICAS SOCIOECONÓMICAS DE LA POBLACIÓN ARGENTINA.

EL ACCESO A ESTA INFORMACIÓN SE ENCUENTRA EN LA PÁGINA OFICIAL DEL 
[INDEC](https://www.indec.gob.ar/indec/web/Institucional-Indec-BasesDeDatos) DONDE SE PROPORCIONAN UN PAR DE ARCHIVOS 
(HOGAR E INDIVIDUAL) POR CADA TRIMESTRE DE DIFERENTES AÑOS DESDE EL 2016.
'''

    st.title(":bar_chart: BASE DE DATOS SOCIOECONOMICOS")
    st.header("¿Qué es la EPH?")
    st.markdown(que_es_eph)



# --- Página 2: Carga de datos ---
elif pagina == "Carga de datos":
    fechas=calcular_fechas_comparadas(PROCESSED_DATA_HOGAR,PROCESSED_DATA_INDIVIDUAL)
    st.title("BASE DE DATOS ")
    # Ruta de destino para los archivos
    carpeta_destino = DATA_PATH

    # Subida múltiple de archivos (pero sin guardarlos aún),crea una lista con los archivos seleccionados
    uploaded_files= st.file_uploader("Elegí uno o más archivos",accept_multiple_files=True,type=["txt", "csv" , "xls"])
    
    if uploaded_files:
        st.write(f":file_folder: {len(uploaded_files)} archivo(s) seleccionados:")
        #CREO DICCIONARIO PARA VERIFICAR SI SE DEBE SOBRESCRIBIR O NO LOS ARCHIVOS 
        #(se obtiene el nombre del archivo como clave y un valor booleano como valor)
        verificacion_sobreescritura = {}

    #PARA CADA ARCHIVO DE LA LISTA DE ARCHIVOS SUBIDOS, SE VERIFICA SI YA EXISTE EN LA CARPETA 'FILES'
    # SI EXISTE SE INFORMA UNA ADVERTENCIA Y SE PREGUNTA SI SE DESEA SOBRESCRIBIRLO
    # EL VALOR SELECCIONADO SE GUARDA EN EL DICCIONARIO 'verificacion_sobreescritura'
    for uploaded_file in uploaded_files:
        new_file = carpeta_destino / uploaded_file.name
        if new_file.exists():
            st.warning(f":warning: El archivo {uploaded_file.name} ya existe.")
            sobrescribir = st.checkbox(f"¿Sobrescribir {uploaded_file.name}?", key=uploaded_file.name)
            verificacion_sobreescritura[uploaded_file.name] = sobrescribir
        else:
            st.write(f":white_check_mark: '{uploaded_file.name}' listo para guardar.")
            verificacion_sobreescritura[uploaded_file.name] = True  # no existe, se permite guardar

    # SE TOMA EL ARCHIVO SELECCIONADO Y SE COMPRUEBA SI SE DESEA SOBRESCRIBIR O NO. 
    if st.button("Confirmar subida"):
        for uploaded_file in uploaded_files:
            ruta_archivo = carpeta_destino / uploaded_file.name
            if verificacion_sobreescritura.get(uploaded_file.name, False):
                with open(ruta_archivo, "wb") as f:
                    f.write(uploaded_file.read())
                st.success(f":floppy_disk: Archivo guardado: {uploaded_file.name}")
            else:
                st.info(f":x: No se guardó {uploaded_file.name} (no se autorizó sobrescritura).")
                
                
                
    #BOTON PARA ACTUALIZAR LA BASE DE DATOS
    actualizar_base_datos = st.button("Actualizar base de datos")

    if actualizar_base_datos:
        st.write(":hourglass: Iniciando actualización de la base de datos...")
        
        creacion_datasets("I")
        procesar_data("I")
        creacion_datasets("H")
        procesar_data("H")

        # Barra de progreso simulada
        barra_placeholder = st.empty()  # espacio temporal para la barra
        with barra_placeholder:
            barra = st.progress(0)
            for porcentaje in range(1, 101):
                time.sleep(0.02)
                barra.progress(porcentaje)

        # una vez terminado, limpiamos el espacio
        barra_placeholder.empty()

        fechas=calcular_fechas_comparadas(PROCESSED_DATA_HOGAR,PROCESSED_DATA_INDIVIDUAL)
        st.subheader(f":green-background[LA BASE DE DATOS CONTIENE LOS DATOS DE LA EPH"
                    f" DESDE EL {fechas[1]}/{fechas[0]} HASTA {fechas[3]}/{fechas[2]}] ")
        st.success(":white_check_mark: Base de datos actualizada con éxito.")
        
    else :
        st.info("Presioná el botón para actualizar la base de datos.")
        st.subheader(f"LA BASE DE DATOS CONTIENE LOS DATOS DE LA EPH"
                    f" DESDE EL {fechas[1]}/{fechas[0]} HASTA {fechas[3]}/{fechas[2]} ")

