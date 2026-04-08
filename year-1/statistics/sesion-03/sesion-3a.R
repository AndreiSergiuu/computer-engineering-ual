# 1. Un sistema de detección de spam clasifica correctamente un 82% de los correos electrónicos
# como spam o no spam. Para evaluar su desempeño, se analizan 34 correos electrónicos y se estudia
# la variable aleatoria, que representa el número de correos electrónicos correctamente clasificados.
# Contesta las siguientes preguntas expresando el resultado con, al menos, 4 decimales.

# 1.1. ¿Cuántos correos electrónicos se espera que sean correctamente clasificados?

n_emails <- 34
p_exito <- 0.82

n_esperados <- n_emails * p_exito

cat(sprintf(
  "Se esperan %.4f correos clasificados correctamente \n",
  n_esperados
))

# 1.2. ¿Cuál es la probabilidad de que al menos 16 correos electrónicos sean correctamente clasificados?
p_min_16 <- 1 - pbinom(q = 15, size = n_emails, prob = p_exito)
cat(
  sprintf(
    "Hay una probabilidad de %.10f de que 16 correos sean correctamente clasificados \n",
    p_min_16
  )
)

# 1.3. ¿Cuál es la probabilidad de que ninguno sea correctamente clasificado?
p_0_correctos <- pbinom(q = 0, size = n_emails, prob = p_exito)
cat(
  sprintf(
    "La probabilidad que no clasifique ninguno correctamente es %.30f \n",
    p_0_correctos
  )
)

# 2.El número de veces al mes que, por diferentes motivos, suena la alarma de una fábrica, sigue una
# distribución de Poisson. Se ha observado que la probabilidad de que en un mes no suene la alarma es
# 0.018316.

# 2.1. ¿Cuál es el número medio de veces al mes en que suena la alarma de la mencionada fábrica?
# Redondea tu respuesta al entero más cercano.
p_0_alarmas <- 0.018316
lambda <- -log(p_0_alarmas)

cat(
  sprintf(
    "Para una prob de %.7f, el numero medio de salto de alarma es %.f dias al mes \n",
    p_0_alarmas,
    lambda
  )
)

# 2.2. ¿Cuál es la probabilidad de que en un mes suene 5 veces? Responde con al menos 4 decimales.
p_5_alarmas <- dpois(x = 5, lambda = lambda)
cat(sprintf(
  "La probabilidad de que en un mes suene 5 veces es %.4f \n",
  p_5_alarmas
))

# 2.3. ¿Cuál es la probabilidad de que en un mes suene al menos una vez? Responde con al menos 4 decimales.
p_min_1_alarma <- 1 - ppois(q = 0, lambda = lambda)
cat(sprintf(
  "La probabilidad de que al menos suene una vez en un mes es %.4f \n",
  p_min_1_alarma
))

# 2.4. ¿Cuál es la probabilidad de que en un año suene 51 veces? Responde con al menos 4 decimales.
lambda_anual <- lambda * 12
p_51_anual <- dpois(x = 51, lambda = lambda_anual)
cat(sprintf(
  "La probabilidad de que suene 51 veces en un año es de %.4f \n",
  p_51_anual
))