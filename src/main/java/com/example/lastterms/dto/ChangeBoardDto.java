package com.example.lastterms.dto;

public class ChangeBoardDto {



    private Long id;
    private String title;

    public ChangeBoardDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public ChangeBoardDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}