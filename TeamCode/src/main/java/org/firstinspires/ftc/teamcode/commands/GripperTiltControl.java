package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.GripperSubsystem;

public class GripperTiltToggle extends CommandBase {
	private final GripperSubsystem subsystem;
	public GripperTiltToggle(GripperSubsystem subsystem) {
		this.subsystem = subsystem;
		addRequirements(subsystem);
	}

	@Override
	public void initialize() {

	}

	@Override
	public boolean isFinished() {
		return true;
	}
}
