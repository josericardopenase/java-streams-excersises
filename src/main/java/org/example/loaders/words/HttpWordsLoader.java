package org.example.loaders.words;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HttpWordsLoader implements WordsLoader{
    private final String url;
    private final HttpClient httpClient;

    public HttpWordsLoader(String url){
        this.url = url;
        this.httpClient = HttpClient.newHttpClient();
    }
    @Override
    public List<String> load() {

        HttpRequest request = createHttpRequest(this.url);
        try {
            return load(request);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private List<String> load(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = this.httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return load(response);
    }

    private List<String> load(HttpResponse<String> response) {
        String[] wordsArray = response.body().split("\n");
        return load(wordsArray);
    }

    private List<String> load(String[] wordsArray) {
        return Arrays.stream(wordsArray).collect(Collectors.toList());
    }

    private HttpRequest createHttpRequest(String url) {
        return HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
    }
}
