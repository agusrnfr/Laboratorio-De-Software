package practica5.ej2;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Archivo {
    String nombre() default "";
}
