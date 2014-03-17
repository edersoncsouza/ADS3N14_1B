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
	/*
	private Nodo<T> procuraNodo(T data) {
		Nodo<T> nodo = head;//cria o atributo nodo e aponta para o head
		Nodo<T> anterior = null;//cria o atributo anterior e aponta para null
		
		while (nodo != null) {//enquanto o nodo atual nao for nulo
			int cmp = nodo.getData().compareTo(data);//compara o nodo localizado atual com o nodo fornecido
			if (cmp == 0){//se forem iguais
				System.out.println("Nodo igual encontrado!");
				return nodo;//o nodo localizado atual
			}
			if (cmp > 0){//se o nodo encontrado for maior
				System.out.println("Nodo maior encontrado:" + nodo.getData().toString() + " valor recebido: " + data);
					return anterior;//retorna o anterior				
			}
			System.out.println("Nodo menor encontrado:" + nodo.getData().toString() + " valor recebido: " + data);
			anterior = nodo;//para continuar anterior recebe o ultimo nodo lido
			nodo = nodo.getNext();//define como nodo atual o proximo do ultimo lido
		}

		return nodo;//ao final retorna o nodo
	}
	*/

private Nodo<T> procuraNodo(T data) {
	Nodo<T> nodo = head;
	Nodo<T> anterior = null;

	//System.out.println("Valor recebido: "+ data.toString());
	
	while (nodo != null) {
		int cmp = nodo.getData().compareTo(data);
		
		//System.out.println("Valor recebido: "+ data.toString() +" Nodo lido: " + nodo.getData().toString());
		
		if (cmp == 0){
			//System.out.println("Sou o procuraNodo, valores iguais, estou retornando o nodo:" + nodo);
			return nodo;
		}
		if (cmp > 0){
			//System.out.println("Sou o procuraNodo, estou retornando anterior:" + anterior);
			return anterior;
		}
		anterior = nodo;
		nodo = nodo.getNext();
	}
	//return nodo;
	return anterior;
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
			if (tail != null) {// anterior nulo e tail existe = 1 ou mais elementos, adic inicio
				novo.setNext(head);//o proximo do novo e o head
				head = novo; //novo passa a ser o head
			} else {//senao (lista esta vazia)
				head = novo;//define como head o nodo novo
			}
			tail = novo;//define como tail o nodo novo
		}
	}
/*
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
<<<<<<< HEAD
			if (tail != null) {// anterior nulo e tail existe = 1 ou mais elementos, adic inicio
=======
			if (tail != null) {//se a cauda nao for nula (lista vazia)
>>>>>>> 24e6d75d5174e4a838afc8ab832f6e66f2bf2d6c
				tail.setNext(novo);//define como proximo da cauda o nodo novo
			} else {//senao (lista esta vazia)
				head = novo;//define como head o nodo novo
			}
			tail = novo;//define como tail o nodo novo
		}
	}
	*/

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

		lista.insert(new Nodo<Integer>(8));

		lista.insert(new Nodo<Integer>(9));

		lista.insert(new Nodo<Integer>(7));

		lista.insert(new Nodo<Integer>(10));
		
		lista.insert(new Nodo<Integer>(5));

		lista.print();
	}
	
*/
}