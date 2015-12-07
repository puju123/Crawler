package com.kingfong.webcrawler.parse;

public interface Parser<T> {
    public T parse(String html);
}
