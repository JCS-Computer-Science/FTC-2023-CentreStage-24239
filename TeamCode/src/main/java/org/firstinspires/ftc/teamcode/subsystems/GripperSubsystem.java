package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

@Config
public class GripperSubsystem extends SubsystemBase {
	private final TelemetrySubsystem t;
	private ServoEx gripper, turner;

	public GripperSubsystem(@NonNull HardwareMap hardwareMap, TelemetrySubsystem t) {
		this.t = t;

		gripper = new SimpleServo(hardwareMap, "gripper", 0, 180);
		turner = new SimpleServo(hardwareMap, "turner", 0, 180);



	}



	public void toggleGripper() {
		if (gripper.getPosition() == 0.0) {
			setGripper(1.0);
		} else {
			setGripper(0.0);
		}
	}

	public void toggleTurner() {
		if (turner.getPosition() == 1.0) {
			setTurner(0.0);
		} else {
			setTurner(1.0);
		}
	}




	public void setGripper(double position) {
		gripper.setPosition(position);
	}
	public void setTurner(double position) {
		turner.setPosition(position);
	}

	public double getTurnerPosition(){return turner.getPosition();}

	@Override
	public void periodic() {
		t.addLine("\nGripper Subsystem");
		t.addData("Gripper", gripper.getPosition());

	}
}
