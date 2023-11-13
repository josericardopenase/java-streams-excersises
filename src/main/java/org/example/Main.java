package org.example;

import org.example.excersises.Excersise;
import org.example.excersises.ExcersiseFive;
import org.example.loaders.words.HttpWordsLoader;
import org.example.loaders.words.MockWordsLoader;
import org.example.loaders.words.WordsLoader;
import java.io.IOException;


public class Main {

    public static String url = "https://raw.githubusercontent.com/JorgeDuenasLerin/diccionario-espanol-txt/master/0_palabras_todas.txt";

    public static void main(String[] args) throws IOException, InterruptedException {
        WordsLoader loader = new MockWordsLoader();
        Excersise excersise = new ExcersiseFive(loader);
        excersise.execute();
    }
}