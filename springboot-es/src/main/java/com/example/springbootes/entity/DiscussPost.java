package com.example.springbootes.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/6 11:30
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@ToString
@Document(indexName = "discusspost",shards = 5,replicas = 1)
public class DiscussPost {
    /**
     * 主键id
     */
    @Id
    private int id;
    /**
     * 用户主键id
     */
    @Field(type = FieldType.Long)
    private int userId;
    /**
     * 帖子标题
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String title;
    /**
     * 帖子内容
     */
    @Field(type = FieldType.Text,analyzer = "ik_max_word",searchAnalyzer = "ik_smart")
    private String content;
    /**
     * 帖子类型
     * 0-普通; 1-置顶;
     */
    @Field(type = FieldType.Integer)
    private int type;
    /**
     * 帖子状态
     * 0-正常; 1-精华; 2-拉黑;
     */
    @Field(type = FieldType.Integer)
    private int status;
    /**
     * 帖子创建日期
     */
    @Field(type = FieldType.Date, format = DateFormat.custom,pattern = "yyyy-MM-dd")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern ="yyyy-MM-dd",timezone="GMT+8")
    private Date createTime;
    /**
     * 帖子评论数量
     */
    @Field(type = FieldType.Integer)
    private int commentCount;
    /**
     * 帖子得分
     */
    @Field(type = FieldType.Float)
    private double score;
}
