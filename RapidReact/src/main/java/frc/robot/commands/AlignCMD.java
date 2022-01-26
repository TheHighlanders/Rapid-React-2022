// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class AlignCMD extends CommandBase {
  /** Creates a new AlignCMD. */

  public final DriveTrain m_DriveTrain;
  
  NetworkTableEntry middleX;
  NetworkTableEntry middleY;
  public boolean isAligned = false;
  double Xvalue;
  double Yvalue;
  double middlesphere = (Constants.LEFTBOUND+Constants.RIGHTBOUND)/2;// (3a+b)/2



  public AlignCMD(DriveTrain driveTrain_subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = driveTrain_subsystem;
    addRequirements(m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    NetworkTableInstance NetworkTable = NetworkTableInstance.getDefault();
    NetworkTable Table = NetworkTable.getTable("Table");
    this.middleX = Table.getEntry("center x");
    this.middleY = Table.getEntry("center y");

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override

  public void execute() {
     
      this.Xvalue = middleX.getDouble(0);
      this.Yvalue = middleY.getDouble(0);
      

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
