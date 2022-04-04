package br.com.asgardproject;

import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
//import com.amazonaws.services.s3.AmazonS3Client;

import lombok.extern.java.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;


@Log
@Named("stream")
public class StreamLambda implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        //AmazonS3 client = new AmazonS3Client();
        //S3Object xFile = client.getObject("mybucket", "x.db");
        //InputStream contents = xFile.getObjectContent();
    }
}
