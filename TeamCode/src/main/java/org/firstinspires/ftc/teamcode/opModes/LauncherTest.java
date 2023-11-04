package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.subsystems.LauncherSubsystem;

@Autonomous(name = "Launcher Test", group = "Testing")
public class LauncherTest extends CommandOpMode {
	@Override
	public void initialize() {
		LauncherSubsystem launcherSubsystem = new LauncherSubsystem(hardwareMap);

		launcherSubsystem.setPower(1);
	}
}
