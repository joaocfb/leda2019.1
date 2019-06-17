package adt.bst.extended;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;

public class FamilyBSTImpl<T extends Comparable<T>> extends BSTImpl<T> implements FamilyBST<T>{	
	

	@Override
	public boolean primosPrimeiroGrau(T elem1, T elem2) {
		boolean primeiroGrau = false;
		if (elem1 != null && elem2 != null) {
			BSTNode<T> node1 = search(elem1);
			BSTNode<T> node2 = search(elem2);
			BSTNode<T> parentNode1 = (BSTNode<T>) node1.getParent();
			BSTNode<T> parentNode2 = (BSTNode<T>) node2.getParent();
			
			if (!parentNode1.getParent().isEmpty() && !parentNode2.getParent().isEmpty()) {
				if (parentNode1.getParent().equals(parentNode2.getParent())) {
					primeiroGrau = true;
				}
			}		
		}
		return primeiroGrau;
	}


	@SuppressWarnings("unchecked")
	@Override
	public boolean primosSegundoGrau(T elem1, T elem2) {
		boolean segundoGrau = false;
		if (elem1 != null && elem2 != null) {
			BSTNode<T> node1 = search(elem1);
			BSTNode<T> node2 = search(elem2);
			BSTNode<T> parentNode1 = (BSTNode<T>) node1.getParent();
			BSTNode<T> parentNode2 = (BSTNode<T>) node2.getParent();

			if (!parentNode1.getParent().isEmpty() && !parentNode2.getParent().isEmpty()) {
				segundoGrau = primosPrimeiroGrau((T) parentNode1,(T) parentNode2);
			}
		}
		return segundoGrau;
	}
	
	
	/**
	 * NAO ALTERAR OS METODOS ABAIXO PORQUE SERAO UTULIZADOS PELOS TESTES
	 */
	@Override
	public void insert(T element) {
		insert(root, element);
	}

	protected void insert(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.getLeft().setParent(node);
			node.setRight(new BSTNode<T>());
			node.getRight().setParent(node);
		} else {
			if (element.compareTo(node.getData()) < 0) {
				insert((BSTNode<T>)node.getLeft(), element);
			} else if (element.compareTo(node.getData()) > 0) {
				insert((BSTNode<T>)node.getRight(), element);
			}
		}
	}
	
	@Override
	public BSTNode<T> search(T element) {
		return search(root, element);
	}

	protected BSTNode<T> search(BSTNode<T> node, T element) {
		BSTNode<T> result = node;
		if (element != null) {
			if (!node.isEmpty()) {
				if (element.compareTo(node.getData()) == 0) {
					result = node;
				} else if (element.compareTo(node.getData()) < 0) {
					result = search((BSTNode<T>)node.getLeft(), element);
				} else {
					result = search((BSTNode<T>)node.getRight(), element);
				}
			}
		}

		return result;
	}
}
