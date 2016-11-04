package iristk.app.musicController;

import java.util.List;
import java.io.File;
import iristk.xml.XmlMarshaller.XMLLocation;
import iristk.system.Event;
import iristk.flow.*;
import iristk.util.Record;
import static iristk.util.Converters.*;
import static iristk.flow.State.*;

public class MusicControllerFlow extends iristk.flow.Flow {

	private MusicController musicController;

	private void initVariables() {
	}

	public MusicController getMusicController() {
		return this.musicController;
	}

	@Override
	public Object getVariable(String name) {
		if (name.equals("musicController")) return this.musicController;
		return null;
	}


	public MusicControllerFlow(MusicController musicController) {
		this.musicController = musicController;
		initVariables();
	}

	@Override
	public State getInitialState() {return new Start();}


	public class Start extends State implements Initial {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 9
			try {
				EXECUTION: {
					int count = getCount(1031980531) + 1;
					incrCount(1031980531);
					iristk.flow.DialogFlow.say state0 = new iristk.flow.DialogFlow.say();
					state0.setText("What do you want to listen to?");
					if (!flowThread.callState(state0, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 9, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					// Line: 11
					Request state1 = new Request();
					flowThread.gotoState(state1, currentState, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 11, 27)));
					eventResult = EVENT_ABORTED;
					break EXECUTION;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 9, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Request extends Dialog {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
			// Line: 17
			try {
				EXECUTION: {
					int count = getCount(1305193908) + 1;
					incrCount(1305193908);
					iristk.flow.DialogFlow.listen state2 = new iristk.flow.DialogFlow.listen();
					if (!flowThread.callState(state2, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 17, 12)))) {
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 17, 12));
			}
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 21
			try {
				count = getCount(1313953385) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:control")) {
						incrCount(1313953385);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 22
							String control = asString(event.get("sem:control"));
							// Line: 23
							if (control == "pause") {
								// Line: 24
								musicController.pause();
								iristk.flow.DialogFlow.say state3 = new iristk.flow.DialogFlow.say();
								state3.setText("Ok, pausing");
								if (!flowThread.callState(state3, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 23, 34)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							// Line: 29
							if (control == "play") {
								// Line: 30
								musicController.play();
								iristk.flow.DialogFlow.say state4 = new iristk.flow.DialogFlow.say();
								state4.setText("Ok, playing");
								if (!flowThread.callState(state4, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 29, 33)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							// Line: 35
							if (control == "volumeUp" || control == "volumeDown") {
								iristk.flow.DialogFlow.say state5 = new iristk.flow.DialogFlow.say();
								state5.setText("Sorry, you have to do that yourself");
								if (!flowThread.callState(state5, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 35, 64)))) {
									eventResult = EVENT_ABORTED;
									break EXECUTION;
								}
							}
							// Line: 38
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 38, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 21, 62));
			}
			// Line: 41
			try {
				count = getCount(1212899836) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:status")) {
						incrCount(1212899836);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state6 = new iristk.flow.DialogFlow.say();
							state6.setText(concat("This is", musicController.status()));
							if (!flowThread.callState(state6, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 41, 61)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 43
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 43, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 41, 61));
			}
			// Line: 46
			try {
				count = getCount(1289696681) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:music")) {
						incrCount(1289696681);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							// Line: 47
							String song = asString(event.get("sem:music"));
							musicController.play(song);
							iristk.flow.DialogFlow.say state7 = new iristk.flow.DialogFlow.say();
							state7.setText(concat("Here is some", song));
							if (!flowThread.callState(state7, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 46, 60)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 52
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 52, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 46, 60));
			}
			// Line: 55
			try {
				count = getCount(1811075214) + 1;
				if (event.triggers("sense.user.speak")) {
					if (event.has("sem:help")) {
						incrCount(1811075214);
						eventResult = EVENT_CONSUMED;
						EXECUTION: {
							iristk.flow.DialogFlow.say state8 = new iristk.flow.DialogFlow.say();
							state8.setText("You can ask for pop, rock or inspirational music. You can also ask me to stop or start music, or to adjust volume");
							if (!flowThread.callState(state8, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 55, 59)))) {
								eventResult = EVENT_ABORTED;
								break EXECUTION;
							}
							// Line: 57
							flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 57, 14)));
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						if (eventResult != EVENT_IGNORED) return eventResult;
					}
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 55, 59));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


	private class Dialog extends State {

		final State currentState = this;


		@Override
		public void setFlowThread(FlowRunner.FlowThread flowThread) {
			super.setFlowThread(flowThread);
		}

		@Override
		public void onentry() throws Exception {
			int eventResult;
			Event event = new Event("state.enter");
		}

		@Override
		public int onFlowEvent(Event event) throws Exception {
			int eventResult;
			int count;
			// Line: 62
			try {
				count = getCount(1940447180) + 1;
				if (event.triggers("sense.user.silence")) {
					incrCount(1940447180);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state9 = new iristk.flow.DialogFlow.say();
						state9.setText("I am sorry, I didn't hear anything.");
						if (!flowThread.callState(state9, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 62, 38)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 64
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 64, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 62, 38));
			}
			// Line: 66
			try {
				count = getCount(2121744517) + 1;
				if (event.triggers("sense.user.speak")) {
					incrCount(2121744517);
					eventResult = EVENT_CONSUMED;
					EXECUTION: {
						iristk.flow.DialogFlow.say state10 = new iristk.flow.DialogFlow.say();
						state10.setText("I am sorry, what was that?");
						if (!flowThread.callState(state10, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 66, 36)))) {
							eventResult = EVENT_ABORTED;
							break EXECUTION;
						}
						// Line: 68
						flowThread.reentryState(this, new FlowEventInfo(currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 68, 14)));
						eventResult = EVENT_ABORTED;
						break EXECUTION;
					}
					if (eventResult != EVENT_IGNORED) return eventResult;
				}
			} catch (Exception e) {
				throw new FlowException(e, currentState, event, new XMLLocation(new File("C:\\Users\\ludvig\\IrisTK\\app\\musicController\\src\\iristk\\app\\musicController\\MusicControllerFlow.xml"), 66, 36));
			}
			eventResult = super.onFlowEvent(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			eventResult = callerHandlers(event);
			if (eventResult != EVENT_IGNORED) return eventResult;
			return EVENT_IGNORED;
		}

	}


}
