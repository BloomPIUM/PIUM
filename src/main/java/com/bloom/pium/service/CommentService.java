package com.bloom.pium.service;

import com.bloom.pium.data.dto.CommentDto;
import com.bloom.pium.data.dto.CommentResponseDto;


public interface CommentService {

    CommentResponseDto saveComment(CommentDto commentDto);
}
