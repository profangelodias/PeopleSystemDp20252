package tech.angelofdiasg.auxs;

/*
  Interface Strategy para comportamento de validação e formatação de telefones.
  Qualquer nova regra (por país, tipo, etc.) deve implementar esta interface.
*/
public interface TelefoneStrategy {
    boolean validar(Telefone telefone);
    String formatar(Telefone telefone);
}

