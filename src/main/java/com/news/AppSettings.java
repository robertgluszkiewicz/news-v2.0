package com.news;

public enum AppSettings {
    API_KEY("db2a29559fa04ecb92bce507099f6af9"),
    DELIMITER(" : "),
    FILE_NAME("articles.txt"),
    END_MESSAGE("Application finished");

    private final String setting;

    AppSettings(String setting) {
        this.setting = setting;
    }

    public String getSetting() {
        return setting;
    }
}
