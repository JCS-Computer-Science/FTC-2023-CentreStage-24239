package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.util.Convert;

public class LiftSubsystem extends SubsystemBase {
	private final TelemetrySubsystem t;
	public DcMotorEx liftMotor;

	public LiftSubsystem(@NonNull HardwareMap hardwareMap, TelemetrySubsystem telemetrySubsystem) {
		t = telemetrySubsystem;
		liftMotor = hardwareMap.get(DcMotorEx.class, "liftMotor");

		liftMotor.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
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

		t.addData("Lift Position", liftMotor.getCurrentPosition());
	}
}
