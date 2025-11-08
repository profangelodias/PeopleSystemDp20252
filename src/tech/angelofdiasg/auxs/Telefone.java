package tech.angelofdiasg.auxs;

import java.util.Scanner;

/*
  Alterações:
  - Introduzido padrão Strategy: Telefone delega validação e formatação a um TelefoneStrategy.
  - Adicionado campo 'strategy' com implementação padrão BrasilTelefoneStrategy.
  - Métodos validar() e formatar() agora delegam à strategy.
  - Adicionados setStrategy/getStrategy para trocar a estratégia em tempo de execução.
  - Comentários explicativos nas partes alteradas.
*/
public class Telefone {
    private String ddd;
    private String numero;
    private String tipo; // ex: celular, residencial, comercial

    private TelefoneStrategy strategy; // strategy que encapsula validação/formatacao

    public Telefone() {
        // definir strategy padrão (Brasil)
        this.strategy = new BrasilTelefoneStrategy();
    }

    public Telefone(String ddd, String numero, String tipo) {
        this.ddd = ddd;
        this.numero = numero;
        this.tipo = tipo;
        // strategy padrão
        this.strategy = new BrasilTelefoneStrategy();
    }

    // Permitir trocar a estratégia em tempo de execução (padrão do padrão Strategy)
    public void setStrategy(TelefoneStrategy strategy) {
        this.strategy = strategy;
    }

    public TelefoneStrategy getStrategy() {
        return this.strategy;
    }

    public void cadastrarTelefone(Scanner sc) {
        System.out.print("DDD: ");
        this.ddd = sc.nextLine().replaceAll("\\D", "");

        System.out.print("Número: ");
        this.numero = sc.nextLine().replaceAll("\\D", "");

        System.out.print("Tipo (celular/residencial/empresa): ");
        this.tipo = sc.nextLine();

        // agora delegamos a validação à strategy configurada
        if (!validar()) {
            System.out.println("Telefone inválido conforme a estratégia atual. Tente novamente.");
            cadastrarTelefone(sc);
        }
    }

    // Agora delega a validação à strategy (encapsula as regras)
    public boolean validar() {
        if (this.strategy != null) {
            return this.strategy.validar(this);
        }
        // fallback minimalista (não deve ocorrer porque sempre definimos uma strategy)
        if (ddd == null || numero == null) return false;
        if (!ddd.matches("\\d{2}")) return false;
        if (!numero.matches("\\d{8,9}")) return false;
        return true;
    }

    // Delegação da formatação para a strategy
    public String formatar() {
        if (this.strategy != null) {
            return this.strategy.formatar(this);
        }
        // fallback: concatenação simples
        return ddd + numero;
    }

    // ...getters e setters...
    public String getDdd() { return ddd; }
    public void setDdd(String ddd) { this.ddd = ddd; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
}
