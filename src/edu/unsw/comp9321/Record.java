package edu.unsw.comp9321;

import java.io.Serializable;
import java.util.*;


public class Record implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private ArrayList<String> Authors;
	private String Title;
	private String publisher;
	private String year;
	private String pages;
	private String isbn;
	private String ee;
	private String journal;
	private String url;
	private String number;
	private String searchKey;
	
	public Record(String title,String publisher,String year,String pages,String isbn,String ee,String type,ArrayList<String> author,
			String journal,String number,String url){
		this.Title = title;
		this.publisher = publisher;
		this.year = year;
		this.pages = pages;
		this.isbn = isbn;
		this.ee = ee;
		this.type =type; 
		this.Authors = author;
		this.journal = journal;
		this.number = number;
		this.url = url;
		this.searchKey = title + journal + publisher + String.join("", Authors);
	}
	
	public String getsearchKey(){
		return this.searchKey;
	}
	public String url(){
		return this.url;
	}
	public String getNumber(){
		return this.number;
	}
	public String getJournal(){
		return this.journal;
	}
	public void addAuthors(String s){
		this.Authors.add(s);
	}
	public ArrayList<String> getAuthors() {
		return Authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		Authors = authors;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getPages() {
		return pages;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getEe() {
		return ee;
	}

	public void setEe(String ee) {
		this.ee = ee;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
