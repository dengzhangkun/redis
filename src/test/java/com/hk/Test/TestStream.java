package com.hk.Test;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * -
 *
 * @ClassName: Test
 * @Description:
 * @Author: Edwin
 * @Date: 2019/10/10 7:19 AM
 * @Version: 1.0
 */

public class TestStream {

    @Test
    public void TestLambda(){
        Runnable run=()-> System.out.print("thread run.....[lambda]");

        run.run();
    }

    @Test
    public void TestStream(){
        List<String> list = Arrays.asList("a","b", "c");
        list.stream().forEach(System.out::println);

    }


    @Test
    public void test() {

        Runnable run=new Runnable() {
            @Override
            public void run() {
                System.out.println("thread run ......");
                System.out.println("thread run ......");
                System.out.println("thread run ......");
                System.out.println("thread run ......");
            }
        };


        run.run();

    }
}
