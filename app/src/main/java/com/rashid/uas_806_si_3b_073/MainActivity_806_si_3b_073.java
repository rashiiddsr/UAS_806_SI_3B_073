package com.rashid.uas_806_si_3b_073;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity_806_si_3b_073 extends AppCompatActivity {
    EditText jenisKendaraan, rutePerjalanan, jarakTempuh;
    Button prosesHitung;
    String jenis, rute, output;
    int jarak, istirahat, bykIstirahat;
    double hari;
    double pjln, rata, total, jam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_806_si_3b_073);
        jenisKendaraan = findViewById(R.id.etKendaraan_806_si_3b_073);
        rutePerjalanan = findViewById(R.id.etRute_806_si_3b_073);
        jarakTempuh = findViewById(R.id.etJarak_806_si_3b_073);
        prosesHitung = findViewById(R.id.btProses_806_si_3b_073);

        prosesHitung.setOnClickListener(v -> {
            jenis = jenisKendaraan.getText().toString();
            rute = rutePerjalanan.getText().toString();
            jarak = Integer.parseInt(jarakTempuh.getText().toString());

            rata = (double) 50/55; //rata-rata km per menit
            pjln = jarak/rata;
            bykIstirahat = (int) (pjln/48);
            istirahat = 25 * bykIstirahat;
            total = pjln + istirahat;
            jam = total /60;
            hari = jam/24;

            output = "Annisa melakukan perjalanan dari " + rute + " dengan jarak " + jarak + " km" + "\n\n" +
                    "Waktu yang habis diperjalanan : " + pjln + " Menit \n\n" +
                    "Istirahat : " + istirahat + " Menit (Istirahat " + bykIstirahat + " kali)\n\n" +
                    "Total Waktu Perjalanan : " + total + " Menit\n\n" +
                    "Selama : " + jam + " Jam dan/atau " + hari + " Hari";

            new AlertDialog.Builder(this)
                    .setTitle("Hasil Proses")
                    .setIcon(R.mipmap.ic_launcher)
                    .setMessage(output)
                    .setPositiveButton("Ok", null)
                    .create()
                    .show();
        });
    }
}