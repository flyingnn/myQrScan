package com.example.myqrcode;

//package com.google.zxing.client.androidtest;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class Qrcode extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_qrcode);
		// findViewById(R.id.scan_qr_code).setOnClickListener(scanQRCode);
		findViewById(R.id.bu).setOnClickListener(scanQRCode);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		IntentResult result = IntentIntegrator.parseActivityResult(requestCode,
				resultCode, intent);
		if (result != null) {
			String contents = result.getContents();
			if (contents != null) {
				//showDialog(R.string.result_succeeded, result.toString());
				Log.w("find", result.toString());
			} else {
				//showDialog(R.string.result_failed, getString(R.string.result_failed_why));
				Log.w("find", "not find");
			}
		}
	}

	private final Button.OnClickListener scanQRCode = new Button.OnClickListener() {
		@Override
		public void onClick(View v) {
			IntentIntegrator integrator = new IntentIntegrator(Qrcode.this);
			integrator.initiateScan(IntentIntegrator.QR_CODE_TYPES);
		}
	};

	private void showDialog(int title, CharSequence message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("OK", null);
		builder.show();
	}
}
