package common;
//KLASA ZAJMUJE SIE WYSY�ANIEM I ODBIERANIEM KOMUNIKATOW

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Action {

    private Socket clientSocket = null;
    private DataInputStream dataReader = null;
    private DataOutputStream dataSender = null;

    public Action(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        this.dataReader = new DataInputStream(this.clientSocket.getInputStream());
        this.dataSender = new DataOutputStream(this.clientSocket.getOutputStream());
    }

    public Data messageController() throws IOException {
        String receivedMessage = dataReader.readUTF();
        if (receivedMessage.length() > 0) {
            String[] splittedText = receivedMessage.split(" ");
            Data info = new Data();
            info.setMessageType(splittedText[0]);

            info.setFullName(String.format("%s %s", splittedText[1], splittedText[2]));

            if (splittedText.length > 3) {
                info.setTime(splittedText[3]);
            }
            info.setSuccess(true);
            return info;
        }
        return null;
    }

    public void orderVisit(String clientInfo, String Time) throws IOException {
        this.dataSender.writeUTF(String.format("REZERWUJ %s %s", clientInfo, Time));
    }

    public void cancelVisit(String clientInfo, String Time) throws IOException {
        if (Time != null) {
            this.dataSender.writeUTF(String.format("ANULUJ %s %s", clientInfo, Time));
        } else {
            this.dataSender.writeUTF(String.format("ANULUJ %s", clientInfo));
        }
    }

    public void addClient(String clientInfo) throws IOException {
        this.dataSender.writeUTF(String.format("DODAJ %s", clientInfo));
    }

    public void closeConnection() throws IOException {
        dataReader.close();
        dataSender.close();
    }
}
