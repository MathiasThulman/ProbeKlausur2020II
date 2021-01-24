package TCP;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface Connection {
    /**
     *
     * @return output stream of created connection
     */
    OutputStream getOutPutStream() throws IOException;

    /**
     *
     * @return inputstream of created connection
     */
    InputStream getInputStream() throws IOException;
}
