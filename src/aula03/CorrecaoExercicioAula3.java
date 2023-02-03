package aula03;

import java.time.LocalDate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class CorrecaoExercicioAula3 {
    public static void main(String[] args) {

        /**
         * Escreva um método utilizando Predicate, que recebe um número e
         * verifica se é par;
         * */

        Consumer<Boolean> impressoraConsumer = (ehPar) -> {
            if (ehPar) {
                System.out.println("eh par");
            } else {
                System.out.println("nao eh par");
            }
        };

        Predicate<Integer> isParPredicate = (num) -> num % 2 == 0;

        Function<String, Integer> funcao = String::length;

        ehPar(5, isParPredicate, impressoraConsumer, funcao);


        /**
         * Escreva um método utilizando Supplier para retornar uma data
         * com o LocalDate.now();
         * */

        Supplier<LocalDate> fornecedorDeData = () -> LocalDate.now();

        System.out.println(fornecedorDeData.get());


    }

    public static void ehPar(int numero, Predicate<Integer> verificador, Consumer<Boolean> impressora, Function<String, Integer> function) {
        impressora.accept(verificador.test(numero));
    }
}
