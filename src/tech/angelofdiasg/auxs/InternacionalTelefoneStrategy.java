package tech.angelofdiasg.auxs;

/*
  Exemplo de Strategy alternativa: aceita DDI/DDI+DDD variados e números maiores.
  Demonstração de como trocar comportamento em tempo de execução.
*/
public class InternacionalTelefoneStrategy implements TelefoneStrategy {

    @Override
    public boolean validar(Telefone telefone) {
        String ddd = telefone.getDdd();   // aqui tratamos texto livre, pode ser DDI+DDD
        String numero = telefone.getNumero();
        if (ddd == null || numero == null) return false;
        // validar DDI/DDI+DDD com 1 a 4 dígitos e número de 5 a 15 dígitos
        if (!ddd.matches("\\d{3}")) return false;
        if (!numero.matches("\\d{7,8}")) return false;
        return true;
    }

    @Override
    public String formatar(Telefone telefone) {
        // Formatação simplificada internacional: +<ddd> <numero>
        String ddd = telefone.getDdd();
        String numero = telefone.getNumero();
        return "+" + ddd + " " + numero;
    }
}
