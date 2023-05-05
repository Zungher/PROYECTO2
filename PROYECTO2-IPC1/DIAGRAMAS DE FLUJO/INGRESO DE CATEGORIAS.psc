Algoritmo Ingresodecategorias
	Escribir usuario
	Dimension categorias[10]
	Si usuario='si' Entonces
		Leer categoria
		Escribir 'Registrar'+categoria
		Para i<-0 Hasta 10 Hacer
			Escribir "Asignar categoria"+i
			Leer categorias[i]
		FinPara
	SiNo
		Escribir "el usuario no existe"
	FinSi
FinAlgoritmo
