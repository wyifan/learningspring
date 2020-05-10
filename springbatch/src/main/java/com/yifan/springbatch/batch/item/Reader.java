package com.yifan.springbatch.batch.item;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class Reader implements ItemReader<String> {
    String[] items = {"wsf", "fan", "yifan", "idiot"};

    private int count = 0;

    @Override
    public String read()
            throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        if (count < items.length) {
            System.out.printf("Iterate the items in reader." + items[count]);
            return items[count++];
        }

        return null;
    }
}
