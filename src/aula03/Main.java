package aula03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        // PROGRAMAÇAO FUNCIONAL

        // FUNCIONAL NO JAVA COM LAMBDAS

        // PREDICATE -> TEST -> RECEBE UM OBJETO E RETORNA UM BOOLEAN

        Ave aguia = new Ave("Aguia", true, false);
        Ave pinguim = new Ave("pinguim", false, true);
        Ave gaivota = new Ave("gaivota", true, true);

        List<Ave> aves = List.of(aguia, pinguim, gaivota);

        List<Ave> avesFiltradas = filtrarAves(aves, (ave) -> ave.isVoa());

        for (Ave ave : avesFiltradas) {
            System.out.println(ave.getNome());
        }

        System.out.println("FUNCTION");

        List<String> nomes = transformarObjAve(aves, (ave) -> ave.getNome());

        System.out.println(nomes);


        System.out.println("CONSUMER");

        aves.forEach((ave) -> System.out.println(ave.getNome()));

    }

    public static void imprimirNomesAves(List<Ave> aves, Consumer<Ave> consumidor) {

        for (Ave ave : aves) {
            consumidor.accept(ave);
        }

    }

    public static List<String> transformarObjAve(List<Ave> aves, Function<Ave, String> transformador) {
        List<String> nomesAves = new ArrayList<>();

        for (Ave ave : aves) {
            nomesAves.add(transformador.apply(ave));
        }

        return nomesAves;
    }

    public static List<Ave> filtrarAves(List<Ave> aves, Predicate<Ave> filtro) {
        ArrayList<Ave> avesFiltradas = new ArrayList<>();

        for (int i = 0; i < aves.size(); i++) {
            if (filtro.test(aves.get(i))) {
                avesFiltradas.add(aves.get(i));
            }
        }
        return avesFiltradas;
    }

}