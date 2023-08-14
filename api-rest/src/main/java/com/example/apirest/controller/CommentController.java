package com.example.apirest.controller;

import com.example.apirest.dto.CommentRequestDTO;
import com.example.apirest.dto.CommentResponseDTO;
import org.example.entity.Comment;
import org.example.port.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    private final ModelMapper modelMapper;

    public CommentController(CommentService commentService, ModelMapper modelMapper) {
        this.commentService = commentService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public ResponseEntity<CommentResponseDTO> post(@RequestBody CommentRequestDTO commentRequestDTO) {
        return ResponseEntity.ok(
                modelMapper.map(
                        commentService.createComment(
                                commentRequestDTO.getTitle(),
                                commentRequestDTO.getDate(),
                                commentRequestDTO.getCommentContent(),
                                commentRequestDTO.getCommentType()),
                                CommentResponseDTO.class)
        );
    }

    @GetMapping("")
    public ResponseEntity<CommentResponseDTO> get() {
        return ResponseEntity.ok(modelMapper.map(commentService.getAllComments(), CommentResponseDTO.class));
    }

    @GetMapping("/{idPlant}")
    public ResponseEntity<CommentResponseDTO> getById(@PathVariable int idPlant) {
        return ResponseEntity.ok(modelMapper.map(commentService.getCommentByIdPlant(idPlant), CommentResponseDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDTO> put(@PathVariable int id, @RequestBody CommentRequestDTO commentRequestDTO) {
        Comment comment  = commentService.getCommentById(id);
        comment.setTitle(commentRequestDTO.getTitle());
        comment.setDate(commentRequestDTO.getDate());
        comment.setCommentContent(commentRequestDTO.getCommentContent());
        comment.setCommentType(commentRequestDTO.getCommentType());
        return ResponseEntity.ok(modelMapper.map(commentService.updateComment(id, comment), CommentResponseDTO.class));

    }


}
