package tech.angelofdiasg.auxs;

/*
  Strategy concreta para validação/formatação de números brasileiros.
  - Valida DDD com exatamente 2 dígitos e número com 8 ou 9 dígitos.
  - Formata com máscara (xx) xxxxx-xxxx ou (xx) xxxx-xxxx.
*/
public class BrasilTelefoneStrategy implements TelefoneStrategy {

    @Override
    public boolean validar(Telefone telefone) {
        String ddd = telefone.getDdd();
        String numero = telefone.getNumero();
        if (ddd == null || numero == null) return false;
        if (!ddd.matches("\\d{2}")) return false;
        if (!numero.matches("\\d{8,9}")) return false;
        return true;
    }

    @Override
    public String formatar(Telefone telefone) {
        String ddd = telefone.getDdd();
        String numero = telefone.getNumero();
        if (ddd == null || numero == null) return (ddd==null?"":ddd) + (numero==null?"":numero);

        String num = numero.length() == 9
                ? numero.substring(0, 5) + "-" + numero.substring(5)
                : numero.substring(0, 4) + "-" + numero.substring(4);
        return "(" + ddd + ") " + num;
    }
}

