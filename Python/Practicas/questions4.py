import random
puntaje = 0

# Preguntas para el juego
questions = [
    "¿Qué función se usa para obtener la longitud de una cadena en Python?",
    "¿Cuál de las siguientes opciones es un número entero en Python?",
    "¿Cómo se solicita entrada del usuario en Python?",
    "¿Cuál de las siguientes expresiones es un comentario válido en Python?",
    "¿Cuál es el operador de comparación para verificar si dos valores son iguales?"
]
# Respuestas posibles para cada pregunta, en el mismo orden
#que las preguntas
answers = [
    ("size()", "len()", "length()", "count()"),
    ("3.14", "'42'", "10", "True"),
    ("input()", "scan()", "read()", "ask()"),
    (
        "// Esto es un comentario",
        "/* Esto es un comentario */",
        "-- Esto es un comentario",
        "# Esto es un comentario",
    ),
    ("=", "==", "!=", "==="),
]
# Índice de la respuesta correcta para cada pregunta, el el
#mismo orden que las preguntas
correct_answers_index = [1, 2, 0, 3, 1]

# Se selecciona el conjunto de preguntas y respuestas aleatorias (3 max)
# No pueden repetirse
questions_to_ask = random.sample(list(zip(questions, answers, correct_answers_index)), k=3)

# El usuario deberá contestar 3 preguntas
for quest, ans, correct_answer in questions_to_ask:

    # Se muestra la pregunta y las respuestas posibles
    print(quest)

    # Se usa aux_ans para no pisar ans
    for i, aux_ans in enumerate(ans):
        print(f"{i + 1}. {aux_ans}")

    # El usuario tiene 2 intentos para responder correctamente
    for intento in range(2):
        user_answer = (input("Respuesta: ")) 

        #Si la respuesta no es valida, se termina el programa
        if user_answer < "1" or user_answer > "4":
            print ("Respuesta no valida")
            exit(1) 

# Se verifica si la respuesta es correcta
        if int(user_answer)-1 == correct_answer:
            print("¡Correcto!")
            puntaje += 1
            break
        else:
            puntaje -= 0.5
    else:

        # Si el usuario no responde correctamente después de 2 intentos,
        # se muestra la respuesta correcta
        print("Incorrecto. La respuesta correcta es:")
        print(ans[correct_answer])

# Se imprime un blanco al final de la pregunta
    print()

print (f'Usted hizo {puntaje} puntos')