package com.example.tmp_sda_1124.json_excercise_roberto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MainActivity extends AppCompatActivity {

    String colorsdetails;
    String string;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.text);


        string = " [\n" +
                " {\n" +
                "     \"id\": 8787897997879,\n" +
                "     \"text\": \"How do I read JSON on Android?\",\n" +
                "     \"geo\": null,\n" +
                "     \"user\": {\n" +
                "       \"name\": \"android_newb\",\n" +
                "       \"followers_count\": 41\n" +
                "      }\n" +
                "   },\n" +
                "   {\n" +
                "     \"id\": 912345678902,\n" +
                "     \"text\": \"@android_newb just use android.util.JsonReader!\",\n" +
                "     \"geo\": [50.454722, -104.606667],\n" +
                "     \"user\": {\n" +
                "       \"name\": \"jesse\",\n" +
                "       \"followers_count\": 2\n" +
                "     }\n" +
                "   }\n" +
                " ]";

         colorsdetails= " [\n" +
                " {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\" : \"hue\",\n" +
                "   \"type\": \"primary\",\n" +
                "   \"code\": {\n" +
                "     \"rgba\": [255, 255, 255, 1],\n" +
                "     \"hex\": \"#000\"\n" +
                "   }\n" +
                "  },\n" +
                "  {\n" +
                "    \"color\": \"green\",\n" +
                "    \"category\" : \"hue\",\n" +
                "    \"type\": \"secondary\",\n" +
                "    \"code\": {\n" +
                "       \"rgba\": [0, 255, 0, 1],\n" +
                "       \"hex\": \"#0F0\"\n" +
                "     }\n" +
                "   }\n" +
                " ]" ;
        content = " [\n" +
                "  {\n" +
                "   \"color\": \"black\",\n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 255, 1], \n " +
                "   \"hex\": \"#000\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"white\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 0, 1], \n " +
                "   \"hex\": \"#FFF\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"red\", \n" +
                "   \"category\": \"value\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 0, 0, 1], \n " +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"blue\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 0, 255, 1], \n" +
                "   \"hex\": \"#00F\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"yellow\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"primary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [255, 255, 0, 1], \n" +
                "   \"hex\": \"#FF0\" \n" +
                "   }\n" +
                "   }, \n" +
                "   {\n" +
                "   \"color\": \"green\", \n" +
                "   \"category\": \"hue\", \n" +
                "   \"type\": \"secondary\", \n" +
                "   \"code\": {\n" +
                "   \"rgba\": [0, 255, 0, 1], \n" +
                "   \"hex\": \"#0F0\" \n" +
                "   }\n" +
                "   } \n" +
                "  ] ";

    }

    public void list(View view) throws JSONException
    {
        try {
            JSONArray messages = (JSONArray) new JSONTokener(string).nextValue();
            JSONObject message = messages.getJSONObject(0);
            //JSONObject user = message.getJSONObject("text");

            Toast t = Toast.makeText(this, (String)message.get("text"), Toast.LENGTH_SHORT);
            t.show();

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void count(View view) throws JSONException
    {
        try {

            JSONArray colors = (JSONArray) new JSONTokener(colorsdetails).nextValue();
            JSONObject eachcolor =colors.getJSONObject(0);
            JSONObject colorcode = (JSONObject) eachcolor.get("code");
            JSONObject rgba= (JSONObject) colorcode.get("rgba");

            String x=(String)rgba.get(String.valueOf(1));
           // String  = (String) colorcode.get("rgba");

            Toast t = Toast.makeText(this, x, Toast.LENGTH_SHORT);
            t.show();
            } catch (JSONException e) {
            e.printStackTrace();
        }
    }


}
