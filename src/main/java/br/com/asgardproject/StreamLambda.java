package br.com.asgardproject;

import javax.inject.Named;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import software.amazon.awssdk.services.s3;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsResponse;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.amazonaws.regions.Regions;
import java.util.List;
import java.util.ListIterator;

import lombok.extern.java.Log;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.io.IOException;

@Log
@Named("stream")
public class StreamLambda implements RequestStreamHandler {

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException {
        log.info("Executando...");
        log.info("Criando client...");
        /*AmazonS3 client = AmazonS3ClientBuilder
            .standard()
            .withRegion(Regions.US_EAST_1)
            .build();

        ObjectListing listing = client.listObjects("asgardproject-landing");
        List<S3ObjectSummary> summaries = listing.getObjectSummaries();
        log.info("Processing...");
        listing = client.listNextBatchOfObjects(listing);
        log.info("NOVA LINHA");
        while(listing.isTruncated()){
            log.info("Processing: loop");
            summaries.addAll(listing.getObjectSummaries());
            listing = client.listNextBatchOfObjects(listing);
        }
        summaries.addAll(listing.getObjectSummaries());*/

        S3Client client = S3Client.builder().build();
 
        ListObjectsRequest request = ListObjectsRequest.builder()
                        .bucket("asgardproject-landing")
                        .build();

        ListObjectsResponse response = client.listObjects(request);
        List<S3Object> objects = response.contents();
            
        ListIterator<S3Object> listIterator = objects.listIterator();
            
        while (listIterator.hasNext()) {
            S3Object object = listIterator.next();
            log.info(object.key() + " - " + object.size());
        }

        //AmazonS3 client = new AmazonS3Client();
        //S3Object xFile = client.getObject("mybucket", "x.db");
        //InputStream contents = xFile.getObjectContent();
        log.info("End Lambda!");
    }
}
