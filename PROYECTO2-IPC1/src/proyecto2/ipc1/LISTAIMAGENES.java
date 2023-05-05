/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;
import java.io.Serializable;

public class LISTAIMAGENES implements Serializable{
    NODOCIRCULAR inicio, fin;
    public int contador=0;

    public LISTAIMAGENES() {
        inicio=null;
        fin=null;
    }
    
    public void agregarnodo(String contenido){
        NODOCIRCULAR nuevo=new NODOCIRCULAR();
        nuevo.datos = contenido;
        if (inicio==null) {
            inicio=nuevo;
            inicio.siguiente=inicio;
            nuevo.anterior=fin;
            fin=nuevo;
            contador++;
        }else{
            fin.siguiente=nuevo;
            nuevo.siguiente=inicio;
            nuevo.anterior=fin;
            fin=nuevo;
            inicio.anterior=fin;
            contador++;
        }
    }

    public String[] mostrardatos(){
        NODOCIRCULAR actual = new NODOCIRCULAR();
        String contenido[] = new String[contador];
        actual = inicio;
        do {
            for (int i = 0; i < contador; i++) {
                contenido[i]=(String) actual.datos;
                actual = actual.siguiente;
            }
        } while (actual!=inicio);   
        return contenido;
    }
}
