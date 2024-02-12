package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.util.Convert;

public class ArmSubsystem extends SubsystemBase {
	private final TelemetrySubsystem t;
	public DcMotorEx liftMotor;
	private double ticksPerInches = 537.7/(Math.PI * Convert.mmToInches(38.2));

	public ArmSubsystem(@NonNull HardwareMap hardwareMap, TelemetrySubsystem telemetrySubsystem) {
		t = telemetrySubsystem;
		liftMotor = hardwareMap.get(DcMotorEx.class, "armMotor");

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
	public void setPosition(int pos){
		int capedTicks = Math.max(0, Math.min(4300, pos));

		liftMotor.setTargetPosition(capedTicks);
		liftMotor.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

		PIDFCoefficients pidf = new PIDFCoefficients(10,0,0,0);
		if (liftMotor.getTargetPosition() < liftMotor.getCurrentPosition()) {
			pidf.p = 5;
		} else {
			pidf.p = 10;
		}

		liftMotor.setPIDFCoefficients(DcMotorEx.RunMode.RUN_TO_POSITION, pidf);
		liftMotor.setPower(1);
	}

	public void resetEncoder() {
		liftMotor.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
		liftMotor.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
	}

	@Override
	public void periodic() {

		t.addData("Arm Position", liftMotor.getCurrentPosition());
	}
}
