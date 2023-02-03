package aula04;

import java.util.List;
import java.util.stream.Stream;

public class Main2 {

    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("joao", 20);
        Pessoa pessoa2 = new Pessoa("maria", 21);
        Pessoa pessoa3 = new Pessoa("ugo", 17);
        Pessoa pessoa4 = new Pessoa("angelica", 18);
        Pessoa pessoa5 = new Pessoa("marcos", 19);

        List<Pessoa> pessoas =
                List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);

        /**
         * Operações intermediárias
         * */

        // filter() | Predicate

        Stream<Pessoa> pessoaStream = pessoas.stream();

        List<Pessoa> pessoasFiltradas = pessoaStream
                .filter(pessoa -> pessoa.idade() >= 18)
                .toList();


        // distinct()

        var nomesStream =
                Stream.of("Jorge", "Ugo", "Jorge", "Maria", "Ugo", "Jessica");

        List<String> nomes = nomesStream
                .distinct()
                .toList();

        System.out.println("distinct() -> " + nomes);

        // limit() & skip()

        List<Integer> numerosImparesLimitados = Stream.iterate(1, n -> n < 100, n -> n + 2)
                .limit(3)
                .toList();

        System.out.println("limit() -> "+numerosImparesLimitados);

        List<Integer> numerosImparesSkip = Stream.iterate(1, n -> n < 10, n -> n + 2)
                .skip(3)
                .toList();

        System.out.println("skip() -> "+numerosImparesSkip);

        List<Integer> numerosImparesSkipLimit = Stream.iterate(1, n -> n < 100, n -> n + 2)
                .skip(3)
                .limit(3)
                .toList();

        System.out.println("skip() + limit() -> "+numerosImparesSkipLimit);


        // map() | Function

        List<Integer> tamanhoNomes = Stream.of("jorge", "ugo", "maria")
                .map(String::length)
                .toList();

        System.out.println("map() -> "+ tamanhoNomes);

        // exercicio em sala:

        var nomesStream2 =
                Stream.of("joRge", "Ugo", "JOrge", "MarIa", "ugo", "Jessica");

        nomesStream2
                .map(String::toLowerCase)
                .distinct()
                .forEach(System.out::println);
    }

}
