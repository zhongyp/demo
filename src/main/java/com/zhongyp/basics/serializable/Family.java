package com.zhongyp.basics.serializable;

import java.io.Serializable;

/**
 * @author zhongyp.
 * @date 2019/5/22
 */
public class Family implements Serializable {
    private String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
