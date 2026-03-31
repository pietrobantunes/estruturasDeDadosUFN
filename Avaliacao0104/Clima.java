package Avaliacao0104;

public class Clima {

    String ano;
    String mes;
    String temperatura;
    int precipitacao;

    public Clima(String ano, String mes, String temperatura, int precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    @Override
    public String toString() {
        return String.format(
            "Ano: %s | Mes: %-10s | Temp: %-6s | Chuva: %d",
            ano, mes, temperatura, precipitacao
        );
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Clima outro = (Clima) obj;

        return this.ano.equals(outro.ano) &&
               this.mes.equals(outro.mes);
    }

    public static int converterChuva(String valor) {

        valor = valor.toLowerCase();

        if (valor.equals("nada")) return 0;
        if (valor.equals("pouca")) return 1;
        if (valor.equals("média") || valor.equals("media")) return 2;
        if (valor.equals("muita")) return 3;

        return 0;
    }

    public int valorTemperatura() {

        String t = temperatura.toLowerCase();

        if (t.equals("frio")) return 1;
        if (t.equals("ameno")) return 2;
        if (t.equals("quente")) return 3;

        return 0;
    }
}