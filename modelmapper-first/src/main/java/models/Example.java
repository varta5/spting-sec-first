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

    public void setId(long id) {
        this.id = id;
    }

    public int getaNumber() {
        return aNumber;
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isAwesome() {
        return awesome;
    }

    public void setAwesome(boolean awesome) {
        this.awesome = awesome;
    }

    public List<String> getListOfWords() {
        return listOfWords;
    }

    public void setListOfWords(List<String> listOfWords) {
        this.listOfWords = listOfWords;
    }
}
