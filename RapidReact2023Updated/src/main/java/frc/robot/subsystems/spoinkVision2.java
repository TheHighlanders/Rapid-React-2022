// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class spoinkVision2 extends SubsystemBase {
  /** Creates a new spoinkVision2. */
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  // NetworkTableEntry tx = table.getEntry("tx");
  // NetworkTableEntry ty = table.getEntry("ty");
  // NetworkTableEntry ta = table.getEntry("ta");
  double tv; //is there a target
  double tx;
  double ta;
  double ty;
  boolean target = false;
  // NetworkTableEntry tv = table.getEntry("tv"); 

  
  public spoinkVision2() {
    //post to smart dashboard periodically
  }
  public boolean isTarget(){
    if (tv == 1.0) { 
      target = true;
      return true; 
    } else {
      target = false;
      return false; 
    }
  }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // //read values periodically
    tv = table.getEntry("tv").getDouble(0);
    tx = table.getEntry("tx").getDouble(0);
    ta = table.getEntry("ta").getDouble(0);
    ty = table.getEntry("ty").getDouble(0);
    SmartDashboard.putNumber("LimelightX", tx);
    SmartDashboard.putNumber("LimelightY", ty);
    SmartDashboard.putNumber("LimelightArea", ta);
    SmartDashboard.putBoolean("TargetFound", isTarget());
  }

}