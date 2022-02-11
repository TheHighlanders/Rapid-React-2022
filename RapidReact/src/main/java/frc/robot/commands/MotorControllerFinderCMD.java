// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;

public class MotorControllerFinderCMD extends CommandBase {
  public DriveTrain m_DriveTrain;

  public MotorControllerFinderCMD(DriveTrain driveTrain_Sub) {
    m_DriveTrain = driveTrain_Sub;
    addRequirements(m_DriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
   System.out.print("The Set ID number | What they are");
   System.out.println("Left1 is set as: " + Constants.LEFT_ONE + "but is: " + m_DriveTrain.getLeft1ID());
   System.out.println("Left2 is set as: " + Constants.LEFT_TWO + "but is: " + m_DriveTrain.getLeft2ID());
   System.out.println("Right1 is set as: " + Constants.RIGHT_ONE + "but is: " + m_DriveTrain.getRight1ID());
   System.out.println("Right2 is set as: " + Constants.RIGHT_TWO + "but is: " + m_DriveTrain.getRight2ID());

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
