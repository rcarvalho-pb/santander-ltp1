package aula02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

/**
 * Solução Ana Beatriz
 * */
public class CorrecaoExercicioAula2 {

    public static void main(String[] args) {

        /**
         * 2. A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
         * parcelado em 48x, imprima o valor e a data de cada parcela usando a nova API de datas do Java.
         * Obs.: com uma nova regra;
         * Caso a data do pagamento seja no final de semana, a data do pagamento deve ser postergada para
         * a primeira segunda feira subsequente, porém sem alterar a data dos próximos pagamentos!
         *
         * */

        LocalDate dataAtual = LocalDate.now();

        Double valorCompra = 64000.0D;

        int parcelamento = 48;

        var formatador = DateTimeFormatter.ofPattern("dd/MM/yy");

        for (int i = 1; i <= 48; i++) {

            LocalDate diaPgto = dataAtual.plusMonths(i);

            if (diaPgto.getDayOfWeek() == DayOfWeek.SATURDAY
                || diaPgto.getDayOfWeek() == DayOfWeek.SUNDAY) {
                diaPgto = diaPgto.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
            }

            System.out.printf("Parcela: %s, Data: %s, Valor: %.2f %n", i, diaPgto.format(formatador), (valorCompra/parcelamento));
        }


    }

}
