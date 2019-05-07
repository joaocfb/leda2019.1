package adt.linkedList.set;

import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class SetLinkedListImpl<T> extends SingleLinkedListImpl<T> implements SetLinkedList<T> {

	@Override
	public void removeDuplicates() {
		SingleLinkedListNode<T> node1 = null;
		SingleLinkedListNode<T> node2 = null;
		SingleLinkedListNode<T> duplicate = null;
		node1 = head;
		
		while (node1 != null && node1.getNext() != null) {
			node2 = node1;
			
			while (node2.getNext() != null) {
				
				if (node1.getData() == node2.getNext().getData()) {
					
					duplicate = node2.getNext();
					node2.getNext().setData(node2.getNext().getNext().getData());
					node2.getNext().setNext(node2.getNext().getNext());
					
				} else {
					node2 = node2.getNext();
				}
			}
			node1 = node1.getNext();
		}
	}

	@SuppressWarnings("null")
	@Override
	public SetLinkedList<T> union(SetLinkedList<T> otherSet) {
		SetLinkedList<T> lista = null ;
		SingleLinkedListNode<T> t1 = head;
		@SuppressWarnings("unchecked")
		SingleLinkedListNode<T> t2 = ((SingleLinkedListNode<T>) otherSet);
		
		while (t1.getNext() != null) {
			lista.insert(t1.getData());
			t1 = t1.getNext();
		}
		 
		while (t2.getNext() != null) {
			if (!isPresent(t1, t2.getData())) {
				lista.insert(t2.getData());
			}
			t2 = t2.getNext();
		}
		
		return lista;
	}

	@SuppressWarnings("null")
	@Override
	public SetLinkedList<T> intersection(SetLinkedList<T> otherSet) {
		SetLinkedList<T> lista = null ;
		SingleLinkedListNode<T> t1 = head;
		@SuppressWarnings("unchecked")
		SingleLinkedListNode<T> t2 = ((SingleLinkedListNode<T>) otherSet);
		
		while (t1.getNext() != null) {
			if (isPresent(t2, t1.getData())) {
				lista.insert(t1.getData());
			}
			t1 = t1.getNext();
		}
		return lista;
	}

	@Override
	public void concatenate(SetLinkedList<T> otherSet) {
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");
	}
	
	private boolean isPresent (SingleLinkedListNode<T> head, T data) { 
        SingleLinkedListNode<T>  node = head; 
        while (node != null) { 
            if (node.getData() == data) 
                return true; 
            node = node.getNext(); 
        } 
        return false; 
    }

}
