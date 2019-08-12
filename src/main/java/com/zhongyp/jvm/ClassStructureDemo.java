package com.zhongyp.jvm;

/**
 * @author zhongyp.
 * @date 2019/8/10
 */
public class ClassStructureDemo extends ClassStructureDemoSuperClass implements ClassStructureDemoSuperInterface {

    private static String staticVar = "abc";
    private String normalVar = "def";
    ClassStructureMember member = new ClassStructureMember();

    public ClassStructureDemo (){

    }

    public ClassStructureDemo (String x){

    }

    @Override
    public void interfaceFunc() {
        String localVar = "g";
        System.out.println("实现接口");
    }


    private void localFunc(String y){

    }

    protected void protectedFunc(){

    }
}
