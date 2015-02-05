package com.corpit.edtitext;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

/**
 ***************************************************** 
 * <hr>
 * <dt><span class="strong">类功能简介:</span></dt>
 * <dd>Coffee</dd>
 * <dt><span class="strong">创建时间:</span></dt>
 * <dd>2015-2-5 上午10:01:17</dd>
 * <dt><span class="strong">公司:</span></dt>
 * <dd>设置EdtiText字数并提示剩余字数</dd>
 * 
 * @author aa1000777 - Email:aa1000777@qq.com
 ***************************************************** 
 */

public class Main extends Activity {
	EditText editText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final TextView tv_num;
		final int num = 10;
		editText = (EditText) findViewById(R.id.et_content);
		tv_num = (TextView) findViewById(R.id.tv_num);
		tv_num.setText("10");
		editText.addTextChangedListener(new TextWatcher() {
			private CharSequence temp;
			private int selectionStart;
			private int selectionEnd;

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				temp = s;
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
			}

			@Override
			public void afterTextChanged(Editable s) {
				int number = num - s.length();
				tv_num.setText("" + number);
				selectionStart = editText.getSelectionStart();
				selectionEnd = editText.getSelectionEnd();
				if (temp.length() > num) {
					s.delete(selectionStart - 1, selectionEnd);
					int tempSelection = selectionStart;
					editText.setText(s);
					editText.setSelection(tempSelection);// 设置光标在最后
				}
			}
		});
	}
}