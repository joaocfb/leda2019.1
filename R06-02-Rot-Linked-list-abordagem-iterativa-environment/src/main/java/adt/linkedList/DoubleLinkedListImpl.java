package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	// elemento auxiliar para adição e remoção
	private DoubleLinkedListNode<T> nil;

	@Override
	public void insertFirst(T element) {
		if (element != null) {
			nil = new DoubleLinkedListNode<T>();
			/*
			 * Cria o DLL setando o data, o next fazendo o cast trasformando GetHead() em DLL,
			 * e usando nil para referenciar uma DLL NIL
			 */
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<T>(element, 
					(DoubleLinkedListNode<T>) getHead(), nil);
			// Fazendo o cast para DLL em getHead() referencia o elemento anterior para novo
			((DoubleLinkedListNode<T>) getHead()).setPrevious(novo);
			// Se a lista for vazia 
			if (novo.isNIL())
				setLast(novo);
			setHead(novo);
		}
	}

	@Override
	public void removeFirst() {
		/*
		 * Se a head for diferente de NIL referencia a nova cabeça como o proximo elemento
		 */
		if (!(getHead().isNIL())) {
			setHead(getHead().getNext());
		}
		/*
		 *Se a head for NIL referencia o ultimo elemento como a cabeça 
		 */
		if (getHead().isNIL()) {
			setLast((DoubleLinkedListNode<T>) getHead());
		}
		/*
		 * Aponta o elemento anterior da head como o nil
		 */
		if (getHead() instanceof DoubleLinkedListNode) {
			DoubleLinkedListNode<T> head = (DoubleLinkedListNode<T>) getHead();
			nil = new DoubleLinkedListNode<T>();
			head.setPrevious(nil);
		}
	}

	@Override
	public void removeLast() {
		/*
		 * Se o ultimo elemento não for NIL seta o last como o anterior a ele
		 */
		if (!getLast().isNIL()) {
			setLast(getLast().getPrevious());
			/*
			 * Se o ultimo elemento for NIL seta a cabeça da lista como o last
			 */
			if (getLast().isNIL()) {
				setHead(getLast());
			}
			/*
			 * Instancia o nil e seta o novo next do last como NIL
			 */
			nil = new DoubleLinkedListNode<T>();
			getLast().setNext(nil);
		}
		
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
