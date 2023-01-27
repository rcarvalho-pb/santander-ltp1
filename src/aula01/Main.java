package aula01;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        // DATAS

        // DATE
        // CALENDAR
        // GREGORIAN CALENDAR

        // 1.8

        // java.util.* -> java.time

        // LocalDate, LocalTime e LocalDateTime

        LocalDate agoraDate = LocalDate.now();
        LocalTime agoraTime = LocalTime.now();

        var agoraDateTime = LocalDateTime.now();

        System.out.println(agoraDate);
        System.out.println(agoraTime);
        System.out.println(agoraDateTime);



        //LocalDate.of(int ano, int mes, int diaDoMes)

        LocalDate birthDay = LocalDate.of(1994, 4, 23);

        System.out.println("Birth: " + birthDay);


        // LocalTime.of(int hora, int minuto, int segundo)
        LocalTime remedio = LocalTime.of(15, 30, 12);

        System.out.println("Remedio: " + remedio);


        // LocalDateTime.of(int ano, int mes, int dia, int hora, int minuto, int segundo)

        LocalDateTime nascimento = LocalDateTime.of(1994, 4, 23, 19, 22, 12);


        System.out.println("Nascimento: " + nascimento);

        // LocalDateTime.of(LOCALDATE, LOCALTIME);

        LocalDateTime horario = LocalDateTime.of(birthDay, remedio);

        System.out.println("Horario: " + horario);

        // CONVERTENDO STRING EM DATA

        String dataObtida = "23/01/2023";
        // String dataObtida = "2023-04-22";

        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // LocalDate parsed = LocalDate.parse("YYYY-MM-DD");
        // LocalDate parsed = LocalDate.parse("1994-04-23");
        // LocalDate parsed = LocalDate.parse(dataObtida);
        LocalDate parsed = LocalDate.parse(dataObtida, pattern);

        System.out.println(parsed);

        System.out.println("CONVERTERNDO STRING EM HORA");
        //CONVERTENDO STRING EM HORA

//        String horaObtida = "15:22:15";
        String horaObtida = "15-22";

        // FORMATO PADRAO: hh:mm:ss

        LocalTime parsedHorario = LocalTime.parse(horaObtida, DateTimeFormatter.ofPattern("HH-mm"));

        System.out.println(parsedHorario);

        System.out.println("CONVERTERNDO STRING EM DATA E HORA");
        //CONVERTENDO STRING EM DATA E HORA

        // PADRAO: YYYY-MM-DDTHH:mm:ss
        //String dataHoraObtida = "2023-01-22T22:44:12";
        String dataHoraObtida = "2023-01-22 09:55 AM";

        DateTimeFormatter pattern1 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

        LocalDateTime dataHoraParsed = LocalDateTime.parse(dataHoraObtida, pattern1);

        System.out.println(dataHoraParsed);

        System.out.println("COMECANDO COM FORMAT");
        System.out.println();

        LocalDate now = LocalDate.now();

        System.out.println(now);
        String dataFormatada = now.format(DateTimeFormatter.ofPattern("dd/MM/yy"));

        System.out.println(dataFormatada);


        LocalDate nowPlusThree = now.plusYears(3);
        nowPlusThree = nowPlusThree.plusDays(25);
        nowPlusThree = nowPlusThree.plusWeeks(3);
        nowPlusThree = nowPlusThree.plusMonths(43);

        System.out.println(nowPlusThree);


        LocalDate updated = nowPlusThree.minusYears(3);
        updated = updated.minusDays(25);
        updated = updated.minusWeeks(3);
        updated = updated.minusMonths(43);

        System.out.println(updated);

        // DATAS COM FUSO HORARIO
        System.out.println("DATAS COM FUSO HORARIO");

        ZoneId fusoSp = ZoneId.of("America/Sao_Paulo");
        ZoneId fusoAc = ZoneId.of("Brazil/Acre");
        ZoneId fusoLisboa = ZoneId.of("Europe/Lisbon");

        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        LocalTime timezoned = LocalTime.now(fusoLisboa);
        System.out.println("timeZoned: " + timezoned);

        ZonedDateTime dateTimeSP = ZonedDateTime.of(dataHoraParsed, fusoSp);
        ZonedDateTime dateTimeAC = ZonedDateTime.of(dataHoraParsed, fusoAc);

        System.out.println(dateTimeSP);
        System.out.println(dateTimeAC);

    }
}