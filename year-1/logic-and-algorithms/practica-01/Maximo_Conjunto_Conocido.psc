Algoritmo Maximo_Conjunto_Conocido
	Definir n_temperaturas, i como Entero
	Definir temperatura, temperatura_maxima como Real
	i = 0
	Repetir
		Escribir "Introduzca el numero de temperaturas que desea introducir (> 0): "
		Leer n_temperaturas
		Si n_temperaturas <= 0 Entonces
			Escribir "El número que has introducido no es correcto, debe ser positivo (> 0)"
		FinSi
	Hasta Que n_temperaturas > 0
	Repetir 
		Escribir "Introduzca la temperatura nº ", i + 1, ": "
		Leer temperatura
		Si temperatura > temperatura_maxima o i == 0 Entonces
			temperatura_maxima = temperatura
		FinSi
		i = i + 1
	Hasta Que i == n_temperaturas
	Escribir "La temperatura máxima introducida es ", temperatura_maxima, " ºC"
FinAlgoritmo
