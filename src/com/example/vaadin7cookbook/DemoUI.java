package com.example.vaadin7cookbook;

import com.example.vaadin7cookbook.chapter7.CrudForm;
import com.example.vaadin7cookbook.chapter9.demo4.crud.CRUD;
import com.example.vaadin7cookbook.chapter9.demo5.fltering.FilteredTable;
import com.example.vaadin7cookbook.demo.MyView;
import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("vaadin7cookbook")
public class DemoUI extends UI {

	@Override
	protected void init(VaadinRequest request) {
		//Chapter7
		//Demo7 CRUD Form
		//this.setContent(new CrudForm());
		
		//Chapter9 
		//Demo4 CRUD
		//this.setContent(new CRUD());
		//Demo5 Filtering
		//this.setContent(new FilteredTable());
		
		
		this.setContent(new MyView());
		
	}

}