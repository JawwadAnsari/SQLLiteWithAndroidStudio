package com.example.vc.sqllitewithandroidstudio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Database_Helper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new Database_Helper(this);
        Adddata();
    }


    public void Adddata()
    {
        final EditText n = (EditText)findViewById(R.id.editText5);
        final EditText f = (EditText)findViewById(R.id.editText6);
        final EditText s = (EditText)findViewById(R.id.editText7);
        final Button btn = (Button)findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                    boolean temp =  myDb.onAdd(n.getText().toString(),f.getText().toString(),s.getText().toString());
                                    if(temp == true)
                                    {
                                        Toast.makeText(MainActivity.this, "Data successfully Inserted", Toast.LENGTH_LONG).show();

                                    }
                                       else

                                    {
                                        Toast.makeText(MainActivity.this, "Failed Inserted", Toast.LENGTH_LONG).show();

                                    }

                                   }
                               }
        );
    }


}
