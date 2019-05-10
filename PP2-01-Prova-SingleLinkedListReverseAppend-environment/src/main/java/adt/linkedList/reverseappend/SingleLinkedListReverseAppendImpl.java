package adt.linkedList.reverseappend;

import adt.linkedList.SingleLinkedListNode;

/**
 * 
 * @see SingleLinkedListReverseAppend
 * 
 * @author campelo
 *
 * @param <T>
 */
public class SingleLinkedListReverseAppendImpl<T> implements SingleLinkedListReverseAppend<T> {
	
	/*
	 * Nao remover esse atributo nem criar outros
	 */
	protected SingleLinkedListNode<T> head;
	
	/*
	 * Nao modifique o construtor
	 * @param head
	 */
	public SingleLinkedListReverseAppendImpl() {
		head = new SingleLinkedListNode<T>();
	}

	/* (non-Javadoc)
	 * @see adt.linkedList.reverseappend.SingleLinkedListReverseAppend#doIt(java.lang.Object)
	 * 
	 * Implemente apenas este metodo de acordo com os comentários da interface.
	 * 
	 */
	@Override
    public void doIt(T elem) {
    	
		//TODO Implement your code here
		throw new UnsupportedOperationException("Not implemented yet!");

    }
    
	
	
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     * NAO REMOVA NEM MODIFIQUE ESTE METODO. ELE SERA USADO NOS TESTES!
     */
	@Override
    public String toString() {
    	String retorno = "";
    	SingleLinkedListNode<T> currentNode = this.head;
    	while (currentNode!=null) {
    		if (!retorno.equals("")) {
    			retorno += " ";
    		}
    		retorno += currentNode;
    		currentNode = currentNode.getNext();
    	}
		return retorno;
    }
    
}