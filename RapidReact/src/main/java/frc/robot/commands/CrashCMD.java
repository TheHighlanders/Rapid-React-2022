// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.OI;


public class CrashCMD extends CommandBase {
  /** Creates a new CrashCMD. */
  public final DriveTrain m_dDriveTrain;

 public final float StopCurrent = 2;
 public double PreviousCurrentL = 3;
 public double PreviousCurrentR = 4;


  public CrashCMD(DriveTrain drive_subsystem) {
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
    m_dDriveTrain.drivepower(0.2,0.2);
    DriverStation.reportWarning("current to left 2" + m_dDriveTrain.getOutputCurrentL(), false );
    DriverStation.reportWarning("current to right 1" + m_dDriveTrain.getOutputCurrentR(), false );
    DriverStation.reportWarning("left current  is more than stop current" + (m_dDriveTrain.getOutputCurrentL() > StopCurrent), false);
    DriverStation.reportWarning("right current  is more than stop current" + (m_dDriveTrain.getOutputCurrentR() > StopCurrent), false);
    DriverStation.reportWarning("current jump left" + (m_dDriveTrain.getOutputCurrentL()- PreviousCurrentL), false);
    DriverStation.reportWarning("current jump right" + (m_dDriveTrain.getOutputCurrentR()- PreviousCurrentR), false);


    PreviousCurrentL = m_dDriveTrain.getOutputCurrentL();
    PreviousCurrentR =  m_dDriveTrain.getOutputCurrentR();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    //m_OI.setxboxrumble(1);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (m_dDriveTrain.getOutputCurrentL() > StopCurrent) || (m_dDriveTrain.getOutputCurrentL() - PreviousCurrent > 3) &&  (m_dDriveTrain.getOutputCurrentR() > StopCurrent) || (m_dDriveTrain.getOutputCurrentR() - PreviousCurrent > 3);
   // return false;

  }
}
