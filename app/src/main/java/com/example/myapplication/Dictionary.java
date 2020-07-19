package com.example.myapplication;

public class Dictionary {
    private String Word;
    private String Type;
    private String Phonectic;
    private String Meaning;

    public Dictionary(String word, String type, String phonectic, String meaning) {
        Word = word;
        Type = type;
        Phonectic = phonectic;
        Meaning = meaning;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getPhonectic() {
        return Phonectic;
    }

    public void setPhonectic(String phonectic) {
        Phonectic = phonectic;
    }

    public String getMeaning() {
        return Meaning;
    }

    public void setMeaning(String meaning) {
        Meaning = meaning;
    }
    @Override
    public String toString() {
        return "Dictionary{" +
                "Word='" + Word + '\'' +
                ", Type='" + Type + '\'' +
                ", Phonectic='" + Phonectic + '\'' +
                ", Meaning='" + Meaning + '\'' +
                '}';
    }
}
