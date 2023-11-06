package org.firstinspires.ftc.teamcode.subsystems;

import androidx.annotation.NonNull;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class LauncherSubsystem extends SubsystemBase {
	private DcMotor launcherMotor;
	public LauncherSubsystem(@NonNull HardwareMap hardwareMap) {
		launcherMotor = hardwareMap.get(DcMotor.class, "launcherMotor");
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
}
