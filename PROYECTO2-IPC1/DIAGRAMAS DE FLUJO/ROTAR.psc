Algoritmo EDITORDEIMAGENES
	Escribir 'SELECCIONE LA IMAGEN'
	Leer imagen
	Escribir 'SELECCIONE LA ACCION A REALIZAR'
	Leer ACCION
	Segun ACCION  Hacer
		CONVERTIR jpg A bmp Y VICEVERSA:
			respuesta <- CONVERTIRAFORMATO
		copiajpg:
			respuesta <- copiajpg
		ESCALA_DE_GRISES:
			respuesta <- GRISES
		ROTAR:
			respuesta <- Rotacion
		SEPIA:
			respuesta <- imagensepia
	FinSegun
FinAlgoritmo

Funcion CONVERTIRAFORMATO
	Escribir 'ESCRIBA EL NOMBRE DE LA IMAGEN'
	Leer imagen
	Escribir 'ESCRIBA LA EXTENSION DE LA IMAGEN'
	Leer extension
	Si extension='.jpg' Entonces
		Escribir 'convertir a bmp'
		extension <- bmp
	SiNo
		Escribir 'convertir a jpg'
		extension <- jpg
	FinSi
	Escribir 'la imagen se convertido correctamente'+imagen+extension
FinFuncion

Funcion copiajpg
	Escribir 'escriba el nombre de la imagen'
	Leer imagen
	Escribir 'cortar el .jpg'
	Escribir 'colocar la palabra copy al inicio de la imagen'
	copy <- 'copy-'
	extension <- '.jpg'
	Escribir copy+imagen+extension
FinFuncion

Funcion imagensepia
	Escribir 'Ingrese el nombre de la imagen'
	Leer imagen
	Escribir 'ingrese el alto y ancho de la imagen'
	Leer alto
	Leer ancho
	Escribir 'declarar tr, tg, tb'
	Escribir 'declarar R[][], G[][], B[][]'
	Escribir 'instanciar un BufferedImage'
	Para i<-0 Hasta 1 Con Paso ancho Hacer
		Para j<-0 Hasta 1 Con Paso alto Hacer
			Escribir 'definir p a los colores del BufferedImage'
			Escribir 'definir a para p>>24'
			Escribir 'definir r para p>>16'
			Escribir 'definir g para p>>8'
			Escribir 'definir b para p'
			Escribir 'definir tr = (r*alfa+g*beta+b*gamma)'
			Escribir 'definir tg = (r*alfa+g*beta+b*gamma)'
			Escribir 'definir tb = (r*alfa+g*beta+b*gamma)'
			Si tr>255 Entonces
				r <- 255
			SiNo
				r <- tr
			FinSi
			Si tg>255 Entonces
				g <- 255
			SiNo
				g <- tg
			FinSi
			Si tb>255 Entonces
				b <- 255
			SiNo
				b <- tb
			FinSi
			Escribir 'definir p si a<<24 | r<<16 | g<<8 | b'
			Escribir 'definir un el los pixeles del Buffered con (x,y,p)'
		FinPara
	FinPara
FinFuncion

Funcion GRISES
	Leer mediaPixel
	Escribir 'definir variable C'
	Escribir 'definir una matriz gris[][]'
	Escribir 'definir una matriz R[][]'
	Escribir 'definir una matriz G[][]'
	Escribir 'definir una matriz B[][]'
	Para i<-0 Hasta 1 Con Paso ancho Hacer
		Para j<-0 Hasta 1 Con Paso alto Hacer
			Escribir 'definir c como un nuevo Color del Buffered imagenoriginal'
			Escribir 'llenar R[i][j] con C.getred()'
			Escribir 'llenar G[i][j] con C.getGreen'
			Escribir 'llenar B[i][j] con C.getBlue'
			Escribir 'llenar la variable mediaPixel con la operacion ((c.getRed*0.3+c.getGreen*0.59+c.getBlue*0.11))'
			Escribir 'llenar gris[i][j] con la variable mediaPixel'
		FinPara
	FinPara
	Escribir 'definir Buffered Imagentrabajada como un nuevo Buffered(x, y, imagenoriginal.gettype)'
	Para i<-0 Hasta 10 Hacer
		Para j<-0 Hasta 10 Hacer
			Escribir 'definir rgb con imagen[i][j]<<16 | imagen[i][j]<<8 | imagen[i][j]'
			Escribir 'definir un nuevo color para imagentrabajada desde (x, y, rgb.getRGB)'
		FinPara
	FinPara
FinFuncion

Funcion ROTAR
	Escribir 'Instancia un ImageInputStream inicial = ImageIO.createInputStream(archivo entrada, archivo salida, rotacion)'
	Escribir 'Instanciar un iterador desde ImageIO.getImageReader(inicio)'
	Escribir 'Instanciar un ImageReader desde el iterador.next()'
	Escribir 'Instanciar un String formato con el reader.getFormatName'
	Escribir 'Instanciar un BufferedImage dato con el ImageIO.read(inicio)'
	Escribir 'definir la altura'
	Escribir 'definir el ancho'
	Escribir 'Instanciar un nuevo BufferedImage rotacion con un Buffered de tipo dato.type()'
	Para x<-0 Hasta 5 Hacer
		Para j<-0 Hasta 1 Con Paso alto Hacer
			Segun Rotacion  Hacer
				ROTATE_90:
					Escribir 'rotacion.SetRGB(y, (width-1)-x, dato.getRGB(x, y)'
			FinSegun
		FinPara
	FinPara
	Escribir 'ImageIO.write(rotacion, formato, archivo de salida)'
FinFuncion
