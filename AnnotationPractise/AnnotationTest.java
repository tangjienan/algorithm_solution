package AnnotationPractise;

/**
 * Created by donezio on 1/31/19.
 */
public class AnnotationTest {
    @MyMessage(num = 10, desc = "annotation parameter a")
    private static int a;


    @MyMessage(name = "Sam test", desc = "anntation name")
    public void test() {
        System.out.println("test");
    }
}
