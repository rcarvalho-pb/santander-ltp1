package aula04;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {


        // .:: STREAMS ::.

        // stream vazia
        Stream<String> streamVazia = Stream.empty();
        System.out.println(streamVazia.count());

        // stream com 1 elemento
        Stream<Integer> streamComUmElemento = Stream.of(22);
        System.out.println(streamComUmElemento.count());

        // stream com varios elementos
        Stream<Integer> streamDeVariosElementos = Stream.of(0,1,2,3,4,5,6,7,8,9);
        System.out.println(streamDeVariosElementos.count());

        // STREAMS INFINITAS

        // generate()
        //Stream.generate(Math::random)
                //.forEach((numero) -> System.out.println(numero));

        // iterate()
        //Stream.iterate(1, n -> n + 2)
                //.forEach((numero) -> System.out.println(numero));

        //Stream.iterate(
                //1,
                //n -> n < 100,
                //n -> n + 2)
                //.forEach((numero) -> System.out.println(numero));


        /**
         * STREAMS FINITAS
         * */

        System.out.println(".::STREAMS FINITAS::.");

        Stream<Integer> numeros = Stream.of(0, 1, 2, 3, 4, 5);

        /**
         * PRINCIPAIS METODOS TERMINAIS
         * */

        // count()
        System.out.println("count() -> " + numeros.count());

        // min(), max()

        Optional<String> menorPalavra = Stream.of("casa", "asa", "comida")
                .min((palavra1, palavra2) -> palavra1.length() - palavra2.length());

        System.out.println("min() -> " + menorPalavra.get());

        Optional<String> maiorPalavra = Stream.of("casa", "asa", "comida")
                .max((palavra1, palavra2) -> palavra1.length() - palavra2.length());

        System.out.println("max() -> " + maiorPalavra.get());

        //exercicio: usar min para stream de numeros

        Stream<Integer> streamDeNumeros = Stream.of(2, 1, 5, 3, 8, 9, 7, 6, 4);
        Integer menor = streamDeNumeros
                .min((n1, n2) -> n1.compareTo(n2))
                .get();

        System.out.println("Menor numero: " + menor);

        // findAny() & findFirst()

        Integer any = Stream.iterate(1, n -> n < 10, n -> n + 2)
                .findAny()
                .get();

        System.out.println("any: " + any);

        Integer first = Stream.iterate(1, n -> n < 10, n -> n + 2)
                .findFirst()
                .get();

        System.out.println("first: " + first);

        // allMatch(Predicate), anyMatch(Predicate) e noneMatch(Predicate) -> boolean
        boolean todosSaoImpares = Stream.of(1,3,4,5)
                .allMatch(numero -> numero % 2 != 0);

        System.out.println("allMatch() -> " + todosSaoImpares);

        boolean temNumeroPar = Stream.of(1, 3, 4, 5)
                .anyMatch(numero -> numero % 2 == 0);

        System.out.println("anyMatch() -> " + temNumeroPar);

        boolean nenhumNumeroEhPar = Stream.of(1, 3,4, 5)
                .noneMatch(numero -> numero % 2 == 0);

        System.out.println("noneMatch() -> " + nenhumNumeroEhPar);

        // forEach()

        Stream.of(1,3,5)
                .forEach((numero) -> System.out.println("forEach() -> " + numero));

        // reduce()
        String palavra = Stream.of("c", "a", "s", "a")
                .reduce("", (acumulardor, letra2) -> acumulardor+letra2);

        System.out.println("reduce() -> "+palavra);

        // collect()
        List<Integer> numerosPares = Stream.of(1,2,3,4,5,6,7,8,9)
                .filter((numero) -> numero % 2 == 0) // filtra os numeros pares
                .toList(); // a partir do java 17
                //.collect(Collectors.toList()); antes do java 17
                //.toSet(); Não existe até o java 17

        System.out.println("collect() -> "+numerosPares);


    }

}
