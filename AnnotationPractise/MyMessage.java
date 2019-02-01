package AnnotationPractise;

/**
 * Created by donezio on 1/31/19.
 */
import java.lang.annotation.*;

/**
 * @author sam
 * @since 2017/7/13
 */
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MyMessage {

    String name() default "sam";

    int num() default 0;

    String desc();

}
