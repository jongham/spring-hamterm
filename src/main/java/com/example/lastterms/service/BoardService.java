package com.example.lastterms.service;

import com.example.lastterms.dto.BoardDto;
import com.example.lastterms.dto.BoardResponseDto;

import java.util.List;

public interface BoardService {

    BoardResponseDto getBoard(Long id);
    BoardResponseDto saveBoard(BoardDto boardDto);

    BoardResponseDto changeBoardTitle(Long id, String title) throws Exception;

    void deleteBoard(Long id) throws Exception;

    List<BoardResponseDto> boardList();

    BoardResponseDto getBoardByTitle(String title);

    List<BoardResponseDto> selectOrderByName(String name);

    List<BoardResponseDto> OrderByCreatedAtBoard();
}