Algoritmo Maximo_Conjunto_No_Conocido_V1
	Definir temperatura, temperatura_maxima Como Real
	Definir i Como Entero
	i = 0
	Mientras  temperatura <> -999
		Escribir "Introduzca la temperatura deseada (> -999):"
		Leer temperatura
		Si i == 0 o temperatura > temperatura_maxima Entonces
			temperatura_maxima = temperatura
		FinSi
		i = i + 1
	FinMientras
	Escribir "La temperatura máxima introducida es ", temperatura_maxima, " ºC"
FinAlgoritmo
