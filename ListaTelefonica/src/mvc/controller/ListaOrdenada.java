package mvc.controller;

import mvc.model.Nodo;

public class ListaOrdenada<T extends Comparable<T>> extends ListaEncadeada<T> {

	/*
	 * Metodo procuraNodo
	 * 
	 * <p>Este metodo procura um nodo na lista do tipo {@link #mvc.model.Nodo.java} Nodo
	 * e retorna o mesmo, caso o encontre, ou o anterior.</p>
	 * 
	 * @param <data>     Nodo de tipo generico T
	 * @return <Nodo>
	 */
	private Nodo<T> procuraNodo(T data) {
		Nodo<T> nodo = head;
		Nodo<T> anterior = null;

		while (nodo != null) {//enquanto o nodo atual nao for nulo
			int cmp = nodo.getData().compareTo(data);//compara o inicio da lista com o nodo fornecido
			if (cmp == 0)//se forem iguais
				return nodo;//retorna ele mesmo
			if (cmp > 0)//se o nodo encontrado for maior
				return anterior;//retorna o anterior
			anterior = nodo;//para continuar anterior recebe o ultimo nodo lido
			nodo = nodo.getNext();//define como nodo atual o proximo do ultimo lido
		}

		return nodo;//ao final retorna o nodo
	}

	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo, herdado e sobrescrito, insere um novo nodo na posicao ordenada
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 */
	@Override
	public void insert(Nodo<T> novo)
	{
		Nodo<T> anterior = procuraNodo(novo.getData());//define como anterior o encontrado ou o proprio

		if (anterior != null) {//se nao for o primeiro ou lista vazia
			novo.setNext(anterior.getNext());//aponta para o proximo do nodo anterior
			anterior.setNext(novo);//define como proximo do anterior o nodo novo
			if (anterior == tail)//se o anterior for a cauda
				tail = novo;//o novo sera definido como cauda
		} else {//senao
			if (tail != null) {//se a cauda nao for nula (lista vazia)
				tail.setNext(novo);//define como proximo da cauda o nodo novo
			} else {//senao (lista esta vazia)
				head = novo;//define como head o nodo novo
			}
			tail = novo;//define como tail o nodo novo
		}
	}
	

	/*
	 * Metodo insert (em sobrecarga)
	 * 
	 * <p>Este metodo, herdado e sobrescrito, insere um novo nodo na posicao ordenada
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 * @param <anterior> Nodo de tipo generico Nodo<T>
	 */
	@Override
	public void insert(Nodo<T> novo, Nodo<T> anterior)
	{
		insert(novo);
	}

	/*
	 * Metodo append (em sobrecarga)
	 * 
	 * <p>Este metodo, herdado e sobrescrito, apenas chama o metodo insert
	 * evitando que haja uma insercao em local inadequado.</p>
	 * 
	 * @param <novo>     Nodo de tipo generico Nodo<T>
	 */
	@Override
	public void append(Nodo<T> novo) {
		insert(novo);
	}

	/*
	public static void main(String[] args) {
		// criar lista
		ListaOrdenada<Integer> lista = new ListaOrdenada<Integer>();

		Nodo<Integer> novo = new Nodo<Integer>(1);
		lista.insert(novo);

		lista.insert(new Nodo<Integer>(2), novo);

		lista.append(new Nodo<Integer>(3));

		lista.insert(new Nodo<Integer>(4), novo);

		lista.print();
	}
	*/

}