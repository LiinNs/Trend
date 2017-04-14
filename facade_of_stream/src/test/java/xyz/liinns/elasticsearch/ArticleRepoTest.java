package xyz.liinns.elasticsearch;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Description:
 * Created by LiinNs on 2017-4-14 0014.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ArticleRepoTest {

    /*@Autowired
    private ArticleRepo articleRepo;

    @Test
    public void testSaveArticleIndex(){
        Article article =new Article();
        article.setId(1L);
        article.setTitle("springboot integrate elasticsearch");
        article.setAbstracts("springboot integrate elasticsearch is very easy");
        article.setContent("elasticsearch based on lucene,"
                + "spring-data-elastichsearch based on elaticsearch"
                + ",this tutorial tell you how to integrate springboot with spring-data-elasticsearch");
        article.setPostTime(new Date());
        article.setClickCount(1L);
        articleRepo.save(article);
    }

    @Test
    public void testSearch(){
        String queryString="springboot";//搜索关键字
        QueryStringQueryBuilder builder=new QueryStringQueryBuilder(queryString);
        Iterable<Article> searchResult = articleRepo.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }*/

}