// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.spoinkVision2;

public class VisionAlignYawCMD extends CommandBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  public final spoinkVision2 m_vision;
  public final DriveTrain m_dDriveTrain; 
  /** Creates a new VisionAlignYawCMD. */
  public VisionAlignYawCMD(spoinkVision2 vision_sub, DriveTrain  drive_sub) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_vision = vision_sub;
    m_dDriveTrain = drive_sub;
    addRequirements(m_vision,m_dDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    /*
      THIS NEEDS TO BE TESTED
      THIS MIGHT NOT WORK 
      IT NEEDS TO BE TESTED
    */
    NetworkTableEntry tx = table.getEntry("tx");
    double TargetOffsetYaw = tx.getDouble(0.0);
    if(TargetOffsetYaw > 3){
      DriverStation.reportWarning("Turning Left", false);
      m_dDriveTrain.drivepower(0.15, 0.15);

    }
    if(TargetOffsetYaw < -3) {
      DriverStation.reportWarning("Turning Right", false);
      m_dDriveTrain.drivepower(-0.15, -0.15);
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
