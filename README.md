[![Published on Vaadin  Directory](https://img.shields.io/badge/Vaadin%20Directory-published-00b4f0.svg)](https://vaadin.com/directory/component/canvas)
[![Stars on Vaadin Directory](https://img.shields.io/vaadin-directory/star/canvas.svg)](https://vaadin.com/directory/component/canvas)

# HTML5 Canvas add-on for Vaadin
This is a Vaadin add-on that adds support for the HTML5 canvas. You add the `Canvas` component to your Vaadin UI, and can then draw on it using the Java API from your server-side code.

## Features

* Most of the [HTML5 Canvas API](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API)
* Mouse move and click events

## Downloads
Sources are available here, and you can download the add-on package from the [Vaadin add-on Directory](https://vaadin.com/addon/canvas).

Versions are available for both Vaadin 7 and 8.

## Development
Clone the repo and start the demo with:
```bash
$ mvn jetty:run
```

Then you can just point your browser at [http://localhost:8080](http::localhos:8080) to see it in action.

## Compatibility
This add-on is compatible with Vaadin 7. A canvas add-on for Vaadin 6 is available [here](https://vaadin.com/addon/canvaswidget).

## Installation
To install the add-on to your Vaadin project just copy the JAR file from [Vaadin Directory](https://vaadin.com/addon/canvas), and compile your widgetset (more details [here](https://vaadin.com/directory/help/using-vaadin-add-ons)).

Alternatively you can add the add-on to your project using Maven (see the Maven POM snippet required from [Vaadin Directory](https://vaadin.com/addon/canvas)).

## Basic Usage
Here is a trivial Vaadin application that uses the add-on:
```java
@SuppressWarnings("serial")
@Theme("valo")
@Widgetset("org.vaadin.hezamu.canvas.CanvasWidgetset")
public class Demo extends UI {
	private Canvas canvas;

	@WebServlet(value = { "/*", "/VAADIN/*" }, asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = Demo.class)
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
```

## Mouse events
The `Canvas` component supports listening to mouse move, up and down events within the canvas area. Unfortunately the HTML5 Canvas API doesn't support objects, so you can only find out the coordinates where the click happened. Note that the mouse move listener will not trigger server roundtrips before you register to listen the mouse move events.

You can find out other details related to the click event using the `MouseEventDetails` instance you receive from the listener.

## Working with images
The HTML5 Canvas image support contains a few pitfalls that complicate drawing images to the canvas. In practice, you should ensure that the image has been preloaded to the browser cache before trying to draw it on the `Canvas`.

To make sure that your images are preloaded before drawing you should first tell the component to load your images using the `loadImages(String[] urls)` method, and add a `CanvasImageLoadListener` to the `Canvas`. The listener will notify you when the images have been loaded, and you can start issuing `drawImage()` commands that work with the preloaded images.
