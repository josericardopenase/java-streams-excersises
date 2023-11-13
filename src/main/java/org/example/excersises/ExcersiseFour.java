package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.groupingBy;

public class ExcersiseFour implements Excersise {

    private final WordsLoader loader;

    public ExcersiseFour(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> words = this.loader.load();
        var result = words.stream()
                .filter(this::isPalindrome)
                .collect(Collectors.toList());
        System.out.println(result);
    }

    private boolean isPalindrome(String x) {
        return IntStream.range(0, x.length() / 2).noneMatch((i) -> x.charAt(i) != x.charAt(x.length() - i));
    }
}
