package Hello.Demo.singleton;

public class SingleTonService {

    private SingleTonService(){}

    private static class InnerInstanceClass {
        private static final SingleTonService instance = new SingleTonService();
    }

    public static SingleTonService getInstance(){
        return InnerInstanceClass.instance;
    }
}
