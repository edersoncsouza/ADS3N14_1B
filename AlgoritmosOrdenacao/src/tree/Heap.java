package tree;
 
import java.util.ArrayList;
import java.util.NoSuchElementException;
 
/**
 * @author Sesh Venugopal. New Jersey. 2013
 */
public class Heap<T extends Comparable<T>> {
     
    private ArrayList<T> nodos;
     
    public Heap() {
        nodos = new ArrayList<T>();
    }
         
    private void siftUp() {
        int elemento = nodos.size() - 1;//posiciona a leitura no ultimo item da lista
        while (elemento > 0) {
            int pai = (elemento-1)/2;//com uso da contagem matricial pai e sempre igual ao trunc(filho/2)
            T nodo = nodos.get(elemento);//atribui a nodo o elemento da lista
            T nodoPai = nodos.get(pai);//atribui a nodoPai o elemento pai calculado
            if (nodo.compareTo(nodoPai) > 0) {//se o nodo filho for maior que o pai
                // swap
                nodos.set(elemento, nodoPai);//nodoPai recebe o valor do elemento lido
                nodos.set(pai, nodo);//elemento calculado como pai recebe o valor do nodo filho
                 
                // move up one level
                elemento = pai;//retorna um nivel matricial na arvore
            } else {
                break;
            }
        }
    }
     
    public void insert(T item) {
        nodos.add(item);//insere item na lista
        siftUp();//reordena a arvore
    }
     
    private void siftDown() {
        int k = 0;//posiciona a leitura no primeiro item da lista
        int l = 2*k+1;//com uso da contagem matricial filho da esquerda é sempre (2*pai+1)
        while (l < nodos.size()) {//enquanto l for menor que o tamanho da lista
            int max=l, r=l+1;//max recebe filho da esquerda e o filho da direita e o elemento que fica na posicao +1 da esquerda
            if (r < nodos.size()) { // se houver um filho da direita
                if (nodos.get(r).compareTo(nodos.get(l)) > 0) {//se o filho da direita for maior que o da esquerda
                    max++;//max recebe filho da direita
                }
            }
            if (nodos.get(k).compareTo(nodos.get(max)) < 0) {//se o pai for menor que o filho
                    // switch
                    T temp = nodos.get(k);//temp recebe o nodo do item lido
                    nodos.set(k, nodos.get(max));//no do item lido recebe o maior filho
                    nodos.set(max, temp);//max recebe o nodo do item lido
                    k = max;//avanca um nivel matricial na arvore
                    l = 2*k+1;//recalcula o filho da esquerda
            } else {
                break;
            }
        }
    }
     
    public T delete() 
    throws NoSuchElementException {
        if (nodos.size() == 0) {//se a lista estiver vazia
            throw new NoSuchElementException();
        }
        if (nodos.size() == 1) {//se a lista tiver tamanho 1 remove o nodo raiz
            return nodos.remove(0);
        }
        T hold = nodos.get(0);//hold recebe o nodo raiz
        nodos.set(0, nodos.remove(nodos.size()-1));//nodo raiz recebe o ultimo no da arvore e o remove
        siftDown();//reordena a arvore
        return hold;//devolve o nodo raiz antigo
    }
 
    public int size() {
        return nodos.size();
    }
     
    public boolean isEmpty() {
        return nodos.isEmpty();
         
    }
     
    public String toString() {
        return nodos.toString();
    }
}