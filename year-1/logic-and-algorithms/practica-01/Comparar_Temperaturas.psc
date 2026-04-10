Algoritmo Comparar_Temperaturas
    Definir t1, t2, t3 Como Real
    Mostrar "Introduzca el valor de la primera temperatura (t1): "
    Leer t1
    Mostrar "Introduzca el valor de la primera temperatura (t2): "
    Leer t2
    Mostrar "Introduzca el valor de la primera temperatura (t3): "
    Leer t3
    
    Si t1 = t2 Y t1 = t3 Y t2 = t3 Entonces
        Mostrar "Caso 1. Las tres temperaturas son iguales."
    SiNo
        Si t1 = t2 Y t3 <> t1 Y t3 <> t2 Entonces
            Mostrar "Caso 2. Hay dos temperaturas iguales: primera y segunda."
        SiNo
            Si t1 = t3 Y t2 <> t1 Y t2 <> t3 Entonces
                Mostrar "Caso 3. Hay dos temperaturas iguales: primera y tercera."
            SiNo
                Si t2 = t3 Y t1 <> t2 y t1 <> t3 Entonces
                    Mostrar "Caso 4. Hay dos temperaturas iguales: segunda y tercera."
                SiNo
                    Mostrar "Caso 5. Las tres temperaturas son distintas"
                FinSi
            FinSi
        FinSi
    FinSi
FinAlgoritmo