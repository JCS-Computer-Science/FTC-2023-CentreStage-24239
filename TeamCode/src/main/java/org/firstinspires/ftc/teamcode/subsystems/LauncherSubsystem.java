package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.SimpleServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LauncherSubsystem extends SubsystemBase {
	private DcMotor launcherMotor;
	private ServoEx launcherServo;
	public LauncherSubsystem(@NonNull HardwareMap hardwareMap) {
		launcherMotor = hardwareMap.get(DcMotor.class, "launcherMotor");
		launcherServo = new SimpleServo(hardwareMap,"launcherServo",0,180);
		launcherServo.setPosition(1);
	}

	public void setPower(double power) {
		launcherMotor.setPower(power);
	}

	public void toggle(){
		if(launcherMotor.getPower() == 0){
			setPower(1);
		} else {
			setPower(0);
		}
	}
	public void toggleServo(){
		if(launcherServo.getPosition()==0.75){
			launcherServo.setPosition(1);
		}else{
			launcherServo.setPosition(0.75);
		}
	}
}
