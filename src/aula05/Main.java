package aula05;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        /**
         * Collectors
         * */
        // Coletor básico

        Set<Integer> streamColetada = Stream.of(1, 2, 3)
                .collect(Collectors.toSet());
                //.toList();

        System.out.println(streamColetada);

        // Coletor para outra implementação

        LinkedHashSet<Integer> treeset = Stream.of(1,2,3)
                .collect(Collectors.toCollection(LinkedHashSet::new));
                //.collect(Collectors.toCollection(() -> new LinkedHashSet<>()));

        System.out.println(treeset);

        TreeSet<String> collect = Stream.of("b", "o", "l", "a")
                .collect(Collectors.toCollection(TreeSet::new));

        System.out.println(collect);


        // coletor como reduce
        StringBuilder reduzido = Stream.of("c", "a", "s", "a")
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);

        System.out.println(reduzido);


        // joining()

        String itens = Stream.of("feijao", "arroz", "agua")
                .collect(Collectors.joining(","));

        System.out.println(itens);

        // averagingInt()
        Double media = Stream.of("feijao", "arroz", "agua")
                //.collect(Collectors.averagingInt(item -> item.length()));
                .collect(Collectors.averagingInt(String::length));

        System.out.println(media);

        Double media2 = Stream.of(1L, 5L, 10L)
                .collect(Collectors.averagingLong(item -> item));

        System.out.println(media2);

        // coletar em MAPS
        // chave [palavra]:[tamanho]

        Map<String, Integer> map = Stream.of("feijao", "arroz", "agua")
                .collect(Collectors.toMap(
                        item -> item, // mapear a chave
                        String::length)); // mapear o valor

        System.out.println(map); // {feijao=6, arroz=5, agua=4}

        // coletar em MAPS 2
        Map<Integer, String> map2 = Stream.of("feijao", "arroz", "agua", "mamao")
                .collect(Collectors.toMap(
                        String::length, // mapeando a chave (key)
                        item -> item,   // mapeando o valor (value)
                        (item1, item2) -> item1 + "," + item2)); // merge

        System.out.println(map2); // {6=feijao, 5=arroz,mamao, 4=agua}

        // coletar em MAPS 3
        Map<Integer, String> map3 = Stream.of("feijao", "arroz", "agua", "mamao")
                .collect(Collectors.toMap(
                        String::length, // mapeando a chave (key)
                        item -> item,   // mapeando o valor (value)
                        (item1, item2) -> item1 + "," + item2, // merge
                        TreeMap::new)); // outra implementação

        System.out.println(map3);
        System.out.println(map3.getClass());

        // Collectors com agrupamento, partições e mapeamentos

        Map<Integer, List<String>> map4 = Stream.of("feijao", "arroz", "mamao")
                //.collect(Collectors.groupingBy(item -> item.length()));
                .collect(Collectors.groupingBy(String::length));

        List<String> lista = map4.get(6);
        int qtd = lista.size();
        System.out.println(qtd);

        System.out.println(map4);

        // mudando o tipo de implementação

        Map<Integer, Set<String>> map5 = Stream.of("feijao", "arroz", "mamao")
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.toCollection(TreeSet::new)
                ));

        System.out.println(map5);

        // mudando implementação do map

        Map<Integer, Set<String>> map6 = Stream.of("feijao", "arroz", "mamao")
                .collect(Collectors.groupingBy(
                        String::length,
                        TreeMap::new,
                        Collectors.toCollection(TreeSet::new)
                ));

        System.out.println(map6);
        System.out.println(map6.getClass());

        // usar outro tipo de coletor

        Map<Integer, Long> map7 = Stream.of("feijao", "arroz", "mamao")
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.counting()
                ));

        System.out.println(map7);

        // PARTICIONAMENTO

        Map<Boolean, List<String>> map8 = Stream.of("feijao", "arroz", "mamao")
                .collect(Collectors.partitioningBy(item -> item.length() <= 5));

        System.out.println(map8);

        // dado uma lista de alunos, particionar entre aprovados e reprovados baseado na nota 7

        List<Aluno> alunos = List.of(new Aluno("jorge", 10),
                new Aluno("joao", 9),
                new Aluno("maria", 6),
                new Aluno("joana", 5),
                new Aluno("jessica", 7),
                new Aluno("karol", 8));


        Map<Boolean, List<Aluno>> resultado = alunos.stream()
                .collect(Collectors.partitioningBy(aluno -> aluno.nota() >= 7));

        System.out.println(resultado);

        Integer res = alunos.stream()
                .reduce(0, (acumulador, aluno) -> acumulador + aluno.nota(), (a, b) -> a + b);

        System.out.println(res);


    }

}


record Aluno(String nome, int nota){}