package com.maqianyu.nicedrama.myset;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.karics.library.zxing.android.CaptureActivity;
import com.karics.library.zxing.encode.CodeCreator;
import com.maqianyu.nicedrama.AbsActivity;
import com.maqianyu.nicedrama.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dllo on 16/10/17.
 * 扫描二维码页面
 */
public class ScanActivity extends AbsActivity{

    private static final int REQUEST_CODE_SCAN = 0x0000;

    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private Bitmap bitmap = null;

    //	TextView qrCoded;
    ImageView qrCodeImage;
    Button creator, scanner;
    EditText qrCodeUrl;
    private Button saveBtn;
    @Override
    protected int setLayout() {
        return R.layout.activity_scan_code;
    }

    @Override
    protected void initViews() {
        qrCodeImage = byView(R.id.ECoder_image);
        creator = byView(R.id.ECoder_creator);
        scanner = byView(R.id.ECoder_scaning);
        qrCodeUrl = byView(R.id.ECoder_input);
        saveBtn = byView(R.id.save_img_btn);

    }

    @Override
    protected void initDatas() {
        creator.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String url = qrCodeUrl.getText().toString();
                try {
                    bitmap = CodeCreator.createQRCode(url);
                    qrCodeImage.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }

        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveQrCodePicture(bitmap);
            }
        });

        scanner.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(ScanActivity.this,
                        CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE_SCAN);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {

                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);

//				qrCoded.setText(content);

//				qrCoded.setMovementMethod(LinkMovementMethod.getInstance());
                qrCodeImage.setImageBitmap(bitmap);
                Intent intent = new Intent();
                intent.setData(Uri.parse(content));//Url 就是你要打开的网址
                intent.setAction(Intent.ACTION_VIEW);
                this.startActivity(intent); //启动浏览器
            }
        }

    }


    /**
     * 保存生成的二維碼圖片
     */
    private void saveQrCodePicture(Bitmap bitmap) {
        final File qrImage = new File(Environment.getExternalStorageDirectory(), qrCodeUrl.getText().toString()+".jpg");
        if(qrImage.exists())
        {
            qrImage.delete();
        }
        try {
            qrImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileOutputStream fOut = null;
        try {
            fOut = new FileOutputStream(qrImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(bitmap == null)
        {
//			Toast.makeText(this,R.string.image_not_exist, Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "无图片", Toast.LENGTH_SHORT).show();
            return;
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
        try {
            fOut.flush();
            fOut.close();
            Toast.makeText(this,"完毕", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
