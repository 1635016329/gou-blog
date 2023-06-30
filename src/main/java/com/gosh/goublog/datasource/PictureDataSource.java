package com.gosh.goublog.datasource;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.common.ErrorCode;
import com.gosh.goublog.exception.BusinessException;
import com.gosh.goublog.model.eneity.Picture;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/23 16:43
 * @description 图片数据源
 */
@Service
public class PictureDataSource implements DataSource<Picture> {
    @Override
    public Page<Picture> doSearch(String searchText, long pageNum, long pageSize) {
        String url = "https://cn.bing.com/images/search?q=" + searchText + "&qs=n&form=QBIR&sp=-1&lq=0&pq=xiao%27hei%27zi&sc=10-11&cvid=D5E8092F67824A65A11B991B03C77103&ghsh=0&ghacc=0&first=1&cw=1177&ch=759";
        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据获取异常");
        }
        Elements elements = doc.select(".iuscp.isv");
        List<Picture> pictures = new ArrayList<>();
        for (Element element : elements) {
            Elements imgpts = element.select(".imgpt");
            Elements iusc = imgpts.select(".iusc");
            String m = iusc.attr("m");
            HashMap<String, Object> map = new HashMap<>();
            map = JSONUtil.toBean(m, map.getClass());
            String murl = (String) map.get("murl");
            String title = element.select(".inflnk").attr("aria-label");
            Picture picture = new Picture();
            picture.setTitle(title);
            picture.setUrl(murl);
            pictures.add(picture);
            if (pictures.size() >= pageSize) {
                break;
            }
        }
        Page<Picture> picturePage = new Page<>(pageNum, pageSize);
        picturePage.setRecords(pictures);
        return picturePage;
    }

}
