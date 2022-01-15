// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistribution;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.PowerDistribution.ModuleType;
import frc.robot.OI;

public class CrashCMD extends CommandBase {
  /** Creates a new CrashCMD. */
  public final DriveTrain m_dDriveTrain;

  public final float StopCurrent = 2; // what the robot will need to exceed when stopped
  public double PreviousCurrentL = 3;
  //public double PreviousCurrentR = 4;

  public CrashCMD(DriveTrain drive_subsystem) {
    m_dDriveTrain = drive_subsystem;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_dDriveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_dDriveTrain.drivepower(0.1, -0.1);
    //PreviousCurrentL = m_dDriveTrain.getOutputCurrentL();
    //PreviousCurrentR =  m_dDriveTrain.getOutputCurrentR();
   // m_dDriveTrain.driveBack();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_OI.setxboxrumble(1);
    DriverStation.reportWarning("DONE",false);
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
   // return (m_dDriveTrain.getOutputCurrentL() > StopCurrent) || (m_dDriveTrain.getOutputCurrentL() - PreviousCurrentL > 3); //  &&  (m_dDriveTrain.getOutputCurrentR() > StopCurrent) || (m_dDriveTrain.getOutputCurrentR() - PreviousCurrentR > 3);
   return false;

  }
}
