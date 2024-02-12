package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.subsystems.ArmSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.LiftSubsystem;

public class MoveLiftManual extends CommandBase {
	private final LiftSubsystem liftSubsystem;
	private final GamepadEx toolOp;
	public MoveLiftManual(LiftSubsystem liftSubsystem, GamepadEx toolOp) {
		this.liftSubsystem = liftSubsystem;
		this.toolOp = toolOp;
		addRequirements(liftSubsystem);
	}

	@Override
	public void execute() {
		liftSubsystem.driveMotor(toolOp.getTrigger(GamepadKeys.Trigger.RIGHT_TRIGGER)-toolOp.getTrigger(GamepadKeys.Trigger.LEFT_TRIGGER));
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
