package aula05;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {


        var pessoas = List.of(
                new Pessoa("maria", 22),
                new Pessoa("joao", 30),
                new Pessoa("ugo", 28),
                new Pessoa("eduarda", 25),
                new Pessoa("jose", 35));

        Integer somaIdades = pessoas
                .stream()
                .reduce(
                        0,
                        (acumulador, pessoa) -> acumulador + pessoa.idade(),
                        Integer::sum);

        System.out.println("Soma das idades: " + somaIdades);

        // Stream de tipos primitivos

        // IntStream
        IntStream pessoasIS = pessoas
                .stream()
                .mapToInt(Pessoa::idade);

        IntSummaryStatistics statistics = pessoasIS.summaryStatistics();

        System.out.println("Soma das idades com intStream: " + statistics.getSum());
        System.out.println("Media das idades: " + statistics.getAverage());

        // LongStream

        LongStream longStream = LongStream.rangeClosed(0, 10);

        LongSummaryStatistics longStatistics = longStream.summaryStatistics();

        System.out.println(longStatistics.getMax());

        // DoubleStream

        // flatMap

        // [ [a,b], [c,d] ] -> flatMap -> [1,2,3,4]

        List<String> ab = List.of("a", "b");
        List<String> cd = List.of("c", "d");

        List<String> strings = Stream.of(ab, cd)
                .flatMap(List::stream)
                .toList();

        System.out.println(strings);

        Optional<Aluno> optional = Optional.of(new Aluno("aluno op", 22));

        optional.ifPresent(System.out::println);

        Integer nota = optional
                .filter(aluno -> aluno.nota() > 5)
                .map(Aluno::nota)
                .orElse(0);

        System.out.println(nota);

    }

}

record Pessoa(String nome, int idade){}
