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
public class ArbolBinarioRE <T extends Comparable<T>> {

    T dato;
    public ArbolBinarioRE() {
        raiz = null;

    }
    
    NodoBinarioRE<T> raiz;

    public NodoBinarioRE<T> getNodoRaiz() {
        return raiz;
    }

    public void setNodoRaiz(NodoBinarioRE<T> raiz) {
        this.raiz = raiz;

    }

    public void Preorden(NodoBinarioRE<T> raiz) {
        if (raiz != null) {
            System.out.print(raiz.getDato());
            Preorden(raiz.getIzquierda());
            Preorden(raiz.getDerecha());

        }

    }

    public void Inorden(NodoBinarioRE<T> raiz) {
        if (raiz != null) {
            Inorden(raiz.getIzquierda());
            System.out.print(raiz.getDato());
            Inorden(raiz.getDerecha());

        }

    }

    public void Posorden(NodoBinarioRE<T> raiz) {
        if (raiz != null) {
            Posorden(raiz.getIzquierda());
            Posorden(raiz.getDerecha());
            System.out.print(raiz.getDato());

        }

    }

    public void Buscar(NodoBinarioRE<T> raiz, T dato) {

        if (raiz != null) {
            if (dato.compareTo(raiz.getDato()) < 0) {
                Buscar(raiz.getIzquierda(), dato);

            } else if (dato.compareTo(raiz.getDato()) > 0) {
                Buscar(raiz.getDerecha(), dato);

            } else {
                System.out.println(" el objeto no se encontro en el arbol");
            }

        } else {
            System.out.println("  el objeto no existe");
        }
    }
    

    public int altura(NodoBinarioRE<T> raiz, int altura) {
        altura = altura + 1;
        int izquierda, derecha;
        if (raiz != null) {
            System.out.println("El nivel del nodo: " + raiz.getDato() + " es: " + altura);
            izquierda = altura(raiz.getIzquierda(), altura);
            derecha = altura(raiz.getDerecha(), altura);
        } else {
            return -1;
        }
        if (izquierda > derecha) {
            return izquierda + 1;
        } else {
            return derecha + 1;
        }
    }
}
