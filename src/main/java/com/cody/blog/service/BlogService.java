package com.cody.blog.service;

import com.cody.blog.entity.Blog;
import com.cody.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @author Cody
 * @date 2020/11/16 - 21:25
 */
public interface BlogService {
    Blog getBlog(Long id);

    Blog getAndConvert(Long id);

    Page<Blog> listBlogs(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlogByTag(Long tagId , Pageable pageable);

    Page<Blog> listBlogByQuery(String query, Pageable pageable);

    List<Blog> listRecommendBlog(Integer size);

    Map<String, List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    void deleteBlog(Long id);
}
