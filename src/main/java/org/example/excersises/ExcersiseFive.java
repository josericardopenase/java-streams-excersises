package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ExcersiseFive implements Excersise {

    private final WordsLoader loader;
    private static String vowels = "aeiou";

    public ExcersiseFive(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> words = this.loader.load();
        var result = words.stream().map(ExcersiseFive::CountVowels).collect(Collectors.toList());
        System.out.println(result);
    }

    private static int CountVowels(String s) {
        return s.chars().reduce(0, (acc, curr) -> vowels.chars().anyMatch((x) -> x == curr) ? acc + 1 : acc);
    }

}
