package com.example.lastterms.dao.impl;

import com.example.lastterms.dao.BoardDAO;
import com.example.lastterms.dto.*;
import com.example.lastterms.entity.Board;
import com.example.lastterms.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardDAO boardDAO;

    @Autowired
    public BoardServiceImpl(BoardDAO boardDAO) {
        this.boardDAO = boardDAO;
    }

    @Override
    public BoardResponseDto getBoard(Long id) {
        Board board = boardDAO.selectBoard(id);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setId(board.getId());
        boardResponseDto.setUserId(board.getUserId());
        boardResponseDto.setUserName(board.getUserName());
        boardResponseDto.setTitle(board.getTitle());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto saveBoard(BoardDto boardDto) {
        Board board = new Board();
        board.setContents(board.getContents());
        board.setId(board.getId());
        board.setTitle(board.getTitle());
        board.setUserId(board.getUserId());
        board.setUserName(board.getUserName());
        board.setCreatedAt(board.getCreatedAt());
        board.setUpdatedAt(board.getUpdatedAt());

        Board saveBoard = boardDAO.insertBoard(board);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(saveBoard.getTitle());
        boardResponseDto.setId(saveBoard.getId());
        boardResponseDto.setContents(saveBoard.getContents());
        boardResponseDto.setUserId(saveBoard.getUserId());
        boardResponseDto.setUserName(saveBoard.getUserName());

        return boardResponseDto;
    }

    @Override
    public BoardResponseDto changeBoardTitle(Long id, String title) throws Exception {
        Board changeBoard = boardDAO.updateBoardTitle(id, title);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setId(changeBoard.getId());
        boardResponseDto.setTitle(changeBoard.getTitle());
        boardResponseDto.setUserName(changeBoard.getUserName());
        boardResponseDto.setContents(changeBoard.getContents());
        boardResponseDto.setUserId(changeBoard.getUserId());
        return boardResponseDto;
    }

    @Override
    public void deleteBoard(Long id) throws Exception {
        boardDAO.deleteBoard(id);
    }

    @Override
    public List<BoardResponseDto> boardList() {

        List<Board> allList = boardDAO.allBoard();
        List<BoardResponseDto> result = allList.stream().map(BoardResponseDto::new).collect(Collectors.toList());

        return result;
    }

    @Override
    public BoardResponseDto getBoardByTitle(String title) {
        Board board = boardDAO.selectBoardByTitle(title);

        BoardResponseDto boardResponseDto = new BoardResponseDto();
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setId(board.getId());
        boardResponseDto.setContents(board.getContents());
        boardResponseDto.setUserId(board.getUserId());
        boardResponseDto.setUserName(board.getUserName());

        return boardResponseDto;
    }

    @Override
    public List<BoardResponseDto> selectOrderByName(String title) {

        List<Board> allList = boardDAO.selectOrderByName(title);
        List<BoardResponseDto> result = allList.stream().map(BoardResponseDto::new).collect(Collectors.toList());

        return result;
    }

    @Override
    public List<BoardResponseDto> OrderByCreatedAtBoard() {

        List<Board> allList = boardDAO.OrderByCreatedAtBoard();
        List<BoardResponseDto> result = allList.stream().map(BoardResponseDto::new).collect(Collectors.toList());

        return result;
    }
}