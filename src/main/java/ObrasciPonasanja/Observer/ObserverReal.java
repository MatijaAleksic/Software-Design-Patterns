package ObrasciPonasanja.Observer;

import java.util.Observable;
import java.util.Observer;

class ONewsChannel implements Observer {

    private String news;

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }
}

class ONewsAgency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
public class ObserverReal {

    public static void main(String[] args) {
        ONewsAgency observable = new ONewsAgency();
        ONewsChannel observer = new ONewsChannel();

        observable.addObserver(observer);
        observable.setNews("news");

        String observerMessage = observer.getNews();
        System.out.println(observerMessage);
    }
}
