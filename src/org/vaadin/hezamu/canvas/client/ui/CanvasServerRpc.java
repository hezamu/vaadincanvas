package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.communication.ServerRpc;

public interface CanvasServerRpc extends ServerRpc {
	public void click(int x, int y);
}
