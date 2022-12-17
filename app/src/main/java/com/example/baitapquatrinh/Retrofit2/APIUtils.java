package com.example.baitapquatrinh.Retrofit2;

public class APIUtils {
    public static  final  String baseUrl = "http://172.20.10.2:8080/BaiTapQuaTrinh/";
    public  static  DataCilent getData(){
        return  RetrofitCilent.getCilent(baseUrl).create(DataCilent.class);
    }
}
