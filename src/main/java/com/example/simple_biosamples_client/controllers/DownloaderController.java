package com.example.simple_biosamples_client.controllers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class DownloaderController {


    @RequestMapping("/download")
    String downloadFile() throws IOException {
        URL url = new URL("ftp://ftp.ebi.ac.uk/pub/databases/ena/sequence/release/con/rel_con_fun_02_r135.dat.gz");
        URLConnection connection = url.openConnection();
        File target = new File("readme.txt");
        List<Integer> list = new ArrayList<>();
        Flux.just(1)
                .log()
                .map(i -> i * 2)
                .subscribeOn(Schedulers.parallel())
                .subscribe(list::add);
        target.createNewFile();


        try {
            System.out.println("hello");
            FTPClient client = new FTPClient();
            client.connect("test.rebex.net");
            client.login("demo", "password");
            System.out.println(client.getReplyString());
            int code = client.getReplyCode();

            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
            client.enterLocalPassiveMode();
            System.out.println("hello");
            client.setFileType(FTP.ASCII_FILE_TYPE);
            Flux.just("/pub/example/readme.txt")
                    .subscribeOn(Schedulers.parallel())
                    .map(i -> {
                        try {
                            return client.retrieveFile(i, outputStream);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return i;
                    })
                    .subscribe();
//            boolean success = client
//                    .retrieveFile("/pub/example/readme.txt",outputStream);
//            System.out.println("hello");
            //InputStream inputStream = client.retrieveFileStream("/pub/example/readme.txt");

//            if (success){
//                System.out.println("success");
//            }
            outputStream.close();
            client.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        Mono.just(url)
//                .log()
//                .map(stream -> {
//                    try {
//                        System.out.println("hello");
//                        FTPClient client = new FTPClient();
//                        client.connect("ftp://ftp.ebi.ac.uk");
//                        client.setFileType(FTP.COMPRESSED_TRANSFER_MODE);
//                        FileOutputStream outputStream = new FileOutputStream(target);
//                        boolean success = client
//                                .retrieveFile("/pub/databases/ena/sequence/release/con/rel_con_fun_02_r135.dat.gz",outputStream);
//                        if (success){
//                            System.out.println("success");
//                        }
//                        outputStream.flush();
//                        outputStream.close();
//                        client.disconnect();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    return target;
//                })
//                .subscribeOn(Schedulers.parallel())
//                .subscribe();

        return "File will be downloaded";
    }

}
