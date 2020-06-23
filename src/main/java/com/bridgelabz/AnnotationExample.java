package com.bridgelabz;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Kaustavi", comments = "Main Method", date = "June 23 2020", revision = 1)
    public String toString(){
        return "Overridden toString method";
    }
    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "June 23 2020")
    public static void oldMethod(){
        System.out.println("Old Method,Don't use it");
    }

    public static void main(String[] args) {
        try{
            for(Method method : AnnotationExample.class.getMethods()){
                if (method.isAnnotationPresent(MethodInfo.class)){
                    try{
                        for (Annotation anno : method.getDeclaredAnnotations()){
                            System.out.println("Annotation is Method"+method+":"+anno);
                        }
                        MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
                        if(methodAnno.revision() == 1){
                            System.out.println("Method revision no 1 ="+method);
                        }
                    }catch(Throwable e){
                        e.printStackTrace();
                    }
                }
            }
        }catch(SecurityException ex){
            ex.printStackTrace();
        }
    }


}
