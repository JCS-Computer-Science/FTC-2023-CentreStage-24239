package org.firstinspires.ftc.teamcode.opModes.Auto;

import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.commands.drive.TimedDrive;
import org.firstinspires.ftc.teamcode.commands.util.Wait;
import org.firstinspires.ftc.teamcode.opModes.base.AutoOpMode;

@Autonomous(name = "DriveFwdWithBackup", group = "Autonomous", preselectTeleOp = "Manual Control")
public class DriveFwdWithBackup extends AutoOpMode {
    @Override
    public void setup() {
        schedule(new SequentialCommandGroup(

                new TimedDrive(driveSubsystem,0.5,0.0,0.0,5.0),
                new Wait(1.0),
                new TimedDrive(driveSubsystem,-0.2,0.0,0.0,0.5)
        ));
    }
}
