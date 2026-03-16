# Establecer directorio de trabajo
setwd(dirname(rstudioapi::getActiveDocumentContext()$path))

# Importar datos descargados de Moodle
datos = read.table("tortugas.xls", header= TRUE)

# 1. Realiza el gráfico más apropiado para la variable Sexo. ¿Qué gráfico has realizado?: 

# Se ha escogido usar un diagrama de sectores.

# Obtener los datos relacionados al Sexo
datos_sexo = datos$Sexo

# Crear el diagrama de sectores
pie(table(datos_sexo),
    main = "Proporción de Sexo en la Muestra",
    labels = c("Hembras", "Machos", "Sin determinar"),
    col = c("lightpink", "skyblue", "lightgray"),
    border = "white",
    init.angle = 90,
)

# 2. ¿Cuál es el peso máximo del 16% de los ejemplares más ligeros?

round(quantile(datos$Peso, probs = 0.16, na.rm = TRUE), 2)

# 3. ¿Cuál es el ancho mínimo del 26% de los ejemplares más anchos?:
round(quantile(datos$Anchura, probs = 1 - 0.26, na.rm = TRUE), 2)

# 4. Para la variable Anchura, calcula los siguientes estadísticos descriptivos:
# Media, Mediana, Rango, Rango Intercuartílico.

# Obtener los datos relacionados a la Anchura
datos_anchura = datos$Anchura

# Obtener la media
round(mean(datos_anchura, na.rm = TRUE), 2)

# Obtener la mediana
round(median(datos_anchura, na.rm = TRUE), 2)

# Obtener el rango
round(diff(range(datos_anchura, na.rm = TRUE)), 2)

# Obtener Rango Intercuartílico.
round(IQR(datos_anchura, na.rm = TRUE),2)

# 5. Si diferenciamos los ejemplares por sexo (macho o hembra), 
# ¿cuál tiene la variable Longitud más homogénea?

round(tapply(datos$Longitud, datos$Sexo, sd, na.rm = TRUE), 2)

# 6. Representa el diagrama de cajas y bigotes de la variable Peso para comparar 
# los ejemplares juveniles y senior. ¿Se podría decir que la variabilidad del 50% 
# central de ambas distribuciones es, aproximadamente, similar?

# Datos filtrados por Peso y Edad
datos_peso <- datos[datos$Edad %in% c("Juvenil", "Senior"), ]

# Creación del Diagrama de Caja y Bigotes
boxplot(Peso ~ Edad, data = datos_peso, main = "Distribución del Peso por Edad", xlab = "Categoría de Edad", ylab = "Peso", col = c("skyblue", "tan"))

# 7. Implementa una función para el cálculo de la varianza, utilizando la expresión vista en clase de teoría. Utiliza dicha función para calcular la varianza
# y la desviación típica de la variable Longitud.

calcular_varianza <- function(x) {
  # Limpiamos NAs para evitar errores
  x <- x[!is.na(x)]
  
  # N es el número total de elementos
  N <- length(x)
  
  # Aplicamos la fórmula de la teoria:
  # (Suma de x^2 / N) - media^2
  resultado <- (sum(x^2) / N) - (mean(x)^2)
  
  return(resultado)
}

# Calculo de la varianza
varianza_longitud <- round(calcular_varianza(datos$Longitud), 2)

# Calculo de la desviación típica
round(sqrt(varianza_longitud), 2)

# 8. Implementa una función para el cálculo del momento de orden r con respecto 
# a la media, utilizando la expresión vista en clase de teoría. Utiliza dicha 
# función para calcular el coeficiente de asimetría y la curtosis de la 
# variable Longitud.:

momento_central <- function(x, r) {
  x <- x[!is.na(x)] # Limpieza de datos
  n <- length(x)
  media <- mean(x)
  
  # Fórmula: suma de las diferencias a la r, dividido por N
  m_r <- sum((x - media)^r) / n
  return(m_r)
}

# Desviación Típica 
s2 <- momento_central(datos$Longitud, 2)
s <- sqrt(s2)

# Coeficiente de Asimetría
asimetria_longitud <- round(momento_central(datos$Longitud, 3) / s^3, 2)
asimetria_longitud
# Coeficiente de Curtosis
curtosis_longitud <- round((momento_central(datos$Longitud, 4) / s^4) - 3, 2)
curtosis_longitud
