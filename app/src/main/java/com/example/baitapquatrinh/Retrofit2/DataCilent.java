package com.example.baitapquatrinh.Retrofit2;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface DataCilent {
    // Gửi dạng file
    @Multipart
    @POST("upaloadImage.php")
    Call<String> upLoadPhoto(@Part MultipartBody.Part partPhoto);
    // Gủi dạng chuỗi
    @FormUrlEncoded
    @POST("insertNote.php")
    Call<String> insertDataNote(@Field("id") int id,
                                @Field("title") String title,
                                @Field("content") String content,
                                @Field("date") String date,
                                @Field("time") String time,
                                @Field("upload") String upload);
    @FormUrlEncoded
    @POST("updateNote.php")
    Call<String> updateDataNote(@Field("id") int id,
                                @Field("title") String title,
                                @Field("content") String content,
                                @Field("date") String date,
                                @Field("time") String time,
                                @Field("upload") String upload);
    @FormUrlEncoded
    @POST("deleteNote.php")
    Call<String> removeDataNote(@Field("id") int id);
}
