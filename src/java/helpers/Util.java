package helpers;

import org.reactivestreams.Subscriber;

import java.util.function.Consumer;

public class Util {

    //its a library to generate data for examples

    //3 simple static methods, to return lamdas
    public static Consumer<Object> onNext()
    {
        return  o-> System.out.println("Received :"+o);
    }

    public static Consumer<Throwable> onError()
    {
        return  e -> System.out.println("Error :"+e.getMessage());
    }

    public static Runnable onComplete()
    {
        return () -> System.out.println("Completed");
    }



    public static void sleepSeconds(int sec)
    {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Subscriber<Object> subscriber()
    {
        return new DefaultSubscriber();
    }

    public static Subscriber<Object> subscriber(String name)
    {
        return new DefaultSubscriber(name);
    }

}
