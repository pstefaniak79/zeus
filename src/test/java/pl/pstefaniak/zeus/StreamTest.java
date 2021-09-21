package pl.pstefaniak.zeus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) throws IOException {

        URI content = URI.create("https://www.google.com/"); // Quick way to get input steam
        /**
         * Convert the stream in to String using Java 8 Stream API
         */
        String output = new BufferedReader(
                new InputStreamReader(content.toURL().openStream()))
                .lines().collect(Collectors.joining()); //you can use the joiner based on your requirement like joining("/n")


        System.out.println(output); //<!doctype html>
    }

}
