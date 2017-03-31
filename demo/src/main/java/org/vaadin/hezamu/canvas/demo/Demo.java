package org.vaadin.hezamu.canvas.demo;

import javax.servlet.annotation.WebServlet;

import org.vaadin.hezamu.canvas.Canvas.CanvasMouseMoveListener;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

import org.vaadin.hezamu.canvas.Canvas;

@SuppressWarnings("serial")
//@Theme("valo")
//@Widgetset("org.vaadin.hezamu.canvas.demo.DemoWidgetset")
public class Demo extends UI {
	private Canvas canvas;

//	@WebServlet(value = { "/*", "/VAADIN/*" }, asyncSupported = true)
//	@VaadinServletConfiguration(productionMode = false, ui = Demo.class)
	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Demo.class, widgetset = "org.vaadin.hezamu.canvas.demo.DemoWidgetset")
	public static class Servlet extends VaadinServlet {
	}

	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout content = new VerticalLayout();
		setContent(content);

		// Instantiate the component and add it to your UI
		content.addComponent(canvas = new Canvas());

		// Draw a 20x20 filled rectangle with the upper left corner
		// in coordinate 10,10. It will be filled with the default
		// color which is black.
		canvas.fillRect(10, 10, 20, 20);

		canvas.addMouseMoveListener(new CanvasMouseMoveListener() {
			@Override
			public void onMove(MouseEventDetails mouseDetails) {
				System.out.println("Mouse moved at "
						+ mouseDetails.getClientX() + ","
						+ mouseDetails.getClientY());
			}
		});
	}
}
