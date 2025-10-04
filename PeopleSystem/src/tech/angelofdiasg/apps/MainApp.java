package tech.angelofdiasg.apps;

import tech.angelofdiasg.auxs.Endereco;
import tech.angelofdiasg.pessoas.Cliente;
import tech.angelofdiasg.pessoas.Dependente;

public class MainApp {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente();
        Endereco end1 = new Endereco("Rua 1","1","111100","Um","Estado Um","OUm");
        cliente1.setEndereco(end1);

        Dependente depnd1 = new Dependente();
        depnd1.setTitular(cliente1);
        cliente1.cadastrar();

        System.out.println(cliente1.getEndereco().getCep());
        System.out.println(depnd1.getTitular().getEndereco().getCep());

    }
}
