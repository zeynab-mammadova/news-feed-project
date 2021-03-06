package com.feed.news.entity.db;


import com.feed.news.crawler.Website;
import lombok.*;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Optional;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name="article")
public class Article {
    @Column(name="header")
    String header;

    @Column(name="content",columnDefinition="TEXT")
    String content;

    @Id
    @Column(name="article_link")
    String articleLink;

    @Column(name="image_link")
    String imageLink;

    @Column(name="article_date")
    LocalDate date;

    @Column(name="site")
    @Enumerated(EnumType.STRING)Website site;


}
