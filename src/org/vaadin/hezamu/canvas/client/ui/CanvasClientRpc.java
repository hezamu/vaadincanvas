package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.communication.ClientRpc;

public interface CanvasClientRpc extends ClientRpc {
	public void drawImage(String url, Double offsetX, Double offsetY);

	public void drawImage(String url, Double offsetX, Double offsetY,
			Double width, Double height);

	public void drawImage(String url, Double sourceX, Double sourceY,
			Double sourceWidth, Double sourceHeight, Double destX,
			Double destY, Double destWidth, Double destHeight);

	public void fill();

	public void fillRect(Double startX, Double startY, Double width,
			Double height);

	public void fillText(String text, Double x, Double y, Double maxWidth);

	public void setFont(String font);

	public void setTextBaseline(String textBaseline);

	public void lineTo(Double x, Double y);

	public void moveTo(Double x, Double y);

	public void quadraticCurveTo(Double cpx, Double cpy, Double x, Double y);

	public void rect(Double startX, Double startY, Double width, Double height);

	public void rotate(Double angle);

	public void setFillStyle(String color);

	public void setLineCap(String lineCap);

	public void setLineJoin(String lineJoin);

	public void setLineWidth(Double width);

	public void setMiterLimit(Double miterLimit);

	public void setColorStrokeStyle(String color);

	public void strokeRect(Double startX, Double startY, Double width,
			Double height);

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
}
