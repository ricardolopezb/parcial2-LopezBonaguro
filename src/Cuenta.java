public class Cuenta implements Comparable{
    private final int numero;
    private final char tipo; // 'A'  si es ahorro, 'C' si es cta corriente
    private int saldo;

    public Cuenta(int numero, char tipo, int saldo) {
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    @Override
    public int compareTo(Object o) {
        return this.numero - ((Cuenta)o).getNumber();
    }

    public int getNumber() {
        return numero;
    }

    public char getType() {
        return tipo;
    }

    public int getBalance() {
        return saldo;
    }

    public String toString(){
        return "Cuenta nro. " + this.tipo + "-" + this.numero + " - Saldo: "+ this.saldo;
    }
}
