package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.GripperSubsystem;


public class ToggleTurner extends CommandBase {
    private GripperSubsystem gripperSubsystem;

    public ToggleTurner(GripperSubsystem gripperSubsystem) {
        this.gripperSubsystem = gripperSubsystem;
//        addRequirements(gripperSubsystem);
    }

    @Override
    public void initialize() {
        gripperSubsystem.toggleTurner();
    }

    public boolean isFinished() {
        return true;
    }
}