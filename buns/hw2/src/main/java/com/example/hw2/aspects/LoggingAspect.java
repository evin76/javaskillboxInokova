package com.example.hw2.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
//для того, чтобы не видеть в консоли логи этого аспекта, закомментируйте аннотации @Component и @Aspect
@Component
@Aspect
public class LoggingAspect {

    public StringBuilder getMethodInfo(JoinPoint joinPoint) {
        StringBuilder builder = new StringBuilder();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        String methodName = method.getName();
        Parameter[] parameters = method.getParameters();
        builder.append(" MethodSignature: ").append(signature).append("; ");
        builder.append(" Method: ").append(methodName).append("; ");
        builder.append(" Return type: " + method.getReturnType().getName()).append("; ");
        builder.append(" Parameters: ");
        Object[] args = joinPoint.getArgs();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            builder.append(parameter.getType().getName()).append(" ").append(parameter.getName())
                    .append(" = ").append(args[i].toString()).append("; ");
        }
        return builder;
    }

    @Pointcut("execution( public void addBook(com.example.hw2.Book, ..))")
    private void addBookPointcut(){}

    @Before("addBookPointcut()")
    public void beforeAddBookAdvice(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("beforeReturnBookAdvice: " + builder.toString());
    }

    @Pointcut("execution( * com.example.hw2.*.get*())")
    private void allGetPointcut(){}

    @Pointcut("execution( * com.example.hw2.UniLibrary.get*(..))")
    private void allGetMethodsUniLibraryPointcut(){}

    @Pointcut("execution( * com.example.hw2.UniLibrary.add*(..))")
    private void allAddMethodsUniLibraryPointcut(){}

    @Pointcut("execution( * com.example.hw2.UniLibrary.return*(..))")
    private void allReturnMethodsUniLibraryPointcut(){}

    @Pointcut("allAddMethodsUniLibraryPointcut() || allGetMethodsUniLibraryPointcut() " +
            "|| allReturnMethodsUniLibraryPointcut()")
    private void allMethodsUniLibraryPointcut(){}

    @Pointcut("execution( * com.example.hw2.UniLibrary.returnBook(com.example.hw2.Book))")
    private void returnBookMethodUniLibraryPointcut(){}

    @Pointcut("allMethodsUniLibraryPointcut() && !returnBookMethodUniLibraryPointcut()")
    private void allMethodsExceptReturnBookPointcut(){}

    @Before("allMethodsExceptReturnBookPointcut()")
    public void allMethodsExceptReturnBook(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("allMethodsExceptReturnBook: " + builder.toString());
    }

    @Before("allMethodsUniLibraryPointcut()")
    public void allMethodsUniAdvice(JoinPoint joinPoint){
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("allMethodsUniAdvice: a method in UniLibrary.class was called; " + builder.toString());
    }

    @Before("execution(public void getBook(com.example.hw2.Book))")
    public void beforeGetBookAdviceUni(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("beforeGetBookAdviceUni: getBook(Book) in class UniLibrary was called; "
                + builder.toString());
    }

    @Before("execution(public void com.example.hw2.PublicLibrary.getBook())")
    public void beforeGetBookAdvicePub(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("beforeGetBookAdvicePub: getBook() in class PublicLibrary was called; " + builder.toString());
    }

    @Before("allGetPointcut()")
    public void beforeGetAdvice(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("beforeGetAdvice: get method was called; " + builder.toString());
    }

    @Before("returnBookMethodUniLibraryPointcut()")
    public void beforeReturnBookAdvice(JoinPoint joinPoint) {
        StringBuilder builder = getMethodInfo(joinPoint);
        System.out.println("beforeReturnBookAdvice: returnBook(Book) method was called; " + builder.toString());
    }
}
