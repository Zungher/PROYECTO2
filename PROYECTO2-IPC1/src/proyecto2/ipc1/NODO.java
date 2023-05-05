/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;


public class NODO {
    public NODO siguiente;
    public Object datos;
    public final LISTACATEGORIA categoria = new LISTACATEGORIA();
    public NODO(String d, NODO sig){
        datos=d;
        siguiente=sig; 
    }
    Object verDato(){
        return this.datos;
    }
}
