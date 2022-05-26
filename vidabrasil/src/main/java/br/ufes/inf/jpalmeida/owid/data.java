package br.ufes.inf.jpalmeida.owid;

public class data {
    String entity;
    String code;
    Integer year;
    String male;
    String female;

    public data(String entity, String code, Integer year, String male, String female) {
        this.entity = entity;
        this.code = code;
        this.year = year;
        this.male = male;
        this.female = female;
    }

    
}