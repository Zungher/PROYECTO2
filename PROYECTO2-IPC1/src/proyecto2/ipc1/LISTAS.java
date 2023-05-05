/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2.ipc1;

import java.io.Serializable;
import javax.swing.JOptionPane;


public class LISTAS implements Serializable{

    /**
     * @return the cabeza
     */
    public NODO getCabeza() {
        return cabeza;
    }

    /**
     * @param cabeza the cabeza to set
     */
    public void setCabeza(NODO cabeza) {
        this.cabeza = cabeza;
    }

    /**
     * @return the cola
     */
    public NODO getCola() {
        return cola;
    }

    /**
     * @param cola the cola to set
     */
    public void setCola(NODO cola) {
        this.cola = cola;
    }

    /**
     * @return the contador
     */
    public int getContador() {
        return contador;
    }

    /**
     * @param contador the contador to set
     */
    public void setContador(int contador) {
        this.contador = contador;
    }
    private NODO cabeza;
    private NODO cola;
    private int contador = 0;
    public LISTAS(){
        cabeza=null;
        cola=null;
    }
    public boolean estado(){
        return getCabeza()==null;
    }
    public void agragandoalinicio(String d){
        setContador(getContador() + 1);
        if (estado()) {
            setCabeza(new NODO(d, getCabeza()));
            setCola(getCabeza());
        }else{
            setCabeza(new NODO(d, getCabeza()));
        }
    }
    public boolean buscardato(String d){
        boolean encontrado=false;
        NODO aux=getCabeza();
            while (encontrado!=true && aux!=null) {
            if (d.equals(aux.datos)) {
                encontrado=true;
            }else{
                aux=aux.siguiente;
            }
            if (encontrado==true)break;
            }
            return encontrado;
        }
    public void mostrarvalor(){
        NODO aux=getCabeza();
        String data;
        while (aux!=null) {
            data=(String) aux.verDato();
        }
    }
    public void llamarcategoria(String e){
        getCabeza().categoria.agregaralinicio(e);
    }
}
