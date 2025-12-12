package solutions.lab9.task17;

import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Min {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Range {
    int min();
    int max();
}

class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}

class User {
    @NotNull
    private String name;

    @MaxLength(10)
    private String username;

    @Min(18)
    private int age;

    @Range(min = 1, max = 100)
    private int level;

    public User(String name, String username, int age, int level) {
        this.name = name;
        this.username = username;
        this.age = age;
        this.level = level;
    }
}

class Validator {
    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        
        List<String> errors = new ArrayList<>();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);

            // --- Проверка @NotNull ---
            if (field.isAnnotationPresent(NotNull.class)) {
                if (value == null) {
                    errors.add("Поле '" + field.getName() + "' не должно быть null.");
                }
            }

            // --- Проверка @MaxLength ---
            if (field.isAnnotationPresent(MaxLength.class)) {
                int maxLength = field.getAnnotation(MaxLength.class).value();
                if (value instanceof String strValue) {
                    if (strValue.length() > maxLength) {
                        errors.add("Поле '" + field.getName() + "' превышает максимальную длину " + maxLength + 
                                   ". Текущая длина: " + strValue.length());
                    }
                }
            }

            // --- Проверка @Min ---
            if (field.isAnnotationPresent(Min.class)) {
                int minVal = field.getAnnotation(Min.class).value();
                // Проверяем, является ли значение числом
                if (value instanceof Number number) {
                    int numValue = number.intValue();
                    if (numValue < minVal) {
                        errors.add("Поле '" + field.getName() + "' должно быть не меньше " + minVal + 
                                   ". Текущее значение: " + numValue);
                    }
                }
            }

            // --- Проверка @Range ---
            if (field.isAnnotationPresent(Range.class)) {
                Range range = field.getAnnotation(Range.class);
                if (value instanceof Number number) {
                    int numValue = number.intValue();
                    if (numValue < range.min() || numValue > range.max()) {
                        errors.add("Поле '" + field.getName() + "' должно быть в диапазоне от " + 
                                   range.min() + " до " + range.max() + 
                                   ". Текущее значение: " + numValue);
                    }
                }
            }
        }

        if (!errors.isEmpty()) {
            System.out.println("--- Ошибки валидации ---");
            for (String error : errors) {
                System.out.println(error);
            }

            throw new ValidationException("Объект не прошел валидацию. Найдено ошибок: " + errors.size());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // name = null (ошибка NotNull)
        // username = "SuperLongUsernameHere" (ошибка MaxLength > 10)
        // age = 16 (ошибка Min < 18)
        // level = 999 (ошибка Range 1-100)
        User user = new User(null, "UsernameHere", 16, 999);

        try {
            Validator.validate(user);
            System.out.println("Валидация прошла успешно!");
        } catch (ValidationException e) {
            System.out.println("\n[!] Перехвачено исключение валидации: " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.out.println("\n[!] Перехвачено исключение нелегального доступа: " + e.getMessage());
        }
    }
}