package com.example.bookshop.data;

public class Book {

    private Integer id;
    private String author_id;
    private String title;
    private Integer price_old;
    private Integer price;

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author_id='" + author_id + '\'' +
                ", title='" + title + '\'' +
                ", price_old=" + price_old +
                ", price=" + price +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(String author_id) {
        this.author_id = author_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice_old() {
        return price_old;
    }

    public void setPrice_old(Integer price_old) {
        this.price_old = price_old;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
