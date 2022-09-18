package com.azhar.sptht.activities;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.azhar.sptht.R;
import com.azhar.sptht.database.DatabaseHelper;

public class DetailPenyakitActivity extends AppCompatActivity {

    SQLiteDatabase sqLiteDatabase;
    DatabaseHelper databaseHelper;
    Toolbar toolbar;
    TextView tvTitle, tvPenjelasan, tvPenanganan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        setStatusBar();

        //set database
        databaseHelper = new DatabaseHelper(this);
        if (databaseHelper.openDatabase())
            sqLiteDatabase = databaseHelper.getReadableDatabase();

        String strKodePenyakit = getIntent().getStringExtra("KODE_PENYAKIT");

        String selectQuery = "SELECT nama_penyakit, deskripsi, penanganan FROM penyakit WHERE kode_penyakit = '" + strKodePenyakit + "'";
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        toolbar = findViewById(R.id.toolbar);
        tvTitle = findViewById(R.id.tvTitle);
        tvPenjelasan = findViewById(R.id.tvPenjelasan);
        tvPenanganan = findViewById(R.id.tvPenanganan);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

        tvTitle.setText(cursor.getString(0));
        tvPenjelasan.setText(cursor.getString(1));
        tvPenanganan.setText(cursor.getString(2));

        cursor.close();
    }

    private void setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }

        if (Build.VERSION.SDK_INT >= 21) {
            setWindowFlag(this, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, false);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    public static void setWindowFlag(Activity activity, final int bits, boolean on) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        if (on) {
            layoutParams.flags |= bits;
        } else {
            layoutParams.flags &= ~bits;
        }
        window.setAttributes(layoutParams);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
