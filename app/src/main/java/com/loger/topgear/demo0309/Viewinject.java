package com.loger.topgear.demo0309;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)   //运行时注解
@Target(ElementType.TYPE)   //类 接口 注解
public @interface Viewinject {
    int mainlayoutid() default -1;   //其默认值是-1
}
