# 1. En una empresa los empleados se clasifican en dos categorías: técnicos y especialistas.
# El salario medio mensual (€) y la varianza de los salarios (€) de cada categoría en el mes de
# Diciembre de 2023 son los que aparecen en el siguiente cuadro:
#
# 	           Media	 Varianza
# Técnicos	    2900	 86279
# Especialistas	3610	 15070

# Calcula el coeficiente de variación de cada grupo
# (Introduce todas las respuestas numéricas con al menos 2 decimales):

# Datos del enunciado
media_tecnicos <- 2900
media_especialistas <- 3610

varianza_tecnicos <- 86279
varianza_especialistas <- 15070

# Desviacion típica
desviacion_tecnicos <- sqrt(varianza_tecnicos)
desviacion_especialistas <- sqrt(varianza_especialistas)

# Coeficiente de Variacion
coeficiente_variacion_tecnicos = desviacion_tecnicos / media_tecnicos
coeficiente_variacion_especialistas = desviacion_especialistas / media_especialistas

# Mostrar los resultados
cat(
  sprintf(
    "El coeficiente de variazión de los empleados tecnicos es: %.2f\n",
    coeficiente_variacion_tecnicos
  )
)
cat(
  sprintf(
    "El coeficiente de variazión de los empleados especialistas es: %.2f\n",
    coeficiente_variacion_especialistas
  )
)

# 2. En la discusión para fijar los salarios de 2026 se ha propuesto elevar todos
# los salarios en un 7%. Calcula la media y varianza del salario de cada grupo tras
# aplicar esta medida.

# Datos actualizados sobre la media
media_tecnicos_actualizada <- media_tecnicos * 1.07
media_especialistas_actualizada <- media_especialistas * 1.07

cat(
  sprintf(
    "El nuevo salario de los empleados tecnicos es: %.2f\n\n",
    media_tecnicos_actualizada
  )
)
cat(
  sprintf(
    "El nuevo salario de los empleados especialistas es: %.2f\n\n",
    media_especialistas_actualizada
  )
)

# Datos actualizados sobre la varianza
varianza_tecnicos_actualizada <- varianza_tecnicos * (1.07^2)
varianza_especialistas_actualizada <- varianza_especialistas * (1.07^2)

cat(sprintf("La nueva varianza de los técnicos es: %.2f\n", varianza_tecnicos_actualizada))
cat(sprintf("La nueva varianza de los especialistas es: %.2f\n", varianza_especialistas_actualizada))

# 2. Contesta a las siguientes preguntas usando al menos 2 decimales para las preguntas 
# de respuesta numérica. Expresa el resultado en porcentaje SOLO si se pide explícitamente.

# Cargar los datos del archivo de Moodle
datos = read.table("contaminacion_aire.xls", header = TRUE)

# 2.1 Devuelve la distribución de frecuencias relativas (en %) de la variable Punto_muestreo:
prop.table(table(datos$Punto_muestreo)) * 100

# 2.2 Agrupa la variable Nitrógeno en 4 intervalos de igual amplitud y la variable Viento en 2 
# intervalos también de igual amplitud, todos cerrados por la derecha (primer intervalo también 
# cerrado por la izquierda). Con las variables agrupadas, construye la tabla de frecuencias 
# relativas de la variable Viento condicionada a Nitrógeno y completa la siguiente tabla, 
# expresando el resultado en porcentaje

# Creacion de Intervalos
datos$N_agrupado <- cut(datos$Nitrogeno, breaks = 4, right = TRUE, include.lowest = TRUE)
datos$V_agrupado <- cut(datos$Viento, breaks = 2, right = TRUE, include.lowest = TRUE)

# Crear la tabla de frecuencia
tabla_frecuencia <- table(datos$N_agrupado, datos$V_agrupado)

# Pasar los datos a porcentaje y redondearlo
tabla_porcentaje <- round(prop.table(tabla_frecuencia, margin = 1) * 100, 2)

# Mostrar la tabla
print(tabla_porcentaje)

