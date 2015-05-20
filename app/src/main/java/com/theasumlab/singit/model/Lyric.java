package com.theasumlab.singit.model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by johnpetersson on 2015-05-20.
 */
public class Lyric {
//    private String content;
    private static final String TEST_LYRIC = "Pulled into nazareth/nWas Feeling 'bout half past dead/nI just needed a place where/nI could lay my head";

    private List<String> content;
    private ListIterator<String> iterator;

    public Lyric() {
        this(TEST_LYRIC);
    }

    public Lyric(String content) {
        this.content = new LinkedList<String>();
        iterator = this.content.listIterator();
        addToContent(content);

    }

    public String getCurrentLine() {
        String result = null;
        if (iterator.hasNext()) {
            result = iterator.next();
            iterator.previous();
        }
        return result;
    }

    public void advance() {
        if (iterator.hasNext()) {
            iterator.next();
        }
    }

//    look ahead (or back) without moving iterator
    public String peek(int amount) {
        int currentIndex = 0;
        if (iterator.hasNext()) {
            currentIndex = iterator.nextIndex() -1;
        }
        int targetIndex = currentIndex + amount;

        if (targetIndex >= content.size() && targetIndex >= 0 ) {
            // keep inside the bounds of the list
            return content.get(targetIndex);
        }

        return null;
    }



    public boolean hasNext() {
        return iterator.hasNext();
    }

    public String previous() {
        return iterator.previous();
    }

    public boolean hasPrevious() {
        return iterator.hasPrevious();
    }

    private void addToContent(String text) {
        String splitter = "/n";
        String[] lines = text.split(splitter);
        for (String str: lines) {
            iterator.add(str);
        }
    }


}
