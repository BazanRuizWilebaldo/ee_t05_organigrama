/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbst;

/**
 *
 * @author WILY
 */
public class NodoBinarioRE<T> {

    T dato;
    NodoBinarioRE<T> izquierda;
    NodoBinarioRE<T> derecha;

    public NodoBinarioRE(){
     
       
    }

    public NodoBinarioRE(T dato) {
        this.dato = dato;
        this.izquierda = izquierda;
        this.derecha = derecha;;

    }


    public void setDato(T dato) {
        this.dato = dato;

    }

    public T getDato() {
        return dato;
    }

    public void setIzquierda(NodoBinarioRE<T> izquierda) {
        this.izquierda = izquierda;
    }

    public NodoBinarioRE<T> getIzquierda() {
        return izquierda;
    }

    public void setDerecha(NodoBinarioRE<T> derecha) {
        this.derecha = derecha;

    }

    public NodoBinarioRE<T> getDerecha() {
        return derecha;

    }

    public String toString() {
        return dato.toString() + "--->";
    }

}
