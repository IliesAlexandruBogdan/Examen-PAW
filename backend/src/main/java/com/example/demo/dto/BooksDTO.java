package com.example.demo.dto;

public class BooksDTO {
    public Long id;
    public String titlu;
    public Long keys;
    public String autor;
    public Long an;

    public BooksDTO(){

    }
    public BooksDTO(Long id, String titlu, Long keys, String autor, Long an){
        this.id=id;
        this.titlu=titlu;
        this.keys = keys;
        this.autor = autor;
        this.an = an;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitlu() {
        return titlu;
    }

    public void setTitlu(String titlu) {
        this.titlu = titlu;
    }

    public Long getKeys() {
        return keys;
    }

    public void setKeys(Long keys) {
        this.keys = keys;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Long getAn() {
        return an;
    }

    public void setAn(Long an) {
        this.an = an;
    }
}
