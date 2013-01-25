package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.communication.ServerRpc;

public interface CanvasServerRpc extends ServerRpc {
	public void mouseUp(int x, int y);

	public void mouseDown(int x, int y);
}
