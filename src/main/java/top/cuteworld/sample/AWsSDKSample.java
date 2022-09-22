package top.cuteworld.sample;

import software.amazon.awssdk.http.apache.ApacheHttpClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.http.apache.ProxyConfiguration;

import java.net.URI;

/**
 * https://github.com/aws/aws-sdk-java-v2/blob/master/docs/LaunchChangelog.md#132-client-http-proxy-configuration
 */
public class AWsSDKSample {

    public static void main(String[] args) {
        Region region = Region.US_EAST_1;
        S3Client s3 = S3Client.builder()
                .httpClientBuilder(httpclientBuilder())
                .region(region).build();


        String bucket = "bucket" + System.currentTimeMillis();
        String key = "key";

        ListBucketsResponse listBucketsResponse = s3.listBuckets();
        listBucketsResponse.buckets().forEach(t -> {
            System.out.println(t.name());
        });
    }

    private static ApacheHttpClient.Builder httpclientBuilder() {
//        ClientHttpConfiguration
//    System.out.println(software.amazon.awssdk.http.);

        ProxyConfiguration.Builder proxyConfig =
                ProxyConfiguration.builder()
                        .endpoint(URI.create("http://119.29.178.64:1087"));
//                        .username(USERNAME)
//                        .password(PASSWORD);
        return ApacheHttpClient.builder()
                .proxyConfiguration(proxyConfig.build());
    }

    private void test() {

    }


    private static void setupHttpProxy() {
        System.setProperty("http.proxyHost", "119.29.178.64");
        System.setProperty("http.proxyPort", "1087");
//        System.setProperty("http.nonProxyHosts", "192.168.3.249 | 192.168.3.100");
    }

    private static void setupSocksProxy() {
        System.setProperty("socksProxyHost", "119.29.178.64");
        System.setProperty("socksProxyPort", "1087");
//        System.setProperty("http.nonProxyHosts", "192.168.3.249 | 192.168.3.100");
    }
}
