package models;

import java.util.List;

public class Example {
    private long id;
    private int aNumber;
    private String text;
    private boolean awesome;
    private List<String> listOfWords;

    public Example() {
    }

    public Example(long id, int aNumber, String text, boolean awesome, List<String> listOfWords) {
        this.id = id;
        this.aNumber = aNumber;
        this.text = text;
        this.awesome = awesome;
        this.listOfWords = listOfWords;
    }

    public long getId() {
        return id;
    }

    public int getaNumber() {
        return aNumber;
    }

    public String getText() {
        return text;
    }

    public boolean isAwesome() {
        return awesome;
    }

    public List<String> getListOfWords() {
        return listOfWords;
    }
}
