package adt.linkedList;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		if (data == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int size() {
		if (isEmpty()) {
			return 0;
		} else {
			return 1 + next.size();
		}
	}

	@Override
	public T search(T element) {
		if (!isEmpty()) {
			return null;
		} else {
			if (data == element) {
				return data;
			} else {
				next.search(element);
			}
		}
		return null;
	}

	@Override
	public void insert(T element) {
		if (isEmpty()) {
			data = element;
			next = new RecursiveSingleLinkedListImpl<T>();
		} else {
			next.insert(element);
		}
	}

	@Override
	public void remove(T element) {
		if (isEmpty()) {

		} else {
			if (data == element) {
				data = next.data;
				next = next.next;
			} else {
				next.remove(element);
			}
		}

	}

	@Override
	public T[] toArray() {
		T[] result = new T[];
		listToArray(result, this, 0);
		return result;
	}

	private void listToArray(T[] array, RecursiveSingleLinkedListImpl<T> node, int index) {
		if (!node.isEmpty()) {
			array[index] = node.data;
			listToArray(array, node, index +1);
		}
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public RecursiveSingleLinkedListImpl<T> getNext() {
		return next;
	}

	public void setNext(RecursiveSingleLinkedListImpl<T> next) {
		this.next = next;
	}

}
