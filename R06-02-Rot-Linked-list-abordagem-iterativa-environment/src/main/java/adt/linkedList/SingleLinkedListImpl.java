package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head == null;
	}

	@Override
	public int size() {
		int tam = 0;
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL()) {
			aux = aux.getNext();
			tam++;
		}
		return tam;
	}

	@Override
	public T search(T element) {
		T retorno = null;
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL() && !aux.getData().equals(element)) {
			aux = aux.getNext();
		}
		retorno = aux.getData();
		return retorno;
	}


	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> aux = getHead();
		while (!aux.isNIL()) {
			aux = aux.getNext();
		}
		aux.setData(element);
		aux.setNext(new SingleLinkedListNode<T>());
	}
	
	@Override
	public void remove(T element) {
		if (element != null) {
			if (!getHead().isNIL()) {
				SingleLinkedListNode<T> aux = getHead();
				while (!aux.getNext().isNIL() && !aux.getNext().getData().equals(element)) {
					aux = aux.getNext();
				}
				if (!aux.getNext().isNIL()) {
					aux.setNext(aux.getNext().getNext());
				}
			}
		}
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Object[this.size()];
		SingleLinkedListNode<T> aux = getHead();
		int tam = 0;
		while (!aux.isNIL()) {
			array[tam] = aux.getData();
			aux = aux.getNext();
			tam++;
		}
		return array;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
