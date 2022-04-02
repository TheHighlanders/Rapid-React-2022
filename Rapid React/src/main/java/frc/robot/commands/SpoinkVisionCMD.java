// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpoinkVision;
import frc.robot.subsystems.spoinkVision2;
import frc.robot.subsystems.DriveTrain;
public class SpoinkVisionCMD extends CommandBase {
  /** Creates a new SpoinkVisionCMD. */
    private final DriveTrain m_DriveTrain;
    private final spoinkVision2 m_vision;

  public SpoinkVisionCMD(DriveTrain drive_sub, spoinkVision2 spoink_sub) {
    m_DriveTrain = drive_sub;
    m_vision = spoink_sub;
    addRequirements(m_DriveTrain, m_vision);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (m_vision.isTarget()){
      DriverStation.reportWarning("Saw the target",false);
    }
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
