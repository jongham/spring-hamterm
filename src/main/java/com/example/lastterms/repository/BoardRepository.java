package com.example.lastterms.repository;

import com.example.lastterms.entity.Board;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findAllByOrderByCreatedAtDesc();



    Board findByUserId(String userId, Sort sort);

    List<Board> findAllByTitle(String title);
}
