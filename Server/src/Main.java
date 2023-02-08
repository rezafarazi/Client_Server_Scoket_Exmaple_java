import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Main
{


    //global varaibles
    static Scanner scanner;
    static String file_address="/home/rezafta/Downloads/r.txt";


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


        File f=new File(file_address);
        FileOutputStream FOS=new FileOutputStream(f);

        long size=DIS.readLong();
        byte []buffer=new byte[4096];
        int bytes=0;
        while(size > 0 && (bytes=DIS.read(buffer,0,buffer.length))!=-1){
            FOS.write(buffer,0,bytes);
            size-=bytes;
        }


        DIO.close();
        DIS.close();
        sock.close();
    }
    //socket function END


}