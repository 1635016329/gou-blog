package com.gosh.goublog.service;

import com.gosh.goublog.model.eneity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/21 23:07
 * @description 帖子服务测试类
 */
@SpringBootTest
public class PostServiceTest {

    @Resource
    private PostService postService;

    @Test
    public void addPostTest() {
        for (int i = 0; i <100 ; i++) {
            Post post = new Post();
            post.setTitle("人文之美：探索世界的多样性与智慧" + (i + 1));
            post.setContent("人文是世界上最美妙的一种存在，它代表着人类创造的智慧和文化的多样性。在不同的地方，我们可以发现各种各样丰富多彩的人文景观。例如，古老的建筑如巴黎的埃菲尔铁塔、印度的泰姬陵等，它们不仅仅是建筑的壮丽，更是彰显着不同文化背景下的历史和价值观念。艺术也是人文中不可或缺的一部分，它通过绘画、音乐、舞蹈等形式表达人类情感和思想。文学作品如莎士比亚的戏剧、杜甫的诗歌等，承载着深厚的文化内涵，感动着人们的心灵。人文之美还体现在风俗习惯、传统节日等独特的文化活动中，如中国的春节、西班牙的斗牛节等，它们展示了人类的智慧和传统的延续。探索人文的奇妙之旅，让我们了解不同地区和民族的文化特色，促进不同文化间的交流与理解。人文之美是世界的瑰宝，让我们一同探索，共同品味这美丽而多元的人类智慧。");
            post.setTags("[\"人文探索\",\"文化多样性\"]");
            post.setUserId(3L);
            boolean save = postService.save(post);
            Assertions.assertTrue(save);
        }

    }
}
