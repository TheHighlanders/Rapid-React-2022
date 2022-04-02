// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpoinkVision extends SubsystemBase {
  /** Creates a new SpoinkVision. */
  NetworkTable m_limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  
  NetworkTableEntry tx = m_limelightTable.getEntry("tx");
  NetworkTableEntry ty = m_limelightTable.getEntry("ty");
  //NetworkTableEntry ta = m_limelightTable.getEntry("ta");

  //read values periodically
  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  // double area = ta.getDouble(0.0);
  double tv;
  double ta;
  boolean target = false;

  public SpoinkVision() {

  }
  public boolean isTargetValid() {
    target = true;
    return(tv == 1.0);
  }

  @Override
  public void periodic() {
    //post to smart dashboard periodically
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    // SmartDashboard.putNumber("LimelightArea", area);
    // SmartDashboard.putBoolean("TV?", target);
    tv = m_limelightTable.getEntry("tv").getDouble(0);
    ta = m_limelightTable.getEntry("tx").getDouble(0);
    // ty = m_limelightTable.getEntry("ty").getDouble(0);
    // ta = m_limelightTable.getEntry("ta").getDouble(0);
    // This method will be called once per scheduler run
  }
}
