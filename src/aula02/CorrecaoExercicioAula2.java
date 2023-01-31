package aula02;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;


public class CorrecaoExercicioAula2 {

    public static void main(String[] args) {

        /**
         *
         * Solução Ramon
         *
         * 1. Dado uma data e hora específiva,
         * use a nova API de data do Java para criar um objeto
         * ZonedDateTime com o seu fuso horário e imprimí-los;
         *
         * */

        String data = "2023-01-30T19:31:30";


        LocalDateTime dateTime = LocalDateTime.parse(data);

        ZoneId fuso = ZoneId.systemDefault();

        ZonedDateTime zonedDateTime = ZonedDateTime.of(dateTime, fuso);

        System.out.println(zonedDateTime);

        /**
         *
         * Solução Ana Beatriz
         *
         * 2. A partir da data atual, calcule e imprima uma compra de R$ 64.000,00
         * parcelado em 48x, imprima o valor e a data de cada parcela usando a nova API de datas do Java.
         * Obs.: com uma nova regra;
         * Caso a data do pagamento seja no final de semana, a data do pagamento deve ser postergada para
         * a primeira segunda feira subsequente, porém sem alterar a data dos próximos pagamentos!
         *
         * */

//        LocalDate dataAtual = LocalDate.now();
//
//        Double valorCompra = 64000.0D;
//
//        int parcelamento = 48;
//
//        var formatador = DateTimeFormatter.ofPattern("dd/MM/yy");
//
//        for (int i = 1; i <= 48; i++) {
//
//            LocalDate diaPgto = dataAtual.plusMonths(i);
//
//
//            // melhoria sugerida, Adriano
//
//            // if (diaPgto.getDayOfWeek().getValue() > 5) {
//            if (diaPgto.getDayOfWeek() == DayOfWeek.SATURDAY
//                || diaPgto.getDayOfWeek() == DayOfWeek.SUNDAY) {
//                diaPgto = diaPgto.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
//            }
//
//            System.out.printf("Parcela: %s, Data: %s, Valor: %.2f %n", i, diaPgto.format(formatador), (valorCompra/parcelamento));
//        }

        /**
         * 3. A partir da sua data de nascimento, faça um programa que calcule as seguintes informações;
         * */
        String dataNascimento = "2000-01-23";

        // A - RAMON
        var dia = LocalDate.parse(dataNascimento).getDayOfWeek();
        System.out.println(dia);

        // B - MATHEUS PANOBINACO
        var primeiroDiaDoMes = LocalDate
                .parse(dataNascimento)
                .with(TemporalAdjusters.firstDayOfMonth())
                .getDayOfWeek();

        System.out.println(primeiroDiaDoMes);

        // C - NATALIA STOLL

        DayOfWeek primeiroDiaDoAno = LocalDate
                .parse(dataNascimento)
                .with(TemporalAdjusters.firstDayOfYear())
                .getDayOfWeek();

        System.out.println(primeiroDiaDoAno);

        // D - IAN

        var ultimoDiaDoMes = LocalDate
                .parse(dataNascimento)
                .with(TemporalAdjusters.lastDayOfMonth())
                .getDayOfWeek();

        System.out.println(ultimoDiaDoMes);

        // D

        var ultimoDiaDoAno = LocalDate
                .parse(dataNascimento)
                .with(TemporalAdjusters.lastDayOfYear())
                .getDayOfWeek();

        System.out.println(ultimoDiaDoAno);

        // F - ANTONIO

        var primeiraSextaDepoisDoNascimento = LocalDate.parse(dataNascimento)
                .with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        System.out.println(primeiraSextaDepoisDoNascimento);
    }

}
