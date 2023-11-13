package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public class LectureExcersise implements Excersise{

    private final WordsLoader loader;

    public LectureExcersise(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> data = this.loader.load();

        System.out.println(data.stream()
                .filter(wordIsGreaterThan(4))
                .filter(wordIsLessThan(10))
                .collect(groupingBy(w-> w.substring(0, 2))));

        System.out.println(data.stream()
                .filter(hasNumberOfSyllabels(3))
                .filter(endsWithSyllabel("ton"))
                .collect(Collectors.toList()));
    }

    private Predicate<? super String> endsWithSyllabel(String syllabel) {
        return (x) -> x.endsWith(syllabel);
    }

    private Predicate<? super String> hasNumberOfSyllabels(int syllabels) {
        return (x) -> true;
    }

    //Currying
    private Predicate<? super String> wordIsLessThan(int i) {
        return (x) -> x.length() < i;
    }

    //Currying
    private Predicate<? super String> wordIsGreaterThan(int i) {
        return (x) -> x.length() > i;
    }
}
