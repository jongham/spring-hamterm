package com.example.lastterms.controller;

import com.example.lastterms.dto.ChangeBoardDto;
import com.example.lastterms.dto.BoardDto;
import com.example.lastterms.dto.BoardResponseDto;
import com.example.lastterms.dto.SignUpResultDto;
import com.example.lastterms.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/Board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    @PostMapping("/insert")
    public ResponseEntity<BoardResponseDto> saveBoard(@RequestBody BoardDto boardDto) throws Exception {
        BoardResponseDto boardResponseDto = boardService.saveBoard(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @PutMapping("/change")
    public ResponseEntity<BoardResponseDto> changeBoardTitle(@RequestBody ChangeBoardDto changeBoardDto) throws Exception{
        BoardResponseDto boardResponseDto = boardService.changeBoardTitle(changeBoardDto.getId(), changeBoardDto.getTitle());
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteBoard(Long id) throws Exception{
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제되었습니다.");
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardResponseDto>> allBoard() {
        List<BoardResponseDto> boardResponseDto = boardService.boardList();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @GetMapping("/listOrderByCreatedAt")
    public ResponseEntity<List<BoardResponseDto>> OrderByCreatedAtBoard() {
        List<BoardResponseDto> boardResponseDto = boardService.OrderByCreatedAtBoard();
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @GetMapping("/byName")
    public ResponseEntity<List<BoardResponseDto>> selectBoardByName(String title) {
        List<BoardResponseDto> boardResponseDto = boardService.selectOrderByName(title);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @GetMapping("/")
    public ResponseEntity<BoardResponseDto> getBoard(Long id) {
        BoardResponseDto boardResponseDto = boardService.getBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

}