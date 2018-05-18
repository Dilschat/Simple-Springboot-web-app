package com.example.simple_biosamples_client.controllers;

import org.apache.commons.io.FileUtils;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

@RestController
@EnableAutoConfiguration
public class DownloaderController {


    @RequestMapping("/download")
    String downloadFile() throws IOException {
        URL url = new URL("ftp://ftp.ebi.ac.uk/pub/databases/ena/sequence/release/con/rel_con_fun_02_r135.dat.gz");
        URLConnection connection = url.openConnection();
        File target = new File("sequence.tmp");
        Mono.just(url)
                .log()
                .map(stream -> {
                    try {
                        FileUtils.copyURLToFile(url, target);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return target;
                })
                .subscribeOn(Schedulers.parallel());

        return "File will be downloaded";
    }

}
