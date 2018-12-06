package com.melevo.arvin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
package com.melevo.arvin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{

    EditText editText;
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.editText);
        editText = (EditText) findViewById(R.id.editText2);
        editText = (EditText) findViewById(R.id.editText3);
        textView = (TextView) findViewById(R.id.textview);
        textView = (TextView) findViewById(R.id.textview2);
        textView = (TextView) findViewById(R.id.textview3);
    }

    public void Search(View view)
    {
        String Search = editText.getText().toString();
        String file_name = "hello_file";
        try {
            FileOutputStream fileOutputStream = openFileOutput(file_name, MODE_PRIVATE);
            fileOutputStream.write(Search.getBytes());
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "Message Saved", Toast.LENGTH_LONG).show();
            editText.setText("");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Save(View view)
    {
        try
        {
            String Search;
            FileInputStream fileInputStream = openFileInput("hello_file");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            Buffered    Reader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            while ((Search=bufferedReader.readLine()) !=null)
            {
                stringBuffer.append(Search + "\n");
            }
            textView.setText(stringBuffer.toString());
            textView.setVisibility(View.VISIBLE);
        }

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
