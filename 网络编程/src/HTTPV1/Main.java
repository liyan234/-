package HTTPV1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        HttpSeverV1 httpSeverV1 = new HttpSeverV1(80);
        httpSeverV1.start();

    }
}
