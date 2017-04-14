package xyz.liinns.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.util.Date;

/**
 * document
 * String indexName();//索引库的名称，个人建议以项目的名称命名
 * String type() default "";//类型，个人建议以实体的名称命名
 * short shards() default 5;//默认分区数
 * short replicas() default 1;//每个分区默认的备份数
 * String refreshInterval() default "1s";//刷新间隔
 * String indexStoreType() default "fs";//索引文件存储类型
 *
 * field
 * FieldType type() default FieldType.Auto;#自动检测属性的类型
 * FieldIndex index() default FieldIndex.analyzed;#默认情况下分词
 * DateFormat format() default DateFormat.none;
 * String pattern() default "";
 * boolean store() default false;#默认情况下不存储原文
 * String searchAnalyzer() default "";#指定字段搜索时使用的分词器
 * String indexAnalyzer() default "";#指定字段建立索引时指定的分词器
 * String[] ignoreFields() default {};#如果某个字段需要被忽略
 * boolean includeInParent() default false;
 * Description:
 * Created by LiinNs on 2017-4-14 0014.
 */
@Data
@Document(indexName="article_index",type="article",shards=5,replicas=1,indexStoreType="fs",refreshInterval="-1")
public class Article {

    @Id
    private Long id;
    /**标题*/
    private String title;
    /**摘要*/
    private String abstracts;
    /**内容*/
    private String content;
    /**发表时间*/
    @Field(format= DateFormat.date_time,index= FieldIndex.no,store=true,type= FieldType.Object)
    private Date postTime;
    /**点击率*/
    private Long clickCount;
}
