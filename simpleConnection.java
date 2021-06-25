import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class simpleConnection {
    public static void main(String[]args){
        FTPClient ftpClient = new FTPClient();
        String server = "your host";
        Integer port = 21;
        String user = "your user";
        String pass = "your pass";
        try{
            ftpClient.connect(server, port);
            boolean success = ftpClient.login(user, pass);
            if(!success){
                System.out.println("Could not possible to connect to server");
            }else{
                System.out.println("Connected in the server");
            }
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
