package com.pluralsight;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    // Constructor
    Book (int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters/Setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }
    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // methods
    public void checkOut(String fullName) {
        this.isCheckedOut = true;
        this.checkedOutTo = fullName;
    }
    public void checkIn() {
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    public String display() {
        return String.format("\tBook ID: %d" +
                "\n\tBook ISBN: %s" +
                "\n\tTitle: %s",
                id,
                isbn,
                title
        );
    }
}
