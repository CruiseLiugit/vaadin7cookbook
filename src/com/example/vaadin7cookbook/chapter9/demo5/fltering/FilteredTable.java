package com.example.vaadin7cookbook.chapter9.demo5.fltering;

import com.vaadin.data.Container.Filter;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.data.util.filter.Compare.Greater;
import com.vaadin.event.FieldEvents.TextChangeEvent;
import com.vaadin.event.FieldEvents.TextChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class FilteredTable extends CustomComponent {

	private BeanItemContainer<Product> container = new BeanItemContainer<Product>(Product.class);
	//itemID
	private static final Object[] COLUMN_IDS = new Object[] { "id", "name", "price" };
	//每列宽度
	private static final int[] COLUMN_WIDTHS = { 50, 100, 70 };
	//间隙
	private static final int COLUMN_SPACE = 13;

	public FilteredTable() {		
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		
		Table table = new Table();
		layout.addComponent(createFilters(table));

		fillContainer(container);
		table.setPageLength(table.size());
		table.setContainerDataSource(container);
		layout.addComponent(table);
	}

	
	private HorizontalLayout createFilters(final Table table) {
		HorizontalLayout filtersLayout = new HorizontalLayout();
		int i = 0;
		for (final Object columnID : COLUMN_IDS) {
			int columnWidth = COLUMN_WIDTHS[i++];            //列宽
			table.setColumnWidth(columnID, columnWidth);     //设置列宽
			final TextField field = new TextField();         //创建文本框跟列宽一致
			field.setWidth(columnWidth + COLUMN_SPACE, Unit.PIXELS);
			
			if ("id".equals(columnID)) {
				field.setConverter(Integer.class);
			}
			field.addTextChangeListener(new TextChangeListener() {
				@Override
				public void textChange(TextChangeEvent event) {
					filterTable(table, columnID, event.getText());
				}
			});

			filtersLayout.addComponent(field);
		}
		return filtersLayout;
	}

	private void filterTable(Table table, Object columnID, String value) {
		container.removeContainerFilters(columnID);	

		if ("id".equals(columnID)) {
			try {
				Filter greater = new Greater(columnID, new Integer(value));
				container.addContainerFilter(greater);				
			} catch (NumberFormatException e) {
				if (!value.isEmpty()) {
					Notification.show("Cannot filter by value: " + value);
				}
			}
		} else {
			container.addContainerFilter(columnID, value, true, false);
		}
	}

	private void fillContainer(BeanItemContainer<Product> container) {
		int id = 0;
		container.addItem(new Product(id++, "Computer", 599.90));
		container.addItem(new Product(id++, "Phone", 14.5));
		container.addItem(new Product(id++, "Tablet", 99.90));
		container.addItem(new Product(id++, "Mouse", 0.99));
	}
}
