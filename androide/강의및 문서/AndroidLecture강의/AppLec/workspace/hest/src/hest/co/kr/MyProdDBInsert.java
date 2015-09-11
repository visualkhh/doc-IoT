package hest.co.kr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MyProdDBInsert extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.my_prod_db_insert);
		final EditText prod_code = (EditText) findViewById(R.id.et_prod_code);
		final EditText prod_name = (EditText) findViewById(R.id.et_prod_name);
		Button btn_ok = (Button) findViewById(R.id.btn_ok);
		btn_ok.setOnClickListener(new OnClickListener() {
			public void onClick(View arg0) {
				Intent intent = new Intent(Intent.ACTION_INSERT);
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
