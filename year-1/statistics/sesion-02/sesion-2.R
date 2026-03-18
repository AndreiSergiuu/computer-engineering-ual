# Establecer directorio de trabajo
setwd(dirname(rstudioapi::getActiveDocumentContext()$path))

# Importar datos descargados de Moodle
datos <- read.table("regresion.xls", header = TRUE)

# 1. Implementa una función para el cálculo de la covarianza, utilizando la expresión
# vista en clase de teoría. Utiliza dicha función para calcular la covarianza de las
# variables Tiempo y Gasto.

calcular_covarianza <- function(x, y) {
  n <- length(x)
  sum_xy <- sum(x * y)
  sum_x <- sum(x)
  sum_y <- sum(y)
  
  covarianza <- (sum_xy - (sum_x * sum_y) / n) / n
  return(covarianza)
}

covarianza_tiempo_gasto <- calcular_covarianza(datos$Tiempo, datos$Gasto)
cat(sprintf(
  "La covarianza entre Tiempo y Gasto es: %.2f\n\n",
  covarianza_tiempo_gasto
))

# 2. Calcula el coeficiente de correlación de Pearson entre las dos variables. Implementa tu
# propia función utilizando la expresión vista en clase de teoría. Compara el resultado
# con el obtenido por la función cor().

calcular_pearson <- function(x, y) {
  varianza_x <- (sum(x^2) / length(x)) - mean(x)^2
  varianza_y <- (sum(y^2) / length(y)) - mean(y)^2
  
  desviacion_x <- sqrt(varianza_x)
  desviacion_y <- sqrt(varianza_y)
  
  r <- calcular_covarianza(x, y) / (desviacion_x * desviacion_y)
  return(r)
}

coeficiente_calculado <- calcular_pearson(datos$Tiempo, datos$Gasto)
coeficiente_cor <- cor(datos$Tiempo, datos$Gasto)

cat(sprintf(
  "Coeficiente de Pearson calculado: %.2f\n",
  coeficiente_calculado
))
cat(sprintf("Coeficiente de Pearson con cor(): %.2f\n\n", coeficiente_cor))

# 3. Para explicar la variable Gasto en función de la variable Tiempo, ajusta un modelo
# de regresión lineal. Devuelve los coeficientes del modelo ajustado.

# Modelo de regresion lineal simple Y sobre X
modelo_gasto_tiempo <- lm(Gasto ~ Tiempo, data = datos)

cat("Coeficientes del modelo de Gasto sobre Tiempo:\n")
print(coef(modelo_gasto_tiempo))
cat("\n")

# Mostrar grafico de dispersión con la línea de regresión
plot(
  datos$Tiempo,
  datos$Gasto,
  pch = 20,
  col = "blue",
  xlab = "Tiempo",
  ylab = "Gasto",
  main = "Regresión Lineal: Gasto vs Tiempo"
)
abline(modelo_gasto_tiempo, col = "black", lwd = 2)

# 4. Utilizando el modelo ajustado, ¿cuánto gastará en estas aplicaciones una persona que
# se pasa 5 horas/día en aplicaciones de IA?

r2 <- summary(modelo_gasto_tiempo)$r.squared
cat(sprintf(
  "El modelo explica el %.2f%% de la variabilidad del Gasto.\n",
  r2 * 100
))

gasto_predicho <- predict(modelo_gasto_tiempo, newdata = data.frame(Tiempo = 5))
cat(sprintf("Gasto estimado para 5 horas/día: %.2f\n\n", gasto_predicho))

# 5. Ajusta un modelo de regresión lineal de Tiempo sobre Gasto utilizando únicamnete
# aquellas observaciones que cumplen que Gasto > 45. Devuelve los coeficientes del modelo ajustado.

# Filtrar los datos para Gasto > 45
datos_filtrados <- subset(datos, Gasto > 45)

# Modelo de regresion lineal simple Y sobre X con los datos filtrados
modelo_filtrado <- lm(Tiempo ~ Gasto, data = datos_filtrados)

cat("Coeficientes del modelo (Tiempo sobre Gasto, Gasto > 45):\n")
print(coef(modelo_filtrado))
cat("\n")

# Mostrar grafico de dispersión con la línea de regresión para los datos filtrados
plot(
  datos_filtrados$Gasto,
  datos_filtrados$Tiempo,
  pch = 20,
  col = "red",
  xlab = "Gasto",
  ylab = "Tiempo",
  main = "Regresión: Tiempo vs Gasto (Gasto > 45)"
)
abline(modelo_filtrado, col = "black", lwd = 2)

# 6. Considera de nuevo el conjunto de datos completo. Supón que se ha detectado un error,
# de manera que para cada registro la variable Tiempo se debe aumentar en un 8% y la variable
# Gasto se debe aumentar en 11 euros/año. Ajusta un nuevo modelo de regresión con los datos
# corregidos, utilizando Tiempo como variable independiente, y devuelve los coeficientes de
# dicho modelo.

tiempo_corregido <- datos$Tiempo * 1.08
gasto_corregido <- datos$Gasto + 11

modelo_corregido <- lm(gasto_corregido ~ tiempo_corregido)

cat("Coeficientes del modelo corregido (Gasto corregido sobre Tiempo corregido):\n")
print(coef(modelo_corregido))
cat("\n")

# 7. Para las variables corregidas de la pregunta anterior, calcula su covarianza y su correlación.
# Compara el resultado con el obtenido usando las variables originales. ¿Ha habido algún cambio?

covarianza_corregida <- calcular_covarianza(tiempo_corregido, gasto_corregido)
pearson_corregido <- calcular_pearson(tiempo_corregido, gasto_corregido)

cat(sprintf("Covarianza corregida: %.2f\n", covarianza_corregida))
cat(sprintf("Coeficiente de Pearson corregido: %.2f\n", pearson_corregido))