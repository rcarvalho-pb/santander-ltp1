package aula02;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

public class Main {

    public static void main(String[] args) {


        // AJUSTES EM DATAS E HORAS

        /**
         *  with
         * */

        // LocalDate, LocalTime e LocalDateTime

        LocalDateTime asDez = LocalDateTime.now()
                .withDayOfMonth(26)
                .withSecond(00)
                .withMinute(00)
                .withHour(10);
        System.out.println(asDez);

        LocalDate date = LocalDate.now()
                .withDayOfMonth(10)
                .withMonth(2);

        System.out.println(date);

        LocalTime asDezHoras = LocalTime.now().withHour(10);
        System.out.println(asDezHoras);

        LocalDateTime localDateTime = LocalDate.now().atStartOfDay();
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = LocalTime.now().atDate(LocalDate.now());
        System.out.println(localDateTime1);

        System.out.println();
        System.out.println("PERIOD, DURATION AND INSTANT");
        System.out.println();

        /**
         *
         * Period : representa um período de dias, meses e anos
         * Duration : representa um duração de minutos ou horas;
         * Instant : respresenta o número de segundo e nanosegundos desde 1/11970
         *
         * */

        ZoneId fusoSP = ZoneId.of("America/Sao_Paulo");

        var dataComFuso = ZonedDateTime
                .of(2022, 4, 8, 13, 35, 56, 0, fusoSP);

        Period period = Period.of(1, 3, 5);

        ZonedDateTime novaData = dataComFuso.plus(period);

        System.out.println(novaData);

        System.out.println("Inicio atividade: " + dataComFuso);
        System.out.println("Fim atividade: " + novaData);

        System.out.println("calculando periodo entre duas datas...");


        var dataNascimento = LocalDate.of(1994, 4, 23);
        var dataAtual = LocalDate.now();

        Period periodoEntreNascimento = Period.between(dataNascimento, dataAtual);

        System.out.println("Objeto period, getYears(): " + periodoEntreNascimento.getYears());

        // não me devolve a quantidade total de meses, e sim os meses do periodo
        System.out.println("Objeto period, getMonths(): " + periodoEntreNascimento.getMonths());
        System.out.println("Objeto period, getDays(): " + periodoEntreNascimento.getDays());

        // calculando a quantidade total de meses
        System.out.println("Objeto period, meses totais: " + periodoEntreNascimento.toTotalMonths());

        // como calcular a quantidade total de dias???
        long diasEntre = ChronoUnit.DAYS.between(dataNascimento, dataAtual);
        System.out.println("Dias entre as datas: " + diasEntre);

        System.out.println();
        System.out.println(" DURATION ");
        System.out.println();

        LocalTime dAsDezHoras
                = LocalTime.of(10, 20);

        Duration threeHoursDuration = Duration.ofHours(3);

        LocalTime novaHora = dAsDezHoras.plus(threeHoursDuration);

        System.out.println(novaHora);

        Duration between = Duration.between(LocalTime.of(0, 0), LocalTime.now());
        System.out.println(between.toMinutes());

        Duration between1 = Duration.between(asDez, LocalDateTime.now());

        System.out.println(between1.toHours());
        System.out.println(between1.toDays());
        System.out.println(between1.toMinutes());

        // divide as horas por 24 para não retornar mais de 24 (resto da divisão)
        System.out.println(between1.toHoursPart());


        System.out.println();
        System.out.println(" INSTANT");
        System.out.println();

        Instant now = Instant.now();

        Instant instant = dataComFuso.toInstant();
        long milisegundosEntre1970 = instant.toEpochMilli();

        System.out.println("Numero de millisegundos entre 1/1/1970 até agora: " + milisegundosEntre1970);



    }

}
