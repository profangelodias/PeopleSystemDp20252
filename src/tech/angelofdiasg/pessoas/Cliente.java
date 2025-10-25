package tech.angelofdiasg.pessoas;

import tech.angelofdiasg.auxs.Endereco;
import tech.angelofdiasg.auxs.Telefone;
import tech.angelofdiasg.interfaces.PessoasCadastraveis;

import java.util.Scanner;

public class Cliente extends Pessoa implements PessoasCadastraveis {
    private String codigo;
    private String profissao;



    public void cadastrar(){
        Scanner sc = new Scanner(System.in);

        // Campos da superclasse Pessoa
        System.out.print("Nome: ");
        setNome(sc.nextLine());

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        setDataNascimento(sc.nextLine());

        // ... substitui leitura bruta de telefones pela criação de objetos Telefone ...
        System.out.println("=== Cadastro de Telefones ===");
        String mais;
        do {
            Telefone tel = new Telefone();
            tel.cadastrarTelefone(sc);
            addTelefone(tel);
            System.out.print("Adicionar outro telefone? (s/n): ");
            mais = sc.nextLine();
        } while (mais != null && mais.equalsIgnoreCase("s"));

        Endereco end = new Endereco();
        System.out.println("=== Cadastro de Endereço ===");
        end.cadastrarEndereco(sc);
        setEndereco(end);

        // Campos da subclasse Cliente
        System.out.print("Código do Cliente: ");
        this.codigo = sc.nextLine();

        System.out.print("Profissão: ");
        this.profissao = sc.nextLine();
    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
}
