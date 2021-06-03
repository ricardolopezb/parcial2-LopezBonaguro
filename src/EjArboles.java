import binaryTree.BSTException;
import binaryTree.BinarySearchTree;
import binaryTree.BinaryTree;

public class EjArboles {
    /**
     * Las cuentas corrientes y cajas de ahorro de los clientes de un banco
     * se encuentran almacenadas en un árbol binario. Por cada cuenta se conoce
     * el número; si es caja de ahorro o cuenta corriente y el saldo. Se pide
     * construir un árbol binario de búsqueda con los números de las cuentas
     * corrientes que tienen saldo negativo.
     *
     * Usar solamente las primitivas de BinaryTree y SearchBinaryTree.
     *
     * */


    public BinarySearchTree<Cuenta> BSTCorrientesNegativas(BinaryTree<Cuenta> tree) throws BSTException {
        if(tree.isEmpty()) return new BinarySearchTree<>();
        BinarySearchTree<Cuenta> newTree = new BinarySearchTree<>();
        distributeTrees(tree, newTree);
        return newTree;

    }

    private void distributeTrees(BinaryTree<Cuenta> tree, BinarySearchTree<Cuenta> bst) throws BSTException {
        if(tree.isEmpty()) return;
        if(tree.getRoot().getType() == 'C' && tree.getRoot().getBalance() < 0) bst.insert(tree.getRoot());
        distributeTrees(tree.getLeft(), bst);
        distributeTrees(tree.getRight(), bst);
    }


}
