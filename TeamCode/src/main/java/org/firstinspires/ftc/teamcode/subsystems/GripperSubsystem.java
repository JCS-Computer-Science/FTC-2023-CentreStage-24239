package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class GripperSubsystem extends SubsystemBase {
	private final TelemetrySubsystem t;
	private ServoEx  gripper;
	private double TOP= 1;
	private double BOTTOM=0.35;
	public GripperSubsystem(@NonNull HardwareMap hardwareMap, TelemetrySubsystem t) {
		this.t = t;

		gripper = new SimpleServo(hardwareMap, "gripper", 0, 180);

	}



	public void setGripper(double position) {
		gripper.setPosition(position);
	}

	public void toggleGripper(){
		if(gripper.getPosition()>=TOP){
			gripper.setPosition(BOTTOM);
		}else{
			gripper.setPosition(TOP);
		}
	}

	@Override
	public void periodic() {
		t.addLine("\nGripper Subsystem");
		t.addData("Gripper", gripper.getPosition());

	}
}
