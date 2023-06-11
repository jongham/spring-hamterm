package com.example.lastterms.dto;

import com.example.lastterms.entity.Board;
import com.example.lastterms.entity.Product;

public class BoardResponseDto {

    public BoardResponseDto(Board board) {
    }

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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    private Long id;
    private String title;
    private String contents;
    private String userName;
    private String userId;
    public BoardResponseDto(){}

    public BoardResponseDto(Long id, String title, String contents, String userName, String userId) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.userName = userName;
        this.userId = userId;
    }

    public static BoardResponseDtoBuilder builder() {
        return new BoardResponseDtoBuilder();
    }

    public static class BoardResponseDtoBuilder{
        private Long id;
        private String title;
        private String contents;
        private String userName;
        private String userId;

        public BoardResponseDtoBuilder id(Long id) {
            this.id = id;
            return this;
        }
        public BoardResponseDtoBuilder contents(String contents) {
            this.contents = contents;
            return this;
        }

        public BoardResponseDtoBuilder title(String title) {
            this.title = title;
            return this;
        }

        public BoardResponseDtoBuilder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public BoardResponseDtoBuilder userName(String userName) {
            this.userName = userName;
            return this;
        }

        public BoardResponseDto build() {
            return new BoardResponseDto(id, title, contents, userId, userName);
        }
    }
}