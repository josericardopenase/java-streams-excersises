package org.example.loaders.words;

import org.example.loaders.Loader;

import java.io.IOException;
import java.util.List;

public interface WordsLoader extends Loader<String> {
    List<String> load();
}
