package com.gery.statsapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

	public Tree tree, currentTree;
	public TextView question;
	public ImageView backButton;
	public TextView questionButton;
	public Button [] buttons = new Button [3];

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        
        backButton = (ImageView)findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		if(currentTree.parent == null)
        			finish();
        		else
        		{
        			currentTree = currentTree.parent;
        			refresh();
        		}
        	}
        });
        
        generateTree(parseTree());
        currentTree = tree;
        
        question = (TextView)findViewById(R.id.question);
        buttons[0] = (Button)findViewById(R.id.button1);
        buttons[1] = (Button)findViewById(R.id.button2);
        buttons[2] = (Button)findViewById(R.id.button3);
        questionButton = (TextView)findViewById(R.id.questionButton);
        
        
        buttons[0].setOnClickListener(new Button.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		if(currentTree.options.size() == 0)
        		{
                    Intent intent = new Intent(MainActivity.this, MenuActivity.class);
                    startActivity(intent);
        		}
        		else currentTree = currentTree.children.get(0);
        		refresh();
        	}
        });
        
        buttons[1].setOnClickListener(new Button.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		currentTree = currentTree.children.get(1);
        		refresh();
        	}
        });
        
        buttons[2].setOnClickListener(new Button.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		currentTree = currentTree.children.get(2);
        		refresh();
        	}
        });
        
        questionButton.setOnClickListener(new View.OnClickListener()
        {
        	@Override
        	public void onClick(View view)
        	{
        		if(currentTree.options.size() == 0)
        		{
            		Intent intent = new Intent(MainActivity.this, DefinitionsActivity.class);
            		startActivity(intent);
        		}
        		else
        		{
	        		Intent intent = new Intent(MainActivity.this, InformationActivity.class);
	        		intent.putExtra("Explanation", currentTree.information);
	        		intent.putExtra("Title", "What's that?");
	        		startActivity(intent);
        		}
        	}
        });
        
        
        refresh();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    public void generateTree(List <Tree> trees)
    {
    	for(int i = 0; i < trees.size(); i++)
    	{
    		if(trees.get(i).options.size() == 0) trees.get(i).filled = true;
    	}
    	
    	tree = trees.get(0);
    	for(int i = 1; i < trees.size(); i++)
    	{
    		addTree(findNextParent(tree), trees.get(i));
 /*   		current.children.add(trees.get(i));
    		trees.get(i).parent = current;
    		if(trees.get(i).options.size() > 0)
    			current = trees.get(i);
    		if(current.options.size() == current.children.size())
    			current = current.parent;*/
    	}
    }
    
    public Tree findNextParent(Tree current)
    {
    	if(current.children.size() == 0)
    	{
    		return current;
    	}
    	else
    	{
    		if(current.children.get(current.children.size() - 1).filled)
    		{
    			return current;
    		}
    		return findNextParent(current.children.get(current.children.size() - 1));
    	}
    }
    
    public void addTree(Tree parent, Tree child)
    {
    	parent.children.add(child);
    	child.parent = parent;
    	fillUpTree(parent);
    }
    
    public void fillUpTree(Tree current)
    {
    	if(current.options.size() == current.children.size())
    	{
			boolean success = true;
			for(int i = 0; i < current.children.size(); i++)
			{
				if(!current.children.get(i).filled) success = false;
			}
			if(success) 
			{
				current.filled = true;
				if(current.parent != null) fillUpTree(current.parent);
			}
    	}
    }
    
    public List<Tree> parseTree()
    {
    	List <Tree> trees = new ArrayList <Tree> ();
    	String temp;
    	
    	try {
    		XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
    		factory.setNamespaceAware(true);
    		XmlPullParser xpp = factory.newPullParser();
    		InputStream fIn = getAssets().open("flowchart.xml"); 
    		InputStreamReader isr = new InputStreamReader(fIn);
    		xpp.setInput(isr);
    		int eventType = xpp.getEventType();
    		Tree current = null;
    		while (eventType != XmlPullParser.END_DOCUMENT) {
    			if(eventType == XmlPullParser.START_TAG)
    			{
    				String tagName = xpp.getName();
    				if(tagName.compareTo("tree") == 0)
    					current = new Tree();
    				else if(tagName.compareTo("question") == 0)
    				{
    					xpp.next();
    					current.question = xpp.getText();
    				}
    				else if(tagName.compareTo("option") == 0)
    				{
    					xpp.next();
    					current.options.add(xpp.getText());
    				}
    				else if(tagName.compareTo("information") == 0)
    				{
    					xpp.next();
    					current.information = xpp.getText();
    				}
    			}
    			else if(eventType == XmlPullParser.END_TAG)
    			{
    				if(xpp.getName().compareTo("tree") == 0) 
    					trees.add(current);
    			}
    			eventType = xpp.next();
    		}
    	}
    	catch(Exception e) {}
    	return trees;
    }
    
    public void refresh()
    {
    	int i;
    	question.setText(currentTree.question);
    	for(i = 0; i < currentTree.options.size(); i++)
    	{
    		buttons[i].setVisibility(View.VISIBLE);
    		buttons[i].setText(currentTree.options.get(i));
    	}
    	for(; i < 3; i++)
    		buttons[i].setVisibility(View.GONE);
    	if(currentTree.options.size() == 0)
    	{
    		questionButton.setText("Definitions");
    		buttons[0].setVisibility(View.VISIBLE);
    		buttons[0].setText("Home");
    	}
    	else
    	{
    		questionButton.setText("What's that?");
    	}
    	
    /*	if(currentTree.parent == null)
    		backButton.setVisibility(View.GONE);
    		
    	else 
    		backButton.setVisibility(View.VISIBLE); */
    		
    }
}
