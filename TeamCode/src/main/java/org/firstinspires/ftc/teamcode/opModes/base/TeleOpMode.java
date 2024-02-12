package org.firstinspires.ftc.teamcode.opModes.base;

import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;

import org.firstinspires.ftc.teamcode.commands.GripperTiltControl;
import org.firstinspires.ftc.teamcode.commands.LauncherServoToggle;

import org.firstinspires.ftc.teamcode.commands.MoveHookManual;

import org.firstinspires.ftc.teamcode.commands.MoveArmManual;

import org.firstinspires.ftc.teamcode.commands.MoveLiftManual;
import org.firstinspires.ftc.teamcode.commands.ToggleTurner;
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
        hookSubsystem.setDefaultCommand(new MoveHookManual(hookSubsystem,toolOp));
        GamepadButton toolA=new GamepadButton(toolOp, GamepadKeys.Button.A);

        armSubsystem.setDefaultCommand(new MoveArmManual(armSubsystem, toolOp));
        toolOp.getGamepadButton(GamepadKeys.Button.A).whenPressed(new ToggleGripper(gripperSubsystem));


        //Launcher
        toolOp.getGamepadButton(GamepadKeys.Button.Y).whenPressed(new ToggleMotors(launcherSubsystem));
        toolOp.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(new LauncherServoToggle(launcherSubsystem));

        toolOp.getGamepadButton(GamepadKeys.Button.DPAD_UP).whenPressed(new ToggleTurner(gripperSubsystem));
//        dDown.whenPressed(new ToggleGripper(gripperSubsystem));
    }
}
