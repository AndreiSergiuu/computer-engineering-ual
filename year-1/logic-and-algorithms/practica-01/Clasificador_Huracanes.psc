Algoritmo Clasificador_Huracanes
    Repetir
		Mostrar "Introduzca la velocidad del viento (KM/H):"
        Leer Velocidad
        Si Velocidad <= 0 Entonces
            Mostrar "Error: La velocidad no puede ser negativa"
        SiNo 
            Si Velocidad < 119 Entonces
                Mostrar "Velocidad de ", Velocidad, " km/h: No alcanza fuerza de huracán"
            FinSi
        FinSi
    Hasta Que Velocidad > 118
	Si Velocidad >= 119 Y Velocidad <= 153 Entonces
		Mostrar "Categoría 1. Daños mínimos"
	SiNo
		Si Velocidad >= 154 Y Velocidad <= 177 Entonces
			Mostrar "Categoría 2. Daños moderados"
		SiNo
			Si Velocidad >= 178 Y Velocidad <= 209 Entonces
				Mostrar "Categoría 3. Daños extensos"
			SiNo 
				Si Velocidad >= 210 Y Velocidad <= 250 Entonces
					Mostrar "Categoría 4. Daños extremos"
				SiNo
					Mostrar "Categoría 5. Daños catastróficos"
				FinSi
			FinSi
		FinSi
	FinSi
	
FinAlgoritmo