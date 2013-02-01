package org.vaadin.hezamu.canvas.client.ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.ErrorEvent;
import com.google.gwt.event.dom.client.ErrorHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.MouseEventDetailsBuilder;
import com.vaadin.client.VConsole;
import com.vaadin.client.communication.RpcProxy;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.ui.AbstractComponentConnector;
import com.vaadin.client.ui.PostLayoutListener;
import com.vaadin.client.ui.SimpleManagedLayout;
import com.vaadin.shared.MouseEventDetails;
import com.vaadin.shared.ui.Connect;

@SuppressWarnings("serial")
@Connect(org.vaadin.hezamu.canvas.Canvas.class)
public class CanvasConnector extends AbstractComponentConnector implements
		SimpleManagedLayout, PostLayoutListener {
	private boolean needsDraw = false;

	private final List<Command> commands;

	private final Map<String, CanvasGradient> gradients = new HashMap<String, CanvasGradient>();

	private final CanvasServerRpc rpc = RpcProxy.create(CanvasServerRpc.class,
			this);

	public CanvasConnector() {
		commands = new ArrayList<Command>();
	}

	@Override
	protected void init() {
		super.init();

		getWidget().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				MouseEventDetails med = MouseEventDetailsBuilder
						.buildMouseEventDetails(event.getNativeEvent(),
								getWidget().getElement());

				rpc.clicked(med);
			}
		});

		registerRpc(CanvasClientRpc.class, new CanvasClientRpc() {
			private static final long serialVersionUID = -7521521510799765779L;

			private final Context2d ctx = getWidget().getContext2d();

			@Override
			public void fillRect(final Double startX, final Double startY,
					final Double width, final Double height) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.fillRect(startX, startY, width, height);
					}
				});
			}

			@Override
			public void drawImage1(final String url, final Double offsetX,
					final Double offsetY) {
				runCommand(new Command() {
					@Override
					public void execute() {
						VConsole.log("Drawing " + url + "\n at " + offsetX
								+ "," + offsetY);
						ctx.drawImage(
								ImageElement.as(new Image(url).getElement()),
								offsetX, offsetY);
						VConsole.log("Drawing complete");
					}
				});
			}

			@Override
			public void drawImage2(final String url, final Double offsetX,
					final Double offsetY, final Double imageWidth,
					final Double imageHeight) {
				runCommand(new Command() {
					@Override
					public void execute() {
						VConsole.log("Drawing " + url + "\n at " + offsetX
								+ "," + offsetY + " w" + imageWidth + " h"
								+ imageHeight);
						ctx.drawImage(
								ImageElement.as(new Image(url).getElement()),
								offsetX, offsetY, imageWidth, imageHeight);
						VConsole.log("Drawing complete");
					}
				});
			}

			@Override
			public void drawImage3(final String url, final Double sourceX,
					final Double sourceY, final Double sourceWidth,
					final Double sourceHeight, final Double destX,
					final Double destY, final Double destWidth,
					final Double destHeight) {
				runCommand(new Command() {
					@Override
					public void execute() {
						VConsole.log("Drawing " + url + "\n from " + sourceX
								+ "," + sourceY + " w" + sourceWidth + " h"
								+ sourceHeight + " to " + destX + "," + destY
								+ " " + destWidth + "x" + destHeight);
						ctx.drawImage(
								ImageElement.as(new Image(url).getElement()),
								sourceX, sourceY, sourceWidth, sourceHeight,
								destX, destY, destWidth, destHeight);
						VConsole.log("Drawing complete");
					}
				});
			}

			@Override
			public void fill() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.fill();
					}
				});
			}

			@Override
			public void fillText(final String text, final Double x,
					final Double y, final Double maxWidth) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.fillText(text, x, y, maxWidth);
					}
				});
			}

			@Override
			public void setFont(final String font) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setFont(font);
					}
				});
			}

			@Override
			public void setTextBaseline(final String textBaseline) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setTextBaseline(textBaseline);
					}
				});
			}

			@Override
			public void lineTo(final Double x, final Double y) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.lineTo(x, y);
					}
				});
			}

			@Override
			public void moveTo(final Double x, final Double y) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.moveTo(x, y);
					}
				});
			}

			@Override
			public void quadraticCurveTo(final Double cpx, final Double cpy,
					final Double x, final Double y) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.quadraticCurveTo(cpx, cpy, x, y);
					}
				});
			}

			@Override
			public void rect(final Double startX, final Double startY,
					final Double rectWidth, final Double rectHeight) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.rect(startX, startY, rectWidth, rectHeight);
					}
				});
			}

			@Override
			public void rotate(final Double angle) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.rotate(angle);
					}
				});
			}

			@Override
			public void setFillStyle(final String color) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setFillStyle(color);
					}
				});
			}

			@Override
			public void setLineCap(final String lineCap) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setLineCap(lineCap);
					}
				});
			}

			@Override
			public void setLineJoin(final String lineJoin) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setLineJoin(lineJoin);
					}
				});
			}

			@Override
			public void setLineWidth(final Double lineWidth) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setLineWidth(lineWidth);
					}
				});
			}

			@Override
			public void setMiterLimit(final Double miterLimit) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setMiterLimit(miterLimit);
					}
				});
			}

			@Override
			public void strokeRect(final Double startX, final Double startY,
					final Double strokeWidth, final Double strokeHeight) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.strokeRect(startX, startY, strokeWidth,
								strokeHeight);
					}
				});
			}

			@Override
			public void transform(final Double m11, final Double m12,
					final Double m21, final Double m22, final Double dx,
					final Double dy) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.transform(m11, m12, m21, m22, dx, dy);
					}
				});
			}

			@Override
			public void arc(final Double x, final Double y,
					final Double radius, final Double startAngle,
					final Double endAngle, Boolean antiClockwise) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.arc(x, y, radius, startAngle, endAngle);
					}
				});
			}

			@Override
			public void translate(final Double x, final Double y) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.translate(x, y);
					}
				});
			}

			@Override
			public void scale(final Double x, final Double y) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.scale(x, y);
					}
				});
			}

			@Override
			public void stroke() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.stroke();
					}
				});
			}

			@Override
			public void saveContext() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.save();
					}
				});
			}

			@Override
			public void restoreContext() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.restore();
					}
				});
			}

			@Override
			public void setStrokeStyle(final String rgb) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setStrokeStyle(rgb);
					}
				});
			}

			@Override
			public void beginPath() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.beginPath();
					}
				});
			}

			@Override
			public void clear() {
				ctx.clearRect(0, 0, getWidget().getCoordinateSpaceWidth(),
						getWidget().getCoordinateSpaceHeight());
				clearCommands();
			}

			@Override
			public void setGlobalAlpha(final Double alpha) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setGlobalAlpha(alpha);
					}
				});
			}

			@Override
			public void closePath() {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.closePath();
					}
				});
			}

			@Override
			public void setGlobalCompositeOperation(final String mode) {
				runCommand(new Command() {
					@Override
					public void execute() {
						ctx.setGlobalCompositeOperation(mode);
					}
				});
			}

			@Override
			public void setGradientFillStyle(final String gradientName) {
				runCommand(new Command() {
					@Override
					public void execute() {
						if (gradients.containsKey(gradientName)) {
							ctx.setFillStyle(gradients.get(gradientName));
						} else {
							System.err
									.println("setGradientFillStyle: Gradient not foud with name "
											+ gradientName);
						}
					}
				});
			}

			@Override
			public void createLinearGradient(final String name,
					final Double x0, final Double y0, final Double x1,
					final Double y1) {
				runCommand(new Command() {
					@Override
					public void execute() {
						CanvasGradient newGradient = ctx.createLinearGradient(
								x0, y0, x1, y1);

						gradients.put(name, newGradient);
					}
				});
			}

			@Override
			public void createRadialGradient(final String name,
					final Double x0, final Double y0, final Double r0,
					final Double x1, final Double y1, final Double r1) {
				runCommand(new Command() {
					@Override
					public void execute() {
						CanvasGradient newGradient = ctx.createRadialGradient(
								x0, y0, r0, x1, y1, r1);

						gradients.put(name, newGradient);
					}
				});
			}

			@Override
			public void setGradientStrokeStyle(final String gradientName) {
				runCommand(new Command() {
					@Override
					public void execute() {
						if (gradients.containsKey(gradientName)) {
							ctx.setStrokeStyle(gradients.get(gradientName));
						} else {
							System.err
									.println("setGradientStrokeStyle: Gradient not found with name "
											+ gradientName);
						}
					}
				});
			}

			@Override
			public void addColorStop(final String gradientName,
					final Double offset, final String color) {
				runCommand(new Command() {
					@Override
					public void execute() {
						if (gradients.containsKey(gradientName)) {
							gradients.get(gradientName).addColorStop(offset,
									color);
						} else {
							System.err
									.println("addColorStop: Gradient not foud with name "
											+ gradientName);
						}
					}
				});
			}

			@Override
			public void loadImages(final String[] urls) {
				final List<String> imagesToLoad = new ArrayList<String>();
				imagesToLoad.addAll(Arrays.asList(urls));

				for (final String url : urls) {
					final Image image = new Image(url);

					image.addLoadHandler(new LoadHandler() {
						@Override
						public void onLoad(LoadEvent event) {
							RootPanel.get().remove(image);
							imagesToLoad.remove(url);

							if (imagesToLoad.isEmpty())
								rpc.imagesLoaded();
						}
					});

					image.addErrorHandler(new ErrorHandler() {
						@Override
						public void onError(ErrorEvent event) {
							RootPanel.get().remove(image);
							imagesToLoad.remove(url);

							if (imagesToLoad.isEmpty())
								rpc.imagesLoaded();
						}
					});

					// Force loading of the image
					image.setVisible(false);
					RootPanel.get().add(image);
				}
			}
		});
	}

	@Override
	protected Widget createWidget() {
		return Canvas.createIfSupported();
	}

	@Override
	public Canvas getWidget() {
		return (Canvas) super.getWidget();
	}

	@Override
	public void onStateChanged(StateChangeEvent stateChangeEvent) {
		super.onStateChanged(stateChangeEvent);
	}

	@Override
	public void layout() {
		int newHt = getWidget().getElement().getOffsetHeight();
		if (newHt != getWidget().getCoordinateSpaceHeight()) {
			getWidget().setCoordinateSpaceHeight(newHt);
			needsDraw = true;
		}

		int newWt = getWidget().getElement().getOffsetWidth();
		if (newWt != getWidget().getCoordinateSpaceWidth()) {
			getWidget().setCoordinateSpaceWidth(newWt);
			needsDraw = true;
		}
	}

	@Override
	public void postLayout() {
		if (needsDraw) {
			for (Command cmd : commands)
				cmd.execute();
			needsDraw = false;
		}
	}

	public void runCommand(Command command) {
		if (commands.add(command))
			command.execute();
	}

	public void clearCommands() {
		commands.clear();
	}
}
