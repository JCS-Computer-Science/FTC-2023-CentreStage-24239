package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class HookSubsystem extends SubsystemBase {
	private final TelemetrySubsystem t;
	public DcMotorEx liftMotor;

	public HookSubsystem(@NonNull HardwareMap hardwareMap, TelemetrySubsystem telemetrySubsystem) {
		t = telemetrySubsystem;
		liftMotor = hardwareMap.get(DcMotorEx.class, "climbMotor");

		liftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//		liftMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//		liftMotor.setDirection(DcMotorEx.Direction.REVERSE);
		liftMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
	}

	public void driveMotor(double power){
		liftMotor.setPower(power);
	}
	/**
	 * Sets the position of the lift motor
	 * @param pos - Target position in ticks
	 */


	@Override
	public void periodic() {

	}
}
