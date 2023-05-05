Algoritmo ingresarusuarios
	Leer usuario
	Dimension usuarios[10]
	Mientras usuario='' Hacer
		Para i<-0 Hasta 9 Hacer
			Si usuarios[i]!=usuario Entonces
				Escribir ''
			SiNo
				Escribir 'Valor encontrado'
			FinSi
		FinPara
	FinMientras
	Si usuario='existe' Entonces
		Escribir 'Bienvenido'
	SiNo
		Escribir 'Registrar nuevo usuario'
	FinSi
FinAlgoritmo
