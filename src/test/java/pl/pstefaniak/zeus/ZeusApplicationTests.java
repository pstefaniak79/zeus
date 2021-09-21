package pl.pstefaniak.zeus;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

@SpringBootTest
class ZeusApplicationTests {

	@Test
	void contextLoads() {
	}


	public static void main(String[] args) {
		SocketChannel sc = null;
		try {
			sc = SocketChannel.open();
			sc.connect(new InetSocketAddress("www.google.com", 80));
			if(sc.isConnected()) {
				ByteBuffer[] byteBuffers = new ByteBuffer[256];
				//sc.bind();
				System.out.print(byteBuffers.toString());
				sc.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

}
