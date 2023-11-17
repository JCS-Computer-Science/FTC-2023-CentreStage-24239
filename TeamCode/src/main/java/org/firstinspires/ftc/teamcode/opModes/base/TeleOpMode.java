package org.firstinspires.ftc.teamcode.opModes.base;

import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.MoveLiftManual;
import org.firstinspires.ftc.teamcode.commands.TeleOpDrive;
import org.firstinspires.ftc.teamcode.commands.TeleOpDriveAutoHeading;
import org.firstinspires.ftc.teamcode.commands.ToggleGripper;
import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.subsystems.OdometrySubsystem;
import org.firstinspires.ftc.teamcode.subsystems.TelemetrySubsystem;

/**
 * Base class for TeleOp opmodes comes preloaded with the following subsystems:
 *
 * @author Eric Singer
 * @see BaseOpMode
 */
public abstract class TeleOpMode extends BaseOpMode {

    protected GamepadEx driver;
    protected GamepadEx toolOp;

    /**
     * This method is called when the opmode is initialized.
     */
    public abstract void setup();

    @Override
    public void additionalConfig() {

//      Gamepads
        driver = new GamepadEx(gamepad1);
        toolOp = new GamepadEx(gamepad2);

//      Drive Subsystem Controls
        driveSubsystem.setDefaultCommand(new TeleOpDrive(driveSubsystem, driver::getLeftX, driver::getLeftY, driver::getRightX));

//        liftSubsystem.setDefaultCommand(new MoveLiftManual(liftSubsystem, toolOp));
//        GamepadButton toolA=new GamepadButton(toolOp, GamepadKeys.Button.A);
//        toolA.whenPressed(new ToggleGripper(gripperSubsystem));
    }
}
