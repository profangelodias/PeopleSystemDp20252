package tech.angelofdiasg.pessoas;

import tech.angelofdiasg.auxs.Endereco;
import tech.angelofdiasg.auxs.Telefone;
import java.util.List;
import java.util.ArrayList;

public class Pessoa {
    private String nome;
    private String dataNascimento;
    protected Endereco endereco;
    private List<Telefone> telefones = new ArrayList<>();

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

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public void addTelefone(Telefone telefone) {
        if (telefone != null && telefone.validar()) {
            this.telefones.add(telefone);
        }
    }
}
