package org.vaadin.hezamu.canvas.client.ui;

import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.communication.ServerRpc;

public interface CanvasServerRpc extends ServerRpc {
	public void clicked(MouseEventDetails med);
	
	public void onClickDown(MouseEventDetails mouseDetails);

	public void onClickUp(MouseEventDetails mouseDetails);

	public void onMouseMove(MouseEventDetails mouseDetails);

	public void imagesLoaded();
}
