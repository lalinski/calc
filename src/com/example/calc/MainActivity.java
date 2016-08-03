package com.example.calc;



import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements OnClickListener{
	
	private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9;
	private Button btn_point;// 小数点
	private Button btn_divide;// 除以
	private Button btn_multiply;// 乘以
	private Button btn_minus;// 减去
	private Button btn_add;// 加
	private Button btn_equal;// 等于

	private Button btn_clear;
	private Button btn_del;

	private Button leftBracket;
	private Button rightBracket;
	private TextView showview;
	private boolean clear;
	private boolean initial;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.table_calc2);
		
		btn_0 = (Button) findViewById(R.id.btn_0);
		btn_1 = (Button) findViewById(R.id.btn_1);
		btn_2 = (Button) findViewById(R.id.btn_2);
		btn_3 = (Button) findViewById(R.id.btn_3);
		btn_4 = (Button) findViewById(R.id.btn_4);
		btn_5 = (Button) findViewById(R.id.btn_5);
		btn_6 = (Button) findViewById(R.id.btn_6);
		btn_7 = (Button) findViewById(R.id.btn_7);
		btn_8 = (Button) findViewById(R.id.btn_8);
		btn_9 = (Button) findViewById(R.id.btn_9);
		btn_point = (Button) findViewById(R.id.btn_point);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_multiply = (Button) findViewById(R.id.btn_multipy);
		btn_minus = (Button) findViewById(R.id.btn_minus);
		btn_add = (Button) findViewById(R.id.btn_add);
		btn_equal = (Button) findViewById(R.id.btn_equal);

		btn_clear = (Button) findViewById(R.id.btn_clear);
		btn_del = (Button) findViewById(R.id.btn_delete);
		showview = (TextView) findViewById(R.id.textview);
		
		leftBracket = (Button)findViewById(R.id.btn_leftBracket);
		rightBracket = (Button)findViewById(R.id.btn_rightBracket);
		
		btn_0.setOnClickListener(this);
		btn_1.setOnClickListener(this);
		btn_2.setOnClickListener(this);
		btn_3.setOnClickListener(this);
		btn_4.setOnClickListener(this);
		btn_5.setOnClickListener(this);
		btn_6.setOnClickListener(this);
		btn_7.setOnClickListener(this);
		btn_8.setOnClickListener(this);
		btn_9.setOnClickListener(this);

		btn_point.setOnClickListener(this);
		btn_divide.setOnClickListener(this);
		btn_multiply.setOnClickListener(this);
		btn_minus.setOnClickListener(this);
		btn_add.setOnClickListener(this);
		btn_equal.setOnClickListener(this);

		btn_clear.setOnClickListener(this);
		btn_del.setOnClickListener(this);
		
		leftBracket.setOnClickListener(this);
		rightBracket.setOnClickListener(this);
		initial = true;
	}
	public void onClick(View v){
		String str = showview.getText().toString();
		switch(v.getId()){
		case R.id.btn_0:
		case R.id.btn_1:
		case R.id.btn_2:
		case R.id.btn_3:
		case R.id.btn_4:
		case R.id.btn_5:
		case R.id.btn_6:
		case R.id.btn_7:
		case R.id.btn_8:
		case R.id.btn_9:
		case R.id.btn_point:
			if(clear){
				str = "";
				clear = false;
			//	showview.setText("");
			}
			if(initial){
				str = "";
				initial = false;
			}
			showview.setText(str + ((Button)v).getText());
			break;
		case R.id.btn_add:
		case R.id.btn_minus:
		case R.id.btn_multipy:
		case R.id.btn_divide:
		case R.id.btn_leftBracket:
		case R.id.btn_rightBracket:
			showview.setText(str +((Button)v).getText());
			break;
		case R.id.btn_equal:
		
			clear = true;
			calc c = new calc(str);
			double result = c.eval();
			int resultInt = (int)result;
			if(!str.contains("."))
				showview.setText(Integer.toString(resultInt));
			else
				showview.setText(Double.toString(result));
			break;
		case R.id.btn_delete:
			if (str != null && !str.equals("")) {
				str = str.substring(0, str.length() - 1);
				showview.setText(str);
			}
			break;
		case R.id.btn_clear:
			str = "";
			showview.setText(str);
			break;
		}
	}

}
