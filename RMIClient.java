import java.rmi.*;
///////////////
import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.lang.*;
///////////////
public class RMIClient
{
	//ambito global.
	public static Scanner entrada=new Scanner(System.in);
  public static String tipo="", nombresensor="", nombresensor2="", tiempo="", fecha="", nombreobservante="",total2="";
  public static String Mensaje="",Mensaje2="";
  public static String str2="";
  public static float dato=0;
  public static int checksum=0,checksum2=0;
  public static boolean prueba;
  public static char[] sta1 = tipo.toCharArray();
	public static String msg="";
	//fin ambito global.

/////////////////////
	public static void llenado()
	{
		//SENSOR
    System.out.print("Selecciona tu tipo de usuario: U (Sensor) y R (Observador): ");
    tipo=entrada.nextLine();
    sta1 = tipo.toCharArray();
    if(sta1[0]=='u'||sta1[0]=='U')
    {
      update();
			msg=Mensaje;
    }
    else if (sta1[0]=='r'||sta1[0]=='R')
    {
      request();
			msg=Mensaje2;
    }
    else
    {
      try
      {
        System.out.println("Error, no ingresaste un valor correcto.");
      }
      catch (Exception QQ)
      {
        System.out.println("Error, no ingresaste un valor correcto.");
      }
    }
	}
	public static String request()
	{
		String message2="";
		tipo="R";
    sta1 = tipo.toCharArray();
    try
    {
      //OBSERVANTE
      do
      {
        System.out.print("Ingresa el nombre del observante (8 caracteres solamente): ");
        nombreobservante = entrada.nextLine();
        if(nombreobservante.length()==1)
        {
          nombreobservante=nombreobservante+"XXXXXXX";
        }
        else if(nombreobservante.length()==2)
        {
          nombreobservante=nombreobservante+"XXXXXX";
        }
        else if(nombreobservante.length()==3)
        {
          nombreobservante=nombreobservante+"XXXXX";
        }
        else if(nombreobservante.length()==4)
        {
          nombreobservante=nombreobservante+"XXXX";
        }
        else if(nombreobservante.length()==5)
        {
          nombreobservante=nombreobservante+"XXX";
        }
        else if(nombreobservante.length()==6)
        {
          nombreobservante=nombreobservante+"XX";
        }
        else if(nombreobservante.length()==7)
        {
          nombreobservante=nombreobservante+"X";
        }
        else if(nombreobservante.length()==8)
        {
          nombreobservante=nombreobservante;
        }
        else
        {
          System.out.println("No ingresaste un nombre de observante correcto.");
        }
      } while(nombreobservante.length()!=8);
      do
      {
        System.out.print("Ingresa el nombre del sensor (8 caracteres solamente): ");
        nombresensor2 = entrada.nextLine();
          if(nombresensor2.length()==1)
          {
            nombresensor2=nombresensor2+"XXXXXXX";
          }
          else if(nombresensor2.length()==2)
          {
            nombresensor2=nombresensor2+"XXXXXX";
          }
          else if(nombresensor2.length()==3)
          {
            nombresensor2=nombresensor2+"XXXXX";
          }
          else if(nombresensor2.length()==4)
          {
            nombresensor2=nombresensor2+"XXXX";
          }
          else if(nombresensor2.length()==5)
          {
            nombresensor2=nombresensor2+"XXX";
          }
          else if(nombresensor2.length()==6)
          {
            nombresensor2=nombresensor2+"XX";
          }
          else if(nombresensor2.length()==7)
          {
            nombresensor2=nombresensor2+"X";
          }
          else if(nombresensor2.length()==8)
          {
            nombresensor2=nombresensor2;
          }
          else
          {
            System.out.println("No ingresaste un nombre de observante correcto.");
          }
      } while(nombresensor2.length()!=8);
    }
    catch (Exception QW)
    {
      System.out.println("Error no ingresaste un valor correcto.");
    }
    Mensaje2 = tipo+nombreobservante+nombresensor2;
    char[] sta3 = Mensaje2.toCharArray();
    for (int y=0;y<sta3.length;y++)
    {
      checksum2= checksum2 + (int) sta3[y];
    }
    //System.out.println(checksum);
    String str1 = Integer.toString(checksum2);
    Mensaje2 = Mensaje2+str1;
		/////
		message2=Mensaje2;
		return message2;
	}
	public static String update()
	{
		String message="";
		tipo="U";
    sta1 = tipo.toCharArray();
    try
    {
      do
      {
        System.out.print("Ingresa el nombre del sensor (8 caracteres solamente): ");
        nombresensor = entrada.nextLine();
          if(nombresensor.length()==1)
          {
            nombresensor=nombresensor+"XXXXXXX";
          }
          else if(nombresensor.length()==2)
          {
            nombresensor=nombresensor+"XXXXXX";
          }
          else if(nombresensor.length()==3)
          {
            nombresensor=nombresensor+"XXXXX";
          }
          else if(nombresensor.length()==4)
          {
            nombresensor=nombresensor+"XXXX";
          }
          else if(nombresensor.length()==5)
          {
            nombresensor=nombresensor+"XXX";
          }
          else if(nombresensor.length()==6)
          {
            nombresensor=nombresensor+"XX";
          }
          else if(nombresensor.length()==7)
          {
            nombresensor=nombresensor+"X";
          }
          else if(nombresensor.length()==8)
          {
            nombresensor=nombresensor;
          }
          else
          {
            System.out.println("No ingresaste un nombre de sensor correcto.");
          }
      }while(nombresensor.length()!=8);
      do
      {
        System.out.print("Ingresa dato de medicion (8 digitos solamente): ");
        dato = entrada.nextFloat();
        entrada.nextLine(); //Limpia el bufer de entrada.
          if(dato>=-99999.9 && dato<=999999.9)
          {
            total2 = Float.toString(dato);
						if(total2.length()==1)
	          {
	            total2=total2+".000000";
	          }
	          else if(total2.length()==2)
	          {
	            total2=total2+".00000";
	          }
	          else if(total2.length()==3)
	          {
	            total2=total2+"00000";
	          }
	          else if(total2.length()==4)
	          {
	            total2=total2+"0000";
	          }
	          else if(total2.length()==5)
	          {
	            total2=total2+"000";
	          }
	          else if(total2.length()==6)
	          {
	            total2=total2+"00";
	          }
	          else if(total2.length()==7)
	          {
	            total2=total2+"0";
	          }
	          else if(total2.length()==8)
	          {
	            total2=total2;
	          }
            prueba = true;
          }
					else
          {
            prueba = false;
          }
      }while(total2.length()!=8 && !prueba);
      do
      {
        System.out.print("Ingresa el tiempo (HHMMSS): ");
        tiempo = entrada.nextLine();
      }while(tiempo.length()!= 6);
      do
      {
        System.out.print("Ingresa la fecha (DDMMAAAA): ");
        fecha = entrada.nextLine();
      } while (fecha.length()!=8);
      Mensaje = tipo+nombresensor+total2+tiempo+fecha;
      char[] sta2 = Mensaje.toCharArray();
      for (int x=0;x<sta2.length;x++)
      {
        checksum= checksum + (int) sta2[x];
      }
      str2 = Integer.toString(checksum);
      Mensaje = Mensaje+str2;
			/////
			message=Mensaje;
			return message;
    }
    catch (Exception Q)
    {
      System.out.println("Error no ingresaste el valor correcto.");
    }
		return "Error.";
	}
/////////////////

	public static void main(String[] args)
	{

		String hostName = "localhost";
		String serviceName = "HelloWorldService";
		//String msg = HelloWorld.message;
		System.setProperty("java.security.policy","file:./security.policy");
    System.setProperty("java.rmi.server.hostname","192.168.0.7");
    System.setSecurityManager(new RMISecurityManager());
		try
		{
			HelloWorld l = (HelloWorld)Naming.lookup("rmi://"+hostName+"/"+serviceName);
			llenado();
			System.out.println(l.message(msg));
		}
		catch(Exception e)
		{
		    e.printStackTrace();
		}
	}
}
