package com.gosh.goublog.esdao;

import com.gosh.goublog.model.dto.post.PostEsDTO;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 18:35
 * @description 帖子es搜索dao
 */
public interface PostEsDao extends ElasticsearchRepository<PostEsDTO, Long> {

    List<PostEsDTO> findByUserId(Long userId);

    List<PostEsDTO> findByTitle(String title);
}
