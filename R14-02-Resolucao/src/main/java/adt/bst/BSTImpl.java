package adt.bst;

import java.util.ArrayList;
import java.util.List;

import adt.bt.BTNode;

public class BSTImpl<T extends Comparable<T>> implements BST<T> {

	protected BSTNode<T> root;

	public BSTImpl() {
		root = new BSTNode<T>();
	}

	public BSTNode<T> getRoot() {
		return this.root;
	}

	@Override
	public boolean isEmpty() {
		return root.isEmpty();
	}

	@Override
	public int height() {
		return this.height(this.root);
	}
	
	protected int height(BSTNode<T> node) {
		if (node.isEmpty()) {
			return -1;
		}
		return Math.max(this.height((BSTNode<T>) node.getLeft()), this.height((BSTNode<T>)node.getRight())) + 1;
	}

	@Override
	public BSTNode<T> search(T element) {
		if (this.getRoot().isEmpty() || element.compareTo(this.getRoot().getData()) == 0) {
			return this.getRoot();
		} else {
			if (element.compareTo(root.getData()) < 0) {
				return searchRec((BSTNode<T>) this.getRoot().getLeft(), element);
			} else {
				return searchRec((BSTNode<T>) this.getRoot().getRight(), element);
			}
		}
		
	}
	

	private BSTNode<T> searchRec(BSTNode<T> node, T element) {
		if (node.isEmpty()) {
			return node;
		} else if (element.compareTo(node.getData()) < 0) {
			return searchRec((BSTNode<T>) node.getLeft(), element);
		} else if (element.compareTo(node.getData()) > 0) {
			return searchRec((BSTNode<T>) node.getRight(), element);
		} else {
			return node;
		}
	}

	@Override
	public void insert(T element) {
		insertRec(this.root, element, new BSTNode<T>());
	}

	protected void insertRec(BSTNode<T> node, T element, BSTNode<T> parent) {
		if (node.isEmpty()) {
			node.setData(element);
			node.setLeft(new BSTNode<T>());
			node.setRight(new BSTNode<T>());
			node.setParent(parent);
		} else if (element.compareTo(node.getData()) < 0) {
			insertRec((BSTNode<T>) node.getLeft(), element, node);
		} else if (element.compareTo(node.getData()) > 0) {
			insertRec((BSTNode<T>) node.getRight(), element, node);
		}
	}

	@Override
	public BSTNode<T> maximum() {
		return maximum(this.getRoot());
	}
	
	private BSTNode<T> maximum(BTNode<T> root) {
		BTNode<T> node = root;
		if (node.isEmpty()) {
			return null;
		} else {
			while (!node.getRight().isEmpty()) {
				node = node.getRight();
			}
			return (BSTNode<T>) node;
		}
		
	}

	@Override
	public BSTNode<T> minimum() {
		return minimum(this.getRoot());
	}

	private BSTNode<T> minimum(BTNode<T> root) {
		BTNode<T> node = root;
		if (node.isEmpty()) {
			return null;
		} else {
			while (!node.getLeft().isEmpty()) {
				node = node.getLeft();
			}
		}
		return (BSTNode<T>) node;
	}

	@Override
	public BSTNode<T> sucessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		} else if (!node.getRight().isEmpty()) {
			return this.minimum(node.getRight());
		}  else if (node.getParent().getLeft() == node) {
			return (BSTNode<T>) node.getParent();
		}
		while (!node.isEmpty() && this.irRightChild(node, node.getParent())) {
			node = (BSTNode<T>) node.getParent();
		}
		return (BSTNode<T>) node.getParent();
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		BSTNode<T> node = search(element);
		if (node.isEmpty()) {
			return null;
		} else if (!node.getLeft().isEmpty()) {
			return this.maximum(node.getLeft());
		} else if (node.getParent().getRight() == node) {
			return (BSTNode<T>) node.getParent();
		}
		while (!node.isEmpty() && this.isLeftChild(node, node.getParent())) {
			node = (BSTNode<T>) node.getParent();
		}
		if (node == this.root) {
			return null;
		}
		return (BSTNode<T>) node.getParent();
	}

	@Override
	public void remove(T element) {
		BSTNode<T> node = this.search(element);
		remove(node);
	}
	
	protected void remove(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return;
		}
		// Se for folha
		if (node.isLeaf()) {
			/*
			 * se for o próprio node substitui
			 * se for filho à esquerda o remove a partir do parente
			 * se for filho à direita o remove a partir do parente
			 */
			
			if (node == this.root) {
				this.root = new BSTNode<T>();
			} else if (isLeftChild(node, node.getParent())) {
				node.getParent().setLeft(new BSTNode<T>());
			} else {
				node.getParent().setRight(new BSTNode<T>());
			}
			/*
			 * se só tiver filho à direita
			 * se for o próprio node substitui
			 * se for filho à esquerda, 
			 * a partir do parente remove e sobe o seu filho à direita para o node à esquerda
			 * se for filho à direita,
			 * a partir do parente remove e sobe para a direita o seu filho à direita
			 * depois, o filho setado para o lugar do node aponta para o parente de node
			 */
		} else if (justRightChild(node)) {
			if (node == this.root) {
				this.root = (BSTNode<T>) node.getRight();
			} else {
				if (isLeftChild(node, node.getParent())) {
					node.getParent().setLeft(node.getRight());
				} else {
					node.getParent().setRight(node.getRight());
				}
				node.getRight().setParent(node.getParent());
			}
			/*
			 * Se só tiver filho à esquerda
			 * se for o próprio node substitui
			 * se for filho à esquerda, 
			 * a partir do parente remove e sobe o seu filho à esquerda para o node à esquerda
			 * se for filho à direita,
			 * a partir do parente remove e sobe para a direita o seu filho à esquerda
			 */
		} else if (justLeftChild(node)) {
			if (node == this.root) {
				this.root = (BSTNode<T>) node.getLeft();
			} else {
				if (isLeftChild(node, node.getParent())) {
					node.getParent().setLeft(node.getLeft());
				} else {
					node.getParent().setRight(node.getLeft());
				}
				node.getLeft().setParent(node.getParent());
			}
			/*
			 * Senão, cria um node auxiliar setando para o seu sucessor
			 * se o sucessor for null seta para o predecessor de node
			 * cria um T auxiliar setando para o data do node
			 * seta o data do node para o data do node auxiliar
			 * seta o data do node auxiliar para o data do node
			 * chama a funcao remove para o node auxiliar
			 */
		} else {
			BSTNode<T> auxNode = this.sucessor(node.getData());
			if (auxNode == null) {
				auxNode = this.predecessor(node.getData());
			}
			T aux = node.getData();
			node.setData(auxNode.getData());
			auxNode.setData(aux);
			this.remove(auxNode);
		}
	}
	
	protected boolean isLeftChild(BSTNode<T> node, BTNode<T> parent) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return parent.getLeft() == node;
	}

	protected boolean irRightChild(BSTNode<T> node, BTNode<T> parent) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return parent.getRight() == node;
	}

	protected boolean justLeftChild(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return !node.getLeft().isEmpty() && node.getRight().isEmpty();
	}

	protected boolean justRightChild(BSTNode<T> node) {
		if (node == null || node.isEmpty()) {
			return false;
		}
		return !node.getRight().isEmpty() && node.getLeft().isEmpty();
	}
	
	protected boolean hasOneChild(BSTNode<T> node) {

		return ((node.getRight().isEmpty() && !node.getLeft().isEmpty()
				|| node.getLeft().isEmpty() && !node.getRight().isEmpty()));
	}


	@SuppressWarnings("unchecked")
	@Override
	public T[] preOrder() {
		List<T> list = new ArrayList<>(this.size());
		preOrder(list, this.root);
		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void preOrder(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			list.add(node.getData());
			preOrder(list, node.getLeft());
			preOrder(list, node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] order() {
		List<T> list = new ArrayList<>(this.size());
		order(list, this.root);
		return list.toArray((T[])new Comparable[this.size()]);
	}

	private void order(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			order(list, node.getLeft());
			list.add(node.getData());
			order(list, node.getRight());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T[] postOrder() {
		List<T> list = new ArrayList<>(this.size());
		postOrder(list, this.root);
		return list.toArray((T[]) new Comparable[this.size()]);
	}

	private void postOrder(List<T> list, BTNode<T> node) {
		if (!node.isEmpty()) {
			postOrder(list, node.getLeft());
			postOrder(list, node.getRight());
			list.add(node.getData());
		}
	}

	/**
	 * This method is already implemented using recursion. You must understand
	 * how it work and use similar idea with the other methods.
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(BSTNode<T> node) {
		int result = 0;
		// base case means doing nothing (return 0)
		if (!node.isEmpty()) { // indusctive case
			result = 1 + size((BSTNode<T>) node.getLeft())
					+ size((BSTNode<T>) node.getRight());
		}
		return result;
	}

}
