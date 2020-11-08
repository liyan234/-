package HttpV2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpServerV2 httpServerV2 = new HttpServerV2(80);
        httpServerV2.start();

    }

}
