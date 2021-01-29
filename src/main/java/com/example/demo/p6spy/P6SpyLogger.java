package com.example.demo.p6spy;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P6SpyLogger implements MessageFormattingStrategy {
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");


    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        if("".equals(sql.trim())) {
            return "";
        }
        sql = sql.replaceAll("\r|\n|\\s+", " ");
        return this.format.format(new Date()) + "  took " + elapsed + "ms | " + category + " | connection " + connectionId + " | " + sql + ";";
    }

}
