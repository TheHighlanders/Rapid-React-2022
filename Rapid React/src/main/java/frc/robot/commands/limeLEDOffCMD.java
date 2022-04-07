// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.SpoinkVision;

public class limeLEDOffCMD extends CommandBase {
  /** Creates a new limeLEDOnCMD. */
  public SpoinkVision m_Vision;
  boolean isFinished = false;
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  

  public limeLEDOffCMD(SpoinkVision vision_sub) {
    m_Vision = vision_sub;
    addRequirements(m_Vision);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    DriverStation.reportWarning("LEDs Going Off", false);
    m_Vision.limelightOff();
    //NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3)
    isFinished = true;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return isFinished();
  }
}
