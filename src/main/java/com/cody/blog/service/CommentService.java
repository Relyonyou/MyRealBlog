package com.cody.blog.service;

import com.cody.blog.entity.Comment;

import java.util.List;

/**
 * @author Cody
 * @date 2020/11/21 - 9:32
 */
public interface CommentService {
    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);
}
