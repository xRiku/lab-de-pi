package br.ufes.inf.jpalmeida.owid;

import java.util.Objects;

public class data implements Comparable<data> {
    public String entity;
    private String code;
    private Integer year;
    private Double male;
    private Double female;

    public data(String entity, String code, Integer year, Double male, Double female) {
        this.entity = entity;
        this.code = code;
        this.year = year;
        this.male = male;
        this.female = female;
    }

    @Override
    public int compareTo(data arg0) {
        // TODO Auto-generated method stub
        return -Double.compare(this.getMale() + this.getFemale(), arg0.getMale() + arg0.getFemale());
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Double getMale() {
        return male;
    }

    public void setMale(Double male) {
        this.male = male;
    }

    public Double getFemale() {
        return female;
    }

    public void setFemale(Double female) {
        this.female = female;
    }

    

    
}