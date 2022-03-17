// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;


public class CrashCMD extends CommandBase {
  /** Creates a new crashCMD. */
  public final DriveTrain m_ddriveTrain;
  Accelerometer accelerometer = new BuiltInAccelerometer();
 double x = accelerometer.getZ();
 boolean isFinished = false;



  public CrashCMD(DriveTrain drive_subsystem) {
    m_ddriveTrain = drive_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_ddriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    // m_ddriveTrain.drivepower(-0.15,-0.15);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_ddriveTrain.drivepower(0.20,-0.20);
    x = accelerometer.getZ();
    DriverStation.reportError(x + "", false);
    if (x > 0.3) { // used to be 0.5
      DriverStation.reportError(x + "x > -0.5", false);
      isFinished = true;
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_ddriveTrain.drivepower(0, 0);
    DriverStation.reportError("---------------------------------------------- CrashCMD Complete", false);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished;
  }

}
