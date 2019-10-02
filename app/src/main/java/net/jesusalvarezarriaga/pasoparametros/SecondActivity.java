package net.jesusalvarezarriaga.pasoparametros;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.Serializable;

public class SecondActivity extends AppCompatActivity {

    Intent i;
    Button btn;
    EditText txtUsuario, txtEmail, txtTwitter, txtTelefono, txtFechaNacimiento;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn = findViewById(R.id.btnGuardar);
        txtUsuario = findViewById(R.id.txtUsuario);
        txtEmail = findViewById(R.id.txtEmail);
        txtTwitter = findViewById(R.id.txtTwitter);
        txtTelefono = findViewById(R.id.txtTelefono);
        txtFechaNacimiento = findViewById(R.id.txtFechaNacimiento);

        //Contacto nuevoContacto = null;
        i = getIntent();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(txtUsuario.getText().toString()) &&
                        TextUtils.isEmpty(txtEmail.getText().toString()) &&
                        TextUtils.isEmpty(txtTwitter.getText().toString()) &&
                        TextUtils.isEmpty(txtTelefono.getText().toString()) &&
                        TextUtils.isEmpty(txtFechaNacimiento.getText().toString())) {
                    Toast.makeText(SecondActivity.this,
                            "No debe dejar ningún campo sin llenar", Toast.LENGTH_LONG).show();
                } else {
                    //Intent intent = new Intent(SecondActivity.this, MainActivity.class);

                    //nuevoContacto.setUsuario(txtUsuario.getText().toString());

                    //intent.putExtra("usuario", txtUsuario.getText());
                    //intent.putExtra("email", txtEmail.getText());
                    //intent.putExtra("twitter", txtTwitter.getText());
                    //intent.putExtra("telefono", txtTelefono.getText());
                    //intent.putExtra("fechaNacimiento", txtFechaNacimiento.getText());

                    /*intent.putExtra("contacto",
                            nuevoContacto = new Contacto(
                                    txtUsuario.getText().toString(),
                                    txtEmail.getText().toString(),
                                    txtTwitter.getText().toString(),
                                    Long.parseLong(txtTelefono.getText().toString()),
                                    Date.valueOf(txtFechaNacimiento.getText().toString())));*/
                    enviarContacto();
                    setResult(MainActivity.RESULT_OK, i);
                    finish();
                }
            }
        });
    }

    public void enviarContacto() {
        //Intent i = new Intent();
        Contacto nuevoContacto = new Contacto(
                txtUsuario.getText().toString(),
                txtEmail.getText().toString(),
                txtTwitter.getText().toString(),
                txtTelefono.getText().toString(),
                txtFechaNacimiento.getText().toString());

        //Intent enviar = new Intent(SecondActivity.this, MainActivity.class);
        Bundle b = new Bundle();
        //b.putSerializable("Serializable", nuevoContacto);
        b.putParcelable("Parcelable", nuevoContacto);
        //enviar.putExtras(b);
        i.putExtras(b);
        //startActivity(enviar);
    }
}
