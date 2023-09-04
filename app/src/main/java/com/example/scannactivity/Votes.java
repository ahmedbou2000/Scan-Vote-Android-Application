package com.example.scannactivity;

public class Votes {

    private Integer count;
    private String ref;
    private String choix;
    private String description;

    public Votes() {
    }

    public Votes(String ref, String choix, String description,Integer count) {
        this.ref = ref;
        this.choix = choix;
        this.description = description;
        this.count = count;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ref: "+ref +" a '"+count+"' choix "+choix ;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
