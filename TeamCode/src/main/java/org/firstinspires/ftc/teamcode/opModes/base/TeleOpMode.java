package org.firstinspires.ftc.teamcode.opModes.base;

import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.LauncherServoToggle;
import org.firstinspires.ftc.teamcode.commands.MoveLiftManual;
import org.firstinspires.ftc.teamcode.commands.drive.TeleOpDrive;
import org.firstinspires.ftc.teamcode.commands.ToggleGripper;
import org.firstinspires.ftc.teamcode.commands.ToggleMotors;

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

        liftSubsystem.setDefaultCommand(new MoveLiftManual(liftSubsystem, toolOp));
        GamepadButton toolA=new GamepadButton(toolOp, GamepadKeys.Button.A);
        toolA.whenPressed(new ToggleGripper(gripperSubsystem));

        //Launcher
        GamepadButton toolY = new GamepadButton(toolOp, GamepadKeys.Button.Y);
        GamepadButton toolRBumper = new GamepadButton(toolOp, GamepadKeys.Button.RIGHT_BUMPER);

        toolY.whenPressed(new ToggleMotors(launcherSubsystem));
        toolRBumper.whenPressed(new LauncherServoToggle(launcherSubsystem));
    }
}
