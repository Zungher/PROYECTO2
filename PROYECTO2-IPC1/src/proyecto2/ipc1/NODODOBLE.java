/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;


public class NODODOBLE {
    public NODODOBLE siguiente, anterior;
    public Object datos;
    public LISTAIMAGENES imagenes = new LISTAIMAGENES();
    //constructor para cuando ya hay nodos
    public NODODOBLE(Object dato, NODODOBLE sig, NODODOBLE ant){
        datos = dato;
        siguiente=sig;
        anterior=ant;
    }
    //para cuando aun no hay nodos
    public NODODOBLE(Object dato){
        this(dato, null, null);
    }
}
