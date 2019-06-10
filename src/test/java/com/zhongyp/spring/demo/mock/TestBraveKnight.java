package com.zhongyp.spring.demo.mock;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


public class TestBraveKnight {
    @Test
    public void kngihtTest(){
        Quest quest = mock(Quest.class);
        BraveKnight knight = new BraveKnight(quest);
        knight.embark();
        verify(quest, times(1)).test();
    }
}
