package es.source.code.activity;

import android.content.Context;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;

import es.source.code.model.Food;

public class SCOSDataBase {
    private Context context;
    public SCOSDataBase(Context context)
    {
        this.context = context;
    }
    public void save(String data){
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try{
            out = context.openFileOutput("data",Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(data);
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
    public String load(){
        FileInputStream in =null;
        BufferedReader reader = null;
        StringBuilder content = new StringBuilder();
        try{
            in = context.openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while((line = reader.readLine())!=null){
                content.append(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(reader!=null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return content.toString();
    }

}
