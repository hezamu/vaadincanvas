package org.vaadin.hezamu.canvas;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.hezamu.canvas.client.ui.CanvasClientRpc;
import org.vaadin.hezamu.canvas.client.ui.CanvasServerRpc;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.ui.AbstractComponent;

// TODO: Auto-generated Javadoc
/**
 * HTML5 Canvas add-on for Vaadin 7.
 * 
 * You can issue HTML5 Canvas commands to this component using the server-side
 * API, and they will be transported to the browser and "replayed" there. The
 * API this component provides follows the HTML5 Canvas API as closely as
 * possible.
 * 
 * @author henri@vaadin.com
 */
@SuppressWarnings("serial")
public class Canvas extends AbstractComponent {
	private final List<CanvasClickListener> clickListeners = new ArrayList<CanvasClickListener>();
	private final List<CanvasImageLoadListener> imageLoadListeners = new ArrayList<CanvasImageLoadListener>();
	private final CanvasClientRpc rpc = getRpcProxy(CanvasClientRpc.class);

	/**
	 * Instantiates a new canvas.
	 */
	public Canvas() {
		registerRpc(new CanvasServerRpc() {
			public void clicked(MouseEventDetails med) {
				fireClicked(med);
			}

			public void imagesLoaded() {
				fireImagesLoaded();
			}
		});
	}

	/**
	 * Draw an image, other canvas, or video onto this canvas.
	 * 
	 * @param url
	 *            URL of the image
	 * @param offsetX
	 *            the X coordinate for upper left corner of drawing area
	 * @param offsetY
	 *            the Y coordinate for upper left corner of drawing area
	 */
	public void drawImage1(String url, double offsetX, double offsetY) {
		rpc.drawImage1(url, offsetX, offsetY);
	}

	/**
	 * Draw an image, other canvas, or video onto this canvas.
	 * 
	 * @param url
	 *            URL of the image
	 * @param offsetX
	 *            the X coordinate for upper left corner of drawing area
	 * @param offsetY
	 *            the Y coordinate for upper left corner of drawing area
	 * @param width
	 *            the width of the drawing area
	 * @param height
	 *            the height of the drawing area
	 */
	public void drawImage2(String url, double offsetX, double offsetY,
			double imgWidth, double imgHeight) {
		rpc.drawImage2(url, offsetX, offsetY, imgWidth, imgHeight);
	}

	/**
	 * Draw a portion of an image, other canvas, or video onto this canvas.
	 * 
	 * @param url
	 *            URL of the image
	 * @param sourceX
	 *            the X coordinate of the upper left corner of the area in the
	 *            source image to draw
	 * @param sourceY
	 *            the Y coordinate of the upper left corner of the area in the
	 *            source image to draw
	 * @param sourceWidth
	 *            the width of the area in the source image to draw
	 * @param sourceHeight
	 *            the height of the area in the source image to draw
	 * @param destX
	 *            the X coordinate for upper left corner of drawing area
	 * @param destY
	 *            the Y coordinate for upper left corner of drawing area
	 * @param destWidth
	 *            the width of the drawing area
	 * @param destHeight
	 *            the height of the drawing area
	 */
	public void drawImage3(String url, double sourceX, double sourceY,
			double sourceWidth, double sourceHeight, double destX,
			double destY, double destWidth, double destHeight) {
		rpc.drawImage3(url, sourceX, sourceY, sourceWidth, sourceHeight, destX,
				destY, destWidth, destHeight);
	}

	/**
	 * Draw a "filled" rectangle. The default color of the fill is black. Use
	 * the fillStyle property to set a color, gradient, or pattern used to fill
	 * the drawing.
	 * 
	 * @param startX
	 *            the X coordinate for upper left corner of fill area
	 * @param startY
	 *            the Y coordinate for upper left corner of fill area
	 * @param width
	 *            the width of the fill area
	 * @param height
	 *            the height of the fill area
	 */
	public void fillRect(double startX, double startY, double width,
			double height) {
		rpc.fillRect(startX, startY, width, height);
	}

	/**
	 * Clear the canvas contents.
	 */
	public void clear() {
		rpc.clear();
	}

	/**
	 * Fills the current drawing (path). The default color is black. Use the
	 * fillStyle property to fill with another color/gradient.
	 * 
	 * If the path is not closed, the fill() method will add a line from the
	 * last point to the startpoint of the path to close the path (like
	 * {@link #closePath()}), and then fill the path.
	 */
	public void fill() {
		rpc.fill();
	}

	/**
	 * Draw filled text on the canvas. The default color of the text is black.
	 * 
	 * Use the font property to specify font and font size, and use the
	 * fillStyle property to render the text in another color/gradient.
	 * 
	 * @param text
	 *            the text to drawn
	 * @param x
	 *            the X coordinate of the upper left corner of the drawing area
	 * @param y
	 *            the Y coordinate of the upper left corner of the drawing area
	 * @param maxWidth
	 *            the maximum allowed width of the text, in pixels.
	 */
	public void fillText(String text, double x, double y, double maxWidth) {
		rpc.fillText(text, x, y, maxWidth);
	}

	/**
	 * Set the current font properties for text content on the canvas. Uses the
	 * same syntax as the CSS font property.
	 * 
	 * @param font
	 *            the new font
	 */
	public void setFont(String font) {
		rpc.setFont(font);
	}

	/**
	 * Sets the text baseline used when drawing text. Possible values are:
	 * "top", "hanging", "middle", "alphabetic", "ideographic" or "bottom".
	 * Default value is "alphabetic".
	 * 
	 * The {@link #fillText(String, double, double, double)} will use the
	 * specified textBaseline value when positioning the text on the canvas.
	 * 
	 * @param textBaseline
	 *            the new text baseline
	 */
	public void setTextBaseline(String textBaseline) {
		rpc.setTextBaseline(textBaseline);
	}

	/**
	 * Adda a new point and creates a line from that point to the last specified
	 * point in the canvas (this method does not draw the line). Use the
	 * 
	 * @param x
	 *            the x coordinate where to create a line to
	 * @param y
	 *            the y coordinate where to create a line to {@link #stroke()}
	 *            method to actually draw the path on the canvas.
	 */
	public void lineTo(double x, double y) {
		rpc.lineTo(x, y);
	}

	/**
	 * Move the path to the specified point in the canvas, without creating a
	 * line.
	 * 
	 * Use the {@link #stroke()} method to actually draw the path on the canvas.
	 * 
	 * 
	 * @param x
	 *            the x coordinate where to move the path to
	 * @param y
	 *            the y coordinate where to move the path to
	 */
	public void moveTo(double x, double y) {
		rpc.moveTo(x, y);
	}

	/**
	 * Adds a point to the current path by using the specified control points
	 * that represent a quadratic BŽzier curve.
	 * 
	 * A quadratic BŽzier curve requires two points. The first point is a
	 * control point that is used in the quadratic BŽzier calculation and the
	 * second point is the ending point for the curve. The starting point for
	 * the curve is the last point in the current path. If a path does not
	 * exist, use the {@link #beginPath()} and {@link #moveTo(double, double)}
	 * methods to define a starting point.
	 * 
	 * @param cpx
	 *            The X coordinate of the BŽzier control point
	 * @param cpy
	 *            The Y coordinate of the BŽzier control point
	 * @param x
	 *            The X coordinate of the ending point
	 * @param y
	 *            The Y coordinate of the ending point
	 */
	public void quadraticCurveTo(double cpx, double cpy, double x, double y) {
		rpc.quadraticCurveTo(cpx, cpy, x, y);
	}

	/**
	 * Creates a rectangle to the current path. Use the {@link #stroke()} or
	 * 
	 * @param startX
	 *            The X coordinate of the upper-left corner of the rectangle
	 * @param startY
	 *            The Y coordinate of the upper-left corner of the rectangle
	 * @param width
	 *            the width of the rectangle
	 * @param height
	 *            the height of the rectangle {@link #fill()} methods to
	 *            actually draw the rectangle on the canvas.
	 */
	public void rect(double startX, double startY, double width, double height) {
		rpc.rect(startX, startY, width, height);
	}

	/**
	 * Rotates the current drawing. The rotation will only affect drawings made
	 * AFTER the rotation is done.
	 * 
	 * @param angle
	 *            the angle to rotate by, in radians
	 */
	public void rotate(double angle) {
		rpc.rotate(angle);
	}

	/**
	 * Sets the color, gradient, or pattern used to fill the drawing.
	 * 
	 * @param color
	 *            the new fill style
	 */
	public void setFillStyle(String color) {
		rpc.setFillStyle(color);
	}

	/**
	 * Sets the RGB color used to fill the drawing.
	 * 
	 * @param r
	 *            the red component of the fill color
	 * @param g
	 *            the green component of the fill color
	 * @param b
	 *            the blue component of the fill color
	 */
	public void setFillStyle(int r, int g, int b) {
		setFillStyle("rgb(" + r + "," + g + "," + b + ")");
	}

	/**
	 * Sets the style of the end caps for a line. Possible values are "butt",
	 * "round" and "square".
	 * 
	 * "round" and "square" make the lines slightly longer.
	 * 
	 * @param lineCap
	 *            the new line cap
	 */
	public void setLineCap(String lineCap) {
		rpc.setLineCap(lineCap);
	}

	/**
	 * Sets the type of corner created, when two lines meet. Possible values are
	 * "bevel", "round" and "miter".
	 * 
	 * The "miter" value is affected by the miterLimit property, which you can
	 * set using the {@link #setMiterLimit(double)} method.
	 * 
	 * @param lineJoin
	 *            the new line join
	 */
	public void setLineJoin(String lineJoin) {
		rpc.setLineJoin(lineJoin);
	}

	/**
	 * Sets the current line width, in pixels.
	 * 
	 * @param width
	 *            the new line width
	 */
	public void setLineWidth(double width) {
		rpc.setLineWidth(width);
	}

	/**
	 * Sets the maximum miter length. The miter length is the distance between
	 * the inner corner and the outer corner where two lines meet. The
	 * miterLimit property works only if the lineJoin attribute is "miter".
	 * 
	 * The miter length grows bigger as the angle of the corner gets smaller. To
	 * prevent the miter length from being too long, we can use the miterLimit
	 * property.
	 * 
	 * If the miter length exceeds the miterLimit value, the corner will be
	 * displayed as lineJoin type "bevel"
	 * 
	 * @param miterLimit
	 *            the new miter limit
	 */
	public void setMiterLimit(double miterLimit) {
		rpc.setMiterLimit(miterLimit);
	}

	/**
	 * Draw a rectangle (no fill). The default color of the stroke is black.
	 * 
	 * Use the {@link #setStrokeStyle(String)} method to set a color, gradient,
	 * or pattern to style the stroke.
	 * 
	 * @param startX
	 *            the X coordinate of the upper left corner of the rectangle
	 * @param startY
	 *            the X coordinate of the upper left corner of the rectangle
	 * @param width
	 *            the width of the rectangle
	 * @param height
	 *            the height of the rectangle
	 */
	public void strokeRect(double startX, double startY, double width,
			double height) {
		rpc.strokeRect(startX, startY, width, height);
	}

	/**
	 * Each object on the canvas has a current transformation matrix.
	 * 
	 * This method replaces the current transformation matrix. It multiplies the
	 * current transformation matrix with the matrix described by:
	 * 
	 * a c e
	 * 
	 * b d f
	 * 
	 * 0 0 1
	 * 
	 * In other words, the it lets you scale, rotate, move, and skew the current
	 * context.
	 * 
	 * The transformation will only affect drawings made after the method is
	 * called.
	 * 
	 * The {@link #transform(double, double, double, double, double, double)}
	 * method behaves relatively to other transformations made by
	 * 
	 * @param m11
	 *            Scales the drawing horizontally
	 * @param m12
	 *            Skew the drawing horizontally
	 * @param m21
	 *            Skew the drawing vertically
	 * @param m22
	 *            Scales the drawing verticallyv
	 * @param dx
	 *            Moves the the drawing horizontally
	 * @param dy
	 *            Moves the the drawing vertically {@link #rotate(double)},
	 *            {@link #scale(double, double)} or
	 *            {@link #translate(double, double)}.
	 * 
	 *            For example: If you already have set your drawing to scale by
	 *            two, and the
	 *            {@link #transform(double, double, double, double, double, double)}
	 *            method scales your drawings by two, your drawings will now
	 *            scale by four.
	 */
	public void transform(double m11, double m12, double m21, double m22,
			double dx, double dy) {
		rpc.transform(m11, m12, m21, m22, dx, dy);
	}

	/**
	 * This method creates an arc/curve (used to create circles, or parts of
	 * circles). To create a circle with arc(): Set start angle to 0 and end
	 * angle to 2 * Math.PI.
	 * 
	 * Use the {@link #stroke()} or {@link #fill()} method to actually draw the
	 * arc on the canvas.
	 * 
	 * @param x
	 *            The x-coordinate of the center of the circle
	 * @param y
	 *            The y-coordinate of the center of the circle
	 * @param radius
	 *            the radius of the circle, in radians
	 * @param startAngle
	 *            The starting angle, in radians (0 is at the 3 o'clock position
	 *            of the arc's circle)
	 * @param endAngle
	 *            The end angle, in radians
	 * @param antiClockwise
	 *            Specifies whether the drawing should be counterclockwise or
	 *            clockwise.
	 */
	public void arc(double x, double y, double radius, double startAngle,
			double endAngle, Boolean antiClockwise) {
		rpc.arc(x, y, radius, startAngle, endAngle, antiClockwise);
	}

	/**
	 * This method remaps the (0,0) position on the canvas. When you call a
	 * method such as {@link #fillRect(double, double, double, double)} after
	 * 
	 * @param x
	 *            The value to add to horizontal (x) coordinates
	 * @param y
	 *            The value to add to vertical (y) coordinates
	 *            {@link #translate(double, double)}, the value is added to the
	 *            x- and y-coordinate values.
	 */
	public void translate(double x, double y) {
		rpc.translate(x, y);
	}

	/**
	 * Scale the current drawing, bigger or smaller.
	 * 
	 * If you scale a drawing, all future drawings will also be scaled. The
	 * positioning will also be scaled. For example, if you scale(2,2); drawings
	 * will be positioned twice as far from the left and top of the canvas as
	 * you specify.
	 * 
	 * @param x
	 *            Scales the width of the current drawing (1=100%, 0.5=50%,
	 *            2=200%, etc.)
	 * @param y
	 *            Scales the height of the current drawing (1=100%, 0.5=50%,
	 *            2=200%, etc.)
	 */
	public void scale(double x, double y) {
		rpc.scale(x, y);
	}

	/**
	 * Draw the path you have defined with eg {@link #moveTo(double, double)}
	 * and {@link #lineTo(double, double)} methods.
	 * 
	 * The default color is black. Use the {@link #setStrokeStyle(String)} to
	 * draw with another color/gradient.
	 */
	public void stroke() {
		rpc.stroke();
	}

	/**
	 * Saves the state of the current context.
	 */
	public void saveContext() {
		rpc.saveContext();
	}

	/**
	 * Returns previously saved path state and attributes.
	 */
	public void restoreContext() {
		rpc.restoreContext();
	}

	/**
	 * Sets the color, gradient, or pattern used for strokes.
	 * 
	 * @param rgb
	 *            the new stroke style
	 */
	public void setStrokeStyle(String rgb) {
		rpc.setStrokeStyle(rgb);
	}

	/**
	 * Sets the stroke RGB color used for strokes.
	 * 
	 * @param r
	 *            the red component of the stroke color
	 * @param g
	 *            the green component of the stroke color
	 * @param b
	 *            the blue component of the stroke color
	 */
	public void setStrokeStyle(int r, int g, int b) {
		setStrokeStyle("rgb(" + r + "," + g + "," + b + ")");
	}

	/**
	 * Begins a path, or resets the current path.
	 * 
	 * Use {@link #moveTo(double, double)}, {@link #lineTo(double, double)},
	 * {@link #quadraticCurveTo(double, double, double, double)} etc. and arc(),
	 * to create paths.
	 * 
	 * Use the {@link #stroke()} method to actually draw the path on the canvas.
	 */
	public void beginPath() {
		rpc.beginPath();
	}

	/**
	 * Sets the current alpha or transparency value of the drawing.
	 * 
	 * The alpha value must be a number between 0.0 (fully transparent) and 1.0
	 * (no transparancy).
	 * 
	 * @param alpha
	 *            the new global alpha value
	 */
	public void setGlobalAlpha(double alpha) {
		rpc.setGlobalAlpha(alpha);
	}

	/**
	 * Creates a path from the current point back to the starting point.
	 * 
	 * Use the {@link #stroke()} method to actually draw the path on the canvas.
	 * 
	 * Use the {@link #fill()} method to fill the drawing (black is default).
	 * Use the {@link #setFillStyle(String)} method to fill with another
	 * color/gradient.
	 */
	public void closePath() {
		rpc.closePath();
	}

	/**
	 * Sets how a source (new) image are drawn onto a destination (existing)
	 * image.
	 * 
	 * source image = drawings you are about to place onto the canvas.
	 * 
	 * destination image = drawings that are already placed onto the canvas.
	 * 
	 * Possible operation names are:
	 * 
	 * "source-over" Default. Displays the source image over the destination
	 * image
	 * 
	 * "source-atop" Displays the source image on top of the destination image.
	 * The part of the source image that is outside the destination image is not
	 * shown
	 * 
	 * "source-in" Displays the source image in to the destination image. Only
	 * the part of the source image that is INSIDE the destination image is
	 * shown, and the destination image is transparent
	 * 
	 * "source-out" Displays the source image out of the destination image. Only
	 * the part of the source image that is OUTSIDE the destination image is
	 * shown, and the destination image is transparent
	 * 
	 * "destination-over" Displays the destination image over the source image
	 * 
	 * destination-atop Displays the destination image on top of the source
	 * image. The part of the destination image that is outside the source image
	 * is not shown
	 * 
	 * "destination-in" Displays the destination image in to the source image.
	 * Only the part of the destination image that is INSIDE the source image is
	 * shown, and the source image is transparent
	 * 
	 * "destination-out" Displays the destination image out of the source image.
	 * Only the part of the destination image that is OUTSIDE the source image
	 * is shown, and the source image is transparent
	 * 
	 * "lighter" Displays the source image + the destination image
	 * 
	 * "copy" Displays the source image. The destination image is ignored
	 * 
	 * "xor" The source image is combined by using an exclusive OR with the
	 * destination image
	 * 
	 * @param mode
	 *            the new global composite operation name
	 */
	public void setGlobalCompositeOperation(String mode) {
		rpc.setGlobalCompositeOperation(mode);
	}

	/**
	 * Creates a linear gradient object with the specified name The gradient can
	 * be used to fill rectangles, circles, lines, text, etc.
	 * 
	 * Use the gradient name as a parameter for {@link #setStrokeStyle(String)}
	 * or {@link #setFillStyle(String)}.
	 * 
	 * Use the {@link #addColorStop(String, double, String)} method to specify
	 * different colors, and where to position the colors in the gradient
	 * object.
	 * 
	 * @param name
	 *            the gradient name
	 * @param x0
	 *            The x-coordinate of the start point of the gradient
	 * @param y0
	 *            The y-coordinate of the start point of the gradient
	 * @param x1
	 *            The x-coordinate of the end point of the gradient
	 * @param y1
	 *            The y-coordinate of the end point of the gradient
	 */
	public void createLinearGradient(String name, double x0, double y0,
			double x1, double y1) {
		rpc.createLinearGradient(name, x0, y0, x1, y1);
	}

	/**
	 * Creates a radial gradient object with the specified name The gradient can
	 * be used to fill rectangles, circles, lines, text, etc.
	 * 
	 * Use the gradient name as a parameter for {@link #setStrokeStyle(String)}
	 * or {@link #setFillStyle(String)}.
	 * 
	 * Use the {@link #addColorStop(String, double, String)} method to specify
	 * different colors, and where to position the colors in the gradient
	 * object.
	 * 
	 * @param name
	 *            the name of the gradient
	 * @param x0
	 *            The x-coordinate of the starting circle of the gradient
	 * @param y0
	 *            The y-coordinate of the starting circle of the gradient
	 * @param r0
	 *            The radius of the starting circle
	 * @param x1
	 *            The x-coordinate of the ending circle of the gradient
	 * @param y1
	 *            The y-coordinate of the ending circle of the gradient
	 * @param r1
	 *            The radius of the ending circle
	 */
	public void createRadialGradient(String name, double x0, double y0,
			double r0, double x1, double y1, double r1) {
		rpc.createRadialGradient(name, x0, y0, r0, x1, y1, r1);
	}

	/**
	 * Specifies the colors and position in a gradient object. It is used
	 * together with
	 * 
	 * @param gradient
	 *            the gradient name
	 * @param offset
	 *            A value between 0.0 and 1.0 that represents the position
	 *            between start and end in a gradient
	 * @param color
	 *            A CSS color value to display at the stop position
	 *            {@link #createLinearGradient(String, double, double, double, double)}
	 *            or
	 *            {@link #createRadialGradient(String, double, double, double, double, double, double)}
	 *            .
	 * 
	 *            Note: You can call this method multiple times to change a
	 *            gradient. If you omit this method for gradient objects, the
	 *            gradient will not be visible. You need to create at least one
	 *            color stop to have a visible gradient.
	 */
	public void addColorStop(String gradient, double offset, String color) {
		rpc.addColorStop(gradient, offset, color);
	}

	/**
	 * Sets the gradient used for strokes.
	 * 
	 * @param gradient
	 *            the gradient name
	 */
	public void setGradientStrokeStyle(String gradient) {
		rpc.setGradientStrokeStyle(gradient);
	}

	/**
	 * Sets the gradient name to be used to fill the drawing.
	 * 
	 * @param gradient
	 *            the new gradient name
	 */
	public void setGradientFillStyle(String gradient) {
		rpc.setGradientFillStyle(gradient);
	}

	public void loadImages(String[] urls) {
		rpc.loadImages(urls);
	}

	/**
	 * The listener interface for receiving canvasClick events. The class that
	 * is interested in processing a canvasClick event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addCanvasClickListener<code> method. When
	 * the canvasClick event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see CanvasClickEvent
	 */
	public interface CanvasClickListener {

		/**
		 * A mouse was clicked in a canvas.
		 * 
		 * @param med
		 *            the mouse event details
		 */
		public void clicked(MouseEventDetails med);
	}

	/**
	 * Adds the CanvasClickListener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addListener(CanvasClickListener listener) {
		if (!clickListeners.contains(listener)) {
			clickListeners.add(listener);
		}
	}

	/**
	 * Removes a CanvasClickListener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeListener(CanvasClickListener listener) {
		if (clickListeners.contains(listener)) {
			clickListeners.remove(listener);
		}
	}

	private void fireClicked(MouseEventDetails med) {
		for (CanvasClickListener listener : clickListeners) {
			listener.clicked(med);
		}
	}

	/**
	 * The listener interface for receiving canvasImageLoad events. The class
	 * that is interested in processing a canvasImageLoad event implements this
	 * interface, and the object created with that class is registered with a
	 * component using the component's
	 * <code>addCanvasImageLoadListener<code> method. When
	 * the canvasImageLoad event occurs, that object's appropriate
	 * method is invoked.
	 * 
	 * @see CanvasImageLoadEvent
	 */
	public interface CanvasImageLoadListener {

		/**
		 * The canvas has finished loading the images.
		 */
		public void imagesLoaded();
	}

	/**
	 * Adds a CanvasImageLoadListener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void addListener(CanvasImageLoadListener listener) {
		if (!imageLoadListeners.contains(listener)) {
			imageLoadListeners.add(listener);
		}
	}

	/**
	 * Removes a CanvasImageLoadListener.
	 * 
	 * @param listener
	 *            the listener
	 */
	public void removeListener(CanvasImageLoadListener listener) {
		if (imageLoadListeners.contains(listener)) {
			imageLoadListeners.remove(listener);
		}
	}

	private void fireImagesLoaded() {
		for (CanvasImageLoadListener listener : imageLoadListeners) {
			listener.imagesLoaded();
		}
	}
}
