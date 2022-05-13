package main.java.Models;

/**
 *
 * @author PremierSoft
 */
public class ObjetoAuxiliar {
    private float valor;
    private String nome;

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ObjetoAuxiliar() {
    }

    public ObjetoAuxiliar(float valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ObjetoAuxiliar{" + "valor=" + valor + ", nome=" + nome + '}';
    }
    
    
    
}
