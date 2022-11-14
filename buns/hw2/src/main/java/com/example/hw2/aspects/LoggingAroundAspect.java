package com.example.hw2.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAroundAspect {

    @Around("execution(public String returnBook(com.example.hw2.Book))")
    public Object returnBookAroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around Advice started");
        Object result = null;
        try {
            result = joinPoint.proceed();
        } catch (Exception e) {
            System.out.println("returnBookAroundAdvice: an exception was thrown in method " +
                    "com.example.hw2.UniLibrary.returnBook(Book book) " + e);
            throw e;
        }
        System.out.println("returnBookAroundAdvice: returnBook(), Around Advice successfully finished");

        return result;
    }
}
