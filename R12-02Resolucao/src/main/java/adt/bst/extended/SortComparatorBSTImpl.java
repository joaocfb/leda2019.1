package adt.bst.extended;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

/**
 * Implementacao de SortComparatorBST, uma BST que usa um comparator interno em suas funcionalidades
 * e possui um metodo de ordenar um array dado como parametro, retornando o resultado do percurso
 * desejado que produz o array ordenado. 
 * 
 * @author Adalberto
 *
 * @param <T>
 */
public class SortComparatorBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements SortComparatorBST<T> {

	private Comparator<T> comparator;
	
	public SortComparatorBSTImpl(Comparator<T> comparator) {
		super();
		this.comparator = comparator;
	}
	
	@Override
	public void insert(T element) {
		insert(this.root, element, new BSTNode<T>());
	}

	private void insert(BSTNode<T> node, T element, BSTNode<T> parent) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		} else if (comparator.compare(element, node.getData()) < 0) {
			insert((BSTNode<T>)node.getLeft(), element, node);
		} else if (comparator.compare(element, node.getData()) > 0) {
			insert((BSTNode<T>) node.getRight(), element, node);
		}
	}

	@Override
	public T[] sort(T[] array) {
		while (!this.isEmpty()) {
			this.remove(this.root.getData());
		}
		for (int i = 0; i < array.length; i++) {
			this.insert(array[i]);
		}
		return this.order();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] reverseOrder() {
		List<T> list = new ArrayList<T>(this.size());
		reverseOrder(list, this.root);
		return (T[]) list.toArray();
	}

	private void reverseOrder(List<T> list, BSTNode<T> node) {
		if (!node.isEmpty()) {
			reverseOrder(list, (BSTNode<T>) node.getRight());
			list.add(node.getData());
			reverseOrder(list, (BSTNode<T>) node.getLeft());
		}
	}

	public Comparator<T> getComparator() {
		return comparator;
	}

	public void setComparator(Comparator<T> comparator) {
		this.comparator = comparator;
	}
	
}
