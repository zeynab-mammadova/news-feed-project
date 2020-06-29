package com.feed.news.crawler.parsers;

import com.feed.news.crawler.Article;
import com.feed.news.crawler.JsoupParser;
import com.feed.news.crawler.Website;
import lombok.SneakyThrows;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class TechCrunchParser implements JsoupParser {

    static List<Article> articles = new ArrayList();

    @SneakyThrows
    @Override
    public List<Article> getArticles() {
        Document document = Jsoup.connect("https://techcrunch.com/").get();
        Elements elements = document.getElementsByClass("post-block");
        for (Element element : elements) {
            String header = element.select(".post-block__title__link").text();
            String content = element.select(".post-block__content").text();
            String link = element.select(".post-block__title").first().select("a").first().attr("href");
            String image = element.select(".post-block__media").first().select("img").first().attr("src");
            String date = element.select("[datetime]").text();

            articles.add(new Article(header, content, link, image, date, Website.TechCrunch));



        }
        return articles;
    }
}