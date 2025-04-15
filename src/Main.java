import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Dipendente> listaDipendenti = new ArrayList<>();
        listaDipendenti.add(new Dipendente("Lorenzo", 27, 70000, Dipendente.Dipartimento.IT));
        listaDipendenti.add(new Dipendente("Marco", 31, 40000, Dipendente.Dipartimento.FINANCE));
        listaDipendenti.add(new Dipendente("Flavia", 50, 60000, Dipendente.Dipartimento.HR));
        listaDipendenti.add(new Dipendente("Alessio", 33, 50000, Dipendente.Dipartimento.HR));

        //Uso di interfacce funzionali ed espressioni lambda
        System.out.println("Dipendenti che hanno più di 30 anni : ");
        FiltroDipendente<Dipendente> filtroEta = dipendente -> dipendente.getEta() > 30;
        List<Dipendente> ordinaPerEta = listaDipendenti.stream().filter(filtroEta::filtraDipendente).toList();
        ordinaPerEta.forEach(System.out::println);

        //Uso dei Method Reference e Constructor Reference
        System.out.println("Dipendenti ordinati per nome :");
        listaDipendenti.stream().sorted(Comparator.comparing(Dipendente::getNome)).forEach(System.out::println);

        System.out.println("Lista dipendenti a partire da un elenco di nomi ");
        List<String> nomiDipendeti = Arrays.asList("Marco", "Alessio", "Beatrice", "Giovanni ");
        nomiDipendeti.stream().map(Dipendente::new).toList().forEach(System.out::println);

        //Analisi con Stream API
        System.out.println("Analisi con Stream : ");
        FiltroDipendente<Dipendente> filtroStipendio = d -> d.getStipendio() > 50000;

        System.out.println("Stipendi piu alti di 50K ");
        listaDipendenti.stream().filter(filtroStipendio::filtraDipendente).forEach(System.out::println);

        System.out.println("Dipendenti in ordine di età : ");
        listaDipendenti.stream().sorted(Comparator.comparing(Dipendente::getEta)).forEach(System.out::println);

        System.out.println("Media Stipendi Dipendenti");
        double mediaStipendiDipendenti = listaDipendenti.stream()
                .mapToDouble(Dipendente::getStipendio)
                .average().orElse(0.0);
        System.out.println(mediaStipendiDipendenti);

        //Dipendenti raggruppati per dipartimento
        Map<Dipendente.Dipartimento, List<Dipendente>> dipendentiPerDipartimento = listaDipendenti.stream()
                .collect(Collectors.groupingBy(Dipendente::getDipartimento));
        System.out.println("Dipendenti raggruppati per Dipartimento:");
        dipendentiPerDipartimento.forEach((dipartimento, dipendenti) -> {
            System.out.println(dipartimento);
            dipendenti.forEach(dipendente -> System.out.println("  - " + dipendente));
        });
    }
}
