import java.io.ByteArrayInputStream;
import org.apache.commons.net.ftp.*;
import org.apache.commons.net.ftp.FTPReply;
import java.io.*;

public class simpleConnection {
    public static void main(String[]args){
        String server = "192.168.1.170";
        Integer port = 21;
        String user = "po75";
        String pass = "W193410s@";
        FTPClient ftpClient = new FTPClient();
        try{
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            
            System.out.println("Connected in the server");

            try (FileInputStream inputStream = new FileInputStream("foo.txt");) {
                ftpClient.storeFile("for.txt", inputStream);
            }
            ftpClient.logout();
            ftpClient.disconnect();

           
        }catch(Exception e){
            System.out.println("Could not possible to connect to server");
            System.out.println(e);
        }

    }
}
