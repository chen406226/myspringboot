package com.soul;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class TestClient {
	static TransportClient client;
	static String clusterName = "elasticsearch";
	static String serverhost = "localhost";
	static int serverPort = 9300;
	public static void main(String[] args) throws UnknownHostException{
		Settings settings = Settings.builder().put("cluster.name",clusterName).build();
		client = new PreBuiltTransportClient(settings).addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(serverhost),serverPort));
		System.out.println("****创建了Elasticserarch******");
		client.close();
	}
}
