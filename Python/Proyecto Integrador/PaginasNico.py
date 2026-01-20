import matplotlib.pyplot as plt
import streamlit as st
import pandas as pd 
import time
import streamlit as st
import altair as alt

#- - - - - - - - - - - - - - - - - - - - - - - - - - - -INCISO 3.3 - - - - - - - - - - - - - - - - - - - - - - - - - - 
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -AUX 3.3 - - - - - - - - - - - - - - - - - - - - - - - - - - 
def mostrar_aglo(aglomerado):
    """
    Muestra el nombre del aglomerado seleccionado.
    Parameters:
        aglomerado (int): Valor del aglomerado seleccionado.
    Returns:
        Mapeo a string con el nombre del aglomerado.
    """
    return f' {aglo_dict()[aglomerado]}'

def mostrar_grafico_dependencia(evolucion):
    """
    Muestra un gráfico de barras de la evolución de la dependencia demográfica.
    
    Parameters:
        evolucion (DataFrame): DataFrame que contiene la evolución de la dependencia demográfica.
    Returns:
        chart: Gráfico de barras de Altair con la evolución.
    """
    evolucion2 = pd.DataFrame(evolucion)
    # Crear columna de periodo combinado
    evolucion2['Periodo'] = 'Año: ' + evolucion2['Año'].astype(str) + ', Trim: ' + evolucion2['Trimestre'].astype(str)
    
    # Crear gráfico de barras con Altair
    chart = alt.Chart(evolucion2).mark_line(point=True).encode(
        x=alt.X('Periodo:N', sort=None, title='Periodo'),
        y=alt.Y('Proporcion:Q', title='Proporción'),
        tooltip=['Periodo', 'Proporcion']
    ).properties(
        width=600,
        height=400,
        title='Evolución de Dependencia Demográfica'
    ).configure_axisX(
        labelAngle=0
    )
    
    return chart

def hacer_calculo(grupo):
    """
    Calcula la proporción de población inactiva sobre la activa en un grupo de datos.
    
    Parameters:
        grupo (DataFrame): DataFrame que contiene los datos del grupo.
    Returns:
        float: Proporción de población inactiva sobre la activa, multiplicada por 100.
        Si la población activa es 0, retorna 0.
    """
    pob_inactiva = grupo.loc[((grupo['CH06']> 0) & ((grupo['CH06']<=14) |  (grupo['CH06']>=65))), 'PONDERA'].sum()
    pob_activa = grupo.loc[((grupo['CH06']>=15) & (grupo['CH06']<=64)), 'PONDERA'].sum()
    return (pob_inactiva/pob_activa) * 100 if pob_activa != 0 else 0
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -MAIN 3.3 - - - - - - - - - - - - - - - - - - - - - - - - - -
def calcular_dependencia_demografica():
    """
    Calcula y muestra la evolución de la dependencia demográfica por aglomerado, año y trimestre.
    Raises:
        FileNotFoundError: Si no se encuentra el archivo de datos procesados.
        ValueError: Si hay un error al convertir los datos a numéricos.
        Warning: Si faltan columnas requeridas en el DataFrame.
    """
    try:
        individuos = pd.read_csv(PROCESSED_DATA_INDIVIDUAL, delimiter=';', encoding='utf-8')
        columnas_necesarias = {'ANO4', 'TRIMESTRE', 'CH06', 'AGLOMERADO', 'PONDERA'}
        if not columnas_necesarias.issubset(individuos.columns):
            st.warning("Faltan columnas requeridas ('ANO4', 'TRIMESTRE', 'CH06', 'AGLOMERADO', 'PONDERA')")
            

        individuos['ANO4'] = pd.to_numeric(individuos['ANO4'], errors='coerce')
        individuos['TRIMESTRE'] = pd.to_numeric(individuos['TRIMESTRE'], errors='coerce')
        individuos['CH06'] = pd.to_numeric(individuos['CH06'], errors='coerce')
        individuos['PONDERA'] = pd.to_numeric(individuos['PONDERA'], errors='coerce')
        individuos['AGLOMERADO'] = individuos['AGLOMERADO'].astype(str)

        aglo_disponibles = (individuos['AGLOMERADO'].unique())
        aglo_seleccionado = st.selectbox("Seleccionar aglomerado", aglo_disponibles, key='1.3.3')
        

        
        if aglo_seleccionado:
            filtrar_hogar = individuos[(individuos ['AGLOMERADO'] == aglo_seleccionado)]
            # calcula la dependencia demografica
            depen_demografica = filtrar_hogar.groupby(['ANO4', 'TRIMESTRE']).apply (hacer_calculo).reset_index()
            # columnas del df a imprimir
            depen_demografica.columns = ['Año', 'Trimestre', 'Proporcion']
            depen_demografica= depen_demografica.sort_values(['Año','Trimestre']).reset_index(drop=True)
            # nombre del aglomerado
            nom_Aglo = mostrar_aglo(aglo_seleccionado)
            st.write (f'Evolucion del aglomerado llamado {nom_Aglo}')
            fig = mostrar_grafico_dependencia (depen_demografica)
            st.altair_chart(fig, use_container_width=True)
    except FileNotFoundError:
        st.error("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        st.error("Error: se esperaba un número pero se recibió otro dato.")

#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

#- - - - - - - - - - - - - - - - - - - - - - - - - - - -INCISO 4.4 - - - - - - - - - - - - - - - - - - - - - - - - - - 
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -AUX 4.4 - - - - - - - - - - - - - - - - - - - - - - - - - - 
def mostrar_aglo (aglomerado):
    """
    Muestra el nombre del aglomerado seleccionado.
    Parameters:
        aglomerado (int): Valor del aglomerado seleccionado.
    Returns:
        Mapeo a string con el nombre del aglomerado.
    """
    return f' {aglo_dict()[aglomerado]}'

def mostrar_grafico_prop_banio(estructura):
    df = pd.DataFrame([
        {'Aglomerado': aglo, 'Proporción con baño dentro del hogar (%)': valor}
        for aglo, valor in estructura.items()
    ])

    ordenada = df.sort_values("Proporción con baño dentro del hogar (%)", ascending=False)

    fig, ax = plt.subplots(figsize=(12, 6))
    ax.barh(ordenada['Aglomerado'], ordenada['Proporción con baño dentro del hogar (%)'])
    ax.set_xlabel('Proporción con baño dentro del hogar (%)')
    ax.set_ylabel('Aglomerado')
    ax.set_title('Proporción de viviendas con baño dentro del hogar')
    ax.grid()

    return fig

def evaluarTodos(hogares, anios, aglomerados):
    """
    Calcula la proporción de viviendas con baño dentro del hogar por aglomerado,
    considerando todos los años disponibles.

    Parameters:
        hogares: DataFrame con datos de hogares.
        anios: Lista de años disponibles para el análisis.
        aglomerados: Lista de aglomerados a evaluar.

    Returns:
        dic_x_aglo: Diccionario con la proporción de viviendas con baño dentro del hogar por aglomerado.
    """
    dic_x_aglo = {}
    for aglo in aglomerados:
        casas_totales = 0
        cant_con_banio = 0
        clave = f'{mostrar_aglo(aglo)}'
        for anio in anios:
            filtro = (hogares['AGLOMERADO'] == aglo) & (hogares['ANO4'] == anio)
            casas_totales += (hogares[filtro]['PONDERA'].sum())
            cant_con_banio += (hogares[filtro & (hogares['IV9']== 1)]['PONDERA'].sum())
        proporcion = cant_con_banio/casas_totales if casas_totales != 0 else 0
        dic_x_aglo[clave] = round(proporcion*100,2)
    return dic_x_aglo

def evaluarUnAño(hogares, opcion, aglomerados):
    dic_un_anio={}
    for aglo in aglomerados:
        clave = f'{mostrar_aglo(aglo)}'
        casas_totales = (hogares[(hogares['ANO4'] == opcion) & (hogares['AGLOMERADO']== aglo)]['PONDERA'].sum())
        cant_con_banio = hogares[(hogares['ANO4'] == opcion) & (hogares['AGLOMERADO']==aglo) & (hogares['IV9'] == 1)]['PONDERA'].sum()
        proporcion = cant_con_banio/casas_totales if casas_totales != 0 else 0
        dic_un_anio[clave] = ((proporcion*100).round(2))
    return dic_un_anio
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -MAIN 4.2 - - - - - - - - - - - - - - - - - - - - - - - - - -


def banio_dentro_hogar_aglomerado(opcion, anios):
    """
    Muestra la proporción de viviendas con baño dentro del hogar por aglomerado,
    filtrado por año y trimestre si es necesario.
    
    Parameters
    ----------
    opcion : str o int
        Año seleccionado o "Todos"
    anios : list
        Lista de años disponibles para el análisis
    Raises:
    -------
    FileNotFoundError: Si no se encuentra el archivo de datos.
    ValueError: Si se espera un número pero se recibe otro dato.
    Warning: Si faltan columnas requeridas en el DataFrame, muestra un mensaje de advertencia en Streamlit.
    """
    try:
        hogares = pd.read_csv(PROCESSED_DATA_HOGAR, delimiter=';', encoding='utf-8')
        columnas_necesarias = {'ANO4', 'IV9', 'AGLOMERADO', 'PONDERA'}
        if not columnas_necesarias.issubset(hogares.columns):
            st.warning("Faltan columnas requeridas ('PONDERA' , 'ANO4' o 'IV9').")
            
        
        hogares['ANO4'] = pd.to_numeric(hogares['ANO4'], errors='coerce')
        hogares['IV9'] = pd.to_numeric(hogares['IV9'], errors='coerce')
        hogares['PONDERA'] = pd.to_numeric(hogares['PONDERA'], errors='coerce')
        hogares['AGLOMERADO'] = hogares['AGLOMERADO'].astype(str)

        aglomerados = (hogares['AGLOMERADO'].unique())

        if opcion == 'Todos':
            estructura = evaluarTodos(hogares, anios, aglomerados)     
        else:
            estructura = evaluarUnAño(hogares, opcion, aglomerados)
        fig =  mostrar_grafico_prop_banio(estructura)
        st.pyplot(fig)
        #aglo_con_banio = hogares.groupby([ANO4, AGLOMERADO]).apply (calcular_prop).reset_index()  
    except FileNotFoundError:
        st.error("Error: no se encontró uno de los archivos especificados.")
    except ValueError:
        st.error("Error: se esperaba un número pero se recibió otro dato.")

#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -MAIN 5.2 - - - - - - - - - - - - - - - - - - - - - - - - - -
def evolucion_desempleo():
    """
    Grafica la evolución de la tasa de desempleo a lo largo del tiempo,
    ya sea a nivel país o filtrado por un aglomerado en particular.

    Returns
    -------
    None
        Muestra un gráfico con la evolución de la tasa de desempleo.
    Raises
    ------
        FileNotFoundError
            Si no se encuentra el archivo de datos procesados.
        TypeError
            Si hay un error en los parámetros de llamada de la función.
        Warning
            Si faltan columnas necesarias para calcular la tasa de desempleo.
    """
    try:
        datos_personas = pd.read_csv(PROCESSED_DATA_INDIVIDUAL, delimiter=';')

        columnas = {'ANO4', 'TRIMESTRE', 'PONDERA', 'CONDICION_LABORAL', 'AGLOMERADO'}
        if not columnas.issubset(datos_personas.columns):
            st.warning("Faltan columnas necesarias para calcular desempleo.")
            return

        datos_personas['ANO4'] = pd.to_numeric(datos_personas['ANO4'], errors='coerce')
        datos_personas['TRIMESTRE'] = pd.to_numeric(datos_personas['TRIMESTRE'], errors='coerce')
        datos_personas['PONDERA'] = pd.to_numeric(datos_personas['PONDERA'], errors='coerce')
        datos_personas['AGLOMERADO'] = datos_personas['AGLOMERADO'].astype(str)
        datos_personas['CONDICION_LABORAL'] = datos_personas['CONDICION_LABORAL'].astype(str)
        
        aglomerados = sorted(datos_personas['AGLOMERADO'].unique())
        selec_aglo = st.selectbox('Seleccione un aglomerado (Opcional)', ['Total País'] + aglomerados)
        
        if selec_aglo != 'Total País':
            datos_personas = datos_personas[datos_personas['AGLOMERADO'] == selec_aglo]
            nombre_aglomerado = aglo_dict().get(selec_aglo,selec_aglo)
        else:
            nombre_aglomerado = 'Total País'
        
        datos_personas = datos_personas.dropna(subset=['ANO4','TRIMESTRE','PONDERA','AGLOMERADO','CONDICION_LABORAL'])
        datos_personas['PERIODO'] = datos_personas['ANO4'].astype(str) + 'TRIM' + datos_personas['TRIMESTRE'].astype(str)
        
        tipos = ['desempleo', 'empleo']

        selec_tipo = st.selectbox('Seleccione la tasa de empleo o desempleo', tipos)
        resumen = datos_personas.groupby('PERIODO', group_keys=False).apply(lambda grupo: calcular_tasa(grupo, selec_tipo)).reset_index(name='Tasa')

        fig, ax = plt.subplots(figsize=(12, 6))
        ax.plot(resumen['PERIODO'], resumen['Tasa'], marker='o', linestyle='-', color='tomato')
        ax.set_title(f'Tasa de {selec_tipo} en el tiempo - {nombre_aglomerado}')
        ax.set_ylabel('Tasa (%)')
        ax.set_xlabel('Periodo (Año + Trimestre)')
        ax.grid(True)
        plt.xticks(rotation=45)
        plt.tight_layout()

        st.pyplot(fig)
        
    except FileNotFoundError:
        st.error('No se encontró el archivo especificado.')
    except TypeError:
        st.error('Error en los parametros de llamada de la función.')

#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -INCISO 6.3 - - - - - - - - - - - - - - - - - - - - - - - - - - 
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -AUX 6.3 - - - - - - - - - - - - - - - - - - - - - - - - - - 
def mostrar_aglo(aglomerado):
    """
    Muestra el nombre del aglomerado seleccionado.
    Parameters:
        aglomerado (int): Valor del aglomerado seleccionado.
    Returns:
        Mapeo a string con el nombre del aglomerado.
    """
    return f' {aglo_dict()[aglomerado]}'

def convertir(archivo_hogares, archivo_personas):
    """
    Convierte los datos de hogares y personas en un archivo CSV con el top 5 de aglomerados universitarios.
    Parameters:
        archivo_hogares (str): Ruta al archivo de datos de hogares procesados.
        archivo_personas (str): Ruta al archivo de datos de personas procesados.
    Returns:
        None
    """
    top_5 = top_5_aglomerados_universitarios(archivo_hogares, archivo_personas, ok = True)
    archivo_nuevo_csv = "Top 5 aglomerados universitarios.csv"

    with open(archivo_nuevo_csv, mode='w', newline='', encoding='utf-8') as nuevo_arch:
        escritor = csv.writer(nuevo_arch, delimiter=';')
        
        # Escribir encabezado
        escritor.writerow(["Aglomerado", "Porcentaje (%)"])
        
        # Escribir los 5 primeros formateados
        for codigo, porcentaje in top_5[:5]:
            escritor.writerow([mostrar_aglo(codigo), f"{porcentaje:.2f}"])
#- - - - - - - - - - - - - - - - - - - - - - - - - - - -MAIN 6.3 - - - - - - - - - - - - - - - - - - - - - - - - - -
def convertir_top5_csv():
    """
    Convierte el ranking de los 5 aglomerados con mayor porcentaje de hogares con 2 o más universitarios a un archivo CSV.
    Parameters
    ----------
    None
    Returns
    -------
    None
    Raises
    ------
    ValueError
        Si se espera un número pero se recibe otro dato.
    """
    try:
        st.subheader('Se convertirá el ranking de los 5 aglomerados con mayor porcentaje de hogares con 2 o más universitarios a un archivo CSV.')
        st.write('¿Desea continuar?')
        
        hacer = st.button('Continuar')
        
        if hacer:
            convertir(PROCESSED_DATA_HOGAR, PROCESSED_DATA_INDIVIDUAL)
            
            # Barra de progreso simulada
            barra_placeholder = st.empty()
            with barra_placeholder:
                barra = st.progress(0)
                for pct in range(0, 101):
                    time.sleep(0.02)
                    barra.progress(pct)
            barra_placeholder.empty()
            
            st.success('El archivo CSV con los 5 aglomerados con más universitarios se creó exitosamente.')
            
            # Botón para descargar el archivo recién creado
            with open("Top 5 aglomerados universitarios.csv", "rb") as file:
                st.download_button(
                    label="📥 Descargar CSV",
                    data=file,
                    file_name="top5_aglomerados.csv",
                    mime='text/csv'
                )
                
    except ValueError:
        st.error("Error: se esperaba un número pero se recibió otro dato.")


#- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -