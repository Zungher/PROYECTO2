Algoritmo sin_titulo
	Escribir categoria
	Dimension imagenes[10]
	Si categoria='si' Entonces
		Leer categoria
		Escribir 'Registrar'+categoria
		Para i<-0 Hasta 10 Hacer
			Escribir 'Asignar imagen'+i
			Leer imagenes[i]
			Escribir "LA IMAGEN SE A GUARDADO"
		FinPara
	SiNo
		Escribir 'el usuario no existe'
	FinSi
FinAlgoritmo
