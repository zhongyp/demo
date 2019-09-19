package com.zhongyp.advanced.pattern.visitor;

/**
 * @author zhongyp.
 * @date 2019/9/18
 */
public interface Visitor {

    // 访问工程师类型
    void visit(Engineer engineer);

    // 访问经理类型
    void visit(Manager manager);
}