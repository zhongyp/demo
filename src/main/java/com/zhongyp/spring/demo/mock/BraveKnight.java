package com.zhongyp.spring.demo.mock;

public class BraveKnight implements Knight {
    private Quest quest;
    public BraveKnight(Quest quest){
        this.quest = quest;
    }
    @Override
    public void embark() {
        quest.test();
    }
}
