package pl.pstefaniak.zeus;

import org.springframework.cglib.proxy.*;

import java.lang.reflect.Method;

public class CglibTests {

    public String test(String input) {
        return "Hello world!";
    }


    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CglibTests.class);
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy)
                    throws Throwable {
                if(method.getDeclaringClass() != Object.class
                        && method.getReturnType() == String.class) {
                    return "Hello cglib!";
                } else {
                    return proxy.invokeSuper(obj, args);
                }
            }
        });
        CglibTests proxy = (CglibTests) enhancer.create();
        proxy.hashCode(); // Does not throw an exception or result in an endless loop
        System.out.println( proxy.test(null));
        System.out.println( proxy.toString());
    }
}
