package HTTPV3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        HttpServerV3 httpServerV3 = new HttpServerV3(80);
        httpServerV3.start();
    }
}
