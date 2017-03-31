package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface CanvasServerRpc extends ServerRpc {
	public void mouseMoved(MouseEventDetails med);

	public void mouseDown(MouseEventDetails med);

	public void mouseUp(MouseEventDetails med);

	public void imagesLoaded();
}
