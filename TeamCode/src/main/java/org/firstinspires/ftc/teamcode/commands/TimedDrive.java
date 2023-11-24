package org.firstinspires.ftc.teamcode.commands;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.util.Timing;

import org.firstinspires.ftc.teamcode.subsystems.DriveSubsystem;

import java.util.function.DoubleSupplier;

/**
 * Drive the robot for a set amopunt of time.
 *
 * @see DriveSubsystem
 */
public class TimedDrive extends CommandBase {
	private  DriveSubsystem driveSubsystem;
	private  Double forward;
	private  Double strafe;
	private  Double rotation;
	private Double t;
	private Timing.Timer timer;


	/**
	 * Drive the robot using the left joystick for translation and the right joystick for rotation.
	 * @param driveSubsystem
	 * @param forward
	 * @param strafe
	 * @param rotation
	 * @see DriveSubsystem
	 *
	 * @author Eric Singer
	 */
	public TimedDrive(DriveSubsystem driveSubsystem, Double forward, Double strafe, Double rotation, Double t) {
		this.driveSubsystem = driveSubsystem;

		this.forward = forward;
		this.strafe = strafe;
		this.rotation = rotation;
		this.t= t;



		addRequirements(driveSubsystem);
	}

	@Override
	public void initialize(){
		timer = new Timing.Timer(t.longValue());
	}

	@Override
	public void execute() {
		if(!timer.isTimerOn()){
			timer.start();
		}
		driveSubsystem.driveRobotCentric(
				strafe,
				forward,

				rotation,
				true
		);
	}

	@Override
	public boolean isFinished(){
		return timer.done();
	}

	@Override
	public void end(boolean interrupted){
		driveSubsystem.driveRobotCentric(0,0,0);
	}
}
