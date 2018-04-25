package com.douban;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ruikai.lin  on 2018/3/2 下午3:16.
 * Email: ruikai.lin@plusx.cn
 * Copyright (c) 2014 承影互联(科技)有限公司 版权所有
 */
public class MyTest {
    @Test
    public void testThread(){
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(processors);
    }

    @Test
    public void testJDK(){

        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        System.out.println(
                names.stream()
                        .filter(name -> name.length() == 4)
                        .collect(Collectors.joining(",")));
    }
}
