package tech.angelofdiasg.auxs;

import java.util.Scanner;

public class Telefone {
    private String ddd;
    private String numero;
    private String tipo; // ex: celular, residencial, comercial

    public Telefone() {
    }

    public Telefone(String ddd, String numero, String tipo) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
    }

    public void cadastrarTelefone(Scanner sc) {
        System.out.print("DDD: ");
        this.ddd = sc.nextLine().replaceAll("\\D", "");

        System.out.print("Número: ");
        this.numero = sc.nextLine().replaceAll("\\D", "");

        System.out.print("Tipo (celular/residencial/empresa): ");
        this.tipo = sc.nextLine();

        if (!validar()) {
            System.out.println("Telefone inválido. Formato esperado: DDD com 2 dígitos e número com 8 ou 9 dígitos. Tente novamente.");
            cadastrarTelefone(sc);
        }
    }

    public boolean validar() {
        if (ddd == null || numero == null) return false;
        if (!ddd.matches("\\d{2}")) return false;
        if (!numero.matches("\\d{8,9}")) return false;
        return true;
    }

    public String formatar() {
        if (!validar()) return ddd + numero;
        String num = numero.length() == 9
                ? numero.substring(0, 5) + "-" + numero.substring(5)
                : numero.substring(0, 4) + "-" + numero.substring(4);
        return "(" + ddd + ") " + num;
    }

    // ...getters e setters...
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}

