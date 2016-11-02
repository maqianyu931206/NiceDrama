package com.maqianyu.nicedrama.myset.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.WriterException;
import com.karics.library.zxing.android.CaptureActivity;
import com.karics.library.zxing.encode.CodeCreator;
import com.maqianyu.nicedrama.Tools.AbsActivity;
import com.maqianyu.nicedrama.R;
import com.maqianyu.nicedrama.Tools.TitleBuilder;
import com.maqianyu.nicedrama.Tools.Values;
import com.maqianyu.nicedrama.myset.view.ArcMenuView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by dllo on 16/10/17.
 * 扫描二维码页面
 * @author 庞美
 */
public class ScanActivity extends AbsActivity {
    private Bitmap bitmap = null;

    ImageView qrCodeImage;
    EditText qrCodeUrl;

    private ArcMenuView arcMenuView;

    @Override
    protected int setLayout() {
        return R.layout.activity_scan_code;
    }

    @Override
    protected void initViews() {
        qrCodeImage = byView(R.id.ECoder_image);
        qrCodeUrl = byView(R.id.ECoder_input);
        arcMenuView = byView(R.id.arcmenu2);

    }

    @Override
    protected void initDatas() {

        qrCodeUrl.setVisibility(View.INVISIBLE);
        arcMenuView.setOnMenuItemClickListener(new ArcMenuView.OnMenuItemClickListener() {
            @Override
            public void onClick(View view, int pos) {
                //1  保存    2  扫描     3 生成     4写地址
                if (pos == 1) {
                    saveQrCodePicture(bitmap);
                } else if (pos == 2) {
                    Intent intent = new Intent(ScanActivity.this, CaptureActivity.class);
                    startActivityForResult(intent, Values.REQUEST_CODE_SCAN);
                } else if (pos == 3) {
                    String url = qrCodeUrl.getText().toString();
                    try {
                        bitmap = CodeCreator.createQRCode(url);
                        qrCodeImage.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                } else if (pos == 4) {
                    qrCodeUrl.setVisibility(View.VISIBLE);
                    qrCodeUrl.setText("");
                }
            }
        });
        new TitleBuilder(this).setTitle("扫一扫").setBackImgGone(false).setMoreImg(false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 扫描二维码/条码回传
        if (requestCode == Values.REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                String content = data.getStringExtra(Values.DECODED_CONTENT_KEY);
                Bitmap bitmap = data.getParcelableExtra(Values.DECODED_BITMAP_KEY);
                qrCodeImage.setImageBitmap(bitmap);
                /**
                 * 跳转到该地址
                 */
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
        final File qrImage = new File(Environment.getExternalStorageDirectory(), qrCodeUrl.getText().toString() + ".jpg");
        if (qrImage.exists()) {
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
        if (bitmap == null) {
            Toast.makeText(this, R.string.scan_none_img, Toast.LENGTH_SHORT).show();
            return;
        }
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
        try {
            fOut.flush();
            fOut.close();
            Toast.makeText(this, R.string.scan_save_finish, Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
