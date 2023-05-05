/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;
import java.io.Serializable;
import javax.swing.JOptionPane;


public class LISTACATEGORIA implements Serializable{
    public NODODOBLE inicio, fin;
    public int contador;
    public LISTACATEGORIA(){
        inicio=fin=null;
    }
    //metodo para saber si la lista esta vacia
    public boolean estVacia(){
        return inicio==null;
    }
    //metodo para agregar nodos al final
    public void agregaralfinal(String dato){
        if (!estVacia()) {
            fin=new NODODOBLE(dato, null, fin);
            fin.anterior.siguiente=fin;
            
        }else{
            inicio=fin=new NODODOBLE(dato);
        }
    }
    //metodo para agregar al inicio
    public void agregaralinicio(String dato){
        if (!estVacia()) {
            inicio=new NODODOBLE(dato, inicio, null);
            inicio.siguiente.anterior=inicio;
            JOptionPane.showMessageDialog(null, "la categoria a sido guardada");
            contador++;
        }else{
            inicio=fin=new NODODOBLE(dato);
            contador++;
            JOptionPane.showMessageDialog(null, "la categoria a sido guardada");
        }
    }
    public void buscarnodo(String e, String nombreimagen){
        NODODOBLE actual;
        actual = inicio;
        while (actual!=null) {
            if (actual.datos.equals(e)) {;
                actual.imagenes.agregarnodo(nombreimagen);
            }else{
                JOptionPane.showMessageDialog(null, "La categoria no existe");
            }
            actual=actual.siguiente;
        }
    }
    public boolean buscarnodoregresivo(String e){
        NODODOBLE actual;
        actual = inicio;
        boolean encontrado=false;
        while (actual!=null) {
            if (actual.datos.equals(e)) {
                encontrado=true;
            }else{
                encontrado=false;
            }
            actual=actual.siguiente;
            if (encontrado==true) {
                break;
            }
        }
        return encontrado;
    }
    public String[] mostrarContenido(){
        String datos[] = new String[contador];
        if (!estVacia()) {
            NODODOBLE aux = inicio;
            for (int i = 0; i < contador; i++) {
                datos[i]= (String) aux.datos;
                aux = aux.siguiente;
            }
        }
        return datos;   
}
}