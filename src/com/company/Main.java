package com.company;

import com.company.Reflection.Reflection;

public class Main {

    public static void main(String[] args) {
        Reflection.GetClassName();
        Reflection.GetClassConstruct();
        Reflection.GetClassMethod();
        Reflection.GetClassMemeber();
        Reflection.GetInstanceA();
        Reflection.InvokePublicMethod("PublicMethodTest");
        Reflection.InvokePublicMethod("PrivateMethodTest");
    }
}

