package lsp;

public class Sparrow extends Bird implements Flyable{
    @Override
    public void eat(){
        System.out.println("чирик-чирик, клюю семечки, чирик-чирик");
    }

    @Override
    public void fly(){
        System.out.println("чирик-чирик, я лечу, чирик-чирик");
    }
}
