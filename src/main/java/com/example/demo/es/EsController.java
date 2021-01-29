package com.example.demo.es;

import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/es")
public class EsController {

    @Autowired
    private RestHighLevelClient client;

//    @RequestMapping("create")
//    public String create() {
//        IndexRequest indexRequest = new IndexRequest("post");
//        String jsonString = "{" +
//                "\"user\":\"zk\"," +
//                "\"postDate\":\"2019-01-30\"," +
//                "\"message\":\"trying out java\"" +
//                "}";
//        indexRequest.source(jsonString);
////        client.index();
//    }

    @RequestMapping("/get")
    public GetResponse get(String id) throws IOException {
        GetRequest getRequest = new GetRequest("get-together", "group", id);
        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
        return getResponse;
    }

    @RequestMapping("/index")
    public IndexResponse index(String request, String answer, String relation) throws IOException {
        IndexRequest indexRequest = new IndexRequest("faq");
        Map<String, String> source = new HashMap<>();
        source.put("request", request);
        source.put("answer", answer);
        source.put("relation", relation);
        indexRequest.source(source);
        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
        return indexResponse;
    }

    @RequestMapping("/delete")
    public DeleteResponse delete(String index) throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest(index);
        DeleteResponse response = client.delete(deleteRequest, RequestOptions.DEFAULT);
        return response;
    }

}
