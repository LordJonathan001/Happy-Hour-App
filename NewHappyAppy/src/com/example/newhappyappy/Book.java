package com.example.newhappyappy;

import com.orm.dsl.Table;

@Table
public class Book {
  private Long id;
private String title;
private String edition;


  public Book(){
	  
  }

  public Book(String title, String edition){
     this.title = title;
     this.edition = edition;
     
  }

  public Long getId() {
      return id;
  }
  
 
}