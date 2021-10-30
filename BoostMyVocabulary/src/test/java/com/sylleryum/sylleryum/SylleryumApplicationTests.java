package com.sylleryum.sylleryum;

import com.sylleryum.sylleryum.config.ResponseTokenBuilder;
import com.sylleryum.sylleryum.service.ApiUserService;
import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import java.util.ArrayList;

@SpringBootTest
class SylleryumApplicationTests {

    @Test
    void contextLoads() {
        List<Integer> l = new ArrayList<>(List.of(1, 2, 3, 4, 5));

        merge(l);
    }

    ArrayList<Integer> merge(List<Integer> list) {
        System.out.println();
        boolean go = true;
        List<List<Integer>> newList = new ArrayList<>(List.of(list, list));

            for (int i=0;i<newList.size();i++){
                newList.add(list);
                System.out.println();
            }
            //newList.add(list);

//            if (newList.)
//            List<Integer> firstHalf = i.subList(0, i.size() / 2);
//            List<Integer> secondHalf = i.subList(i.size() / 2, i.size());
//            System.out.println();

        return null;
    }

}
