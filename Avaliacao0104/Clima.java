package Avaliacao0104;

public class Clima {

    String ano;
    String mes;
    String temperatura;
    String precipitacao;

    // Construtor
    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    // Formatação do print
    @Override
    public String toString() {
        return String.format(
            "Ano: %s | Mes: %-10s | Temp: %-6s | Chuva: %s",
            ano, mes, temperatura, precipitacao
        );
    }

    // Evita duplicados (mesmo ano + mês)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Clima c = (Clima) obj;
        return this.ano.equals(c.ano) && this.mes.equals(c.mes);
    }

    // Getters usados na análise
    public String getAno() {
        return ano;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }
}