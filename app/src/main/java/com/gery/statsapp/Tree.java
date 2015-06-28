package com.gery.statsapp;

import java.util.ArrayList;
import java.util.List;

public class Tree {

	public String question;
	public String information;
	public List <String> options = new ArrayList <String> ();
	public List <Tree> children = new ArrayList <Tree> ();
	public Tree parent = null;
	
	boolean filled = false;
	
	public Tree(){}
	
	public Tree(String question, String information, List <String> options, List <Tree> children)
	{
		this.question = question;
		this.information = information;
		this.options = options;
		this.children = children;
	}
	
	
}
