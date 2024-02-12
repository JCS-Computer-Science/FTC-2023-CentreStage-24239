package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.HookSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class MoveHookManual extends CommandBase {
	private final HookSubsystem hookSubsystem;
	private final GamepadEx toolOp;
	public MoveHookManual(HookSubsystem hookSubsystem, GamepadEx toolOp) {
		this.hookSubsystem = hookSubsystem;
		this.toolOp = toolOp;
		addRequirements(hookSubsystem);
	}

	@Override
	public void execute() {
		hookSubsystem.driveMotor(-toolOp.getLeftY());
//		liftSubsystem.setPosition(new Double(liftSubsystem.liftMotor.getTargetPosition() + toolOp.getLeftY()).intValue());
	}

	@Override
	public boolean isFinished() {
		return false;
//		return liftSubsystem.liftMotor.getCurrentPosition() == liftSubsystem.liftMotor.getTargetPosition();
	}

//	@Override
//	public void end(boolean interrupted) {
//		liftSubsystem.liftMotor.setPower(0);
//	}
}
