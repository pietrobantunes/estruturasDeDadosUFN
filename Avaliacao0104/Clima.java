package Avaliacao0104;

/**
 * Classe que representa os dados climáticos de um determinado mês e ano.
 */
public class Clima {

    String ano;
    String mes;
    String temperatura;
    String precipitacao;

    /**
     * Construtor da classe Clima.
     *
     * @param ano Ano do registro.
     * @param mes Mês do registro.
     * @param temperatura Temperatura do mês (ex: quente, frio).
     * @param precipitacao Nível de chuva (ex: muita, pouca).
     */
    public Clima(String ano, String mes, String temperatura, String precipitacao) {
        this.ano = ano;
        this.mes = mes;
        this.temperatura = temperatura;
        this.precipitacao = precipitacao;
    }

    /**
     * Retorna uma string formatada com os dados do clima.
     *
     * @return String formatada para impressão.
     */
    @Override
    public String toString() {
        return String.format(
            "Ano: %s | Mes: %-10s | Temp: %-6s | Chuva: %s",
            ano, mes, temperatura, precipitacao
        );
    }

    /**
     * Compara dois objetos Clima para evitar duplicados.
     * Dois climas são iguais se tiverem o mesmo ano e mês.
     *
     * @param obj Objeto a ser comparado.
     * @return true se forem iguais, false caso contrário.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Clima c = (Clima) obj;
        return this.ano.equals(c.ano) && this.mes.equals(c.mes);
    }

    /**
     * Retorna o ano do registro.
     *
     * @return Ano.
     */
    public String getAno() {
        return ano;
    }

    /**
     * Retorna a temperatura do registro.
     *
     * @return Temperatura.
     */
    public String getTemperatura() {
        return temperatura;
    }

    /**
     * Retorna a precipitação do registro.
     *
     * @return Precipitação.
     */
    public String getPrecipitacao() {
        return precipitacao;
    }
}
