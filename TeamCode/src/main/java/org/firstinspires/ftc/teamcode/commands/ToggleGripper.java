package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.GripperSubsystem;


public class ToggleGripper extends CommandBase {
    private GripperSubsystem gripperSubsystem;

    public ToggleGripper(GripperSubsystem gripperSubsystem) {
        this.gripperSubsystem = gripperSubsystem;
        addRequirements(gripperSubsystem);
    }

    @Override
    public void initialize() {
        gripperSubsystem.toggleGripper();
    }

    public boolean isFinished() {
        return true;
    }
}