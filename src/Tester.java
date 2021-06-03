import binaryTree.BSTException;
import binaryTree.BinarySearchTree;
import binaryTree.BinaryTree;
import binaryTree.BinaryTreeApi;

public class Tester {

    static Cuenta[] cuentas = {
            new Cuenta(5, 'A', -500),
            new Cuenta(8, 'C',-1),
            new Cuenta(35, 'C', 20),
            new Cuenta(45, 'C', -100),
            new Cuenta(2, 'C', -30),
            new Cuenta(4, 'A', -12)
    };
    static BinaryTree<Cuenta> cuentasTree = new BinaryTree<Cuenta>(cuentas[0], new BinaryTree<Cuenta>(cuentas[1], new BinaryTree<Cuenta>(cuentas[3]), new BinaryTree<>()), new BinaryTree<Cuenta>(cuentas[2], new BinaryTree<Cuenta>(cuentas[4]), new BinaryTree<Cuenta>(cuentas[5])));
    static EjArboles ej = new EjArboles();
    static EjArchivos ejArch = new EjArchivos();

    public static void main(String[] args) {
        try{
            ejArch.generateDataFile();
            ejArch.showMeanSpeedPerBrand();
            ejArch.generateCounterFile();
            ejArch.readResults();


        } catch(Exception e){e.getMessage();}


    }
    




}
