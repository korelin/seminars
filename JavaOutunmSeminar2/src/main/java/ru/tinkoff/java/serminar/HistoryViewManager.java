package ru.tinkoff.java.serminar;

import java.util.List;

public interface HistoryViewManager<T> {

    void addView(T uuid);

    List<T> getViewHistory();

}
