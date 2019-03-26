import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteTest {

    public static void main(String[] args) {
        readBytes(bytesToSend());
    }

    private static ByteBuffer bytesToSend() {
        ByteBuffer buffer = ByteBuffer.allocate(4).putInt(6);
        //buffer.flip();
        return buffer;
    }

    private static void readBytes(ByteBuffer bb) {
        System.out.println(bb.get());
    }

    private static int getMessageId(byte[] b) {
        return ByteBuffer.wrap(b, 0, 4).getInt();
    }
}
