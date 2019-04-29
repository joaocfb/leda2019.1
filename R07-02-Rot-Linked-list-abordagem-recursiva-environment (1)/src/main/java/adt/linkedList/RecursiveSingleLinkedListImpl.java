package adt.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecursiveSingleLinkedListImpl<T> implements LinkedList<T> {

	protected T data;
	protected RecursiveSingleLinkedListImpl<T> next;

	public RecursiveSingleLinkedListImpl() {

	}


	@Override
	public boolean isEmpty() {
		return (data == null && next == null);
	}

	@Override
	public int size() {
		int size = 0;
		if (!isEmpty()) {
			size = 1 + this.next.size();
		} 
		return size;

	}

	@Override
	public T search(T element) {
		T result = null;
		if (element != null && !isEmpty()) {
	
			if (this.data.equals(element)) {
				result = element;
			} else {
				result = next.search(element);
			}
		}
		return result;
	}

	@Override
	public void insert(T element) {
		if (element != null) {
			
			if (isEmpty()) {
				this.data = element;
				this.next = new RecursiveSingleLinkedListImpl<>();
				
			} else {
				next.insert(element);
			}
		}
		
	}

	@Override
	public void remove(T element) {
		if (element != null) {
			
			if (!isEmpty()) {
				if (this.data.equals(element)) {
					this.setData(this.next.data);
					this.setNext(next.next);
					
				} else {
					next.remove(element);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] toArray() {
		T[] result = (T[]) new Object[0];
		if (!this.isEmpty()) {
			List<T> list = new ArrayList<T>();
			list.add(this.data);
			list.addAll(Arrays.asList(this.next.toArray()));

			T[] newArray = (T[]) new Object[list.size()];
			result = list.toArray(newArray);
		}

		return result;
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
