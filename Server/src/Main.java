import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main
{


    //global varaibles
    static Scanner scanner;


    //main function start
    public static void main(String[] args)
    {

        //Get init scanner
        ini_scanner();

        //Get fun socket start
        try{
            socket_server();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Get fun socket end

    }
    //main function end



    //initlize scanner function start
    public static void ini_scanner()
    {
        scanner = new Scanner(System.in);
    }
    //initlize scanner function end


    //socket function start
    public static void socket_server() throws Exception
    {
        ServerSocket SS=new ServerSocket(8085);

        System.out.println("Server is ready");

        Socket sock = SS.accept();
        DataInputStream DIS=new DataInputStream(sock.getInputStream());
        DataOutputStream DIO=new DataOutputStream(sock.getOutputStream());

        System.out.print("Enter your text : ");
        String input=scanner.nextLine();
        DIO.write(input.getBytes());

        byte []inp=new byte[1024];
        DIS.read(inp);
        String intput=new String(inp);
        System.out.println("User message is : "+intput);

        DIO.close();
        DIS.close();
        sock.close();
    }
    //socket function END


}