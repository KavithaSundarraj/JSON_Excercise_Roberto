package com.example.tmp_sda_1124.json_excercise_roberto;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

/**
 * Class to perform excercise on JSON serialization and Deserialization
 */
public class MainActivity extends AppCompatActivity {

    String colorsdetails;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // UI
        textView = (TextView) findViewById(R.id.text);
        textView.setMovementMethod(new ScrollingMovementMethod());

        // String contains JSON structure
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
    }

   /* When the user clicks “count”, the application processes the JSON data and writes into the textView the number of colors
    having green component equal to 255.*/

    public void count(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(colorsdetails).nextValue();
            int count=0;
            for(int i=0;i<colors.length();i++) {
                JSONObject eachcolor = colors.getJSONObject(i);
                JSONObject colorcode = eachcolor.getJSONObject("code");
                JSONArray rgba = (JSONArray) colorcode.get("rgba");
                String y = Integer.toString(rgba.getInt(1));
                if (y.equals("255"))
                    count++;
            }
            textView.setText(Integer.toString(count));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /*When the user clicks “list”, the application processes the JSON data and writes into the textView a string consisting of
    the concatenation of the color field (i.e. black) of the colors having green component equal to 255.
    */
    public void list(View view) throws JSONException
    {
        try {
            JSONArray colors = (JSONArray) new JSONTokener(colorsdetails).nextValue();
            String text="";
            for(int i=0;i<colors.length();i++) {
                JSONObject eachcolor = colors.getJSONObject(i);
                JSONObject colorcode = eachcolor.getJSONObject("code");
                JSONArray rgba = (JSONArray) colorcode.get("rgba");
                String y = Integer.toString(rgba.getInt(1));
                if (y.equals("255"))
                    text+=" "+(String)eachcolor.get("color");
            }
            textView.setText(text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    /*When the user clicks on “modify”, the application modifies the JSON data, adding a new color (color:
            orange, category: hue, rgba: 255,165,1,0 hex: #FA0), then serializes the JSON data to a string and
             writes it into the textView.*/

    public void modify(View view) throws JSONException
    {
        try {

            JSONArray colors = (JSONArray) new JSONTokener(colorsdetails).nextValue();
            JSONObject eachcolor = new JSONObject();
            eachcolor.put("color", "orange");
            eachcolor.put("category","hue");
            JSONObject code = new JSONObject();
            JSONArray rgba=new JSONArray();
            rgba.put(255);
            rgba.put(165);
            rgba.put(1);
            rgba.put(0);
            code.put("rgba",rgba);
            code.put("hex","#FA0");
            eachcolor.put("code", code);
            colors.put(eachcolor);
            textView.setText(colors.toString(2));

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
