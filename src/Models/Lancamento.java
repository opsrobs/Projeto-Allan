package Models;
public class Lancamento {

    private int id_controle;
    private int codFuncionario;
    private float horasTrabalhadas;
    private int mes;
    private int ano;

    public Lancamento(int id_controle, int codFuncionario, float horasTrabalhadas, int mes, int ano) {
        this.id_controle = id_controle;
        this.codFuncionario = codFuncionario;
        this.horasTrabalhadas = horasTrabalhadas;
        this.mes = mes;
        this.ano = ano;
    }

    public Lancamento(int codFuncionario, float horasTrabalhadas, int mes, int ano) {
        this.codFuncionario = codFuncionario;
        this.horasTrabalhadas = horasTrabalhadas;
        this.mes = mes;
        this.ano = ano;
    }

    public Lancamento() {
    }
    
    
    

    public int getId_controle() {
        return id_controle;
    }

    public void setId_controle(int id_controle) {
        this.id_controle = id_controle;
    }

    public int getCodFuncionario() {
        return codFuncionario;
    }

    public void setCodFuncionario(int codFuncionario) {
        this.codFuncionario = codFuncionario;
    }

    public float getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(float horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return  String.valueOf(mes);
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }
    
    
    
    
}
