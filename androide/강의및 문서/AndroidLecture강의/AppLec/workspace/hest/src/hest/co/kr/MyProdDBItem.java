package hest.co.kr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MyProdDBItem extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_prod_db_insert);
		final EditText prod_name = (EditText) findViewById(R.id.et_prod_name);
		prod_name.requestFocus();
		final EditText prod_code = (EditText) findViewById(R.id.et_prod_code);
		prod_code.setFocusable(false);
		Intent intent = getIntent();
		final String action = intent.getAction();
		if (Intent.ACTION_PICK.equals(action)) {
			String prod_code_t = intent.getStringExtra(MyProdDBCons.PROD_CODE);
			String prod_name_t = intent.getStringExtra(MyProdDBCons.PROD_NAME);
			prod_code.setText(prod_code_t);
			prod_name.setText(prod_name_t);
		}
		// 삭제
		Button btn_del = (Button) findViewById(R.id.btn_del);
		btn_del.setVisibility(View.VISIBLE);
		btn_del.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_DELETE);
				intent.putExtra(MyProdDBCons.PROD_CODE, prod_code.getText()
						.toString());
				intent.putExtra(MyProdDBCons.PROD_NAME, prod_name.getText()
						.toString());
				intent.setType(MyProdDBCons.CONTENT_TYPE);
				startActivity(intent);
			}
		});
		// 수정
		Button btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_EDIT);
				intent.putExtra(MyProdDBCons.PROD_CODE, prod_code.getText()
						.toString());
				intent.putExtra(MyProdDBCons.PROD_NAME, prod_name.getText()
						.toString());
				intent.setType(MyProdDBCons.CONTENT_TYPE);
				startActivity(intent);
			}
		});

	}
}
