package mvc.model;

public class NodoD<T> {

	private T  dado;
	private NodoD<T> prev, next;

	public NodoD(NodoD prev, NodoD next, T i)
	{
		this.prev = prev;
		this.next = next;
		this.dado = i;
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public NodoD<T> getPrev() {
		return prev;
	}

	public void setPrev(NodoD<T> prev) {
		this.prev = prev;
	}

	public NodoD<T> getNext() {
		return next;
	}

	public void setNext(NodoD<T> next) {
		this.next = next;
	}

	
}