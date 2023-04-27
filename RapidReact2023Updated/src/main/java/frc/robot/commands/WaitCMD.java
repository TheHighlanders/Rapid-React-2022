// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class WaitCMD extends CommandBase {
  /** Creates a new WaitCMD. */
  public final DriveTrain m_dDriveTrain;
  public Timer m_Timer;
  public WaitCMD(DriveTrain drive_subsytem) {
    m_dDriveTrain = drive_subsytem;
    addRequirements(m_dDriveTrain);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_Timer = new Timer();
    m_Timer.reset();
    m_Timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() { 
    if(m_Timer.get() < 5 ) { //change timer to whatever number needed
      m_dDriveTrain.drivepower(0, 0);
      SmartDashboard.putBoolean("Vision Running", false);
   }
   else{ 
    //  m_dDriveTrain.drivepower(0.2, 0.2); 
     m_Timer.stop();

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
