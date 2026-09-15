package com.example.domain;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;

    public Category(){
    }

    public Category(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public List<Book> getBooks() {
		return books;
	}

	public void setbooks(List<Book> books) {
		this.books = books;
	}
}
