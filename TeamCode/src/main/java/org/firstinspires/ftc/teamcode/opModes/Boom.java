package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.util.RunCheck;
import org.firstinspires.ftc.teamcode.commands.util.Wait;
import org.firstinspires.ftc.teamcode.subsystems.TelemetrySubsystem;

@Autonomous(name = "Boom", group = "Test")
public class Boom extends CommandOpMode {
	@Override
	public void initialize() {
		TelemetrySubsystem t = new TelemetrySubsystem(telemetry);
		schedule(
				new SequentialCommandGroup(
					new Wait(20.0, t),
					new RunCheck("Boom", t)
				)
		);
	}
}
