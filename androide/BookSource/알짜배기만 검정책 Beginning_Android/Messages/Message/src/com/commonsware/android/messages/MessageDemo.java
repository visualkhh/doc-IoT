/***
	Copyright (c) 2008-2009 CommonsWare, LLC
	
	Licensed under the Apache License, Version 2.0 (the "License"); you may
	not use this file except in compliance with the License. You may obtain
	a copy of the License at
		http://www.apache.org/licenses/LICENSE-2.0
	Unless required by applicable law or agreed to in writing, software
	distributed under the License is distributed on an "AS IS" BASIS,
	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
	See the License for the specific language governing permissions and
	limitations under the License.
*/

package com.commonsware.android.messages;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MessageDemo extends Activity implements View.OnClickListener {
	Button alert;
	Button toast;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		
		setContentView(R.layout.main);
		
		alert=(Button)findViewById(R.id.alert);
		alert.setOnClickListener(this);
		toast=(Button)findViewById(R.id.toast);
		toast.setOnClickListener(this);
	}
	
	public void onClick(View view) {
		if (view==alert) {
			new AlertDialog.Builder(this)
				.setTitle("대화 상자")
				.setMessage("안녕하세요!")
				.setNeutralButton("닫기", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dlg, int sumthin) {
						// 기본적으로 창은 닫히고, 추가 작업은 없다.
					}
				})
				.show();
		}
		else {
			Toast
				.makeText(this, "토스트 메시지", Toast.LENGTH_SHORT)
				.show();
		}
	}
}