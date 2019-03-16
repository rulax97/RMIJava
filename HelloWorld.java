import java.rmi.*;
public interface HelloWorld extends Remote
{
  public String message(String msg) throws RemoteException;
}
