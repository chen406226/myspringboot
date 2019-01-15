package com.soul.index;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;import org.apache.logging.log4j.message.EntryMessage;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.WriteRequest.RefreshPolicy;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;

public class index1 {
	private static final String HOST_NAME = "localhost";
	private static final int PORT = 9300;
	private static TransportClient client;
	private static TransportClient getClient(){
		if (client == null) {
			Settings settings = Settings.builder()
					.put("cluster.name","elasticsearch").build();
			try {
				client = new PreBuiltTransportClient(settings)
						.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(HOST_NAME),9300));
			} catch (UnknownHostException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return client;
	}
	
	public static void main(String[] args) throws Exception{
		// p26  导入数据
		String id = "25";
		System.out.println("sdfdf");
		TransportClient client = getClient();
		System.out.println("sdf");
		//插入数据
		IndexRequestBuilder indexRequestBuilder = client.prepareIndex("cmss","article",id);
		Map<String, String> source = new HashMap<>();
		source.put("title", "人众大家庭");
		source.put("body","我不知道，你知道");
		indexRequestBuilder.setRefreshPolicy(RefreshPolicy.IMMEDIATE).setSource(source);
		IndexResponse response = indexRequestBuilder.execute().actionGet();

//		find();
//		keyw();
//		limitsearch();
		page();
		//删除数据
//>>		DeleteResponse response2 = client.prepareDelete("cmss","article",id).get();
		//System.out.println(response.status().name()); //如果成功，则返回created
		
		// 更新数据
//		UpdateRequest updateRequest = new UpdateRequest();
//		updateRequest.index("cmss"); //索引号
//		updateRequest.type("article"); //类型
//		updateRequest.id(id); //id
//		updateRequest.doc(XContentFactory.jsonBuilder().startObject().field("body","content").endObject());
//		UpdateResponse response3 = client.update(updateRequest).get();
//		
//		
//		System.out.println(response3.status().name()); 
		//如果成功，则返回created  OK  UPDATE
		//Client.prepareDelete()方法删除数据
		
	}
	
	public static void find(){
		TransportClient client = getClient();
		MatchAllQueryBuilder qb = QueryBuilders.matchAllQuery();
		String index = "cmss";
		SearchResponse searchResponse = client.prepareSearch(index).setQuery(qb).execute().actionGet();
		SearchHits hits = searchResponse.getHits();
		for (SearchHit hit : hits) {
			System.out.println("id"+hit.getId()); // 文档id
			Map<String, Object> result = hit.getSource();
			for (final java.util.Map.Entry<String, Object> entry: result.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
	
	//基本的关键词查询
	public static void keyw(){
		TransportClient client = getClient();
		String keyWords = "萨迪克；浪费知道暗室逢灯";
		QueryStringQueryBuilder qb = new QueryStringQueryBuilder(keyWords);
		String index = "cmss";
		SearchResponse searchResponse = client.prepareSearch(index)
				.setQuery(qb).execute().actionGet();
		SearchHits hits = searchResponse.getHits();
		for (SearchHit searchHit : hits) {
			System.out.println("id"+searchHit.getId());
			Map<String, Object> result = searchHit.getSource();
			for (final java.util.Map.Entry<String, Object> entry: result.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
	
	// SearchRequestBuilder.setFetchSource()方法限定返回的列数据，以避免返回过多的数据
	public static void limitsearch(){
		TransportClient client = getClient();
		String index = "cmss";
		String keyWords = "知道";
		QueryStringQueryBuilder qb = new QueryStringQueryBuilder(keyWords);
		SearchRequestBuilder requestBuilder= client.prepareSearch(index).setQuery(qb);
		//限定只返回title列的数据
		SearchResponse searchResponse = requestBuilder.setFetchSource("title",null).execute().actionGet();
		
		
		SearchHits hits = searchResponse.getHits();
		for (SearchHit searchHit : hits) {
			System.out.println("id"+searchHit.getId());
			Map<String, Object> result = searchHit.getSource();
			for (final java.util.Map.Entry<String, Object> entry: result.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
		
		//也可以调用client.prepareget(index,type,id)方法只返回指定文档 result title:..
//		GetResponse response = client.prepareGet("cmss","article","25").setFetchSource("title",null).execute().actionGet();
//		Map<String, Object> result = response.getSourceAsMap();
//		for (final java.util.Map.Entry<String, Object> entry: result.entrySet()) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
	
	}
	
	//设置分页
	//基本的关键词查询
	public static void page(){
		TransportClient client = getClient();
		String keyWords = "萨迪克；浪费知道暗室逢灯";
		int rows=1; // 一页显示多少条结果
		int offset=0; // 开始行
		
		QueryStringQueryBuilder qb = new QueryStringQueryBuilder(keyWords);
		String index = "cmss";
//		SearchResponse searchResponse = client.prepareSearch(index)
//				.setQuery(qb).execute().actionGet();
		SearchRequestBuilder searchRequestBuilder = client.prepareSearch(index);
		searchRequestBuilder.setFrom(offset).setSize(rows);
		//分页
		
		// 设置高亮标签
		HighlightBuilder hibuilder = new HighlightBuilder();
		hibuilder.preTags("<span style=\"color:red\">");
		hibuilder.postTags("</span>");
		//指定高亮字段
		hibuilder.field("title");
		searchRequestBuilder.highlighter(hibuilder);
		SearchResponse searchResponse = searchRequestBuilder.setQuery(qb).execute().actionGet();
		SearchHits hits = searchResponse.getHits();
		long totalHits = hits.getTotalHits(); //得到结果总数
		System.out.println(totalHits);
		
		for (SearchHit searchHit : hits) {
			System.out.println("id"+searchHit.getId());
			Map<String, Object> result = searchHit.getSource();
			for (final java.util.Map.Entry<String, Object> entry: result.entrySet()) {
				System.out.println(entry.getKey()+":"+entry.getValue());
			}
		}
	}
	
	
	
	
}
