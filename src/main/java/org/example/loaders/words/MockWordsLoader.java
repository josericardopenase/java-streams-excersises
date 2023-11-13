package org.example.loaders.words;

import java.util.ArrayList;
import java.util.List;

public class MockWordsLoader implements WordsLoader{

    @Override
    public List<String> load() {
        List<String> words = new ArrayList<>();
        words.add("hola");
        words.add("adiooos");
        words.add("pepe");
        return words;
    }
}
