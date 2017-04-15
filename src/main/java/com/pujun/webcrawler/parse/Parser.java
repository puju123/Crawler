package com.pujun.webcrawler.parse;

public interface Parser<T> {
    public T parse(String html);
}
