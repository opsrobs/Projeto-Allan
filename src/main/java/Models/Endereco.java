package main.java.Models;

public class Endereco {
    private int idEndereco;
    private String cep;
    private String uf;
    private String localidade;
    private String bairro;
    private String logradouro;
    private String numero;
    private String complemento;

    public Endereco(int idEndereco, String cep, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.idEndereco = idEndereco;
        this.cep = cep;
        this.uf = estado;
        this.localidade = cidade;
        this.bairro = bairro;
        this.logradouro = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public int getIdEndereco() {
        return idEndereco;
    }

    public void setIdEndereco(int idEndereco) {
        this.idEndereco = idEndereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Endereco(String cep, String estado, String cidade, String bairro, String rua, String numero, String complemento) {
        this.cep = cep;
        this.uf = estado;
        this.localidade = cidade;
        this.bairro = bairro;
        this.logradouro = rua;
        this.numero = numero;
        this.complemento = complemento;
    }
    
    
}
