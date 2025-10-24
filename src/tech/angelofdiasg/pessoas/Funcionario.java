package tech.angelofdiasg.pessoas;

import tech.angelofdiasg.auxs.Cargo;
import tech.angelofdiasg.auxs.Endereco;
import tech.angelofdiasg.interfaces.PessoasCadastraveis;

import java.util.Random;
import java.util.Scanner;

public class Funcionario extends Pessoa implements PessoasCadastraveis {
    private int matricula;
    private Cargo cargo;
    private double salario;
    private String dataAdmisao;

    public Funcionario(int matricula, Cargo cargo, double salario, String dataAdmisao) {
        this.matricula = matricula;
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmisao = dataAdmisao;
    }

    public Funcionario(Cargo cargo, double salario, String dataAdmisao) {
        Random random = new Random();
        this.matricula = 1000 + random.nextInt(9000); // Gera entre 1000 e 9999
        this.cargo = cargo;
        this.salario = salario;
        this.dataAdmisao = dataAdmisao;
    }

    public Funcionario(){}

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getDataAdmisao() {
        return dataAdmisao;
    }

    public void setDataAdmisao(String dataAdmisao) {
        this.dataAdmisao = dataAdmisao;
    }

    @Override
    public void cadastrar() {
        Scanner sc = new Scanner(System.in);

        // ======== DADOS DA SUPERCLASSE PESSOA ========
        System.out.print("Nome: ");
        setNome(sc.nextLine());

        System.out.print("Data de Nascimento (dd/mm/aaaa): ");
        setDataNascimento(sc.nextLine());

        System.out.print("Telefone(s) de Contato: ");
        setTelsContato(sc.nextLine());

        Endereco end = new Endereco();
        System.out.println("=== Cadastro de Endereço ===");
        end.cadastrarEndereco(sc);
        setEndereco(end);

        // ======== DADOS ESPECÍFICOS DE FUNCIONÁRIO ========
        // Matrícula aleatória de 4 dígitos
        Random random = new Random();
        this.matricula = 1000 + random.nextInt(9000);
        System.out.println("Matrícula gerada automaticamente: " + this.matricula);

        // Escolha do cargo
        System.out.println("=== Escolha o Cargo ===");
        for (Cargo c : Cargo.values()) {
            System.out.println("- " + c);
        }
        System.out.print("Digite o cargo exatamente como mostrado acima: ");
        String cargoStr = sc.nextLine().toUpperCase();
        try {
            this.cargo = Cargo.valueOf(cargoStr);
        } catch (IllegalArgumentException e) {
            System.out.println("Cargo inválido. Definido como 'OUTRO'.");
            this.cargo = Cargo.OUTRO; // opcional, caso tenha um enum OUTRO
        }

        System.out.print("Salário: ");
        this.salario = sc.nextDouble();
        sc.nextLine(); // consumir quebra de linha

        System.out.print("Data de Admissão (dd/mm/aaaa): ");
        this.dataAdmisao = sc.nextLine();
    }
}
