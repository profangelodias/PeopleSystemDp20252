package tech.angelofdiasg.pessoas;

import tech.angelofdiasg.auxs.Endereco;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    protected Endereco endereco;
    private String telsContato;

    public int obterIdade(){
        return 1;

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelsContato() {
        return telsContato;
    }

    public void setTelsContato(String telsContato) {
        this.telsContato = telsContato;
    }
}
