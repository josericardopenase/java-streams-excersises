package org.example.loaders;

import java.util.List;

public interface Loader<T> {
    List<T> load();
}
