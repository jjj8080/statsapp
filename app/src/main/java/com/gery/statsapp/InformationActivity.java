package com.gery.statsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InformationActivity extends Activity {
	
	 protected void onCreate(Bundle savedInstanceState) 
	 {
	        super.onCreate(savedInstanceState);
	        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	        setContentView(R.layout.information_page);
	        
	        ImageView backButton = (ImageView)findViewById(R.id.backButton);
	        backButton.setOnClickListener(new View.OnClickListener()
	        {
	        	@Override
	        	public void onClick(View view)
	        	{
	        		finish();
	        	}
	        });
	        
	        TextView glossaryButton = (TextView)findViewById(R.id.textView3);
	        glossaryButton.setOnClickListener(new View.OnClickListener()
	        {
	        	@Override
	        	public void onClick(View view)
	        	{
	        		Intent intent = new Intent(InformationActivity.this, GlossaryActivity.class);
	        		startActivity(intent);
	        	}
	        });
	        
	        TextView info = (TextView)findViewById(R.id.textView1);
	        info.setText(Html.fromHtml(getIntent().getExtras().getString("Explanation")));      
	        
	        TextView title = (TextView)findViewById(R.id.textView2);
	        title.setText(getIntent().getExtras().getString("Title"));
	        
	        if(title.getText().length() > 16) title.setTextSize(16);
	        
	        String result = getIntent().getExtras().getString("GlossaryActive");
	        if(result != null)
	        {
	        	glossaryButton.setVisibility(View.GONE);
	        }
	 }
	 

}
