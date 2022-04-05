// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.SpoinkVision;
import frc.robot.subsystems.spoinkVision2;


public class VisionAlignDistanceCMD extends CommandBase {
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");

  // how many degrees back is your limelight rotated from perfectly vertical?
  double limelightMountAngleDegrees = 45.0;
  
  // distance from the center of the Limelight lens to the floor
  double limelightLensHeightInches = 55.0;
  
  // distance from the target to the floor
  double goalHeightInches = 102.0;
  
  /** Creates a new VisionAlignCMD. */
  public final SpoinkVision m_vision;
  public final DriveTrain m_dDriveTrain; 
  public VisionAlignDistanceCMD(SpoinkVision vision_sub, DriveTrain  drive_sub) {
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
    NetworkTableEntry ty = table.getEntry("ty");
    double targetOffsetAngle_Vertical = ty.getDouble(0.0);
    NetworkTableEntry tv = table.getEntry("tv");
    double tv2 = tv.getDouble(0.0);   

    double angleToGoalDegrees = limelightMountAngleDegrees + targetOffsetAngle_Vertical;
    double angleToGoalRadians = angleToGoalDegrees * (3.14159 / 180.0);
    
    //calculate distance
    double distanceFromLimelightToGoalInches = (goalHeightInches - limelightLensHeightInches)/Math.tan(angleToGoalRadians);
    SmartDashboard.putNumber("LimelightDistance", distanceFromLimelightToGoalInches);

    //driveback @ (distance-42)*0.01
    double visionPower = (distanceFromLimelightToGoalInches - 42) * 0.01;
    // distances > 42  give a pos proportional to the difference
    //distances < 42 give a neg val proportional to the difference
    if (visionPower > 0.10){
        DriverStation.reportWarning("BONK GOING FORWARD", false);
        m_dDriveTrain.drivepower(0.25, -0.25);
      }
      if (visionPower < 0.10) {
        DriverStation.reportWarning("BONK GOING BACK", false);
        m_dDriveTrain.drivepower(-0.25, 0.25);
      }
      if (visionPower < 0.10 && visionPower > 0.01) {
        DriverStation.reportWarning("BONK STOPPED", false);
        m_dDriveTrain.drivepower(0, 0);
      }
    // if distance is not good
    // drive
    // if distance is good
    // stop
    
    SmartDashboard.putNumber("VisionDrivePower", visionPower);
    SmartDashboard.putNumber("visionPower", visionPower);

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
