// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.DriveTrain;

public class DriveBackCMD extends CommandBase {
  /** Creates a new DriveBack. */
  public final DriveTrain m_dDriveTrain;
  public DriveBackCMD(DriveTrain drive_subsystem) {
   m_dDriveTrain = drive_subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
  addRequirements(m_dDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_dDriveTrain.drivepower(-0.2, -0.2);
    new WaitCommand(3);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
