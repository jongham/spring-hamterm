package com.example.lastterms.dao;

import com.example.lastterms.entity.Board;
import com.example.lastterms.entity.Product;

import java.util.List;

public interface BoardDAO {

    Board insertBoard(Board board);

    Board selectBoard(Long id);

    Board updateBoardTitle(Long id, String title) throws Exception;

    void deleteBoard(Long id) throws Exception;

    Board selectBoardByTitle(String title);

    List<Board> allBoard();

    List<Board> allBoardById(Long id);

    List<Board> OrderByCreatedAtBoard();

    List<Board> selectOrderByName(String name);
}