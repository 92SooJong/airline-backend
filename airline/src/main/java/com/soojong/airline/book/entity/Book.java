package com.soojong.airline.book.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("B")
public class Book extends Item{

    private String author;
    private String isbn;
}
