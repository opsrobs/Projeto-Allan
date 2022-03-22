package Models;

import java.util.Date;

public class Funcionario {
    int cod_funcionario;
    String nome_funcionario;
    String cpf;
    String rg;
    String genero;
    double valor_hora;
    Date data_nasc;

    public Date getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(Date data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    String status;

    public Funcionario(int cod_funcionario, String nome_funcionario, String cpf, String rg, String genero, double valor_hora, Date data_nasc, String status) {
        this.cod_funcionario = cod_funcionario;
        this.nome_funcionario = nome_funcionario;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.valor_hora = valor_hora;
        this.data_nasc = data_nasc;
        this.status = status;
    }

    public Funcionario(String nome_funcionario, String cpf, String rg, String genero, double valor_hora, Date data_nasc, String status) {
        this.nome_funcionario = nome_funcionario;
        this.cpf = cpf;
        this.rg = rg;
        this.genero = genero;
        this.valor_hora = valor_hora;
        this.data_nasc = data_nasc;
        this.status = status;
    }



    public Funcionario() {
    }
    
    

    public int getCod_funcionario() {
        return cod_funcionario;
    }

    public void setCod_funcionario(int cod_funcionario) {
        this.cod_funcionario = cod_funcionario;
    }

    public String getNome_funcionario() {
        return nome_funcionario;
    }

    public void setNome_funcionario(String nome_funcionario) {
        this.nome_funcionario = nome_funcionario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(double valor_hora) {
        this.valor_hora = valor_hora;
    }

    @Override
    public String toString() {
        return nome_funcionario;
    }
    
    
}
