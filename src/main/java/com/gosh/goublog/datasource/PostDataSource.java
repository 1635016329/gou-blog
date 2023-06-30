package com.gosh.goublog.datasource;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.model.dto.post.PostQueryRequest;
import com.gosh.goublog.model.eneity.Post;
import com.gosh.goublog.model.vo.PostVO;
import com.gosh.goublog.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:44
 * @description 帖子数据源
 */
@Service
@Slf4j
public class PostDataSource implements DataSource<PostVO> {

    @Resource
    private PostService postService;

    @Override
    public Page<PostVO> doSearch(String searchText, long pageNum, long pageSize) {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setSearchText(searchText);
        postQueryRequest.setCurrent(pageNum);
        postQueryRequest.setPageSize(pageSize);
        // 通过查询数据库搜索
//        Page<Post> postPage = postService.page(new Page<>(pageNum, pageSize),
//                postService.getQueryWrapper(postQueryRequest));
//        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = servletRequestAttributes.getRequest();
//        return postService.getPostVOPage(postPage, request);

        // 通过查询ES搜索
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Page<Post> postPage = postService.searchFromEs(postQueryRequest);
        return postService.getPostVOPage(postPage, request);
    }
}
