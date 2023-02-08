import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Main
{


    //global variables
    static Scanner scanner;



    //Main function start
    public static void main(String[] args)
    {

        //get init scanner
        init_scan();

        //Socket start
        try{
            socket_func();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //Socket edn

    }
    //Main function end



    //get init scanner function start
    public static void init_scan()
    {
        scanner=new Scanner(System.in);
    }
    //get init scanner function end



    //Socket function start
    public static void socket_func() throws Exception
    {
        //get socket
        Socket sock=new Socket("192.168.1.6",8085);
        System.out.println("Socket is ready");

        //Get socket streams
        DataInputStream DIS=new DataInputStream(sock.getInputStream());
        DataOutputStream DOS=new DataOutputStream(sock.getOutputStream());


        //get data from server socket start
        byte []input=new byte[1024];
        DIS.read(input);
        String inp = new String(input);
        System.out.println("Server : "+inp);
        //get data from server socket end


        //get send data to server socket start
        System.out.print("Please write a text : ");
        String output=scanner.nextLine();
        DOS.write(output.getBytes());
        //get send data to server socket end

    }
    //Socket function end


}