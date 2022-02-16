package com.news;

import com.kwabenaberko.newsapilib.NewsApiClient;

import static com.news.AppSettings.API_KEY;
import static com.news.AppSettings.FILE_NAME;

public class Application {
    public static void main(String[] args) {
        NewsApiClient newsApiClient = new NewsApiClient(API_KEY.getSetting());
        DataProcessor.sendRequest(newsApiClient, FILE_NAME.getSetting());
    }
}
