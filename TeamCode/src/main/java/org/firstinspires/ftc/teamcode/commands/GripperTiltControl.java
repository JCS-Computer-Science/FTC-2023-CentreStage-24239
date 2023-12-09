package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.subsystems.GripperSubsystem;

public class GripperTiltControl extends CommandBase {
	private final GripperSubsystem subsystem;
	private final GamepadEx toolOp;
	private final boolean isUp;
	public GripperTiltControl(boolean isUp, GripperSubsystem subsystem, GamepadEx toolOp) {
		this.subsystem = subsystem;
		this.toolOp=toolOp;
		this.isUp=isUp;

	}

	@Override
	public void initialize() {
		double cur=subsystem.getTurnerPosition();
		double newPos= isUp?Math.min(1,cur+0.05):Math.max(0,cur-0.05);
		subsystem.setTurner(newPos);
	}



	@Override
	public boolean isFinished() {
		return true;
	}
}
