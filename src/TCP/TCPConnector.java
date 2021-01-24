package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPConnector implements Server, Connection, Client {
    private Socket socket;

    @Override
    public Connection connect(String hostname, int port) throws IOException {
        this.socket = new Socket(hostname, port);
        return this;
    }

    @Override
    public Connection acceptConnection(int port) throws IOException {
        ServerSocket ss = new ServerSocket(port);
        System.out.println("serversocket created");
        this.socket = ss.accept();
        return this;
    }

    @Override
    public OutputStream getOutPutStream() throws IOException {
        return this.socket.getOutputStream();
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return this.socket.getInputStream();
    }
}
