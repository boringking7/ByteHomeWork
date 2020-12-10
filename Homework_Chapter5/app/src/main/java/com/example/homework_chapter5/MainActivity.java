package com.example.homework_chapter5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getName();
    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api-sjtu-camp.bytedance.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    private GitHubService testService = retrofit.create(GitHubService.class);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnUpload).setOnClickListener(v -> upLoad());
        findViewById(R.id.btnDownload).setOnClickListener(v -> getVideoList());
    }
    private void upLoad() {

        testService.post("777777777777","yf","our sjtu",getMultipartFroAssetImage(),getMultipartFroAssetVideo()).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                if(response.isSuccessful()){
                    Log.d("77777777","写入成功");
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void getVideoList() {
        Call<GetVideoResponse> videoResponseCall = testService.getVideoList();
        videoResponseCall.enqueue(new Callback<GetVideoResponse>() {
            @Override
            public void onResponse(Call<GetVideoResponse> call, Response<GetVideoResponse> response) {
                Log.d(TAG, "onResponse: received");
                Log.d(TAG, "onResponse: " + response.body());
                if (!response.isSuccessful()) {
                    return;
                }
                if(response.isSuccessful()){
                    Log.d("77777777","读取成功");
                }
                final List<VideoModel> list = response.body().getFeeds();
                if (list == null || list.isEmpty()) {
                    return;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < list.size(); i++) {
                    final VideoModel videoModel = list.get(i);
                    stringBuilder.append("student_id：").append(videoModel.getStudentId())
                            .append(", user_name：").append(videoModel.getUserName())
                            .append(", video_url：").append(videoModel.getVideoUrl())
                            .append(", image_url：").append(videoModel.getImageUrl())
                            .append("\n");
                }
                ((TextView) findViewById(R.id.tv)).setText(stringBuilder.toString());
            }

            @Override
            public void onFailure(Call<GetVideoResponse> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t);
                t.printStackTrace();
            }
        });
    }
    //图片转二进制
    private MultipartBody.Part getMultipartFroAssetImage(){
        final String partKey = "cover_image";
        final String localFileName = "pic.png";
        final AssetManager assetManager = getAssets();
        RequestBody requestFile;
        try {
            final InputStream inputStream = assetManager.open(localFileName);
            requestFile = RequestBody
                    .create(MediaType.parse("multipart/form-data"),toByteArray(inputStream));
            return MultipartBody.Part.createFormData(partKey, localFileName, requestFile);
        }catch (IOException e){
            e.printStackTrace();
            return null;//!!!不确定
        }

    }
    //视频转二进制
    private MultipartBody.Part getMultipartFroAssetVideo(){
        final String partKey = "video";
        final String localFileName = "video.mp4";
        final AssetManager assetManager = getAssets();
        RequestBody requestFile;
        try {
            final InputStream inputStream = assetManager.open(localFileName);
            requestFile = RequestBody
                    .create(MediaType.parse("multipart/form-data"),toByteArray(inputStream));
            return MultipartBody.Part.createFormData(partKey, localFileName, requestFile);
        }catch (IOException e){
            e.printStackTrace();
            return null;//!!!不确定
        }

    }
    //转二进制
    private static byte[] toByteArray(InputStream input) throws IOException{
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while(-1 != (n = input.read(buffer))){
            output.write(buffer, 0, n);
        }
        return output.toByteArray();
    }

}