package org.vaadin.hezamu.canvas;

import java.util.ArrayList;
import java.util.List;

import org.vaadin.hezamu.canvas.client.ui.CanvasClientRpc;
import org.vaadin.hezamu.canvas.client.ui.CanvasServerRpc;

import com.vaadin.ui.AbstractComponent;

@SuppressWarnings("serial")
public class Canvas extends AbstractComponent {
	private final List<CanvasMouseDownListener> downListeners = new ArrayList<CanvasMouseDownListener>();

	private final List<CanvasMouseUpListener> upListeners = new ArrayList<CanvasMouseUpListener>();

	private final CanvasClientRpc rpc = getRpcProxy(CanvasClientRpc.class);

	public Canvas() {
		registerRpc(new CanvasServerRpc() {
			public void mouseDown(int x, int y) {
				fireMouseDown(x, y);
			}

			public void mouseUp(int x, int y) {
				fireMouseUp(x, y);
			}
		});
	}

	public void drawImage(String url, double offsetX, double offsetY) {
		rpc.drawImage(url, offsetX, offsetY);
	}

	public void drawImage(String url, double offsetX, double offsetY,
			double width, double height) {
		rpc.drawImage(url, offsetX, offsetY, width, height);
	}

	public void fillRect(double startX, double startY, double width,
			double height) {
		rpc.fillRect(startX, startY, width, height);
	}

	public void clear() {
		rpc.clear();
	}

	public void drawImage(String url, double sourceX, double sourceY,
			double sourceWidth, double sourceHeight, double destX,
			double destY, double destWidth, double destHeight) {
		rpc.drawImage(url, sourceX, sourceY, sourceWidth, sourceHeight, destX,
				destY, destWidth, destHeight);
	}

	public void fill() {
		rpc.fill();
	}

	public void fillText(String text, double x, double y, double maxWidth) {
		rpc.fillText(text, x, y, maxWidth);
	}

	public void setFont(String font) {
		rpc.setFont(font);
	}

	/**
	 * Possible values are: "top", "hanging", "middle", "alphabetic",
	 * "ideographic" or "bottom". Default value is "alphabetic"
	 */
	public void setTextBaseline(String textBaseline) {
		rpc.setTextBaseline(textBaseline);
	}

	public void lineTo(double x, double y) {
		rpc.lineTo(x, y);
	}

	public void moveTo(double x, double y) {
		rpc.moveTo(x, y);
	}

	public void quadraticCurveTo(double cpx, double cpy, double x, double y) {
		rpc.quadraticCurveTo(cpx, cpy, x, y);
	}

	public void rect(double startX, double startY, double width, double height) {
		rpc.rect(startX, startY, width, height);
	}

	public void rotate(double angle) {
		rpc.rotate(angle);
	}

	public void setFillStyle(String color) {
		rpc.setFillStyle(color);
	}

	public void setLineCap(String lineCap) {
		rpc.setLineCap(lineCap);
	}

	public void setLineJoin(String lineJoin) {
		rpc.setLineJoin(lineJoin);
	}

	public void setLineWidth(double width) {
		rpc.setLineWidth(width);
	}

	public void setMiterLimit(double miterLimit) {
		rpc.setMiterLimit(miterLimit);
	}

	public void strokeRect(double startX, double startY, double width,
			double height) {
		rpc.strokeRect(startX, startY, width, height);
	}

	public void transform(double m11, double m12, double m21, double m22,
			double dx, double dy) {
		rpc.transform(m11, m12, m21, m22, dx, dy);
	}

	public void arc(double x, double y, double radius, double startAngle,
			double endAngle, Boolean antiClockwise) {
		rpc.arc(x, y, radius, startAngle, endAngle, antiClockwise);
	}

	public void translate(double x, double y) {
		rpc.translate(x, y);
	}

	public void scale(double x, double y) {
		rpc.scale(x, y);
	}

	public void stroke() {
		rpc.stroke();
	}

	public void saveContext() {
		rpc.saveContext();
	}

	public void restoreContext() {
		rpc.restoreContext();
	}

	public void setStrokeStyle(String rgb) {
		rpc.setStrokeStyle(rgb);
	}

	public void beginPath() {
		rpc.beginPath();
	}

	public void setGlobalAlpha(double alpha) {
		rpc.setGlobalAlpha(alpha);
	}

	public void closePath() {
		rpc.closePath();
	}

	public void setGlobalCompositeOperation(String mode) {
		rpc.setGlobalCompositeOperation(mode);
	}

	public void setStrokeStyle(int r, int g, int b) {
		setStrokeStyle("rgb(" + r + "," + g + "," + b + ")");
	}

	public void setFillStyle(int r, int g, int b) {
		setFillStyle("rgb(" + r + "," + g + "," + b + ")");
	}

	public void createLinearGradient(String name, double x0, double y0,
			double x1, double y1) {
		rpc.createLinearGradient(name, x0, y0, x1, y1);
	}

	public void createRadialGradient(String name, double x0, double y0,
			double r0, double x1, double y1, double r1) {
		rpc.createRadialGradient(name, x0, y0, r0, x1, y1, r1);
	}

	public void addColorStop(String gradient, double offset, String color) {
		rpc.addColorStop(gradient, offset, color);
	}

	public void setGradientStrokeStyle(String gradient) {
		rpc.setGradientStrokeStyle(gradient);
	}

	public void setGradientFillStyle(String gradient) {
		rpc.setGradientFillStyle(gradient);
	}

	public interface CanvasMouseDownListener {
		public void mouseDown(int x, int y);
	}

	public void addListener(CanvasMouseDownListener listener) {
		if (!downListeners.contains(listener)) {
			downListeners.add(listener);
		}
	}

	public void removeListener(CanvasMouseDownListener listener) {
		if (downListeners.contains(listener)) {
			downListeners.remove(listener);
		}
	}

	private void fireMouseDown(int x, int y) {
		for (CanvasMouseDownListener listener : downListeners) {
			listener.mouseDown(x, y);
		}
	}

	public interface CanvasMouseUpListener {
		public void mouseUp(int x, int y);
	}

	public void addListener(CanvasMouseUpListener listener) {
		if (!upListeners.contains(listener)) {
			upListeners.add(listener);
		}
	}

	public void removeListener(CanvasMouseUpListener listener) {
		if (upListeners.contains(listener)) {
			upListeners.remove(listener);
		}
	}

	private void fireMouseUp(int x, int y) {
		for (CanvasMouseUpListener listener : upListeners) {
			listener.mouseUp(x, y);
		}
	}
}
