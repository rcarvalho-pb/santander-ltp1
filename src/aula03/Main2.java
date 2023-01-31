package aula03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main2 {

    public static void main(String[] args) {

        Ave aguia = new Ave("aguia", true, false);
        Ave pinguim = new Ave("pinguim", false, true);
        Ave gaivota = new Ave("gaivota", true, true);
        Ave pardal = new Ave("pardal", true, false);
        Ave coruja = new Ave("coruja", true, false);

        var aves = new ArrayList<>(List.of(aguia, pinguim, gaivota, pardal, coruja));

        Collections.sort(aves, (obj1, obj2) -> (obj1.getNome().compareToIgnoreCase(obj2.getNome())));

        aves.forEach((ave) -> System.out.println(ave.getNome()));

    }

}