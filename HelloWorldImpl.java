import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
/////
import java.io.*;
import java.util.*;
/////

public class HelloWorldImpl extends UnicastRemoteObject implements HelloWorld
{
	public HelloWorldImpl() throws RemoteException
	{
		super();
	}

	public String message(String msg)
	{
		String data="";
		String u_1="",u_2="",u_3="",u_4="",u_5="",u_6="";
		char[] comp = msg.toCharArray();
		int compare = (int) comp[0];
		if(compare==85)
		{
			data=msg;
			try
			{
				u_1=data.substring(0,1);
				u_2=data.substring(1,9);
				u_3=data.substring(9,17);
				u_4=data.substring(17,23);
				u_5=data.substring(23,31);
				u_6=data.substring(31,35);
				BufferedWriter out = new BufferedWriter (new FileWriter("medicion.csv", true));
				out.write(u_1);
				out.write(",");
				out.write(u_2);
				out.write(",");
				out.write(u_3);
				out.write(",");
				out.write(u_4);
				out.write(",");
				out.write(u_5);
				out.write(",");
				out.write(u_6);
				out.write("\n");
				out.close();
			}
			catch (IOException e)
			{
				System.out.println("Excepcion ocurrida: " + e);
			}
		}
		if(compare==82)
		{
			data=msg;
			try
			{
				BufferedWriter out = new BufferedWriter (new FileWriter("transaccion.csv", true));
				out.write(data.substring(0,1));
				out.write(",");
				out.write(data.substring(1,9));
				out.write(",");
				out.write(data.substring(9,17));
				out.write(",");
				out.write(data.substring(17,21));
				out.write("\n");
				out.close();
			}
			catch (IOException e)
			{
				System.out.println("Excepcion ocurrida: " + e);
			}
		}
		return "Esto me enviaste"+msg+". Atte. El Servidor de Servicios.";
	}
	public static void main(String[] args)
	{
		String hostName = "localhost";
		String serviceName = "HelloWorldService";
		System.setProperty("java.security.policy","file:./security.policy");
  	System.setProperty("java.rmi.server.hostname","192.168.0.7");
    System.setSecurityManager(new RMISecurityManager());
		try
		{
			HelloWorld hello = new HelloWorldImpl();
			Naming.rebind("rmi://"+hostName+"/"+serviceName, hello);
		}
		catch(Exception e)
		{
			System.out.println("Error durante el proceso.");
		}
	}
}
