package helpers;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;


public class DefaultSubscriber implements Subscriber<Object> {


    //a simple named subscriber to know who takes the data
    private String name = "";

    public DefaultSubscriber(String name) {
       this.name=name;
    }

    public DefaultSubscriber() {}

    @Override
    public void onSubscribe(Subscription subscription) {
        subscription.request(Long.MAX_VALUE);

    }

    @Override
    public void onNext(Object o) {
       System.out.println(name+"Received :"+o);
    }

    @Override
    public void onError(Throwable throwable) {
       System.out.println(name + "Error :" + throwable.getMessage());
    }

    @Override
    public void onComplete() {
       System.out.println(name+"Completed");
    }
}
