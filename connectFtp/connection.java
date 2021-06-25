package connectFtp;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class connection{
    private static void showServerReply(FTPClient ftpClient){
        String[] replies = ftpClient.getReplyStrings();
        if(replies!=null && replies.length>0){
            for(String aReply : replies){
                System.out.print("SERVER: "+aReply);
            }
        }
    }
    public static void main(String[] args){
        String server = "your host";
        int port = 21;
        String user = "your user";
        String pass = "your pass";
        FTPClient ftpClient = new FTPClient();
        try{
            ftpClient.connect(server, port);
            showServerReply(ftpClient);
            int replyCode = ftpClient.getReplyCode();
            if(!FTPReply.isPositiveCompletion(replyCode)){
                System.out.println("\nOperation failed. Server reply code: "+replyCode);
                return;
            }
            boolean success = ftpClient.login(user, pass);
            showServerReply(ftpClient);
            if(!success){
                System.out.println("\nCould not login to the server");
                return;
            }else{
                System.out.println("\nLOGGED IN SERVER");
            }
        }catch(Exception e){
            System.out.println("\nOops! something wrong happened");
            e.printStackTrace();
        }
    }
}