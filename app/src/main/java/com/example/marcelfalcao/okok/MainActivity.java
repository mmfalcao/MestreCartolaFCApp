package com.example.marcelfalcao.okok;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {
    // Criacao dos objetos
    EditText editEmail;
    EditText editPwd;
    Button btnSend;

    boolean fieldsValidate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Vinculando os Objetos aos IDs
        editEmail = (EditText) findViewById(R.id.editEmail);
        editPwd = (EditText) findViewById(R.id.editPwd);
        btnSend = (Button) findViewById(R.id.btnSend);
        // Validando os campos atraves do button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( editEmail.getText().length() == 0 || editPwd.getText().length() == 0 ){
                    Toast.makeText(getApplication(), "Voce nao digitou Nada, mas Porque?", Toast.LENGTH_LONG).show();
                } else {
                    fieldsValidate = true;
                    Toast.makeText(getApplication(), "Seja Bem Vindo "+editEmail.getText().toString()+"!", Toast.LENGTH_LONG).show();
                    // Limpa os campos
                    editEmail.setText("");
                    editPwd.setText("");

                    Intent dashboard = new Intent(MainActivity.this, DashboardActivity.class);
                    startActivity(dashboard);

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
