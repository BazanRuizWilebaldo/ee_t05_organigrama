/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolbst;

/**
 *extends Comparable extends
 * @author WILY
 */
public class NodoBST<T>   {

    T dato;

    NodoBST<T> izq;
    NodoBST<T> der;

  

    public NodoBST(T dato) {
        this.dato = dato;
        this.izq = izq;
        this.der = der;

    }

    public void setDato(T dato) {
        this.dato = dato;

    }

    public T geDato() {
        return dato;

    }

    public void setIzq(NodoBST<T> izq) {
        this.izq = izq;

    }

    public NodoBST<T> getIzq() {
        return izq;

    }

    public void setDer(NodoBST<T> der) {
        this.izq = izq;

    }

    public NodoBST<T> getDer() {
        return der;

    }

    public String toString() {
        return dato.toString();

    }

}
