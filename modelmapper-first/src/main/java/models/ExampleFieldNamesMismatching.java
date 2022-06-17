package models;

import java.util.List;

public class ExampleFieldNamesMismatching {
    private int thisIsANumber;
    private String thisIsAText;
    private boolean thisIsABoolean;
    private List<String> thisIsAListOfStrings;

    public ExampleFieldNamesMismatching() {
    }

    public void setThisIsANumber(int thisIsANumber) {
        this.thisIsANumber = thisIsANumber;
    }

    public void setThisIsAText(String thisIsAText) {
        this.thisIsAText = thisIsAText;
    }

    public void setThisIsABoolean(boolean thisIsABoolean) {
        this.thisIsABoolean = thisIsABoolean;
    }

    public void setThisIsAListOfStrings(List<String> thisIsAListOfStrings) {
        this.thisIsAListOfStrings = thisIsAListOfStrings;
    }
}
