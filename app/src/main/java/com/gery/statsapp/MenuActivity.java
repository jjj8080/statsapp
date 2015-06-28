package com.gery.statsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MenuActivity extends Activity
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.menu);
	    
	    Button flowChartButton = (Button)findViewById(R.id.button1);
        flowChartButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		Intent intent = new Intent(MenuActivity.this, MainActivity.class);
        		startActivity(intent);
        	}
        });
        
        Button definitions = (Button)findViewById(R.id.button2);
        definitions.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		Intent intent = new Intent(MenuActivity.this, DefinitionsActivity.class);
        		startActivity(intent);
        	}
        });
        
        Button glossary = (Button)findViewById(R.id.glossary);
        glossary.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		Intent intent = new Intent(MenuActivity.this, GlossaryActivity.class);
        		startActivity(intent);
        	}
        });
        
        Button aboutUs = (Button)findViewById(R.id.button3);
        aboutUs.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		Intent intent = new Intent(MenuActivity.this, AboutUsActivity.class);
        		startActivity(intent);
        	}
        });
	}
	
}
