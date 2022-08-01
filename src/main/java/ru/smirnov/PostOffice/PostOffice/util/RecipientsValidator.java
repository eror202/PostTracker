package ru.smirnov.PostOffice.PostOffice.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.smirnov.PostOffice.PostOffice.models.Recipients;

public class RecipientsValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Recipients.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Recipients recipients = (Recipients) target;

    }
}
