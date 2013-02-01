package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.communication.ClientRpc;

public interface CanvasClientRpc extends ClientRpc {
	public void drawImage1(String url, Double offsetX, Double offsetY);

	public void drawImage2(String url, Double offsetX, Double offsetY,
			Double imageWidth, Double imageHeight);

	public void drawImage3(String url, Double sourceX, Double sourceY,
			Double sourceWidth, Double sourceHeight, Double destX,
			Double destY, Double destWidth, Double destHeight);

	public void fill();

	public void fillRect(Double startX, Double startY, Double rectWidth,
			Double rectHeight);

	public void fillText(String text, Double x, Double y, Double maxWidth);

	public void setFont(String font);

	public void setTextBaseline(String textBaseline);

	public void lineTo(Double x, Double y);

	public void moveTo(Double x, Double y);

	public void quadraticCurveTo(Double cpx, Double cpy, Double x, Double y);

	public void rect(Double startX, Double startY, Double rectWidth,
			Double rectHeight);

	public void rotate(Double angle);

	public void setFillStyle(String color);

	public void setLineCap(String lineCap);

	public void setLineJoin(String lineJoin);

	public void setLineWidth(Double width);

	public void setMiterLimit(Double miterLimit);

	public void strokeRect(Double startX, Double startY, Double strokeWidth,
			Double strokeHeight);

	public void transform(Double m11, Double m12, Double m21, Double m22,
			Double dx, Double dy);

	public void arc(Double x, Double y, Double radius, Double startAngle,
			Double endAngle, Boolean antiClockwise);

	public void translate(Double x, Double y);

	public void scale(Double x, Double y);

	public void stroke();

	public void saveContext();

	public void restoreContext();

	public void setStrokeStyle(String rgb);

	public void beginPath();

	public void clear();

	public void setGlobalAlpha(Double alpha);

	public void closePath();

	public void setGlobalCompositeOperation(String mode);

	public void setGradientFillStyle(String gradient);

	public void createLinearGradient(String name, Double x0, Double y0,
			Double x1, Double y1);

	public void createRadialGradient(String name, Double x0, Double y0,
			Double r0, Double x1, Double y1, Double r1);

	public void setGradientStrokeStyle(String gradient);

	public void addColorStop(String gradient, Double offset, String color);

	public void loadImages(String[] urls);
	// Sets or returns the color to use for shadows
	// public void shadowColor(String color);

	// public void shadowBlur(Integer level); // Sets or returns the blur level
	// for shadows

	// public void shadowOffset(Integer x, Integer y); // Sets or returns the
	// horizontal distance of the shadow from the shape

	// repeats the specified element in the specified direction.
	// The element can be an image, video, or another <canvas> element.
	// The repeated element can be used to draw/fill rectangles, circles, lines
	// etc.
	// Mode: repeat|repeat-x|repeat-y|no-repeat
	// createPattern(String url, String repeatMode);

	// clears the specified pixels within a given rectangle
	// public void clearRect(Integer x, Integer y, Integer width, Integer
	// height);

	// Clips a region of any shape and size from the original canvas.
	// Tip: Once a region is clipped, all future drawing will be limited to the
	// clipped region (no access to other regions on the canvas). You can
	// however save the current canvas region using the save() method before
	// using the clip() method, and restore it (with the restore() method) any
	// time in the future.
	// public void clip();

	// The bezierCurveTo() method adds a point to the current path by using the
	// specified control points that represent a cubic BŽzier curve.
	//
	// A cubic bezier curve requires three points. The first two points are
	// control points that are used in the cubic BŽzier calculation and the last
	// point is the ending point for the curve. The starting point for the curve
	// is the last point in the current path. If a path does not exist, use the
	// beginPath() and moveTo() methods to define a starting point.
	// public void bezierCurveTo(Integer cp1x, Integer cp1y, Integer cp2x,
	// Integer cp2y, Integer x, Integer y);
}
