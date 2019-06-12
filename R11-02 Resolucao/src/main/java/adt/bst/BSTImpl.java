package adt.bst;

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
	
	private int height(BSTNode<T> node) {
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

	private void insertRec(BSTNode<T> node, T element, BSTNode<T> parent) {
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
	
	private BSTNode<T> maximum(BSTNode<T> root) {
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

	private BSTNode<T> minimum(BSTNode<T> root) {
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
		if (!node.getRight().isEmpty()) {
			return minimum((BSTNode<T>) node.getRight());
		}
	}

	@Override
	public BSTNode<T> predecessor(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public void remove(T element) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] preOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] order() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
	}

	@Override
	public T[] postOrder() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Not implemented yet!");
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
