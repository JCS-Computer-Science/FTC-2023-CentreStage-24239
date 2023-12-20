package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.GripperSubsystem;

public class GripperTiltControl extends CommandBase {
	private final GripperSubsystem subsystem;
	private boolean isUp;
	public GripperTiltControl(boolean isUp, GripperSubsystem subsystem) {
		this.subsystem = subsystem;
		this.isUp=isUp;

	}

	@Override
	public void execute() {
		double cur=subsystem.getTurnerPosition();
		double newPos= isUp?cur+0.05:cur-0.05;
		subsystem.setTurner(newPos);
	}



	@Override
	public boolean isFinished() {
		return true;
	}
}
