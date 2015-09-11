package hest.co.kr;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MyIntentExam extends Activity {
	Button btn;
	Intent intent;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_intent_exam);
		btn = (Button)findViewById(R.id.btn_1);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:010-1234-5678"));
				intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:010-1234-5678"));
				startActivity(intent);
			}
		});
		// 연락처 보기
		btn = (Button)findViewById(R.id.btn_2);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people"));
				intent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts/people"));
				startActivity(intent);
			}
		});		

		// 사진 보기
		btn = (Button)findViewById(R.id.btn_3);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent(Intent.ACTION_VIEW, 
						Uri.parse("content://media/internal/images/media"));
				startActivity(intent);
			}
		});			 
		// 그림파일보기 (file 절대경로)
		btn = (Button)findViewById(R.id.btn_4);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent(Intent.ACTION_VIEW);
				Uri uri = Uri.parse("file:///sdcard/1.jpg");
				intent.setDataAndType (uri, "image/jpg");				
				startActivity(intent);
			}
		});				
		// 음악파일재생 (file 절대경로)
		btn = (Button)findViewById(R.id.btn_5);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent(Intent.ACTION_VIEW);
				Uri uri = Uri.parse("file:///sdcard/1.mp3");
				intent.setDataAndType (uri, "audio/mp3");				
				startActivity(intent);
			}
		});		
		// 오디오 타입을 처리
		btn = (Button)findViewById(R.id.btn_6);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent(Intent.ACTION_GET_CONTENT);
				intent.setType("audio/*");			
				//startActivity(intent);
				startActivity(Intent.createChooser(intent, "선택하세요"));
			}
		});					
		// SMS
		btn = (Button)findViewById(R.id.btn_7);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent (Intent.ACTION_SENDTO, Uri.parse ( "smsto:01012345678"));
				intent.putExtra ( "sms_body", "안녕하세요.");	
				startActivity(intent);
			}
		});				
		
		// MMS
		btn = (Button)findViewById(R.id.btn_8);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				intent = new Intent (Intent.ACTION_SEND);
				intent.putExtra ( "address", "abc@android.com");
				intent.putExtra ( "subject", "요청한 사진입니다.");
				intent.putExtra ( "sms_body", "요청한 사진을 보내드립니다...회신 부탁해요.");
				intent.putExtra (Intent.EXTRA_STREAM, Uri.parse("file:///sdcard/1.jpg"));
				intent.setType("image/*");
				startActivity(intent);
			}
		});			
		
		// 웹사이트
		btn = (Button)findViewById(R.id.btn_9);
		btn.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				//intent = new Intent (Intent.ACTION_VIEW);
				//intent.setData(Uri.parse ("http://d.android.com"));
				intent = new Intent(Intent.ACTION_MAIN);
				intent.addCategory(Intent.CATEGORY_LAUNCHER);
				startActivity(intent);
			}
		});				
	}
}







