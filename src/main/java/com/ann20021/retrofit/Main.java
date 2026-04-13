package com.ann20021.retrofit;

import com.ann20021.retrofit.request.PostCreateRequest;
import com.ann20021.retrofit.request.PostUpdateRequest;
import com.ann20021.retrofit.response.PostResponse;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

public class Main {


    public static void main(String[] args) throws IOException {
        System.out.println("Hello!");

        JsonPlaceholderAPI api = JsonPlaceholderService.getInstance().api();

        System.out.println("");
        System.out.println("GET: /posts -----------------");
        Response<List<PostResponse>> postPesponses = api.posts(null).execute();
        System.out.println(postPesponses.isSuccessful());
        System.out.println(postPesponses.code());
        System.out.println(postPesponses.headers());
        List<PostResponse> posts =  postPesponses.body();
        System.out.println(posts);

        System.out.println("");
        System.out.println("POST: /posts -----------------");
        PostCreateRequest createRequest = new PostCreateRequest();
        createRequest.setBody("create");
        createRequest.setTitle("create");
        createRequest.setUserId(1);
        PostResponse postResponseCreate = api.create(createRequest).execute().body();
        System.out.println(postResponseCreate);

        System.out.println("");
        System.out.println("PUT: /posts -----------------");
        PostUpdateRequest updateRequest = new PostUpdateRequest();
        updateRequest.setBody("update");
        updateRequest.setTitle("update");
        updateRequest.setUserId(1);
        updateRequest.setId(1);
        PostResponse postResponseUpdate = api.update(1, updateRequest).execute().body();
        System.out.println(postResponseUpdate);


       System.out.println("");
       System.out.println("DELETE: /posts -----------------");
       Integer code = api.delete(1).execute().code();
       System.out.println(code);
    }

}
