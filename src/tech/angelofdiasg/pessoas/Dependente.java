package tech.angelofdiasg.pessoas;

import tech.angelofdiasg.interfaces.PessoasCadastraveis;

public class Dependente extends Pessoa implements PessoasCadastraveis {
    private Cliente titular;

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    @Override
    public void cadastrar() {
        
    }
}
