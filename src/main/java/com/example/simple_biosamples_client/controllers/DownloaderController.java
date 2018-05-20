package com.example.simple_biosamples_client.controllers;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.io.*;

@RestController
@EnableAutoConfiguration
public class DownloaderController {

    @RequestMapping("/download")
    String downloadFile() throws IOException {
        Flux.just("test.rebex.net/pub/example/readme.txt")
                .log()
                    .subscribeOn(Schedulers.parallel())
                    .map(i -> {
                        try {
                            String[] ftpServerPaths = i.split("/", 2);
                            File target = new File("readme.txt");
                            boolean fileCreated = target.createNewFile();
                            if (!fileCreated) {
                                return "File creation failed. Download canceled!";
                            }

                            FTPClient client = new FTPClient();
                            client.connect(ftpServerPaths[0]);
                            client.login("demo", "password"); // log and pass just for this example impl
                            System.out.println(client.getReplyString());
                            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(target));
                            client.enterLocalPassiveMode();
                            client.setFileType(FTP.ASCII_FILE_TYPE);
                            client.retrieveFile(ftpServerPaths[1], outputStream);
                            outputStream.close();
                            client.disconnect();
                            return i;
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return i;
                    })
                    .subscribe();

        return "File will be downloaded";
    }

}
