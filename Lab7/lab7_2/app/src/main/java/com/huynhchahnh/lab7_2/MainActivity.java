package com.phamtung230801.lab7_2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity{

    private static final String FILE_NAME = "example.txt";


    Button btSaveExternal, btLoadExternal,btSaveInternal,btLoadInternal;
    EditText editText;
    TextView contentLoad;
    String filename = "";
    String filepath = "";
    String fileContent = "";


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLoadExternal = findViewById(R.id.btnReadExternal);
        btSaveExternal = findViewById(R.id.btnWriteExternal);
        btSaveInternal = findViewById(R.id.btnWriteInternal);
        btLoadInternal = findViewById(R.id.btnReadInternal);
        editText  = findViewById(R.id.edtContent);
        contentLoad = findViewById(R.id.textViewContent);

        filename = "myFile.txt";
        filepath = "MyFileDir";

        if(!isExternalStorageAvailableForRW()){
            btSaveExternal.setEnabled(false);
        }

        btSaveInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save(v);
            }
        });
        btLoadInternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load(v);
            }
        });

        btSaveExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contentLoad.setText("");
                fileContent = editText.getText().toString().trim();
                if (!fileContent.equals("")){
                    File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(myExternalFile);
                        fos.write(fileContent.getBytes());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    editText.setText("");
                    Toast.makeText(MainActivity.this,"information save to DS card. ",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this,"Text field can not be empty. ",Toast.LENGTH_SHORT).show();

                }
            }
        });

        btLoadExternal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileReader fr = null;
                File myExternalFile = new File(getExternalFilesDir(filepath),filename);
                StringBuilder stringBuilder = new StringBuilder();
                try {
                    fr = new FileReader(myExternalFile);
                    BufferedReader br = new BufferedReader(fr);
                    String line = br.readLine();
                    while (line != null){
                        stringBuilder.append(line).append('\n');
                        line = br.readLine();
                    }
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                finally {
                    String fileContents = "EXTERNAL: \n"+stringBuilder.toString();
                    contentLoad.setText(fileContents);
                }
            }
        });
    }

    private boolean isExternalStorageAvailableForRW() {
        String exStorageState = Environment.getExternalStorageState();
        if (exStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }

    public void save(View view){
        String text = editText.getText().toString();
        FileOutputStream  fos = null;

        try {
            fos = openFileOutput(FILE_NAME,MODE_PRIVATE);
            fos.write(text.getBytes());

            editText.getText().clear();
            Toast.makeText(MainActivity.this,"Save to "+getFilesDir() + "/" + FILE_NAME,Toast.LENGTH_SHORT).show();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public void load(View view){
        FileInputStream fis = null;
        try {
            fis = openFileInput(FILE_NAME);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String text;

            while ((text = br.readLine()) != null){
                sb.append(text).append("\n");
            }

            contentLoad.setText("INTERNAL: \n"+sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}