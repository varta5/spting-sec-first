package models;

import java.util.List;

public class ExampleWithLimitedMatchingFields {
    private int aNumber;
    private String text;
    private List<String> listOfWords;

    public ExampleWithLimitedMatchingFields() {
    }

    public void setaNumber(int aNumber) {
        this.aNumber = aNumber;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setListOfWords(List<String> listOfWords) {
        this.listOfWords = listOfWords;
    }
}
