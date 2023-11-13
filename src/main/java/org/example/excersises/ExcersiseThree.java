package org.example.excersises;

import org.example.loaders.words.WordsLoader;

import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.groupingBy;

public class ExcersiseThree implements Excersise {

    private final WordsLoader loader;

    public ExcersiseThree(WordsLoader loader){
        this.loader = loader;
    }


    @Override
    public void execute() throws IOException, InterruptedException {
        List<String> words = this.loader.load();
        var result = words.stream()
                .collect(groupingBy(x -> x.substring(0, 3)));
        System.out.println(result);
    }
}
