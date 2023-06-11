package com.example.lastterms.dao.impl;

import com.example.lastterms.dao.BoardDAO;
import com.example.lastterms.repository.BoardRepository;
import com.example.lastterms.entity.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class BoardDAOImpl implements BoardDAO {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardDAOImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }


    @Override
    public Board insertBoard(Board board) {
        Board saveBoard = boardRepository.save(board);
        return saveBoard;
    }



    @Override
    public Board selectBoard(Long id) {
        Board selectBoard = boardRepository.getReferenceById(id);
        return selectBoard;
    }

    @Override
    public Board updateBoardTitle(Long id, String title) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        Board updateBoard;
        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            board.setTitle(title);
            board.setUpdatedAt(LocalDateTime.now());

            updateBoard = boardRepository.save(board);
        } else throw new Exception();
        return updateBoard;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        Optional<Board> selectedBoard = boardRepository.findById(id);

        if(selectedBoard.isPresent()) {
            Board board = selectedBoard.get();
            boardRepository.delete(board);
        } else throw new Exception();
    }

    @Override
    public Board selectBoardByTitle(String userId) {
        Board selectBoard = boardRepository.findByUserId(userId, Sort.by(Sort.Order.asc("userName")));
        return selectBoard;
    }

    @Override
    public List<Board> allBoard() {
        return boardRepository.findAll();
    }

    @Override
    public List<Board> allBoardById(Long id) {
        return null;
    }


    @Override
    public List<Board> OrderByCreatedAtBoard() {
        return boardRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public List<Board> selectOrderByName(String title) {
        return boardRepository.findAllByTitle(title);
    }
}