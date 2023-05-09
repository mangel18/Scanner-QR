package edu.iest.scanner_qr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView tvContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.tvContenido = findViewById(R.id.tvContenido);
    }

    ///MÉTODO ON CLICK
    public void onClick(View view) {
        if (view.getId()==R.id.bnScanner){
            new IntentIntegrator(this).initiateScan();
        }
    }

    //LLAMAR MÉTODO RESULT
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //LLAMAR A LA INFORMACIÓN
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);

        //OBTENER LA INFORMACIÓN DE UN STRING
        String datos = result.getContents();
        tvContenido.setText(datos);
    }
}