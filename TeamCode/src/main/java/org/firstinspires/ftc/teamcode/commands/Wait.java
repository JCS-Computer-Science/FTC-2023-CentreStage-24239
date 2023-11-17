package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.TelemetrySubsystem;

public class Wait extends CommandBase {
	private Timing.Timer timer;
	private TelemetrySubsystem ts;

	/**
	 * Waits for a specified amount of time
	 * @param t the time to wait in seconds
	 */
	public Wait(Double t, TelemetrySubsystem ts) {
		this.ts = ts;
		timer = new Timing.Timer(t.longValue());
	}

	@Override
	public void initialize() {
		timer.start();
	}

	@Override
	public void execute() {
		ts.addData("ET", timer.elapsedTime());
	}

	@Override
	public boolean isFinished(){
		return timer.done();
	}
}
