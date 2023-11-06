package org.firstinspires.ftc.teamcode.opModes.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.TimedDrive;
import org.firstinspires.ftc.teamcode.opModes.base.AutoOpMode;

@Autonomous(name = "DriveFwd", group = "Autonomous", preselectTeleOp = "Manual Control")
public class DriveFwd extends AutoOpMode {
    @Override
    public void setup() {
        schedule(new TimedDrive(driveSubsystem,-0.5,0.0,0.0,4.0));
    }
}
