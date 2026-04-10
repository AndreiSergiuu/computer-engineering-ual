Algoritmo Taxi
	Definir kilometros_recorridos, tarifa como Real
	Repetir
		Mostrar "Introduzca los kilómetros recorridos: "
		Leer kilometros_recorridos
		
		Si kilometros_recorridos < 0 Entonces
			Mostrar "El número de kilometros recorridos no es válido."
		FinSi
	Hasta Que kilometros_recorridos >= 0
	Si kilometros_recorridos <= 30 Entonces
		tarifa <- 30
	SiNo
		Si kilometros_recorridos <= 100 Entonces
			tarifa <- 30 + ((kilometros_recorridos - 30) * 15)
		SiNo
			tarifa <- 30 + (70 * 15) + ((kilometros_recorridos - 100) * 10)
		FinSi
	FinSi
	Mostrar "La tarifa para un recorrido de ", kilometros_recorridos, "km es de: ", tarifa, "euros."
FinAlgoritmo
