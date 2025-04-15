import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        Dipendente dipendente = new Dipendente("Lorenzo", 27, 70000, Dipendente.Dipartimento.IT);
        Dipendente dipendente1 = new Dipendente("Marco", 31, 40000, Dipendente.Dipartimento.FINANCE);
        Dipendente dipendente2 = new Dipendente("Flavia", 50, 60000, Dipendente.Dipartimento.HR);
        Dipendente dipendente3 = new Dipendente("Francesco", 33, 50000, Dipendente.Dipartimento.HR);

        List<Dipendente> listaDipendenti = Arrays.asList(dipendente, dipendente1, dipendente2, dipendente3);
        //Uso di interfacce funzionali ed espressioni lambda
        List<Dipendente> dipendentiOverTrenta = listaDipendenti.stream().filter(d -> d.getEta() > 30).toList();
        System.out.println("Dipendeti over 30 : ");
        dipendentiOverTrenta.forEach(System.out::println);

        //Uso dei Method Reference e Constructor Reference
        System.out.println("Dipendeti ordinati per nome :");
        listaDipendenti.sort(Comparator.comparing(Dipendente::getNome));
        listaDipendenti.forEach(System.out::println);

        System.out.println("Lista dipendenti a partire da un elenco di nomi ");
        List<String> nomiDipendeti = Arrays.asList("Marco", "Alessio", "Beatrice", "Giovanni ");
        Function<String, Dipendente> creaLista = Dipendente::new;
        nomiDipendeti.stream().map(creaLista);
        nomiDipendeti.forEach(System.out::println);

        //Analisi con Stream API
        System.out.println("Analisi con Stream : ");
        Predicate<Dipendente> filtroStipendio = d -> d.getStipendio() > 50000;

        System.out.println("Stipendi piu alti di 50K ");
        Stream<Dipendente> stipendiAlti = listaDipendenti.stream().filter(filtroStipendio);
        stipendiAlti.forEach(System.out::println);

        System.out.println("Dipendenti in ordine di età : ");
        Stream<Dipendente> ordinePerEta = listaDipendenti.stream().sorted(Comparator.comparing(Dipendente::getEta));
        ordinePerEta.forEach(System.out::println);

        System.out.println("Media Stipendi Dipendenti");
        double mediaStipendiDipendenti = listaDipendenti.stream()
                .mapToDouble(Dipendente::getStipendio)
                .average().orElse(0.0);
        System.out.println(mediaStipendiDipendenti);

        System.out.println("Dipendeti raggruppati per dipartimento ");
        Map<Dipendente.Dipartimento, List<Dipendente>> dipendentiPerDipartimento = listaDipendenti.stream()
                .collect(Collectors.groupingBy(Dipendente::getDipartimento));
        System.out.println(dipendentiPerDipartimento);
    }
}
