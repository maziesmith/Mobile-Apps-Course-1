package com.jasdeleon.chinesehoroscope;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.TextView;

public class Horoscope extends AppCompatActivity {

    private TextView titleTextView;
    private ImageView imageSign;
    private TextView horoscopeTextView;
    public static final String TITLE_EXTRA = "title";
    public static final String IMAGE_EXTRA = "image";
    public static final String CONTENT_EXTRA = "horoscope";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);
        Bundle extras = getIntent().getExtras();
        titleTextView = (TextView) findViewById(R.id.tvTitulo);
        imageSign = (ImageView) findViewById(R.id.imgSigno);
        horoscopeTextView = (TextView) findViewById(R.id.tvHoroscopo);

        String title = extras.getString(TITLE_EXTRA);
        int image = extras.getInt(IMAGE_EXTRA);
        String horoscope = extras.getString(CONTENT_EXTRA);

        titleTextView.setText(title);
        imageSign.setImageResource(image);
        AssetHelper helper = new AssetHelper(this, horoscope);

        horoscopeTextView.setText(Html.fromHtml(helper.loadData()));


    }
}
