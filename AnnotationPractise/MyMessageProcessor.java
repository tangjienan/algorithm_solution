package AnnotationPractise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Created by donezio on 1/31/19.
 */
public class MyMessageProcessor {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();

        int[] arr = new int[2];
        Arrays.fill(arr, Integer.MAX_VALUE);

        try {

            //??annotationTest.class?
            Class clazz = MyMessageProcessor.class.getClassLoader().loadClass("AnnotationPractise.AnnotationTest");

            //????
            Field[] fields = clazz.getDeclaredFields();
            //????
            for (Field field : fields) {
                MyMessage myMessage = field.getAnnotation(MyMessage.class);
                System.out.println("name:" + myMessage.name() + "  num:" + myMessage.num() + "  desc:" + myMessage.desc());
            }

            //???????
            Method[] methods = clazz.getMethods();
            //????
            for (Method method : methods) {

                //????????MyMessage??
                if (method.isAnnotationPresent(MyMessage.class)) {
                    // ?????? method.getDeclaredAnnotations();
                    // ??MyMessage??
                    MyMessage myMessage = method.getAnnotation(MyMessage.class);
                    System.out.println("name:" + myMessage.name() + "  num:" + myMessage.num() + "  desc:" + myMessage.desc());
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
