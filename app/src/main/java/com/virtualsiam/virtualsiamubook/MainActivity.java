package com.virtualsiam.virtualsiamubook;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    //Explicit
    private EditText userEditText, passwordEditText;
    private String userString, passwordString;
    private static final String urlJSON = "http://swiftcodingthai.com/25JUN/get_user_master.php";
    private boolean statusABoolean = true;
    private String truePassworString;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Bind Widget
        userEditText = (EditText) findViewById(R.id.editText5);
        passwordEditText = (EditText) findViewById(R.id.editText6);



    } //นี่คือสิ้นสุด เมททอดหลัก main method

    //Inner Class
    private class SynUserTABLE extends AsyncTask<Void, Void, String> {

        @Override
        protected String doInBackground(Void... params) {

            try {

                OkHttpClient okHttpClient = new OkHttpClient();
                Request.Builder builder = new Request.Builder();
                Request request = builder.url(urlJSON).build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();





            } catch (Exception e) {
                Log.d("26June", "e ==> " + e.toString());

                return null;
            }

        }  // doINback

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            Log.d("26June", "JSON ==> " + s);

            try {

                JSONArray jsonArray = new JSONArray(s);

                for (int i=0;i<jsonArray.length();i++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    if (userString.equals(jsonObject.getString("User"))) {

                        statusABoolean = false;
                        truePassworString = jsonObject.getString("Password");


                    } // if



                } // for

                if (statusABoolean) {
                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(MainActivity.this, "ไม่มี User นี้",
                            "ไมมี " + userString + "ในฐานข้อมูลของเรา");

                } else if (passwordString.equals(truePassworString)) {

                    Intent intent = new Intent(MainActivity.this, ShowBookActivity.class);
                    startActivity(intent);
                    finish();

                } else {

                    MyAlert myAlert = new MyAlert();
                    myAlert.myDialog(MainActivity.this, "Password False",
                            "Please Try Again Password False");
                }

            } catch (Exception e) {
                Log.d("26June", "e onPost ==> " + e.toString());

            }


        }  // onPost


    } // class



        public  void clickSignIn(View view) {

            userString = userEditText.getText().toString().trim();
            passwordString = passwordEditText.getText().toString().trim();

            if (userString.equals("") || passwordString.equals("")) {

                MyAlert myAlert = new MyAlert();
                myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกทุกช่องด้วย");

            } else {

                SynUserTABLE synUserTABLE = new SynUserTABLE();
                synUserTABLE.execute();




            }


        }  // clickSign

    public void clickSignUpMain(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }


}// นี่คือสิ้นสุดคลาสหลัก main class การตั้งชื่อคลาสควรมีตัวใหญ่แรก
