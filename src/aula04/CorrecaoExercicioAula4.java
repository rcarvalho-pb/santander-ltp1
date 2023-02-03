package aula04;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CorrecaoExercicioAula4 {
    public static void main(String[] args) {

        Pessoa pessoa1 = new Pessoa("joao", 20);
        Pessoa pessoa2 = new Pessoa("maria", 21);
        Pessoa pessoa3 = new Pessoa("ugo", 17);
        Pessoa pessoa4 = new Pessoa("angelica", 18);
        Pessoa pessoa5 = new Pessoa("marcos", 19);

        List<Pessoa> pessoas =
                List.of(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5);

        /**
         * 5) Crie o objeto Pessoa com os atributos nome:string e idade:integer
         * no metodo main inicialize uma lista de pessoas
         * use a stream para:
         *  - filtrar somente pessoas com mais de 18 anos de idade
         *  - tranformar em uma lista somente dos nomes dessas pessoas
         *  - limitar a no máximo 3 resultados
         *  - transformar a stream em Set
         *
         * e imprima essa coleção.
         *
         * - lista ordenada
         *
         * */

        Set<String> nomes = pessoas.stream()
                .filter(pessoa -> pessoa.idade() >= 18)
                .sorted(Comparator.comparing(Pessoa::idade).reversed())
                .map(Pessoa::nome)
                .limit(3)
                .collect(Collectors.toSet());

        System.out.println(nomes);
    }
}
