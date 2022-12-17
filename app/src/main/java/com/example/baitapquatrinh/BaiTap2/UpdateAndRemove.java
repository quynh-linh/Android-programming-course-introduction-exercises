package com.example.baitapquatrinh.BaiTap2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.baitapquatrinh.R;
import com.example.baitapquatrinh.Retrofit2.APIUtils;
import com.example.baitapquatrinh.Retrofit2.DataCilent;

import java.io.File;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateAndRemove extends AppCompatActivity {
    EditText editTextTitle , editTextContent , editTextTime , editTextDate;
    ImageButton imageButtonDate , imageButtonTime , imageButtonChooseFile;
    ImageView imageView;
    Button buttonEdit, buttonRemove;
    String timeTonotify;
    Bitmap bitmap;
    int REQUEST_CODE_IMAGE = 123;
    String real_Path = "";
    String urlrm = "http://172.20.10.2:8080/BaiTapQuaTrinh/deleteNote.php";
    int id =0;
    public void AnhXa(){
        editTextTitle = (EditText) findViewById(R.id.editTextTitle);
        editTextContent = (EditText) findViewById(R.id.editTextDes);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        imageButtonDate = (ImageButton) findViewById(R.id.imageButtonDate);
        imageButtonTime = (ImageButton) findViewById(R.id.imageButtonTime);
        imageButtonChooseFile = (ImageButton) findViewById(R.id.imageButtonUpLoadFile);
        imageView = (ImageView) findViewById(R.id.imageView);
        buttonEdit = (Button) findViewById(R.id.buttonEditNote);
        buttonRemove = (Button) findViewById(R.id.buttonRemove);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updateand_remove_bai_tap2);
        AnhXa();
        Bundle bundle = getIntent().getExtras();
        editTextTitle.setText(bundle.getString("title"));
        editTextContent.setText(bundle.getString("content"));
        editTextDate.setText(bundle.getString("date"));
        editTextTime.setText(bundle.getString("time"));
        id = bundle.getInt("id");
        Glide.with(imageView.getContext()).load(APIUtils.baseUrl+"images/"+bundle.getString("nameImage")).into(imageView);
        imageButtonDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectDate();
            }
        });
        imageButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectTime();
            }
        });
        imageButtonChooseFile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent,REQUEST_CODE_IMAGE);
            }
        });
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNote(id);
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeNote(id);
            }
        });

    }
    public void editNote(int id){
        String title = editTextTitle.getText().toString().trim();
        String date = editTextDate.getText().toString().trim();
        String time = editTextTime.getText().toString().trim();
        String content = editTextContent.getText().toString().trim();
        if (title != "" || date != "" || time != "" || content != "" ){
            // tạo file ảnh
            File file = new File(real_Path);
            String file_path = file.getAbsolutePath();
            // tách file ảnh
            String [] mang_ten_file = file_path.split("\\.");
            // tạo name image new
            file_path = mang_ten_file[0] + System.currentTimeMillis() + "." + mang_ten_file[1];
            // kiểm tra type
            RequestBody requestBody = RequestBody.create(MediaType.parse("multipath/from-data"),file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("upload_file",file_path,requestBody);
            DataCilent dataCilent = APIUtils.getData();
            // up load file ảnh lên folder trong PHP
            Call<String> call = dataCilent.upLoadPhoto(body);
            call.enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                    if (response != null){
                        // message trả về cái tên của file ảnh
                        String message = response.body();
                        if (message.length()>0){
                            DataCilent insert =APIUtils.getData();
                            Call<String> call1 = dataCilent.updateDataNote(id,title,content,date,time,message);
                            call1.enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, retrofit2.Response<String> response) {
                                    String result = response.body();
                                    if (result.trim().equals("success")){
                                        Toast.makeText(UpdateAndRemove.this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                                        // gán thông báo
                                        setAlarm(id,title,date,time);
                                        // sau khi thêm thành công trở lại trang list
                                        startActivity(new Intent(UpdateAndRemove.this,ListNote.class));
                                    } else {
                                        Toast.makeText(UpdateAndRemove.this, "Thêm không thành công", Toast.LENGTH_SHORT).show();
                                        Log.d("Error add", response.message().toString());
                                    }
                                }
                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    Log.d("Error add", t.getMessage().toString());
                                }
                            });
                        }
                    }
                }
                @Override
                public void onFailure(Call<String> call, Throwable t) {
                    Log.d("Error", t.getMessage().toString());
                }
            });
        } else {
            Toast.makeText(UpdateAndRemove.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
        }
    }
    public String getRealPathFromURI (Uri contentUri) {
        String path = null;
        String[] proj = { MediaStore.MediaColumns.DATA };
        Cursor cursor = getContentResolver().query(contentUri, proj, null, null, null);
        if (cursor.moveToFirst()) {
            int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
            path = cursor.getString(column_index);
        }
        cursor.close();
        return path;
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if(requestCode== REQUEST_CODE_IMAGE && resultCode==RESULT_OK && data != null)
        {
            Uri uri =data.getData();
            real_Path = getRealPathFromURI(uri);
            try
            {
                InputStream inputStream=getContentResolver().openInputStream(uri);
                bitmap= BitmapFactory.decodeStream(inputStream);
                imageView.setImageBitmap(bitmap);
            }catch (Exception ex)
            {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
    public void removeNote(int id){
        DataCilent dataCilent = APIUtils.getData();
        Call<String> call = dataCilent.removeDataNote(id);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                String result = response.body();
                if (result.trim().equals("success")){
                    Toast.makeText(UpdateAndRemove.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(UpdateAndRemove.this,ListNote.class));
                } else {
                    Toast.makeText(UpdateAndRemove.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    Log.d("Error remove note",result);
                }
            }
            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });
    }
    public void selectTime() {
        //this method performs the time picker task
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int i, int i1) {
                timeTonotify = i + ":" + i1;
                //temp variable to store the time to set alarm
                editTextTime.setText(FormatTime(i, i1));
                //sets the button text as selected time
            }
        }, hour, minute, false);
        timePickerDialog.show();
    }
    public String FormatTime(int hour, int minute) {
        //this method converts the time into 12hr format and assigns am or pm
        String time;
        time = "";
        String formattedMinute;
        if (minute / 10 == 0) {
            formattedMinute = "0" + minute;
        } else {
            formattedMinute = "" + minute;
        }
        if (hour == 0) {
            time = "12" + ":" + formattedMinute + " AM";
        } else if (hour < 12) {
            time = hour + ":" + formattedMinute + " AM";
        } else if (hour == 12) {
            time = "12" + ":" + formattedMinute + " PM";
        } else {
            int temp = hour - 12;
            time = temp + ":" + formattedMinute + " PM";
        }
        return time;
    }
    public void selectDate() {
        //this method performs the date picker task
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                editTextDate.setText(day + "-" + (month + 1) + "-" + year);
                //sets the selected date as test for button
            }
        }, year, month, day);
        datePickerDialog.show();
    }
    private void setAlarm(int id,String text, String date, String time) {
        try {
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            //chỉ định đối tượng quản lý báo động để đặt báo thức
            Intent intent = new Intent(getApplicationContext(), MyNotificationPublisher.class);
            intent.putExtra("event", text);
            //gửi dữ liệu đến lớp báo động để tạo kênh và thông báo
            intent.putExtra("time", date);
            intent.putExtra("date", time);
            intent.putExtra("content", editTextContent.getText().toString().trim());
            intent.putExtra("id", id);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), id, intent, PendingIntent.FLAG_ONE_SHOT);
            String dateandtime = date + " " + timeTonotify;
            DateFormat formatter = new SimpleDateFormat("d-M-yyyy hh:mm");
            Date date1 = formatter.parse(dateandtime);
            am.set(AlarmManager.RTC_WAKEUP, date1.getTime(), pendingIntent);
            Intent intentBack = new Intent(getApplicationContext(), ListNote.class);
            //ý định này sẽ được gọi sau khi cài đặt báo thức hoàn tất
            intentBack.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intentBack);
            //điều hướng từ việc thêm hoạt động nhắc nhở thành hoạt động
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}