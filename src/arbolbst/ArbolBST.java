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
public class ArbolBST<T extends Comparable<T>> {

    NodoBST<T> raiz;

    public void setNodoBSTRa(NodoBST<T> raiz) {
        this.raiz = raiz;
    }

    public NodoBST<T> getNodoBSTRa() {
        return raiz;

    }

    public ArbolBST() {
        raiz = null;
    }

    public void BuscarXele(NodoBST<T> raiz, T dato) {
        if (raiz != null) {
            //por la izquierda
            if (dato.compareTo(raiz.geDato()) < 0) {
                BuscarXele(raiz.getIzq(), dato);
                // si es menor a 0 por la izquieda
            } else if (dato.compareTo(raiz.geDato()) > 0) {
                BuscarXele(raiz.getDer(), dato);
            } else {
                System.out.print("el objeto no se encontro");
            }

        } else {
            System.out.print("no se encotro el objeto");
        }

    }

    private void Insertar(NodoBST<T> nodo, T dato) {

        if (dato.compareTo(nodo.geDato()) < 0) {
            if (nodo.getIzq() == null) {
                nodo.setIzq(new NodoBST(dato));

            } else {
                Insertar(nodo.getIzq(), dato);
            }

        } else {
            if (dato.compareTo(nodo.geDato()) < 0) {
                if (nodo.getDer() == null) {
                    nodo.setDer(new NodoBST(dato));

                } else {
                    Insertar(nodo.getDer(), dato);
                }
            }

        }

    }

    public Integer Insertarx(T dato) {

        if (raiz == null) {
            raiz = new NodoBST<T>(dato);
        } else {
            Insertar(raiz, dato);

        }
        return 0;

    }

    public void eliminaNodo(NodoBST<T> nodo, Integer direccion) {
        NodoBST<T> otro, aux, aux1;

        if (direccion == -1) {
            otro = nodo.getIzq();
        } else {
            otro = nodo.getDer();

        }
        if (otro.getDer() == null) {
            if (direccion == -1) {
                nodo.setIzq(otro.getIzq());

            }

        } else {
            if (otro.getIzq() == null) {
                if (direccion == -1) {
                    nodo.setIzq(otro.getDer());

                } else {
                    nodo.setDer(otro.getDer());

                }

            } else {
                aux = otro.getIzq();
                aux1 = aux;
                while (aux.getDer() != null) {
                    aux1 = aux;
                    aux = aux.getDer();

                }
                otro.setDato(aux.geDato());
                if (aux == aux1) {
                    otro.setIzq(null);

                } else {

                    aux1.setDer(null);

                }

            }

        }

    }

    public void elimina(NodoBST<T> nodo, T dato) {
        NodoBST<T> aux, otro;

        if (dato.compareTo(nodo.geDato()) < 0) {
            if (nodo.getIzq() != null) {

                if (dato.compareTo(nodo.getIzq().geDato()) == 0) {

                    eliminaNodo(nodo, -1);
                } else {
                    elimina(nodo.getIzq(), dato);
                }
            }
        } else {
            if (dato.compareTo(nodo.geDato()) > 0) {

                if (nodo.getDer() != null) {
                    if (dato.compareTo(nodo.getDer().geDato()) == 0) {
                        eliminaNodo(nodo, 1);

                    } else {
                        elimina(nodo.getDer(), dato);
                    }
                }

            }

        }

    }

    public static void main(String[] args) {
        ArbolBST<String> arbol = new ArbolBST<String>();

        arbol.setNodoBSTRa(new NodoBST("presidete"));

        arbol.Insertar(arbol.getNodoBSTRa(), "vicepresidente");
        arbol.Insertar(arbol.getNodoBSTRa(), "jefe de departamento");
        arbol.Insertar(arbol.getNodoBSTRa(), "empleado1");

        BTreePrinter.printNode(arbol.getNodoBSTRa());

    }
}
