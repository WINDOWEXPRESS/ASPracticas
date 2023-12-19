package com.example.aspracticas.ut03.u3e9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import com.example.aspracticas.R;

public class IntentImplicitos extends AppCompatActivity {

    Button cancion,enviarSMS,enviarEmail,marcarNumero,ubicacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a9_intent_implicitos);

        cancion = findViewById(R.id.u3a9_bt_cancion);
        marcarNumero = findViewById(R.id.u3a9_bt_marcaNumero);
        enviarSMS = findViewById(R.id.u3a9_bt_enviarSMS);
        enviarEmail = findViewById(R.id.u3a9_bt_enviarEmail);
        ubicacion = findViewById(R.id.u3a9_bt_ubicacion);

        cancion.setOnClickListener(v -> {

            Uri uri = Uri.parse("https://youtu.be/7DMF6t77iII?si=X8LZYKs2pKCGdpH0");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);

            /*
            //8.多媒体播放:
            Intent intent = new Intent(Intent.ACTION_VIEW);
            Uri uri = Uri.parse("file:///sdcard/foo.mp3");
            intent.setDataAndType(uri, "audio/mp3");
            startActivity(intent);
            */
        });

        marcarNumero.setOnClickListener(v -> {
            Uri uri = Uri.parse("tel:+34 622333444");
            Intent intent = new Intent(Intent.ACTION_DIAL,uri);
            startActivity(intent);

        });

        enviarSMS.setOnClickListener(v -> {
            /*
            Uri uri = Uri.parse("sms:622331122");
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            startActivity(intent);
            */
            Uri uri = Uri.parse("smsto:10086");
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", "Hello");
            startActivity(intent);
        });
        enviarEmail.setOnClickListener(v -> {
            /*Uri uri = Uri.parse("mailto:770263108czy@gmail.com");
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(intent);*/

            // 给someone@domain.com发邮件发送内容为“Hello”的邮件
            String[] tos = {"1@abc.com"}; // 收件人
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.putExtra(Intent.EXTRA_EMAIL, tos);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Soy titulo");
            intent.putExtra(Intent.EXTRA_TEXT, "Soy texto Hello");
            intent.setType("text/plain");
            startActivity(intent);


            /*
            // 给多人发邮件
            Intent intent=new Intent(Intent.ACTION_SEND);
            String[] tos = {"1@abc.com", "2@abc.com"}; // 收件人
            String[] ccs = {"3@abc.com", "4@abc.com"}; // 抄送
            String[] bccs = {"5@abc.com", "6@abc.com"}; // 密送
            intent.putExtra(Intent.EXTRA_EMAIL, tos);
            intent.putExtra(Intent.EXTRA_CC, ccs);
            intent.putExtra(Intent.EXTRA_BCC, bccs);
            intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
            intent.putExtra(Intent.EXTRA_TEXT, "Hello");
            intent.setType("message/rfc822");
            startActivity(intent);
            */
        });
        ubicacion.setOnClickListener(v -> {

            // Abrir google maps con latitud longitud（北纬，东经）
            Uri uri = Uri.parse("geo:40.402308325420485, -3.706450200622982");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            /*
            // 路径规划：从北京某地（北纬39.9，东经116.3）到上海某地（北纬31.2，东经121.4）
            Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=39.9 116.3&daddr=31.2 121.4");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
            */
        });
    }
}

/*
//===============================================================
//1.拨打电话
// 给移动客服10086拨打电话
Uri uri = Uri.parse("tel:10086");
Intent intent = new Intent(Intent.ACTION_DIAL, uri);
startActivity(intent);

//===============================================================

//2.发送短信
// 给10086发送内容为“Hello”的短信
Uri uri = Uri.parse("smsto:10086");
Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
intent.putExtra("sms_body", "Hello");
startActivity(intent);

//3.发送彩信（相当于发送带附件的短信）
Intent intent = new Intent(Intent.ACTION_SEND);
intent.putExtra("sms_body", "Hello");
Uri uri = Uri.parse("content://media/external/images/media/23");
intent.putExtra(Intent.EXTRA_STREAM, uri);
intent.setType("image/png");
startActivity(intent);

//===============================================================

//4.打开浏览器:
// 打开百度主页
Uri uri = Uri.parse("http://www.baidu.com");
Intent intent  = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);

//===============================================================

//5.发送电子邮件:(阉割了Google服务的没戏!!!!)
// 给someone@domain.com发邮件
Uri uri = Uri.parse("mailto:someone@domain.com");
Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
startActivity(intent);
// 给someone@domain.com发邮件发送内容为“Hello”的邮件
Intent intent = new Intent(Intent.ACTION_SEND);
intent.putExtra(Intent.EXTRA_EMAIL, "someone@domain.com");
intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
intent.putExtra(Intent.EXTRA_TEXT, "Hello");
intent.setType("text/plain");
startActivity(intent);
// 给多人发邮件
Intent intent=new Intent(Intent.ACTION_SEND);
String[] tos = {"1@abc.com", "2@abc.com"}; // 收件人
String[] ccs = {"3@abc.com", "4@abc.com"}; // 抄送
String[] bccs = {"5@abc.com", "6@abc.com"}; // 密送
intent.putExtra(Intent.EXTRA_EMAIL, tos);
intent.putExtra(Intent.EXTRA_CC, ccs);
intent.putExtra(Intent.EXTRA_BCC, bccs);
intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
intent.putExtra(Intent.EXTRA_TEXT, "Hello");
intent.setType("message/rfc822");
startActivity(intent);

//===============================================================

//6.显示地图:
// 打开Google地图中国北京位置（北纬39.9，东经116.3）
Uri uri = Uri.parse("geo:39.9,116.3");
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);

//===============================================================

//7.路径规划
// 路径规划：从北京某地（北纬39.9，东经116.3）到上海某地（北纬31.2，东经121.4）
Uri uri = Uri.parse("http://maps.google.com/maps?f=d&saddr=39.9 116.3&daddr=31.2 121.4");
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);

//===============================================================

//8.多媒体播放:
Intent intent = new Intent(Intent.ACTION_VIEW);
Uri uri = Uri.parse("file:///sdcard/foo.mp3");
intent.setDataAndType(uri, "audio/mp3");
startActivity(intent);

//获取SD卡下所有音频文件,然后播放第一首=-= 
Uri uri = Uri.withAppendedPath(MediaStore.Audio.Media.INTERNAL_CONTENT_URI, "1");
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);

//===============================================================

//9.打开摄像头拍照:
// 打开拍照程序
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
startActivityForResult(intent, 0);
// 取出照片数据
Bundle extras = intent.getExtras();
Bitmap bitmap = (Bitmap) extras.get("data");

//另一种:
//调用系统相机应用程序，并存储拍下来的照片
Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
time = Calendar.getInstance().getTimeInMillis();
intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment
.getExternalStorageDirectory().getAbsolutePath()+"/tucue", time + ".jpg")));
startActivityForResult(intent, ACTIVITY_GET_CAMERA_IMAGE);

//===============================================================

//10.获取并剪切图片
// 获取并剪切图片
Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
intent.setType("image/*");
intent.putExtra("crop", "true"); // 开启剪切
intent.putExtra("aspectX", 1); // 剪切的宽高比为1：2
intent.putExtra("aspectY", 2);
intent.putExtra("outputX", 20); // 保存图片的宽和高
intent.putExtra("outputY", 40);
intent.putExtra("output", Uri.fromFile(new File("/mnt/sdcard/temp"))); // 保存路径
intent.putExtra("outputFormat", "JPEG");// 返回格式
startActivityForResult(intent, 0);
// 剪切特定图片
Intent intent = new Intent("com.android.camera.action.CROP");
intent.setClassName("com.android.camera", "com.android.camera.CropImage");
intent.setData(Uri.fromFile(new File("/mnt/sdcard/temp")));
intent.putExtra("outputX", 1); // 剪切的宽高比为1：2
intent.putExtra("outputY", 2);
intent.putExtra("aspectX", 20); // 保存图片的宽和高
intent.putExtra("aspectY", 40);
intent.putExtra("scale", true);
intent.putExtra("noFaceDetection", true);
intent.putExtra("output", Uri.parse("file:///mnt/sdcard/temp"));
startActivityForResult(intent, 0);

//===============================================================

//11.打开Google Market
// 打开Google Market直接进入该程序的详细页面
Uri uri = Uri.parse("market://details?id=" + "com.demo.app");
Intent intent = new Intent(Intent.ACTION_VIEW, uri);
startActivity(intent);

//===============================================================

//12.进入手机设置界面:
// 进入无线网络设置界面（其它可以举一反三） 
Intent intent = new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS); 
startActivityForResult(intent, 0);

//===============================================================

//13.安装apk:
Uri installUri = Uri.fromParts("package", "xxx", null);
returnIt = new Intent(Intent.ACTION_PACKAGE_ADDED, installUri);

//===============================================================

//14.卸载apk:
Uri uri = Uri.fromParts("package", strPackageName, null);
Intent it = new Intent(Intent.ACTION_DELETE, uri);
startActivity(it);

//===============================================================

//15.发送附件:
Intent it = new Intent(Intent.ACTION_SEND);
it.putExtra(Intent.EXTRA_SUBJECT, "The email subject text");
it.putExtra(Intent.EXTRA_STREAM, "file:///sdcard/eoe.mp3");
sendIntent.setType("audio/mp3");
startActivity(Intent.createChooser(it, "Choose Email Client"));

//===============================================================

//16.进入联系人页面:
Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);
intent.setData(People.CONTENT_URI);
startActivity(intent);

//===============================================================


//17.查看指定联系人:
Uri personUri = ContentUris.withAppendedId(People.CONTENT_URI, info.id);//info.id联系人ID
Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);
intent.setData(personUri);
startActivity(intent);

//===============================================================

//18.调用系统编辑添加联系人（高版本SDK有效）：
Intent it = newIntent(Intent.ACTION_INSERT_OR_EDIT);
it.setType("vnd.android.cursor.item/contact");
//it.setType(Contacts.CONTENT_ITEM_TYPE);
it.putExtra("name","myName");
it.putExtra(android.provider.Contacts.Intents.Insert.COMPANY, "organization");
it.putExtra(android.provider.Contacts.Intents.Insert.EMAIL,"email");
it.putExtra(android.provider.Contacts.Intents.Insert.PHONE,"homePhone");
it.putExtra(android.provider.Contacts.Intents.Insert.SECONDARY_PHONE,"mobilePhone");
it.putExtra( android.provider.Contacts.Intents.Insert.TERTIARY_PHONE,"workPhone");
it.putExtra(android.provider.Contacts.Intents.Insert.JOB_TITLE,"title");
startActivity(it);

//===============================================================

//19.调用系统编辑添加联系人（全有效）：
Intent intent = newIntent(Intent.ACTION_INSERT_OR_EDIT);
intent.setType(People.CONTENT_ITEM_TYPE);
intent.putExtra(Contacts.Intents.Insert.NAME, "My Name");
intent.putExtra(Contacts.Intents.Insert.PHONE, "+1234567890");
intent.putExtra(Contacts.Intents.Insert.PHONE_TYPE,Contacts.PhonesColumns.TYPE_MOBILE);
intent.putExtra(Contacts.Intents.Insert.EMAIL, "com@com.com");
intent.putExtra(Contacts.Intents.Insert.EMAIL_TYPE, Contacts.ContactMethodsColumns.TYPE_WORK);
startActivity(intent);

//===============================================================

//20.打开另一程序
Intent i = new Intent();
ComponentName cn = new ComponentName("com.example.jay.test",
"com.example.jay.test.MainActivity");
i.setComponent(cn);
i.setAction("android.intent.action.MAIN");
startActivityForResult(i, RESULT_OK);

//===============================================================

//21.打开录音机
Intent mi = new Intent(Media.RECORD_SOUND_ACTION);
startActivity(mi);

//===============================================================

//22.从google搜索内容
Intent intent = new Intent();
intent.setAction(Intent.ACTION_WEB_SEARCH);
intent.putExtra(SearchManager.QUERY,"searchString")
startActivity(intent);

//===============================================================

*/