package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;

public class MoveArmManual extends CommandBase {
	private final ArmSubsystem armSubsystem;
	private final GamepadEx toolOp;

	public MoveArmManual(ArmSubsystem armSubsystem, GamepadEx toolOp) {
		this.armSubsystem = armSubsystem;
		this.toolOp = toolOp;
		addRequirements(armSubsystem);
	}

	@Override
	public void execute() {
		armSubsystem.driveMotor(Math.round(armSubsystem.liftMotor.getTargetPosition() + (toolOp.getLeftY() * 10)));
	}

}
