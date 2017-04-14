package xyz.liinns.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import xyz.liinns.entity.Article;

/**
 * Description:
 * Created by LiinNs on 2017-4-14 0014.
 */
public interface ArticleRepo extends ElasticsearchRepository<Article, Long> {
}
