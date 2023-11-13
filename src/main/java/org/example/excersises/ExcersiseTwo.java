package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExcersiseTwo implements Excersise {

    private final WordsLoader loader;

    public ExcersiseTwo(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> words = this.loader.load();
        List<String> result = words.stream()
                .filter(startsWithLetter('n'))
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private Predicate<? super String> startsWithLetter(char a) {
        return (x) -> x.toLowerCase().charAt(0) == a;
    }
}
