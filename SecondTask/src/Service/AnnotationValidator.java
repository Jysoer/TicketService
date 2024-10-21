package Service;

import Interfaces.NullableWarning;

import java.lang.reflect.Field;

public class AnnotationValidator {
    public static void validate(Object o) throws IllegalAccessException {
        Field[] fields = o.getClass().getDeclaredFields();

        for (Field field : fields){
            field.setAccessible(true);

            if(field.isAnnotationPresent(NullableWarning.class)){
                Object value = field.get(o);

                if(value == null){
                    System.out.println("Field '" + field.getName() + "' in class: '" + o.getClass().getSimpleName() + "' is null!");
                }
            }
        }
    }
}
