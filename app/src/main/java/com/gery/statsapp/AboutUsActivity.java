package com.gery.statsapp;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutUsActivity extends Activity 
{
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
	    this.requestWindowFeature(Window.FEATURE_NO_TITLE);
	    setContentView(R.layout.about_us);
	    
	    ImageView backButton = (ImageView)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		finish();
        	}
        });
	    
	    TextView text = (TextView)findViewById(R.id.textView1);
	    text.setText(Html.fromHtml(
	    			"<b>WhatStat</b><br/><br/>" +
	    			"You have a research question, you have some hypotheses, and you have collected some data now what?<br/><br/>" +

	    			"<br/><b>What does WhatStat do?</b><br/><br/>" +
	    			"WhatStat is a tool designed to help researchers choose an appropriate inferential statistical test to analyse their data. The app takes users through a series of questions and scenarios to identify the appropriate analysis according to study design, sample size, and data features.<br/><br/>" +
	    			"Help in answering questions about data can be obtained at each step by accessing the many help and information buttons embedded in the app. Links and direct access is also available to a glossary of common statistical terms used within the app and within wider applied statistics and research methods literature.<br/><br/>" +

	    			"<br/><b>Who is WhatStat designed for?</b><br/><br/>" +
	    			"Anyone can use WhatStat! If you have some data and you don't know what to do with it, give WhatStat a go. We have tried to make the language and instructions as accessible to a wide audience as possible. Where statistical terminology is used these terms and phrases are explained in the WhatStat glossary, which can be accessed from all app pages.<br/><br/>" +

	    			"<br/><b>Who is behind WhatStat?</b><br/><br/>" +
	    			"WhatStat content was developed within University College London (UCL) by Dr Vicki Aldridge, Eirini Koutoumanou, and Dr Angie Wade, who comprise the Institute of Child Health Centre for Applied Statistics Courses (CASC). The team have extensive experience in teaching applied statistics to non-statisticians across a broad range of skills, experience, and disciplines.<br/><br/>" +

	    			"<br/><b>What if I want more information?</b><br/><br/>" +
	    			"The CASC team run a variety of applied statistics courses throughout the year: all information is available at: <a href = \"http://www.ucl.ac.uk/stats-courses\">www.ucl.ac.uk/stats-courses</a>"));
	    text.setMovementMethod(LinkMovementMethod.getInstance());
	}
}
