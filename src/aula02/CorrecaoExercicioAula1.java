package aula02;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CorrecaoExercicioAula1 {

    public static void main(String[] args) {

        // Exercicio 1

        LocalDate data = LocalDate.of(2023, 1, 27);
        System.out.println(data);

        LocalTime horario = LocalTime.of(19, 24, 30);
        System.out.println(horario);

        LocalDateTime dataHorario = LocalDateTime.of(data, horario);
        System.out.println(dataHorario);


        // EXERCICIO 2

        LocalDate diaCompra = LocalDate.now();

        Double divida = 64000.0D;

        Integer parcelamento = 48;

        Double parcela = divida/parcelamento;

        LocalDate diaAPagar;

        var formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Divida total de " + divida);

        for (int i = 1; i <= parcelamento; i++) {
            diaAPagar = diaCompra.plusMonths(i);
            String resultado = "Parcela: %s. Valor: %.2f. Vencimento: %s %n";
            System.out.printf(resultado, i, parcela, diaAPagar.format(formatador));
        }


        // EXERCICIO 3

        // 23/04/1994

        var dataNascimento = LocalDate.of(1994, 4, 23);
        var dataAtual = LocalDate.now();

        int idadeCalculada = calcularIdade(dataAtual, dataNascimento);

        System.out.println("Idade: " + idadeCalculada);


    }

    public static int calcularIdade(LocalDate dataAtual, LocalDate dataNascimento) {
        int idade;

        if (dataAtual.getDayOfYear() < dataNascimento.getDayOfYear()) {
            idade = dataAtual.compareTo(dataNascimento) - 1;
        } else {
            idade = dataAtual.compareTo(dataNascimento);
        }

        return idade;
    }

}
