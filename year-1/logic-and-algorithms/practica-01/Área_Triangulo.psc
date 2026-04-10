Algoritmo Área_Triangulo
    Definir a, b, c, semiperimetro, area Como Real
    Repetir
        Mostrar "Introduzca el valor de a (cm): "
        Leer a
        Mostrar "Introduzca el valor de b (cm): "
        Leer b
        Mostrar "Introduzca el valor de c (cm): "
        Leer c
        Si a <= 0 O b <= 0 O c <= 0 Entonces
            Mostrar "Error: Los lados deben ser mayores que 0."
        SiNo
            Si a + b <= c O a + c <= b O b + c <= a Entonces
                Mostrar "Error: No se cumple la desigualdad triangular (un lado es demasiado largo)."
            FinSi
        FinSi
    Hasta Que (a > 0 Y b > 0 Y c > 0) Y (a + b > c Y a + c > b Y b + c > a)
    semiperimetro <- (a + b + c) / 2
    area <- Raiz(semiperimetro * (semiperimetro - a) * (semiperimetro - b) * (semiperimetro - c))
    Mostrar "El area del triangulo con lados ", a, ", ", b, " y ", c, " cm es: ", area, " cm^2"
FinAlgoritmo