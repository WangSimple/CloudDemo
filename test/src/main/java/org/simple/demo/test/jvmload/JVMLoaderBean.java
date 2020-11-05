package org.simple.demo.test.jvmload;

public class JVMLoaderBean extends SuperBean {
    public JVMLoaderBean(){
        System.out.println("constructor");
    }
    {
        System.out.println("Block 1");
    }
    static{
        System.out.println("static 1");
    }
    public static JVMLoaderBean bean=new JVMLoaderBean();

    static{
        System.out.println("static 2");
    }
    {
        System.out.println("Block 2");
    }
}

