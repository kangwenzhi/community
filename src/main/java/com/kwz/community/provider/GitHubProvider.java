package com.kwz.community.provider;

import com.kwz.community.dto.AccessTokenDTO;


import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GitHubProvider {

    public String GetAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType JSON = MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        String json=null;
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
                return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
