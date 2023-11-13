package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ExcersiseOne implements Excersise {

    private final WordsLoader loader;

    public ExcersiseOne(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> words = this.loader.load();
        List<String> result = words.stream()
                .filter(wordGreaterThanChar('a'))
                .filter(wordLessThanChar('c'))
                .collect(Collectors.toList());
        System.out.println(result);
    }


    private Predicate<? super String> wordGreaterThanChar(char character) {
        return (x) -> x.toLowerCase().charAt(0) > character;
    }

    private Predicate<? super String> wordLessThanChar(char character) {
        return (x) -> x.toLowerCase().charAt(0) < character;
    }
}
