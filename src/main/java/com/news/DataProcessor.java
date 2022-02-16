package com.news;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;

import java.util.ArrayList;
import java.util.List;

import static com.news.AppSettings.DELIMITER;
import static com.news.AppSettings.END_MESSAGE;
import static com.news.FileWriter.writeFile;

public class DataProcessor {
    public static void sendRequest(NewsApiClient newsApiClient, String fileName) {
        newsApiClient.getTopHeadlines(
                new TopHeadlinesRequest.Builder()
                        .country("pl")
                        .category("business")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback() {
                    @Override
                    public void onSuccess(ArticleResponse response) {
                        writeFile(getArticles(response), fileName);
                    }

                    @Override
                    public void onFailure(Throwable throwable) {
                        System.out.println(throwable.getMessage());
                    }
                }
        );
    }

    public static String getArticleData(Article article) {
        return article.getTitle() + DELIMITER.getSetting() + article.getDescription() + DELIMITER.getSetting() + article.getAuthor();
    }

    public static List<String> getArticles(ArticleResponse response) {
        List<String> articles = new ArrayList<>();
        for (Article article : response.getArticles()) {
            articles.add(getArticleData(article));
        }
        return articles;
    }

    public static void endApplication() {
        System.out.println(END_MESSAGE.getSetting());
        System.exit(0);
    }
}
